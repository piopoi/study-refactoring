package refactoring.ch1;

import static refactoring.ch1.PlayType.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class InvoiceGenerator {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        StatementData statementData = new StatementData();
        return renderPlainText(statementData, invoice, plays);
    }

    public String renderPlainText(StatementData statementData, Invoice invoice, Map<String, Play> plays) {
        StringBuilder result = new StringBuilder("청구 내역 (고객명: " + invoice.customer() + ")\n");
        for (Performance performance : invoice.performances()) {
            result.append(String.format(" %s: %s (%d석)\n",
                    playFor(plays, performance).name(),
                    usd(amountFor(plays, performance)),
                    performance.audience()));
        }
        result.append(String.format("총액: %s\n", usd(totalAmount(invoice, plays))));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(invoice, plays)));
        return result.toString();
    }

    private int totalAmount(Invoice invoice, Map<String, Play> plays) {
        int result = 0;
        for (Performance performance : invoice.performances()) {
            result += amountFor(plays, performance);
        }
        return result;
    }

    private int totalVolumeCredits(Invoice invoice, Map<String, Play> plays) {
        int result = 0;
        for (Performance performance : invoice.performances()) {
            result += volumeCreditsFor(plays, performance);
        }
        return result;
    }

    private String usd(int number) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(number / 100);
    }

    private int volumeCreditsFor(Map<String, Play> plays, Performance performance) {
        int result = 0;
        result += Math.max(performance.audience() - 30, 0);
        if (COMEDY == playFor(plays, performance).type()) {
            result += (int) Math.floor(performance.audience() / 5.0);
        }
        return result;
    }

    private Play playFor(Map<String, Play> plays, Performance performance) {
        return plays.get(performance.playId());
    }

    private int amountFor(Map<String, Play> plays, Performance performance) {
        int result;
        switch (playFor(plays, performance).type()) {
            case TRAGEDY: // 비극
                result = 40000;
                if (performance.audience() > 30) {
                    result += 1000 * (performance.audience() - 30);
                }
                break;
            case COMEDY: // 희극
                result = 30000;
                if (performance.audience() > 20) {
                    result += 10000 + 500 * (performance.audience() - 20);
                }
                result += 300 * performance.audience();
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + playFor(plays, performance).type().name());
        }
        return result;
    }
}
