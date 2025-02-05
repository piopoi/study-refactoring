package refactoring.ch1;

import static org.assertj.core.api.Assertions.*;
import static refactoring.ch1.PlayType.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvoiceGeneratorTest {

    private InvoiceGenerator invoiceGenerator;
    private List<Performance> performances;
    private Invoice invoice;
    private Map<String, Play> plays;

    @BeforeEach
    void setUp() {
        invoiceGenerator = new InvoiceGenerator();

        performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));

        invoice = new Invoice("BigCo", performances);

        plays = new HashMap<>();
        plays.put("hamlet", new Play("hamlet", TRAGEDY));
        plays.put("as-like", new Play("As You Like It", COMEDY));
        plays.put("othello", new Play("Othello", TRAGEDY));
    }

    @Test
    void statement() {
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

    @Test
    void htmlStatement() {
        //when
        String actual = invoiceGenerator.htmlStatement(invoice, plays);

        //then
        String expected = """
                <h1>청구 내역 (고객명: BigCo)</h1>
                <table>
                 <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr> <tr>
                  <td>hamlet</td>
                  <td>(55석)</td>
                  <td>$650.00</td>
                 </tr>
                 <tr>
                  <td>As You Like It</td>
                  <td>(35석)</td>
                  <td>$580.00</td>
                 </tr>
                 <tr>
                  <td>Othello</td>
                  <td>(40석)</td>
                  <td>$500.00</td>
                 </tr>
                </table>
                <p>총액: <em>$1,730.00</em></p>
                <p>적립 포인트: <em>47}</em>점</p>
                """;
        assertThat(actual).isEqualTo(expected);
    }
}
