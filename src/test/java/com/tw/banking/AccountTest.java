package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    void should_verify_call_addDeposit_method_when_call_deposit_method() {
        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 100;
        // when
        account.deposit(amount);
        // then
        verify(transactionRepository, times(1)).addDeposit(amount);
    }

    @Test
    void should_verify_call_addWithdraw_method_when_call_withdraw_method() {
        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 100;
        // when
        account.withdraw(amount);
        // then
        verify(transactionRepository, times(1)).addWithdraw(amount);
    }

    @Test
    void should_verify_print_addWithdraw_method_when_call_printStatement_method() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        List<Transaction> transactions = new ArrayList<>();
        // when
        account.printStatement();
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        // then
        verify(printer, times(1)).print(transactions);
    }
}
