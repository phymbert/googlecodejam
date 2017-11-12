package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PancakeFlipper {

    private final PrintStream out;

    private final int caseSize;
    private final Scanner scanner;
    private final Stream<PancakeBaseCaseSolver> pancakeCases;

    public PancakeFlipper(final InputStream in, final PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.caseSize = scanner.nextInt();
        this.pancakeCases = IntStream.rangeClosed(1, caseSize)
                    .mapToObj(this::readCase);
    }

    private PancakeBaseCaseSolver readCase(int caseNo) {
        return new PancakeStupidCaseSolverNotRecursive(caseNo, scanner.next(), scanner.nextInt(), this.out);
    }

    public void flipAll() {
        this.pancakeCases.forEach(PancakeBaseCaseSolver::flipAndPrint);
    }

    public static void main(String[] args) {
        new PancakeFlipper(System.in, System.out).flipAll();
    }
}
