package refactoring.ch1;

import static refactoring.ch1.PlayType.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceGenerator {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        StatementData statementData = new StatementData(invoice.customer(), enrichPerformances(invoice, plays));
        return renderPlainText(statementData, plays);
    }

    private List<Performance> enrichPerformances(Invoice invoice, Map<String, Play> plays) {
        return invoice.performances().stream()
                .map(performance -> enrichPerformance(performance, plays))
                .collect(Collectors.toList());
    }

    private Performance enrichPerformance(Performance performance, Map<String, Play> plays) {
        Performance result = new Performance(performance.getPlayId(), performance.getAudience());
        result.setPlay(playFor(plays, result));
        result.setAmount(amountFor(result));
        result.setVolumeCredits(volumeCreditsFor(result));
        return result;
    }

    private String renderPlainText(StatementData data, Map<String, Play> plays) {
        StringBuilder result = new StringBuilder("청구 내역 (고객명: " + data.customer() + ")\n");
        for (Performance performance : data.performances()) {
            result.append(String.format(" %s: %s (%d석)\n",
                    performance.getPlay().name(),
                    usd(performance.getAmount()),
                    performance.getAudience()));
        }
        result.append(String.format("총액: %s\n", usd(totalAmount(data.performances()))));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(data.performances())));
        return result.toString();
    }

    private int totalAmount(List<Performance> performances) {
        int result = 0;
        for (Performance performance : performances) {
            result += performance.getAmount();
        }
        return result;
    }

    private int totalVolumeCredits(List<Performance> performances) {
        int result = 0;
        for (Performance performance : performances) {
            result += performance.getVolumeCredits();
        }
        return result;
    }

    private String usd(int number) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(number / 100);
    }

    private int volumeCreditsFor(Performance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if (COMEDY == performance.getPlay().type()) {
            result += (int) Math.floor(performance.getAudience() / 5.0);
        }
        return result;
    }

    private Play playFor(Map<String, Play> plays, Performance performance) {
        return plays.get(performance.getPlayId());
    }

    private int amountFor(Performance performance) {
        int result;
        switch (performance.getPlay().type()) {
            case TRAGEDY: // 비극
                result = 40000;
                if (performance.getAudience() > 30) {
                    result += 1000 * (performance.getAudience() - 30);
                }
                break;
            case COMEDY: // 희극
                result = 30000;
                if (performance.getAudience() > 20) {
                    result += 10000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + performance.getPlay().type().name());
        }
        return result;
    }
}
