package org.hypik.googlecodejam.e2017.qualif.tidy;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Tidy extends TidyBase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        IntStream.range(0, count)
                .forEach(caseNo -> System.out.println(new Tidy(caseNo + 1, scanner.next()).resolve()));
    }

    public Tidy() {
        super(0, null);
    }

    public Tidy(int caseNumber, String input) {
        super(caseNumber, input);
    }

    @Override
    protected String tidy(String input) {
        int index;
        while ((index = findNotTidyIndex(input)) >= 0) {
            input = input.substring(0, index - 1) + (asInt(input, index - 1) - 1) + nine(input.length() - index);
        }
        return input.replaceFirst("0+", "");
    }
}
