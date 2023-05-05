package ru.netology.teamproject;

public class CreditAccount extends Account {
    protected int creditLimit;

    public CreditAccount(int initialBalance, int creditLimit, int rate) {
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
        this.balance = initialBalance;
        this.creditLimit = creditLimit;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount < -creditLimit) {
            return false;
        } else {
            balance = balance - amount;
            return true;
        }
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }

    @Override
    public int yearChange() {
        int change = 0;
        if (balance >= 0) {
            return change;
        }
        return balance * rate / 100;
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

    @Override
    public void setRate(int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        this.rate = rate;
    }
}