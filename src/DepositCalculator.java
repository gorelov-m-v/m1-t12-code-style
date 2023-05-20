import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundResult(income, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundResult(amount + amount * yearRate * period, 2);
    }

    double roundResult(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void countDeposit() {
        int period;
        int action;
        int amount;
        double returnedPayment = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        if (action == 1) {
            returnedPayment = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            returnedPayment = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + returnedPayment);
    }

    public static void main(String[] args) {
        new DepositCalculator().countDeposit();
    }
}
