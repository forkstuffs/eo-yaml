/**
 * Copyright (c) 2016-2020, Mihai Emil Andronache
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * Neither the name of the copyright holder nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package com.amihaiemil.eoyaml;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for
 * {@link com.amihaiemil.eoyaml.RtYamlScalarBuilder.BuiltBlockScalar}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 4.0.0
 */
public final class BuiltBlockScalarTest {

    /**
     * Indentation works when the user did not hardcode NewLines
     * in the provided strings.
     *
     * Indentation should work the same for both folded and literal
     * block scalars.
     */
    @Test
    public void indentsProperlyNoHardcodedNewLines() {
        final List<String> lines = new ArrayList<>();
        lines.add("line1");
        lines.add("line2");
        lines.add("line3");
        final Scalar folded = new RtYamlScalarBuilder.BuiltBlockScalar(
            lines, true
        );
        MatcherAssert.assertThat(
            folded.indent(2),
            Matchers.equalTo(
                "  line1"
                + System.lineSeparator()
                + "  line2"
                + System.lineSeparator()
                + "  line3"
            )
        );
        final Scalar literal = new RtYamlScalarBuilder.BuiltBlockScalar(
            lines, false
        );
        MatcherAssert.assertThat(
            literal.indent(2),
            Matchers.equalTo(
                "  line1"
                + System.lineSeparator()
                + "  line2"
                + System.lineSeparator()
                + "  line3"
            )
        );
    }

    /**
     * Indentation works when the user hardcoded NewLines
     * in the provided strings.
     *
     * Indentation should work the same for both folded and literal
     * block scalars.
     */
    @Test
    public void indentsProperlyWithHardcodedNewLines() {
        final List<String> lines = new ArrayList<>();
        lines.add("line1" + System.lineSeparator() + "line2");
        lines.add("line3");
        final Scalar folded = new RtYamlScalarBuilder.BuiltBlockScalar(
            lines, true
        );
        MatcherAssert.assertThat(
            folded.indent(2),
            Matchers.equalTo(
                "  line1"
                    + System.lineSeparator()
                    + "  line2"
                    + System.lineSeparator()
                    + "  line3"
            )
        );
        final Scalar literal = new RtYamlScalarBuilder.BuiltBlockScalar(
            lines, false
        );
        MatcherAssert.assertThat(
            literal.indent(2),
            Matchers.equalTo(
                "  line1"
                    + System.lineSeparator()
                    + "  line2"
                    + System.lineSeparator()
                    + "  line3"
            )
        );
    }

}
