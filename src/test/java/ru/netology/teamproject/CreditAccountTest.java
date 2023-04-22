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

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -1,
                    5_000,
                    15
            );
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

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1000,
                    -1,
                    15
            );
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

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5000,
                    -1);
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
    public void shouldPositivePayBelowCreditLimitAssertTrue() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        Assertions.assertTrue(account.pay(6000));
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
    public void shouldPositivePayAboveLimitAssertFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10
        );

        Assertions.assertFalse(account.pay(4000));
    }

    @Test
    public void shouldPositivePayEqualsLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                2000,
                3000,
                10
        );
        account.pay(5000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPositivePayEqualsLimitAssertTrue() {
        CreditAccount account = new CreditAccount(
                2000,
                3000,
                10
        );

        Assertions.assertTrue(account.pay(5000));
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
    public void shouldAddNegativeAmountAssertFalse() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        Assertions.assertFalse(account.add(-50));
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
    public void shouldAddPositiveAmountAssertTrue() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );

        Assertions.assertTrue(account.add(1000));
    }

    @Test
    public void shouldCalculatePercentToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentToBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(200);

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentToNegativeBalanceOddNumber() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(555);

        Assertions.assertEquals(-83, account.yearChange());
    }


    @Test
    public void shouldSetToPositiveRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15
        );
        account.setRate(10);

        Assertions.assertEquals(10, account.getRate());
    }

    @Test
    public void shouldSetToZeroRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15
        );
        account.setRate(0);

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldSetToNegativeRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15
        );
        account.setRate(-10);

        Assertions.assertEquals(15, account.getRate());
    }

    // @Test
    // public void shouldIncreaseCreditLimit() {
    //CreditAccount account = new CreditAccount(
    //     2000,
    //     5000,
    //     15
    // );
    //   account.setCreditLimit(6000);

    //   Assertions.assertEquals(6000, account.getCreditLimit());
    // }

    // @Test
    //  public void shouldDecreaseCreditLimit() {
    // CreditAccount account = new CreditAccount(
    //            5000,
    //            15,
    //          15
    //   );
    //    account.setCreditLimit(4000);

    //   Assertions.assertEquals(4000, account.getCreditLimit());
    // }

    //  @Test
    // public void shouldSetCreditLimitToZero() {
    //    CreditAccount account = new CreditAccount(
    //           2000,
    //          5000,
    //           15
    //   );
    //    account.setCreditLimit(0);

    //   Assertions.assertEquals(0, account.getCreditLimit());
    //}


}
