package refactoring.ch1;

import static refactoring.ch1.PlayType.COMEDY;

public class PerformanceCalculator {

    private Performance performance;
    private Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public int amount() {
        int result;
        switch (this.play.type()) {
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

    public int volumeCredits() {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if (COMEDY == this.play.type()) {
            result += (int) Math.floor(performance.getAudience() / 5.0);
        }
        return result;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
