package ru.netology.teamproject;

import java.util.ArrayList;
import java.util.List;


public class CreditAccount extends Account {

    protected int creditLimit;
    protected int termDays;
    protected int daysYear = 365;
    protected int yearPercent;
    List<Integer> dayBalanceList = new ArrayList<>();
    List<Integer> addList = new ArrayList<>();
    List<Integer> payList = new ArrayList<>();

    public CreditAccount(int initialBalance, int creditLimit, int rate, int termDays) {
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
        if (termDays <= 0) {
            throw new IllegalArgumentException(
                    "Срок не может быть равен нулю или отрицательным, а у вас: " + termDays
            );
        }
        this.balance = initialBalance;
        this.creditLimit = creditLimit;
        this.rate = rate;
        this.termDays = termDays;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= -creditLimit) {
            balance = balance - amount;
            payList.add(amount);
            return true;
        } else {
            return false;
        }
    }

    public int getAmountPay() {
        int amountPay = 0;
        for(int i : payList) {
            amountPay = amountPay + i;
        }
        return amountPay;
    }

    public void clearPayList() {
        payList.clear();
    }

    public List<Integer> getPayListList() {
        return payList;
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount <= -yearPercent) {
            yearPercent = yearPercent + amount;
            addList.add(amount);
            return true;
        }
        addList.add(amount);
        balance = balance + amount + yearPercent;
        yearPercent = 0;
        return true;
    }

    public int getAmountAdd() {
        int amountAdd = 0;
        for(int i : addList) {
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

    @Override
    public int yearChange() {
        int change = 0;
        if (balance >= 0) {
            return change;
        }
        if (termDays == daysYear) {
            change = balance * rate / 100;
        }
        return change;
    }

    public void addDayBalance() {
        dayBalanceList.add(balance);
    }

    public List<Integer> getDayBalanceList() {
        return dayBalanceList;
    }

    public void yearPercent() {
        int amount = 0;
        for (int i : dayBalanceList) {
            if (i < 0) {
                amount = i + amount;
            }
        }
        double yearPercent = (double) amount / daysYear * rate / 100;
        this.yearPercent = (int) yearPercent;
        dayBalanceList.clear();
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

}
