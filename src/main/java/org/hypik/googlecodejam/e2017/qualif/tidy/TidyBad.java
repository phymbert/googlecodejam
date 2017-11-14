package org.hypik.googlecodejam.e2017.qualif.tidy;

import java.math.BigInteger;

public class TidyBad extends TidyBase {

    public TidyBad() {
        super(0, null);
    }

    public TidyBad(int caseNumber, String input) {
        super(caseNumber, input);
    }

    @Override
    protected String tidy(String input) {
        BigInteger big = new BigInteger(input);
        int index;
        while ((index = findNotTidyIndex(big.toString())) >= 0) {
            big = big.subtract(BigInteger.ONE);
        }
        return big.toString();
    }

}
