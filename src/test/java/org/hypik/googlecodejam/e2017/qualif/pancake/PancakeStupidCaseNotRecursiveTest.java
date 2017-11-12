package org.hypik.googlecodejam.e2017.qualif.pancake;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hypik.googlecodejam.e2017.qualif.pancake.PancakeCaseSolver.IMPOSSIBLE;

public class PancakeStupidCaseNotRecursiveTest {

    @Test
    public void should_solve_case_1() {
        final PancakeStupidCaseSolverNotRecursive case1 = new PancakeStupidCaseSolverNotRecursive(1, "---+-++-", 3, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(3);
    }

    @Test
    public void should_solve_case_2() {
        final PancakeStupidCaseSolverNotRecursive case1 = new PancakeStupidCaseSolverNotRecursive(2, "+++++", 4, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(0);
    }

    @Test
    public void should_solve_case_3() {
        final PancakeStupidCaseSolverNotRecursive case1 = new PancakeStupidCaseSolverNotRecursive(2, "-+-+-", 4, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(IMPOSSIBLE);
    }

    @Test
    @Disabled // Out of memory
    public void should_solve_case_large_3() {
        final PancakeStupidCaseSolverNotRecursive case1 = new PancakeStupidCaseSolverNotRecursive(3, "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-", 2, null);

        // When
        int flip = case1.solve();

        // Then
        assertThat(flip).isEqualTo(IMPOSSIBLE);
    }
}
