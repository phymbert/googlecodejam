package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.PrintStream;
import java.util.List;

public abstract class PancakeBaseCaseSolver {
    public static final int IMPOSSIBLE = -1;
    protected final int caseNo;
    protected final PrintStream out;
    protected final int flipperSize;
    protected final List<Pancake> pancakes;

    protected PancakeBaseCaseSolver(final int caseNo, final String pancakes, final int flipperSize, final PrintStream out) {
        this.caseNo = caseNo;
        this.out = out;
        this.pancakes = Pancake.pancakes(pancakes);
        this.flipperSize = flipperSize;
    }

    protected abstract int solve();

    public void flipAndPrint() {
        int flipCount = solve();
        out.println(String.format("Case #%d: %s", caseNo,
                flipCount == IMPOSSIBLE ? "IMPOSSIBLE" : String.valueOf(flipCount)));
    }
}
