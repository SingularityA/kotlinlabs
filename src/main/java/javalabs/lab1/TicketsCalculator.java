package javalabs.lab1;

/**
 * Стоимость билета на одно посещение равна 15 единицам, на десять - 125, на шестьдесят - 440.
 * Для заданного количества посещений найти оптимальное по цене количество билетов каждого типа.
 */
public class TicketsCalculator {
    private static final int[] cost = {15, 125, 440};
    private static final int[] amount = {1, 10, 60};

    public int[] calculate(int desiredAmount) {
        int n1 = desiredAmount / amount[2],
                n2 = (desiredAmount - n1 * amount[2]) / amount[1],
                n3 = (desiredAmount - n1 * amount[2] - n2 * amount[1]) / amount[0];

        int[] candidates = {n1 * cost[2] + n2 * cost[1] + n3 * cost[0],
                n1 * cost[2] + (n2 + 1) * cost[1],
                (n1 + 1) * cost[2]
        };

        int min = indexOfMin(candidates);
        int[] result;

        switch (min) {
            case 0:
                result = new int[]{n3, n2, n1};
                break;
            case 1:
                result = new int[]{0, n2 + 1, n1};
                break;
            case 2:
                result = new int[]{0, 0, n1 + 1};
                break;
            default:
                result = new int[]{0, 0, 0};
        }
        return result;
    }

    private static int indexOfMin(int[] array) {
        int current = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[current]) {
                current = i;
            }
        }
        return current;
    }
}
