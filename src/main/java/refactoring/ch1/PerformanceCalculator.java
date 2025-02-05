package refactoring.ch1;

import static refactoring.ch1.PlayType.COMEDY;

public abstract class PerformanceCalculator {

    private Performance performance;
    private Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public abstract int amount();

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
