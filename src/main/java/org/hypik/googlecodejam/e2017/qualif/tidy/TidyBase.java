package org.hypik.googlecodejam.e2017.qualif.tidy;

import java.util.stream.IntStream;

public abstract class TidyBase {

    private final int caseNumber;
    private final String input;

    protected TidyBase(int caseNumber, String input) {
        this.caseNumber = caseNumber;
        this.input = input;
    }

    public String resolve() {
        String output = tidy(input);
        return String.format("Case #%d: %s", caseNumber, output);
    }

    protected abstract String tidy(String input);

    protected int findNotTidyIndex(String input) {
        int index = -1;
        for (int i = 0; i < input.length() - 1; i++) {
            int a = asInt(input, i);
            int b = asInt(input, i + 1);
            if (a > b) {
                index = i + 1;
                break;
            }
        }
        return index;
    }

    protected String nine(int i) {
        StringBuilder b = new StringBuilder();
        IntStream.range(0, i).forEach(j -> b.append(9));
        return b.toString();
    }

    protected int asInt(String input, int i) {
        return input.charAt(i) - 48;
    }
}
