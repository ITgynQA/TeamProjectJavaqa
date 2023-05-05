package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class BankTest {

    @Test
    public void shouldTrueIfTransferIsActual() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                1000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 1000));
    }

    @Test
    public void shouldShowCreditAccountIfTransferIsActual() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );
        bank.transfer(creditAccount, savingAccount, 3_000);

        Assertions.assertEquals(-1_000, creditAccount.getBalance());
    }

    @Test
    public void shouldShowSavingAccountIfTransferIsActual() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );
        bank.transfer(creditAccount, savingAccount, 3_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }

    @Test
    public void shouldFalseIfTransferIsZero() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                1000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertFalse(bank.transfer(creditAccount, savingAccount, 0));
    }

    @Test
    public void shouldFalseIfTransferIsBelowZero() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                1000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertFalse(bank.transfer(creditAccount, savingAccount, -1));
    }

    @Test
    public void  shouldTrueAtTransferIfCreditLimitIsZero() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                0,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 1000));
    }

    @Test
    public void shouldTrueAtTransferIfMinBalanceIsZero() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                10_000,
                10
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 1000));
    }

    @Test
    public void shouldTrueAtTransferIfMinBalanceAndInitialBalanceIsZero() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                0,
                0,
                10_000,
                10
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 1000));
    }

    @Test
    public void shouldTrueAtTransferEqualsCreditLimit () {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 7000));
    }

    @Test
    public void shouldFalseAtTransferAboveCreditLimit() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                3_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertFalse(bank.transfer(creditAccount, savingAccount, 6000));
    }

    @Test
    public void shouldShowBalanceCreditAccountAtTransferAboveCreditLimit() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                3_000,
                15
        );

        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );
        bank.transfer(creditAccount, savingAccount, 10_000);

        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }

    @Test
    public void shouldFalseAtTransferAboveMaxBalance() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                3_000,
                3_000,
                15
        );

        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                10
        );

        Assertions.assertFalse(bank.transfer(creditAccount, savingAccount, 8_000));
    }

    @Test
    public void shouldShowCreditBalanceAtTransferAboveMaxBalance() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                10_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                10
        );
        bank.transfer(creditAccount, savingAccount, 8_000);

        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }

    @Test
    public void shouldShowSavingBalanceAtTransferAboveMaxBalance() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                2_000,
                10_000,
                15
        );

        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                10
        );

        bank.transfer(creditAccount, savingAccount, 8_000);

        Assertions.assertEquals(2_000, savingAccount.getBalance());
    }

    @Test
    public void shouldAddSavingAccount() {
        Bank bank = new Bank();

        CreditAccount creditAccount = new CreditAccount(
                3_000,
                5_000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                3_000,
                1_000,
                10_000,
                10
        );

        bank.transfer(creditAccount, savingAccount, 3_000);

        Assertions.assertEquals(6_000, savingAccount.getBalance());
    }

    @Test
    void shouldTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 1_000);

        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }

    @Test
    void shouldChangeSavingBalanceAfterTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 1_000);

        Assertions.assertEquals(0, savingAccount.getBalance());
    }

    @Test
    void shouldReturnTrueTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(savingAccount, creditAccount, 1_000));
    }

    @Test
    void shouldNotChangeSavingBalanceAfterTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 7_000);

        Assertions.assertEquals(1_000, savingAccount.getBalance());
    }

    @Test
    void shouldNotChangeCreditBalanceAfterTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 7_000);

        Assertions.assertEquals(1_000, creditAccount.getBalance());
    }

    @Test
    void shouldReturnFalseTransferToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, 7_000));
    }

    @Test
    void shouldReturnFalseTransferToCreditAccountIfAmountEqualsZero() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, 0));
    }

    @Test
    void shouldReturnFalseTransferToCreditAccountIfAmountNegative() {
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                0,
                5_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                1_000,
                2_000,
                10
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, 0));
    }
}