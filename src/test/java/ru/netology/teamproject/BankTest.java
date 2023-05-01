package ru.netology.teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    void test1() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

         bank.transfer(savingAccount, creditAccount, 500);

        Assertions.assertEquals(1_500, savingAccount.getBalance());
    }

    @Test
    void test2() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        bank.transfer(savingAccount, creditAccount, 500);

        Assertions.assertEquals(2_500, creditAccount.getBalance());
    }

    @Test
    void test5() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(savingAccount, creditAccount, 500));
    }

    @Test
    void test3() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        bank.transfer(savingAccount, creditAccount, 1_500);

        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }

    @Test
    void test4() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        bank.transfer(savingAccount, creditAccount, 1_500);

        Assertions.assertEquals(2_000, savingAccount.getBalance());
    }

    @Test
    void test6() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, 1_500));
    }

    @Test
    void test7() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, 0));
    }

    @Test
    void test8() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                5_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAccount, creditAccount, -1));
    }

    @Test
    void test9() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        bank.transfer(creditAccount, savingAccount, 1_500);

        Assertions.assertEquals(2_000, creditAccount.getBalance());
    }

    @Test
    void test10() {
        SavingAccount savingAccount = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5,
                365
        );
        CreditAccount creditAccount = new CreditAccount(
                2_000,
                1_000,
                5,
                365
        );
        Bank bank = new Bank();

        bank.transfer(creditAccount, savingAccount, 1_500);

        Assertions.assertEquals(2_000, savingAccount.getBalance());
    }
}
