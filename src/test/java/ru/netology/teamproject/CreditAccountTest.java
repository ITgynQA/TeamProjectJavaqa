package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldCreateAccountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );
        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void shouldCreateAccountIfInitialBalanceNegative() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getBalance();
        });
    }

    @Test
    public void shouldCreateAccountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldCreateAccountIfCreditLimitPositive() {
        CreditAccount account = new CreditAccount(
                1000,
                1,
                15
        );
        Assertions.assertEquals(1, account.getCreditLimit());
    }

    @Test
    public void shouldCreateAccountIfCreditLimitNegative() {
        CreditAccount account = new CreditAccount(
                1000,
                -1,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getCreditLimit();
        });
    }

    @Test
    public void shouldCreateAccountIfCreditLimitZero() {
        CreditAccount account = new CreditAccount(
                1000,
                0,
                15
        );
        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldCreateAccountIfRatePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                1
        );
        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void shouldCreateAccountIfRateNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                -1
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getBalance();
        });
    }

    @Test
    public void shouldCreateAccountIfRateZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldPositivePayBelowLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayBelowCreditLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(6000);

        Assertions.assertEquals(-1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayAboveLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10
        );
        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldNegativePayIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(-4000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldZeroPayIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(0);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldPositivePayBelowLimitIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                10
        );
        account.pay(3000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPositivePayAboveLimitIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                3000,
                10
        );
        account.pay(4000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.add(-50);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                2000,
                10
        );
        account.add(-50);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddZeroAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.add(0);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAddZeroAmountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                2000,
                10
        );
        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddPositiveAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.add(1000);

        Assertions.assertEquals(6000, account.getBalance());
    }

    @Test
    public void shouldYearChangeToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }
}
