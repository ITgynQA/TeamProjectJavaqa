package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class CreditAccountTest {

    @Test
    public void shouldCreateAdequateAccount() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15,
                365
        );

        Assertions.assertEquals(account, account.getCreditAccount(account));
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15,
                365
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldCreateAdequateAccount0() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15,
                365
        );

        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void shouldNotCreateAccountIfInitialBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(
                -1,
                5_000,
                15,
                365
        ));
    }

    @Test
    public void shouldCreateAccountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15,
                365
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldCreateAccountIfCreditLimitPositive() {
        CreditAccount account = new CreditAccount(
                1000,
                1,
                15,
                365
        );

        Assertions.assertEquals(1, account.getCreditLimit());
    }

    @Test
    public void shouldNotCreateAccountIfCreditLimitNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1000,
                    -1,
                    15,
                    365
            );
        });
    }

    @Test
    public void shouldCreateAccountIfCreditLimitZero() {
        CreditAccount account = new CreditAccount(
                1000,
                0,
                15,
                365
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldCreateAccountIfRatePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                1,
                365
        );

        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void shouldNotCreateAccountIfRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5000,
                    -1,
                    365
            );
        });
    }

    @Test
    public void shouldNotCreateAccountIfTermDaysZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1000,
                    1000,
                    15,
                    0
            );
        });
    }

    @Test
    public void shouldNotCreateAccountIfTermDaysLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    1000,
                    1000,
                    15,
                    -1
            );
        });
    }

    @Test
    public void shouldCreateAccountIfRateZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                0,
                365
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldPositivePayBelowLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayBelowCreditLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.pay(6000);

        Assertions.assertEquals(-1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayBelowCreditLimitAssertTrue() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        Assertions.assertTrue(account.pay(6000));
    }

    @Test
    public void shouldPositivePayAboveLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10,
                365
        );

        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayAboveLimitAssertFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10,
                365
        );

        Assertions.assertFalse(account.pay(4000));
    }

    @Test
    public void shouldPositivePayEqualsLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                2000,
                3000,
                10,
                365
        );

        account.pay(5000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPositivePayEqualsLimitAssertTrue() {
        CreditAccount account = new CreditAccount(
                2000,
                3000,
                10,
                365
        );

        Assertions.assertTrue(account.pay(5000));
    }

    @Test
    public void shouldNotNegativePay() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.pay(-4000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAssertFalseIfNegativePay() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        Assertions.assertFalse(account.pay(-4000));
    }


    @Test
    public void shouldNotZeroPay() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.pay(0);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAssertFalseIfZeroPay() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        Assertions.assertFalse(account.pay(0));
    }

    @Test
    public void shouldPositivePayBelowLimitIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                10,
                365
        );

        account.pay(3000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPositivePayAboveLimitIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                3000,
                10,
                365
        );

        account.pay(4000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    void shouldAddAmountToPayListIfBalanceAfterPayMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        account.pay(3000);
        account.pay(2000);
        account.pay(1500);
        account.pay(1000);
        account.pay(500);

        List<Integer> payList = new ArrayList<>();

        payList.add(3000);
        payList.add(2000);
        payList.add(1500);
        payList.add(1000);
        payList.add(500);

        Assertions.assertEquals(payList, account.getPayList());
    }

    @Test
    void shouldAddAmountToPayListIfBalanceAfterPayEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        account.pay(10_000);
        account.pay(2000);
        account.pay(1500);
        account.pay(1000);
        account.pay(500);

        List<Integer> payList = new ArrayList<>();

        payList.add(10_000);
        payList.add(2000);
        payList.add(1500);
        payList.add(1000);
        payList.add(500);

        Assertions.assertEquals(payList, account.getPayList());

    }

    @Test
    public void shouldAssertFalseIfBalanceAfterPayLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        Assertions.assertFalse(account.pay(15_001));
    }

    @Test
    void shouldNotAddAmountToPayListIfBalanceAfterPayLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        account.pay(10_001);
        account.pay(2000);
        account.pay(2000);
        account.pay(1000);
        account.pay(500);

        Assertions.assertEquals(14501, account.getAmountPay());
    }

    @Test
    void shouldNotAddAmountIfBalanceAfterPayLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        account.pay(10_001);
        account.pay(2000);
        account.pay(2000);
        account.pay(1000);
        account.pay(500);

        List<Integer> payList = new ArrayList<>();
        payList.add(10_001);
        payList.add(2000);
        payList.add(2000);
        payList.add(500);

        Assertions.assertEquals(payList, account.getPayList());
    }

    @Test
    void shouldGetAmountPay() {
        CreditAccount account = new CreditAccount(
                5_000,
                10_000,
                15,
                365
        );

        List<Integer> payList = new ArrayList<>();

        account.pay(3000);
        account.pay(2000);
        account.pay(1500);
        account.pay(1000);
        account.pay(500);

        Assertions.assertEquals(8_000, account.getAmountPay());
    }

    @Test
    void shouldAddAmountToPayList() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.pay(1000);
        account.pay(2000);
        account.pay(2000);
        account.pay(5000);

        List<Integer> payList = new ArrayList<>();

        payList.add(1000);
        payList.add(2000);
        payList.add(2000);
        payList.add(5000);

        Assertions.assertEquals(payList, account.getPayList());
    }

    @Test
    void shouldShowClearPayList() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.pay(1000);
        account.pay(2000);
        account.pay(2000);
        account.pay(500);
        account.clearPayList();

        List<Integer> payList = new ArrayList<>();

        Assertions.assertEquals(payList, account.getPayList());
    }

    @Test
    void shouldShowAmountToPay() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.pay(1000);
        account.pay(2000);
        account.pay(2000);
        account.pay(500);

        Assertions.assertEquals(5500, account.getAmountPay());
    }

    @Test
    void shouldShowBalanceAfterPay() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.pay(1000);
        account.pay(2000);
        account.pay(3000);
        account.pay(5000);

        Assertions.assertEquals(-1000, account.getBalance());
    }


    @Test
    public void shouldAddNegativeAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.add(-50);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmountAssertFalse() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        Assertions.assertFalse(account.add(-50));
    }

    @Test
    public void shouldAddNegativeAmountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                2000,
                10,
                365
        );

        account.add(-50);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddZeroAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.add(0);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAddZeroAmountIfInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                2000,
                10,
                365
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddPositiveAmountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        account.add(1000);

        Assertions.assertEquals(6000, account.getBalance());
    }

    @Test
    public void shouldAddPositiveAmountAssertTrue() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10,
                365
        );

        Assertions.assertTrue(account.add(1000));
    }

    @Test
    void shouldAddAmountToAddList() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.add(1000);
        account.add(2000);
        account.add(2000);
        account.add(500);

        List<Integer> addList = new ArrayList<>();

        addList.add(1000);
        addList.add(2000);
        addList.add(2000);
        addList.add(500);

        Assertions.assertEquals(addList, account.getAddList());
    }

    @Test
    void shouldShowClearAddList() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.add(1000);
        account.add(2000);
        account.add(2000);
        account.add(500);
        account.clearAddList();

        List<Integer> addList = new ArrayList<>();

        Assertions.assertEquals(addList, account.getAddList());
    }

    @Test
    void shouldShowAmountToAdd() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.add(1000);
        account.add(2000);
        account.add(2000);
        account.add(500);

        Assertions.assertEquals(5500, account.getAmountAdd());
    }

    @Test
    void shouldShowBalanceAfterAdd() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                10,
                365
        );

        account.add(1000);
        account.add(2000);
        account.add(2000);
        account.add(500);

        Assertions.assertEquals(15500, account.getBalance());
    }


    @Test
    public void shouldCalculatePercentToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15,
                365
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentToBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15,
                365
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15,
                365
        );

        account.pay(500);
        account.pay(500);
        account.pay(500);
        account.pay(500);

        Assertions.assertEquals(-300, account.yearChange());
    }

    @Test
    void shouldCreateDayBalanceList() {
        CreditAccount account = new CreditAccount(
                1000,
                10_000,
                10,
                365
        );

        account.addDayBalance();
        account.pay(5000);
        account.addDayBalance();
        account.pay(3000);
        account.addDayBalance();
        account.add(2000);
        account.addDayBalance();

        List<Integer> dayBalanceList = new ArrayList<>();

        dayBalanceList.add(1000);
        dayBalanceList.add(-4000);
        dayBalanceList.add(-7000);
        dayBalanceList.add(-5000);

        Assertions.assertEquals(dayBalanceList, account.getDayBalanceList());

    }

    @Test
    void shouldCalculatePercentAfterPayEqualsLimit() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                10,
                365
        );

        account.pay(10_000);

        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(-8, account.getYearPercent());
    }

    @Test
    void shouldCalculatePercentIfRateZero() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                0,
                365
        );

        account.pay(10_000);

        account.addDayBalance();
        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(0, account.getYearPercent());
    }

    @Test
    void shouldCalculatePercentAfterPayLessLimit() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                10,
                365
        );

        account.pay(5_553);

        account.addDayBalance();
        account.addDayBalance();
        account.yearPercent();

        Assertions.assertEquals(-3, account.getYearPercent());
    }

    @Test
    public void shouldSetToPositiveRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        account.setRate(10);

        Assertions.assertEquals(10, account.getRate());
    }

    @Test
    public void shouldSetToZeroRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        account.setRate(0);

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldSetToNegativeRate() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setRate(-10);

        });
    }

    @Test
    public void shouldIncreaseCreditLimit() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        account.setCreditLimit(6000);

        Assertions.assertEquals(6000, account.getCreditLimit());

    }

    @Test
    public void shouldDecreaseCreditLimit() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        account.setCreditLimit(4000);

        Assertions.assertEquals(4000, account.getCreditLimit());

    }

    @Test
    public void shouldSetCreditLimitToZero() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        account.setCreditLimit(0);

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldNotDecreaseCreditLimitBelowZero() {
        CreditAccount account = new CreditAccount(
                2000,
                5000,
                15,
                365
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setCreditLimit(-1000);
        });
    }
}
