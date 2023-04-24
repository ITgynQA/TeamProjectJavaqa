package ru.netology.teamproject;

public class Account {
    protected int balance;
    protected int rate;

    public Account(int balance, int rate) {
        this.balance = balance;
        this.rate = rate;
    }

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange(int month) {
        return 0;
    }

    public boolean addYearPercent() {
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        this.rate = rate;
    }
}