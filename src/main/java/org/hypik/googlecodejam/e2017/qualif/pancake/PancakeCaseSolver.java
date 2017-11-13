package org.hypik.googlecodejam.e2017.qualif.pancake;


import java.io.PrintStream;

public class PancakeCaseSolver extends PancakeBaseCaseSolver {

    public PancakeCaseSolver(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
    }

    public int solve() {
        int result = 0;
        for (int i = 0; i <= pancakes.size() - flipperSize; i++) {
            if (pancakes.get(i) == Pancake.BLANK) {
                result++;
                for (int j = 0; j < flipperSize; j++) {
                    pancakes.set(i + j, pancakes.get(i + j).opposite());
                }
            }
        }
        if (pancakes.stream().anyMatch(p -> p == Pancake.BLANK)) {
            return IMPOSSIBLE;
        }
        return result;
    }

}
