package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;

public class PancakeCaseSolver extends PancakeBaseCaseSolver {

    public PancakeCaseSolver(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
    }

    public int solve() {
        if (flipperSize > pancakes.size()) {
            return IMPOSSIBLE;
        }

        int flipCount = tryAllFlip(this.pancakes, 0);

        return flipCount;
    }

    private int tryAllFlip(List<Pancake> pancakes, int currentFlipCount) {
        int nextFlipCount = currentFlipCount;
        int[] blankIndex = IntStream.range(0, pancakes.size())
                .filter(i -> pancakes.get(i) == Pancake.BLANK)
                .toArray();
        if (blankIndex.length == 0) {
            return nextFlipCount;
        }
        int[] nonContinuousIndex = IntStream.range(0, pancakes.size())
                .filter(i -> pancakes.get(i) == Pancake.BLANK
                        &&( i + 1 == pancakes.size() ||
                        pancakes.get(i + 1) != Pancake.BLANK ))
                .toArray();
        return nonContinuousIndex.length == 0 ? IMPOSSIBLE : nonContinuousIndex.length;
    }
}
