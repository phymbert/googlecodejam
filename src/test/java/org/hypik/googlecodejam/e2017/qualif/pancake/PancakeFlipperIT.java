package org.hypik.googlecodejam.e2017.qualif.pancake;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class PancakeFlipperIT {

    @Test
    public void testSmall() {
        // Given
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //PrintStream printStream = new PrintStream(out);



        InputStream in = getClass().getResourceAsStream("/2017/qualif/A/A-small-practice.in");
        PancakeFlipper pancakeFlipper = new PancakeFlipper(in, System.out);

        // When
        pancakeFlipper.flipAll();

        // Then
        //String result = new String(out.toByteArray());
        //System.out.println(result);
    }
}
