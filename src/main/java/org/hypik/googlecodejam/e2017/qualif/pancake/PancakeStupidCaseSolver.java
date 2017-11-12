package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PancakeStupidCaseSolver extends PancakeBaseCaseSolver {
    private final Map<Map<Integer,List<Pancake>>, Integer> allPancakes = new HashMap<>();
    private final TreeSet<Integer> solvedPancakes = new TreeSet<>();

    public PancakeStupidCaseSolver(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
    }

    public int solve() {
        if (flipperSize > pancakes.size()) {
            return IMPOSSIBLE;
        }

        tryAllFlip(pancakes, 0);


        return solvedPancakes.isEmpty() ? IMPOSSIBLE : solvedPancakes.first();
    }

    private void tryAllFlip(List<Pancake> pancakes, int currentFlipCount) {
        for (int flipStart = 0; flipStart <= pancakes.size() - flipperSize; flipStart++) {
            List<Pancake> nextPancakes = flip(flipStart, pancakes);
            Map<Integer,List<Pancake>> key = new HashMap<>();
            key.put(flipStart, nextPancakes);
            //System.out.println(currentFlipCount + "==> " + pancakes + "=>" + key);
            Integer previous = allPancakes.get(key);
            if (previous == null || previous > currentFlipCount) {
                allPancakes.put(key, currentFlipCount);
                if (solved(pancakes)) {
                    solvedPancakes.add(currentFlipCount);
                }
                tryAllFlip(nextPancakes, currentFlipCount + 1);
            }
        }
    }

    private List<Pancake> flip(int flipStart, List<Pancake> pancakes) {
        return IntStream.range(0, pancakes.size())
                .mapToObj(i -> i>=flipStart &&  i < flipStart + flipperSize
                            ? pancakes.get(i).opposite() : pancakes.get(i))
                .collect(toList());
    }

    private boolean solved(List<Pancake> pancakes) {
        return pancakes.stream().allMatch(p -> p == Pancake.HAPPY);
    }
}
