import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundResult(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundResult(amount + amount * yearRate * period, 2);
    }

    double roundResult(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void countDeposit() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        double item = 0;

        if (action == 1) {
            item = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            item = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + item);
    }

    public static void main(String[] args) {
        new DepositCalculator().countDeposit();
    }
}
