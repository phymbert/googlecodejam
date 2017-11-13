package org.hypik.googlecodejam.e2017.qualif.pancake;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hypik.googlecodejam.e2017.qualif.pancake.PancakeCaseSolver.IMPOSSIBLE;

public class PancakeCaseTest {

    static enum PancakesCaseSmall {
        CASE_1_EXAMPLE("---+-++-", 3, 3),
        CASE_2_EXAMPLE("+++++", 4, 0),

        CASE_SMALL_6("++--+-+--", 3,3),
        CASE_SMALL_7("++++", 3, 0),
        CASE_SMALL_8("-++-", 2, 3),
        CASE_SMALL_15("----------", 10,  1),
        CASE_SMALL_16("+-++++-++", 5,  2),
        CASE_SMALL_17("---", 3,  1),
        CASE_SMALL_18("--", 2,  1),

        CASE_SMALL_42("-++++++++-", 2, 9),
        CASE_SMALL_44("+-+-", 2, 2),
        CASE_SMALL_45("+--", 2, 1),
        CASE_SMALL_46("++----++--", 2, 3),
        CASE_SMALL_47("--+", 2, 1),
        CASE_SMALL_48("++++", 2, 0),

        // impossible
        CASE_SMALL_3_IMPO("-+-+-", 4, IMPOSSIBLE),
        CASE_SMALL_5_IMPO("-+++-", 3, IMPOSSIBLE),
        CASE_SMALL_96_IMPO("+-+-+-+-", 3, IMPOSSIBLE),
        CASE_SMALL_97_IMPO("-+", 2, IMPOSSIBLE),
        CASE_SMALL_98_IMPO("-++", 2, IMPOSSIBLE),
        CASE_SMALL_99_IMPO("----", 3, IMPOSSIBLE),
        CASE_SMALL_100_IMPO("+-+-+-+-+", 3, IMPOSSIBLE)
;

        public final String pancakes;
        public final int flipperSize;
        public final int expectedSolved;

        PancakesCaseSmall(String pancakes, int flipperSize, int expectedSolved) {
            this.pancakes = pancakes;
            this.flipperSize = flipperSize;
            this.expectedSolved = expectedSolved;
        }
    }


    static enum PancakesCaseLarge {
        CASE_4_LARGE("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-", 2, -1),

        ;

        public final String pancakes;
        public final int flipperSize;
        public final int expectedSolved;

        PancakesCaseLarge(String pancakes, int flipperSize, int expectedSolved) {
            this.pancakes = pancakes;
            this.flipperSize = flipperSize;
            this.expectedSolved = expectedSolved;
        }
    }

    @ParameterizedTest
    @EnumSource(PancakesCaseSmall.class)
    void small(PancakesCaseSmall pancakesCase) {
        final PancakeCaseSolver case1 = new PancakeCaseSolver(pancakesCase.ordinal(),
                pancakesCase.pancakes, pancakesCase.flipperSize, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(pancakesCase.expectedSolved);
    }

    @ParameterizedTest
    @EnumSource(PancakesCaseLarge.class)
    void large(PancakesCaseLarge pancakesCase) {
        final PancakeCaseSolver case1 = new PancakeCaseSolver(pancakesCase.ordinal(),
                pancakesCase.pancakes, pancakesCase.flipperSize, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(pancakesCase.expectedSolved);
    }
}
