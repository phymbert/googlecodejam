package org.hypik.googlecodejam.e2017.qualif.pancake;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hypik.googlecodejam.e2017.qualif.pancake.PancakeCaseSolver.IMPOSSIBLE;

public class PancakeStupidCaseTest {

    @Test
    public void should_solve_case_1() {
        final PancakeStupidCaseSolver case1 = new PancakeStupidCaseSolver(1, "---+-++-", 3, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(3);
    }

    @Test
    public void should_solve_case_2() {
        final PancakeStupidCaseSolver case1 = new PancakeStupidCaseSolver(2, "+++++", 4, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(0);
    }

    @Test
    public void should_solve_case_3() {
        final PancakeStupidCaseSolver case1 = new PancakeStupidCaseSolver(2, "-+-+-", 4, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(IMPOSSIBLE);
    }
}
