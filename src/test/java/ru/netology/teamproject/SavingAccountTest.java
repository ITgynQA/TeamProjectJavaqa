package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeRateOnSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeMinBalanceOnSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1,
                    10_000,
                    1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfInitialBalanceLessThanMinBalanceOnSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    999,
                    1_000,
                    10_000,
                    1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceLessThanMinBalanceOnSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    999,
                    1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceEqualsMinBalanceOnSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    1_000,
                    1
            );
        });
    }

    // @Test
    //public void shouldCreateSavingAccountIfInitialBalanceEqualsMinBalance() {
    //SavingAccount account = new SavingAccount(
    //       1_000,
    //       1_000,
    //        10_000,
    //        5
    // );

    //   Assertions.assertEquals(account, account.getSavingAccount(account));
    // }

    //  @Test
    // public void shouldCreateSavingAccountIfRateIsZero() {
    // SavingAccount account = new SavingAccount(
    //       2_000,
    //        1_000,
    //        10_000,
    //          0);

    //  Assertions.assertEquals(account, account.getSavingAccount(account));
    //   }

    @Test
    void shouldChangeBalanceToPurchaseAmountAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(500);

        Assertions.assertEquals(2_000 - 500, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.pay(500));
    }

    @Test
    void DoNotShouldChangeBalanceIfAmountIsZeroAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAmountIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.pay(0));
    }

    @Test
    void DoNotShouldChangeBalanceIfAmountIsNegativeAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAmountIsNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.pay(-1001));
    }

    @Test
    void DoNotShouldChangeBalanceIfAfterAmountBalanceLessThanMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAfterAmountBalanceLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.pay((1_001)));
    }

    @Test
    void shouldChangeBalanceToAmountIfAfterAmountBalanceEqualsMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.approvalPay(1000);
        Assertions.assertEquals(2_000 - 1_000, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtPayIfAfterAmountBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.pay(1_000));
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.approvalAdd(3000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.add(3_000));
    }

    @Test
    void DoNotShouldChangeBalanceAtAddIfAmountEqualsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAmountEqualsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(0));
    }

    @Test
    void DoNotShouldChangeBalanceAtAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(-1));
    }

    @Test
    void DoNotShouldChangeBalanceAtAddIfAfterAmountBalanceMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtAddIfAfterAmountBalanceMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertFalse(account.add(8_001));
    }

    @Test
    public void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.approvalAdd(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtAddIfAfterAmountBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertTrue(account.add(8_000));
    }

    @Test
    void shouldCalculatePercentOnBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceIfResultIsNotInteger() {
        SavingAccount account = new SavingAccount(
                2_175,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(108, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultOne() {
        SavingAccount account = new SavingAccount(
                20,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(1, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultLessThanOne() {
        SavingAccount account = new SavingAccount(
                10,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenBalanceIsZero() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenRateIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );
        Assertions.assertEquals(0, account.yearChange());
    }
}
