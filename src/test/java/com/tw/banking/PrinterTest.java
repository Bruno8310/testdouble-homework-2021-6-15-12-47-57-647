package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class PrinterTest {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    @Test
    void should_print_line_when_call_print_all_transaction() {
        // given
        List<Transaction> transactions = new ArrayList<>();
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        // when
        printer.print(transactions);
        // then
        verify(console, times(1)).printLine(STATEMENT_HEADER);
    }

    @Test
    void should_print_ordered_statement_lines_when_call_printStatementLines_method() {
        // given
        Transaction transaction1 = new Transaction("12/06/2121", 1000);
        Transaction transaction2 = new Transaction("13/06/2121", 100);
        Transaction transaction3 = new Transaction("14/06/2121", 50);
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        // when
        printer.print(transactions);
        // then
        verify(console, times(1)).printLine(STATEMENT_HEADER);
    }

}
