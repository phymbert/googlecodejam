package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PancakeStupidCaseSolver extends PancakeBaseCaseSolver {
    private final Map<Map<Integer, List<Pancake>>, Integer> allPancakes = new HashMap<>();
    private final TreeSet<Integer> solvedPancakes = new TreeSet<>();

    public PancakeStupidCaseSolver(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
    }

    @Override
    public int solve() {
        if (flipperSize > pancakes.size()) {
            return IMPOSSIBLE;
        }

        tryAllFlip(pancakes, 0);

        return solvedPancakes.stream().findFirst().orElse(IMPOSSIBLE);
    }

    private void tryAllFlip(List<Pancake> pancakes, int currentFlipCount) {
        if (solved(pancakes)) {
            solvedPancakes.add(currentFlipCount);
        } else {
            for (int flipStart = 0; flipStart <= pancakes.size() - flipperSize; flipStart++) {
                final List<Pancake> nextPancakes = flip(flipStart, pancakes);
                final Map<Integer, List<Pancake>> key = new HashMap<>();
                key.put(flipStart, nextPancakes);
                final Integer previous = allPancakes.get(key);
                if (previous == null || previous > currentFlipCount) {
                    allPancakes.put(key, currentFlipCount);
                    tryAllFlip(nextPancakes, currentFlipCount + 1);
                }
            }
        }
    }

    private List<Pancake> flip(final int flipStart, final List<Pancake> pancakes) {
        return IntStream.range(0, pancakes.size())
                .mapToObj(i -> i >= flipStart && i < flipStart + flipperSize
                        ? pancakes.get(i).opposite() : pancakes.get(i))
                .collect(toList());
    }

    private boolean solved(List<Pancake> pancakes) {
        return pancakes.stream().allMatch(p -> p == Pancake.HAPPY);
    }
}
