package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class PancakeStupidCaseSolverNotRecursive extends PancakeBaseCaseSolver {

    private final int maxStartFlipper;

    public PancakeStupidCaseSolverNotRecursive(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
        this.maxStartFlipper = this.pancakes.size() - flipperSize;
    }

    class FlipStep {
        final int flipCount;
        final int flipStart;
        final List<Pancake> pancakes;

        FlipStep(int flipCount, int flipStart, List<Pancake> pancakes) {
            this.flipCount = flipCount;
            this.flipStart = flipStart;
            this.pancakes = pancakes;
        }

        boolean solved() {
            return pancakes.stream().allMatch(p -> p == Pancake.HAPPY);
        }

        FlipStep next(final int flipStart) {
            List<Pancake> next = IntStream.range(0, pancakes.size())
                    .mapToObj(i -> i >= flipStart && i < flipStart + flipperSize
                            ? pancakes.get(i).opposite() : pancakes.get(i))
                    .collect(toList());
            return new FlipStep(flipCount + 1, flipStart, next);
        }

        Stream<FlipStep> allNext() {
            return IntStream.rangeClosed(0, maxStartFlipper).mapToObj(this::next);
        }
    }

    @Override
    public int solve() {
        final Map<Integer, Integer> allPancakes = new HashMap<>();
        final TreeSet<Integer> solvedPancakes = new TreeSet<>();

        final List<FlipStep> stepsToDo = new ArrayList<>(singletonList(new FlipStep(0, 0, pancakes)));
        while (!stepsToDo.isEmpty()) {
            final List<FlipStep> stepsToCheck = new ArrayList<>(stepsToDo);
            stepsToDo.clear();
            for (final FlipStep step : stepsToCheck) {
                if (step.solved()) {
                    solvedPancakes.add(step.flipCount);
                } else {
                    step.allNext().forEach(nextStep -> {
                        final Map<Integer, List<Pancake>> key = new HashMap<>();
                        key.put(nextStep.flipStart, nextStep.pancakes);
                        final int hash = key.hashCode();
                        final Integer previous = allPancakes.get(hash);
                        if (previous == null || nextStep.flipCount < previous) {
                            allPancakes.put(hash, nextStep.flipCount);
                            stepsToDo.add(nextStep);
                        }
                    });
                }
            }
        }
        return solvedPancakes.stream().findFirst().orElse(IMPOSSIBLE);
    }
}
