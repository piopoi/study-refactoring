package refactoring.ch1;

import static org.assertj.core.api.Assertions.*;
import static refactoring.ch1.PlayType.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class InvoiceGeneratorTest {

    @Test
    void statement() {
        //given
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));

        Invoice invoice = new Invoice("BigCo", performances);

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("hamlet", TRAGEDY));
        plays.put("as-like", new Play("As You Like It", COMEDY));
        plays.put("othello", new Play("Othello", TRAGEDY));

        //when
        String actual = invoiceGenerator.statement(invoice, plays);

        //then
        String expected = """
                청구 내역 (고객명: BigCo)
                 hamlet: $650.00 (55석)
                 As You Like It: $580.00 (35석)
                 Othello: $500.00 (40석)
                총액: $1,730.00
                적립 포인트: 47점
                """;
        assertThat(actual).isEqualTo(expected);
    }
}
