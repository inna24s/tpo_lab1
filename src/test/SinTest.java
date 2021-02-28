package test;

import javafx.util.Pair;
import main.Sinus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SinTest extends Assertions {
    private ArrayList <Pair <Double, Double> > arrayTestValues = new ArrayList<>();
    private ArrayList <Pair <Double, Double> > arrayWrongTestValues = new ArrayList<>();
    private static final double DELTA = 0.001;

    @BeforeEach
    public void setUp() {
        //zero check
        arrayTestValues.add(new Pair<>((double) 0, (double) 0));
        //right side check
        arrayTestValues.add(new Pair<>((double) 1 / 2, Math.PI / 6));
        arrayTestValues.add(new Pair<>(Math.sqrt(2) / 2, 3 * Math.PI / 4));

//        parity check
        arrayTestValues.add(new Pair<>(Math.sqrt(3) / 2, Math.PI / 3));
        arrayTestValues.add(new Pair<>(Math.sqrt(3) / 2, 2* Math.PI/3));

        // test coverage boundaries
        arrayTestValues.add(new Pair<>((double) 1, Math.PI / 2));
        arrayTestValues.add(new Pair<>(-(double) 1, -Math.PI / 2));

        //test NaN, Infinity
        arrayTestValues.add(new Pair<>(Double.NaN, Double.NaN));
        arrayTestValues.add(new Pair<>(Double.NaN, Double.POSITIVE_INFINITY));

        arrayWrongTestValues.add(new Pair<>((double) 0, Math.PI ));
        arrayWrongTestValues.add(new Pair<>(-(double)1/2, 7* Math.PI/6 ));
        arrayWrongTestValues.add(new Pair<>(-(double) 1, 3*Math.PI/2 ));

    }

    @AfterEach
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void testSin() {
        double expected, actual;
        for(Pair entry : arrayTestValues) {
            expected = ( (Double) entry.getKey()).doubleValue();
            actual = Sinus.sin( ( (Double) entry.getValue() ).doubleValue());
            assertEquals(expected, actual, DELTA);
        }
        for(Pair entry : arrayWrongTestValues) {
            expected = ( (Double) entry.getKey()).doubleValue();
            actual = Sinus.sin( ( (Double) entry.getValue() ).doubleValue());
            assertNotEquals(expected, actual, DELTA);
        }
    }
}
