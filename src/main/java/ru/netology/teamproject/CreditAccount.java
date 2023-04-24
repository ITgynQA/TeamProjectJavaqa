
package ru.netology.teamproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Кредитный счёт
 * Может иметь баланс вплоть до отрицательного, но до указанного кредитного лимита.
 * Имеет ставку - количество процентов годовых на сумму на балансе, если она меньше нуля.
 * При создании, баланс кредитного счёта изначально выставляется в кредитный лимит.
 */
public class CreditAccount extends Account {

    protected int creditLimit;
    protected int daysYear = 365;
    List<Integer> dayBalance = new ArrayList<>();

    /**
     * Создаёт новый объект кредитного счёта с заданными параметрами.
     * Если параметры некорректны (кредитный лимит отрицательный и так далее), то
     * должно выкидываться исключения вида IllegalArgumentException.
     * @param initialBalance - неотрицательное число, начальный баланс для счёта
     * @param creditLimit - неотрицательное число, максимальная сумма которую можно задолжать банку
     * @param rate - неотрицательное число, ставка кредитования для расчёта долга за отрицательный баланс
     */
    public CreditAccount(int initialBalance, int creditLimit, int rate) {
        super(initialBalance, rate);
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть отрицательным, а у вас: " + initialBalance
            );
        }
        if (creditLimit < 0) {
            throw new IllegalArgumentException(
                    "Кредитный лимит не может быть отрицательным, а у вас: " + creditLimit
            );
        }
        if (initialBalance != creditLimit) {
            throw new IllegalArgumentException(
                    "Начальный баланс должен быть равен кредитному лимиту, а у вас: баланс " + initialBalance +
                    " ,а лимит " + creditLimit
            );
        }
        this.creditLimit = creditLimit;
    }

    /**
     * Операция оплаты с карты на указанную сумму.
     * В результате успешного вызова этого метода, баланс должен уменьшиться
     * на сумму покупки. Если же операция может привести к некорректному
     * состоянию счёта (например, баланс может уйти в минус), то операция должна
     * завершиться вернув false и ничего не поменяв на счёте.
     * @param amount - сумма покупки
     * @return true если операция прошла успешно, false иначе.
     */
    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= -creditLimit) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Операция пополнения карты на указанную сумму.
     * В результате успешного вызова этого метода, баланс должен увеличиться
     * на сумму покупки. Если же операция может привести к некорректному
     * состоянию счёта, то операция должна
     * завершиться вернув false и ничего не поменяв на счёте.
     * @param amount - сумма пополнения
     * @return true если операция прошла успешно, false иначе.
     * @param amount
     * @return
     */
    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }

    /**
     * Операция расчёта процентов на отрицательный баланс счёта при условии, что
     * счёт не будет меняться год. Сумма процентов приводится к целому
     * числу через отбрасывание дробной части (так и работает целочисленное деление).
     * Пример: если на счёте -200 рублей, то при ставке 15% ответ должен быть -30.
     * Пример 2: если на счёте 200 рублей, то при любой ставке ответ должен быть 0.
     * @return
     */
    @Override
    public int yearChange(int month) {
        int change = 0;
        if (balance >= 0) {
            return change;
        }
        if (month == 12) {
            change = balance * rate / 100;
        }
        return change;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        if (creditLimit < 0) {
            throw new IllegalArgumentException(
                    "Кредитный лимит не может быть отрицательным, а у вас: " + creditLimit
            );
        }
        this.creditLimit = creditLimit;
    }

    public CreditAccount getCreditAccount(CreditAccount creditAccount) {
        return creditAccount;
    }

    public void days() {
        dayBalance.add(balance);
    }

    @Override
    public boolean addYearPercent() {
        if(dayBalance.size() == daysYear) {
            int amountYear = 0;
            for (int i : dayBalance) {
                if(i < 0) {
                    amountYear = i + amountYear;
                    double yearPercent = (double) amountYear / daysYear * rate / 100;
                    balance = (int) yearPercent + balance;
                    return true;
                }
            }
        }
        return false;
    }
}
