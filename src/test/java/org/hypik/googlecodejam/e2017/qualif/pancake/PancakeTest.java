package org.hypik.googlecodejam.e2017.qualif.pancake;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hypik.googlecodejam.e2017.qualif.pancake.Pancake.BLANK;
import static org.hypik.googlecodejam.e2017.qualif.pancake.Pancake.HAPPY;

public class PancakeTest {

    @Test
    public void shouldParse() {
        assertThat(Pancake.pancakes("-+")).isEqualTo(asList(BLANK, HAPPY));
    }
}
