
package ru.netology.teamproject;

import java.util.ArrayList;
import java.util.List;

public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;
    protected int termDays;
    protected int daysYear = 365;
    protected int yearPercent;

    List<Integer> dayBalanceList = new ArrayList<>();
    List<Integer> addList = new ArrayList<>();
    List<Integer> payList = new ArrayList<>();


    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate, int termDays) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        if (minBalance < 0) {
            throw new IllegalArgumentException(
                    "Минимальный баланс не может быть отрицательным, а у вас: " + minBalance
            );
        }
        if (initialBalance < minBalance) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть меньше минимального баланса, а у вас начальный баланс : " + initialBalance +
                            ", а минимальный баланс : " + minBalance
            );
        }
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException(
                    "Максимальный  баланс не может быть меньше или равен минимальному балансу, а у вас максимальный баланс : " + maxBalance +
                            ", а минимальный баланс : " + minBalance
            );
        }
        if (termDays <= 0) {
            throw new IllegalArgumentException(
                    "Срок не может быть равен нулю или отрицательным, а у вас: " + termDays
            );
        }
        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
        this.termDays = termDays;
    }

    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount + yearPercent < minBalance) {
            return false;
        }
        if (amount <= yearPercent) {
            yearPercent = yearPercent - amount;
            payList.add(amount);
            return true;
        }
        balance = balance - amount + yearPercent;
        payList.add(amount);
        yearPercent = 0;
        return true;
    }

    public int getAmountPay() {
        int amountPay = 0;
        for (int i : payList) {
            amountPay = amountPay + i;
        }
        return amountPay;
    }

    public void clearPayList() {
        payList.clear();
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance + amount <= maxBalance) {
            balance = balance + amount;
            addList.add(amount);
            return true;
        } else {
            return false;
        }
    }

    public int getAmountAdd() {
        int amountAdd = 0;
        for (int i : addList) {
            amountAdd = amountAdd + i;
        }
        return amountAdd;
    }

    public void clearAddList() {
        addList.clear();
    }

    public List<Integer> getAddList() {
        return addList;
    }

    public List<Integer> getPayList() {
        return payList;
    }

    @Override
    public int yearChange() {
        int change = 0;

        if (termDays == daysYear) {
            change = balance * rate / 100;
        }
        return change;
    }

    public void addDayBalance() {
        dayBalanceList.add(balance);
    }

    public void yearPercent() {
        int amount = 0;
        for (int i : dayBalanceList) {
            amount = i + amount;
        }
        double yearPercent = (double) amount / daysYear * rate / 100;
        this.yearPercent = (int) yearPercent;
        dayBalanceList.clear();

    }

    public List<Integer> getDayBalanceList() {
        return dayBalanceList;
    }

    @Override
    public void setRate(int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        this.rate = rate;
    }

    public int getYearPercent() {
        return yearPercent;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        if (minBalance < 0) {
            throw new IllegalArgumentException(
                    "Минимальный баланс не может быть отрицательным, а у вас: " + minBalance
            );
        }
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException(
                    "Максимальный  баланс не может быть меньше или равен минимальному балансу, а у вас максимальный баланс : " + maxBalance +
                            ", а минимальный баланс : " + minBalance
            );
        }
        this.minBalance = minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(int maxBalance) {
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException(
                    "Максимальный  баланс не может быть меньше или равен минимальному балансу, а у вас максимальный баланс : " + maxBalance +
                            ", а минимальный баланс : " + minBalance
            );
        }
        this.maxBalance = maxBalance;
    }

    public SavingAccount getSavingAccount(SavingAccount account) {
        return account;
    }
}




