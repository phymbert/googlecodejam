package org.hypik.googlecodejam.e2017.qualif.pancake;

import java.util.List;

import static org.junit.platform.commons.util.CollectionUtils.toUnmodifiableList;

public enum Pancake {
    HAPPY(),
    BLANK();

    @Override
    public String toString() {
        switch (this) {
            case HAPPY:
                return "+";
            case BLANK:
                return "-";
        }
        throw new IllegalStateException();
    }

    public Pancake opposite() {
        switch (this) {
            case HAPPY:
                return BLANK;
            case BLANK:
                return HAPPY;
        }
        throw new IllegalStateException();
    }

    public static List<Pancake> pancakes(String pancakes) {
        return pancakes.chars().mapToObj(Pancake::parsePancake).collect(toUnmodifiableList());
    }

    private static Pancake parsePancake(int i) {
        switch (i) {
            case 43:
                return Pancake.HAPPY;
            case 45:
                return Pancake.BLANK;
        }
        throw new IllegalStateException("Not a pancake " + i);
    }
}
