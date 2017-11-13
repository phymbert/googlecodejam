package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.util.*;

import static org.hypik.googlecodejam.e2017.qualif.pancake.PancakeBaseCaseSolver.IMPOSSIBLE;

public class Flipper {
    private final boolean[] pancakes;
    private final int flipperSize;
    private final int maxFlipperStart;
    private final List<Integer> flipIndexes = new ArrayList<>();
    private final Map<Integer, Integer> explored = new HashMap<>();
    private int flipCount = 0;

    private int bestSolution = IMPOSSIBLE;

    public Flipper(boolean[] pancakes, int flipperSize) {
        this.pancakes = pancakes;
        this.flipperSize = flipperSize;
        this.maxFlipperStart = this.pancakes.length - flipperSize;
        this.explored.put(hash(), 0);
    }

    public boolean next() {
//        print("NEXT");
        boolean validFlip = false;

        while (!isDone() && !validFlip) {
            if (!canFlip()) {
                explored.put(hash(), flipCount);
                doUnFlip();
            } else {
                validFlip = flipIndexes.isEmpty() || !isPancakesAlreadyKnownBetter();
                if (!validFlip) {
                    doUnFlip();
                } else {
                    doFlip();
                }
            }
        }

        return validFlip;
    }

    private boolean canFlip() {
        return flipIndexes.size() - 1 < flipCount || flipIndexes.get(flipCount) < maxFlipperStart
//                && flipCount < 4 // FIXME
                ;
    }

    private boolean isPancakesAlreadyKnownBetter() {
        boolean pancakesAlreadyKnownBetter = false;
        int hash = hash();
        final Integer previous = explored.putIfAbsent(hash, flipCount);
        if (previous != null && previous < flipCount) {
            pancakesAlreadyKnownBetter = true;
        }
        //print("KnownBetter " + (pancakesAlreadyKnownBetter ? "TRUE " + previous : "FALSE"));
        return pancakesAlreadyKnownBetter;
    }

    private int hash() {
        int flipIndex = flipCount > 0 ? flipIndexes.get(flipCount - 1) : 0;
        return 31 * Integer.hashCode(flipIndex) + 31 * Arrays.hashCode(pancakes);
    }

    private void doFlip() {
        flipCount++;
        if (flipIndexes.size() < flipCount) {
            flipIndexes.add(0);
        } else {
            flipIndexes.set(flipCount - 1, flipIndexes.get(flipCount - 1) + 1);
        }
        flip();
//        print("FLIP");
    }

    private void doUnFlip() {
        flip();
        if (flipIndexes.size() >= flipCount + 1) {
            flipIndexes.remove(flipCount);
        }
        flipCount--;
//        print("UNFLIP");
    }

    public boolean isDone() {
        return flipCount == 0 && !canFlip();
    }

    public boolean checkSolved() {
        for (boolean pancake : pancakes) {
            if (!pancake) {
                return false;
            }
        }
        if (bestSolution == IMPOSSIBLE) {
            bestSolution = flipCount;
        } else {
            bestSolution = Math.min(bestSolution, flipCount);
        }
        return true;
    }

    private void flip() {
        int flipIndex =  flipIndexes.get(flipCount - 1);
        flip(pancakes, flipIndex);
    }

    private void flip(boolean[] pancakes, int flipStart) {
        final int end = flipStart + flipperSize;
        for (int i = flipStart; i < end; i++) {
            pancakes[i] = !pancakes[i];
        }
    }

    public int getBestSolution() {
        return bestSolution;
    }

    private void print(String next) {
//        StringBuilder builder = new StringBuilder(next);
//        builder.append(flipCount)
//                .append(" ")
//                .append(bestSolution)
//                .append(" ")
//                .append(explored.size())
//                .append(" ")
////                .append(flipIndexes)
////                .append(" ")
// ;
//
//        boolean[] pancakesTmp = new boolean[pancakes.length];
//        System.arraycopy(pancakes, 0, pancakesTmp, 0, pancakes.length);
//        StringBuilder builder2 = new StringBuilder();
//        builder2.append(printPancakes(pancakesTmp, flipCount > 0 && flipCount <= flipIndexes.size() ? flipIndexes.get(flipCount - 1) : -1));
//
//        for (int i = flipCount - 1; i >= 0; i--) {
//            int flipIndex = flipIndexes.get(i);
//            flip(pancakesTmp, flipIndex);
//            String builder3 = printPancakes(pancakesTmp, flipIndex);
//            builder2.insert(0, builder3);
//        }
//        builder.append(builder2.toString());

//        System.out.println(builder.toString());
    }

    private String printPancakes() {
       return printPancakes(pancakes,  0);
    }

    private String printPancakes(boolean[] pancakesTmp, int flipIndex) {
        StringBuilder builder3 = new StringBuilder();
        builder3.append(" ")
                .append(flipIndex )
                .append(" => ")
                .append(" " );
        for (boolean pancake : pancakesTmp) {
            builder3.append(pancake ? '+' : '-');
        }
        return builder3.toString();
    }
}
