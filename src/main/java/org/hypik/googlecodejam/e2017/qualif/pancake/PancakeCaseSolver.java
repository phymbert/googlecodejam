package org.hypik.googlecodejam.e2017.qualif.pancake;


import java.io.PrintStream;
import java.util.List;

public class PancakeCaseSolver extends PancakeBaseCaseSolver {

    private final Flipper flipper;

    public PancakeCaseSolver(int caseNo, String pancakes, int flipperSize, PrintStream out) {
        super(caseNo, pancakes, flipperSize, out);
        this.flipper = new Flipper(asBoolean(this.pancakes), flipperSize);
    }

    private boolean[] asBoolean(List<Pancake> pancakes) {
        boolean[] pancakesBool = new boolean[pancakes.size()];
        for (int i = 0; i < pancakesBool.length; i++) {
            pancakesBool[i] = pancakes.get(i).asBoolean();
        }
        return pancakesBool;
    }

    public int solve() {
        boolean next = true;
        if (!flipper.checkSolved()) {
            while (!flipper.isDone() && next) {
                flipper.checkSolved();
                next = flipper.next();
            }
        }
        return flipper.getBestSolution();
    }

}
