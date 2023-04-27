package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SavingAccountTest {

    @Test
    void shouldTrowIllegalArgumentExceptionIfNegativeRateAtSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1,
                    365
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
                    1,
                    365
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
                    1,
                    365
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
                    1,
                    365
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
                    1,
                    365
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfTermDaysIsNegativeAtSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    1,
                    -1
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfTermDaysIsZeroAtSavingAccount() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    1,
                    0
            );
        });
    }

    @Test
    void shouldTrowIllegalArgumentExceptionIfSetRateNegativeAtSavingAccount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                1,
                365
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
                5,
                365
        );

        Assertions.assertEquals(account, account.getSavingAccount(account));
    }

    @Test
    void shouldCreateSavingAccountIfRateIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0,
                365
        );

        Assertions.assertEquals(account, account.getSavingAccount(account));
    }

    @Test
    void shouldChangeBalanceToPurchaseAmountAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );
        account.pay(500);

        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );

        Assertions.assertTrue(account.pay(90_000));
    }

    @Test
    void shouldNotChangeBalanceIfAmountIsZeroAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
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
                5,
                365
        );

        Assertions.assertFalse(account.pay(0));
    }

    @Test
    void shouldNotChangeBalanceIfAmountIsNegativeAtPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
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
                5,
                365
        );
        Assertions.assertFalse(account.pay(-1));
    }

    @Test
    void shouldNotChangeBalanceIfAfterAmountBalanceLessThanMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();
        account.pay(100_165);

        Assertions.assertEquals(100_000, account.getBalance());
    }

    @Test
    void shouldReturnFalseAtPayIfAfterAmountBalanceLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertFalse(account.pay(100_165));
    }

    @Test
    void shouldChangeBalanceToAmountIfAfterAmountBalanceEqualsMinBalanceAtPay() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();
        account.pay(99_164);

        Assertions.assertEquals(account.getMinBalance(), account.getBalance());
    }

    @Test
    void shouldReturnTrueAtPayIfAfterAmountBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertTrue(account.pay(99_164));
    }

    @Test
    void shouldMadeYearPercentIsZeroAfterPayIfAmountMoreThanYearPercent() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();
        account.pay(1000);

        Assertions.assertEquals(0, account.getYearPercent());
    }

    @Test
    void shouldChangeYearPercentAfterPayIfAmountLessThanYearPercent() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();
        account.pay(100);

        Assertions.assertEquals(64, account.getYearPercent());
    }

    @Test
    void shouldAddAmountToPayList() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.pay(100);
        account.pay(1_000);
        account.pay(1_300);
        account.pay(500);

        List<Integer> expected = new ArrayList<>();
        expected.add(100);
        expected.add(1_000);
        expected.add(1_300);
        expected.add(500);

        Assertions.assertEquals(expected, account.getPayList());
    }

    @Test
    void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );
        account.add(3000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    void shouldReturnTrueAtAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );

        Assertions.assertTrue(account.add(3_000));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAmountEqualsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
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
                5,
                365
        );

        Assertions.assertFalse(account.add(0));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
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
                5,
                365
        );

        Assertions.assertFalse(account.add(-1));
    }

    @Test
    void shouldNotChangeBalanceAtAddIfAfterAmountBalanceMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
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
                5,
                365
        );

        Assertions.assertFalse(account.add(8_001));
    }

    @Test
    void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );
        account.add(8_000);

        Assertions.assertEquals(account.getMaxBalance(), account.getBalance());
    }

    @Test
    void shouldReturnTrueAtAddIfAfterAmountBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );

        Assertions.assertTrue(account.add(8_000));
    }

    @Test
    void shouldAddAmountToAddListAfterAdd() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );
        account.add(150);
        account.add(1_500);
        account.add(250);
        account.add(500);

        List<Integer> expected = new ArrayList<>();
        expected.add(150);
        expected.add(1_500);
        expected.add(250);
        expected.add(500);

        Assertions.assertEquals(expected, account.getAddList());
    }

    @Test
    void shouldCalculatePercentOnBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                365
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceIfResultIsNotInteger() {
        SavingAccount account = new SavingAccount(
                2_175,
                1_000,
                10_000,
                5,
                365
        );

        Assertions.assertEquals(108, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultOne() {
        SavingAccount account = new SavingAccount(
                20,
                20,
                10_000,
                5,
                365
        );

        Assertions.assertEquals(1, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWithResultLessThanOne() {
        SavingAccount account = new SavingAccount(
                10,
                10,
                10_000,
                5,
                365
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenBalanceIsZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5,
                365
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldCalculatePercentOnBalanceWhenRateIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0,
                365
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldShowZeroAfterCalculatePercentIfTermDaysLessThanYearAtYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15,
                364
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    void shouldShowAmountOfPurchases() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.pay(150);
        account.pay(250);
        account.pay(300);
        account.pay(1_000);

        Assertions.assertEquals(1_700, account.getAmountPay());
    }

    @Test
    void shouldShowAmountOfPurchasesIfAmountIsOne() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.pay(150);

        Assertions.assertEquals(150, account.getAmountPay());
    }

    @Test
    void shouldShowAmountOfPurchasesIfNotAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );

        Assertions.assertEquals(0, account.getAmountPay());
    }

    @Test
    void shouldClearPayList() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.pay(150);
        account.pay(1_500);
        account.pay(250);
        account.pay(500);
        account.clearPayList();

        List<Integer> expected = new ArrayList<>();

        Assertions.assertEquals(expected, account.getPayList());
    }

    @Test
    void shouldShowAddAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.add(150);
        account.add(250);
        account.add(500);
        account.add(50);

        Assertions.assertEquals(950, account.getAmountAdd());
    }

    @Test
    void shouldShowAddAmountIfAddIsOne() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.add(150);

        Assertions.assertEquals(150, account.getAmountAdd());
    }

    @Test
    void shouldShowAddAmountIsZeroIfNotAdd() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );

        Assertions.assertEquals(0, account.getAmountAdd());
    }

    @Test
    void shouldClearAddList() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                15,
                365
        );
        account.add(150);
        account.add(1_500);
        account.add(250);
        account.add(500);
        account.clearAddList();

        List<Integer> expected = new ArrayList<>();

        Assertions.assertEquals(expected, account.getAddList());
    }

    @Test
    void shouldCreateDayBalanceList() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.pay(55_000);
        account.addDayBalance();
        account.add(10_500);
        account.addDayBalance();
        account.add(500);
        account.addDayBalance();

        List<Integer> expected = new ArrayList<>();
        expected.add(100_000);
        expected.add(45_000);
        expected.add(55_500);
        expected.add(56_000);

        Assertions.assertEquals(expected, account.getDayBalanceList());
    }

    @Test
    void shouldCalculateYearPercent() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(164, account.yearPercent);
    }

    @Test
    void shouldCalculateYearPercentIfRateIsZero() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                0,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(0, account.yearPercent);
    }

    @Test
    void shouldCalculateYearPercentIfDayBalanceIsZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                100_000,
                15,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(0, account.yearPercent);
    }

    @Test
    void shouldClearDayBalanceListAfterCalculateYearPercent() {
        SavingAccount account = new SavingAccount(
                100_000,
                1_000,
                100_000,
                0,
                365
        );
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        List<Integer> expected = new ArrayList<>();

        Assertions.assertEquals(expected, account.getDayBalanceList());
    }
}
