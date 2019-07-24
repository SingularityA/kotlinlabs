package javalabs.lab1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * Стоимость билета на одно посещение равна 15 единицам, на десять - 125, на шестьдесят - 440.
 * Для заданного количества посещений найти оптимальное по цене количество билетов каждого типа.
 */
@RunWith(Parameterized.class)
public class TicketsCalculatorTest {

    private int desiredAmount;
    private int[] typesAmount;

    private TicketsCalculator calculator = new TicketsCalculator();
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public TicketsCalculatorTest(int desiredAmount, int[] typesAmount) {
        this.desiredAmount = desiredAmount;
        this.typesAmount = typesAmount;
    }

    @Parameterized.Parameters(name = "{0}, {1}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {5, new int[]{5, 0, 0}},
                {10, new int[]{0, 1, 0}},
                {60, new int[]{0, 0, 1}},
                {3, new int[]{3, 0, 0}},
                {7, new int[]{7, 0, 0}},
                {30, new int[]{0, 3, 0}},
                {1, new int[]{1, 0, 0}},
                {9, new int[]{0, 1, 0}},
                {59, new int[]{0, 0, 1}},
                {129, new int[]{0, 1, 2}},
                {95, new int[]{0, 0, 2}}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTicketsCalculator() {
        int[] result = calculator.calculate(desiredAmount);

        log.info("Tickets: " + desiredAmount +
                " Expected: " + Arrays.toString(typesAmount) +
                " Result: " + Arrays.toString(result));

        Assert.assertArrayEquals(typesAmount, result);
    }
}
