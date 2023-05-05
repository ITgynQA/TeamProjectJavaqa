package ru.netology.teamproject;

public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;

    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {

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
        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount < minBalance) {
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
        if (balance + amount > maxBalance) {
            return false;
        } else {
            balance = balance + amount;
            return true;
        }
    }

    @Override
    public int yearChange() {
        return balance * rate / 100;
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