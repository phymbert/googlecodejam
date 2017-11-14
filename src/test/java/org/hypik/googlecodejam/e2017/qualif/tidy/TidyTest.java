package org.hypik.googlecodejam.e2017.qualif.tidy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TidyTest {

    static enum CaseSmall {
        CASE_1_EXAMPLE(132, 129),
        CASE_2_EXAMPLE(1000, 999),
        CASE_3_EXAMPLE(7, 7),
        CASE_4_EXAMPLE(111111111111111110L, 99999999999999999L),

        ;

        public final long input;
        public final long output;

        CaseSmall(long input, long output) {
            this.input = input;
            this.output = output;
        }
    }

    @ParameterizedTest
    @EnumSource(CaseSmall.class)
    public void small(CaseSmall caseSmall) {
        String output = new Tidy().tidy(String.valueOf(caseSmall.input));
        assertThat(output).isEqualTo(String.valueOf(caseSmall.output));
    }

    @ParameterizedTest
    @EnumSource(CaseSmall.class)
    public void smallBad(CaseSmall caseSmall) {
        String output = new TidyBad().tidy(String.valueOf(caseSmall.input));
        assertThat(output).isEqualTo(String.valueOf(caseSmall.output));
    }

    @Test
    public void checkFastTidy() {
        Tidy tidy = new Tidy();
        TidyBad tidyBad = new TidyBad();
        long tidyTime = 0;
        long tidyBadTime = 0;
        long init = (long) Math.pow(10, 10);
        long count = 100;
        for (long i = init; i >= init - count; i--) {
            String input = String.valueOf(i);
            long start1 = System.currentTimeMillis();
            String output1 = tidy.tidy(input);
            long start2 = System.currentTimeMillis();
            String output2 = tidyBad.tidy(input);
            long end = System.currentTimeMillis();
            long time = start2 - start1;
            long time2 = end - start2;
            System.out.println(String.format("tidyTime=%dms, tidyBadTime=%dms, %s=%s=%s",
                    time,
                    time2,
                    input, output1, output2));
            assertThat(output1).as("Bad for " + i).isEqualTo(output2);
            tidyTime += time;
            tidyBadTime += time2;
        }
        System.out.println(String.format("tidyTime=%dms, tidyBadTime=%dms",
                tidyTime / count,
                tidyBadTime / count));
    }

}
