package com.tw.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TransactionRepositoryTest {

    TransactionRepository repository;

    Clock clock;

    @BeforeEach
    private void setUp() {
        clock = mock(Clock.class);
        repository = new TransactionRepository(clock);
        repository.transactions.clear();
    }

    @Test
    void should_check_add_deposit_correct_when_call_addDespoity_method_then_init_transaction_list_and_give_amount() {
        // given
        int amount = 100;
        // when
        repository.addDeposit(amount);
        // then
        assertEquals(1, repository.transactions.size());
        assertEquals(amount, repository.transactions.get(0).amount());
    }

    @Test
    void should_check_add_withdraw_correct_when_call_addWithdraw_method_then_init_transaction_list_and_give_amount() {
        // given
        int amount = 100;
        // when
        repository.addWithdraw(amount);
        // then
        assertEquals(1, repository.transactions.size());
        assertEquals(-amount, repository.transactions.get(0).amount());
    }

    @Test
    void should_check_allTransactions_size_correct_when_withdraw_and_deposit_by_amount() {
        // when
        List<Transaction> result =  repository.allTransactions();
        // then
        assertEquals(0, result.size());
    }
}
