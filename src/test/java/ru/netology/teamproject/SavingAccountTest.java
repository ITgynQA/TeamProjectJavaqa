package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeRateAtSavingAccount() {

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
    void shouldTrowIllegalArgumentExceptionIfNegativeMinBalanceAtSavingAccount() {

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
    void shouldTrowIllegalArgumentExceptionIfInitialBalanceLessThanMinBalanceAtSavingAccount() {

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
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceLessThanMinBalanceAtSavingAccount() {

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
    void shouldTrowIllegalArgumentExceptionIfMaxBalanceEqualsMinBalanceAtSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    1_000,
                    1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetRateNegativeAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setRate(-1);
        });
    }

    @Test
    void shouldSetRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );
        account.setRate(0);

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetMinBalanceNegativeAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(-1);
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetMinBalanceMoreThanMaxBalanceAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(10_001);
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetMinBalanceEqualsMaxBalanceAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(10_000);
        });
    }

    @Test
    void shouldSetMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        account.setMinBalance(0);

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetMaxBalanceEqualsMinBalanceAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMaxBalance(1_000);
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetMaxBalanceLessThanMinBalanceAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMaxBalance(999);
        });
    }

    @Test
    void shouldSetMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );
        account.setMaxBalance(11_000);

        Assertions.assertEquals(11_000, account.getMaxBalance());
    }


    @Test
    void shouldCreateSavingAccountIfInitialBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(account, account.getSavingAccount(account));
    }

    @Test
    void shouldCreateSavingAccountIfRateIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        Assertions.assertEquals(account, account.getSavingAccount(account));

    }

    @Test
    void shouldChangeBalanceToPurchaseAmountAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());

    }

    @Test
    void shouldReturnTrueAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15
        );

        Assertions.assertTrue(account.pay(90_000));

    }

    @Test
    void shouldNotChangeBalanceIfAmountIsZeroAtPay() {
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
    void shouldNotChangeBalanceIfAmountIsNegativeAtPay() {
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
    void shouldNotChangeBalanceIfAfterAmountBalanceLessThanMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15
        );

        account.pay(100_165);

        Assertions.assertEquals(100_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAfterAmountBalanceLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15
        );

        Assertions.assertFalse(account.pay(100_165));

    }

    @Test
    void shouldChangeBalanceToAmountIfAfterAmountBalanceEqualsMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(99_000, account.getBalance());

    }

    @Test
    void shouldReturnTrueAtPayIfAfterAmountBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15
        );

        Assertions.assertTrue(account.pay(1_000));
    }

    @Test
    void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
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
    void shouldNotChangeBalanceAtAddIfAmountEqualsZero() {
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
    void shouldNotChangeBalanceAtAddIfAmountNegative() {
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
    void shouldNotChangeBalanceAtAddIfAfterAmountBalanceMoreThanMaxBalance() {
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
    void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());

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
                0,
                1000,
                5
        );

        Assertions.assertEquals(1, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultLessThanOne() {
        SavingAccount account = new SavingAccount(
                10,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenBalanceIsZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
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
