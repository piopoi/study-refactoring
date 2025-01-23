package refactoring.ch1;

import static refactoring.ch1.PlayType.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class InvoiceGenerator {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder("청구 내역 (고객명: " + invoice.customer() + ")\n");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance performance : invoice.performances()) {
            Play play = plays.get(performance.playId());
            int thisAmount = amountFor(performance, play);

            // 포인트를 적립한다.
            volumeCredits += Math.max(performance.audience() - 30, 0);
            // 희극 관객 5명마다 추가 포인트를 제공한다.
            if (COMEDY == play.type()) {
                volumeCredits += (int) Math.floor(performance.audience() / 5.0);
            }

            // 청구 내역을 출력한다.
            result.append(String.format(" %s: %s (%d석)\n",
                    play.name(),
                    format.format(thisAmount / 100),
                    performance.audience()));

            totalAmount += thisAmount;
        }

        result.append(String.format("총액: %s\n", format.format(totalAmount / 100)));
        result.append(String.format("적립 포인트: %d점\n", volumeCredits));

        return result.toString();
    }

    private int amountFor(Performance performance, Play play) {
        int result;
        switch (play.type()) {
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
                throw new IllegalArgumentException("알 수 없는 장르: " + play.type().name());
        }
        return result;
    }
}
