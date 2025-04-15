package refactoring.ch1;

public abstract class PerformanceCalculator {

    private Performance performance;
    private Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public int amount() {
        throw new IllegalArgumentException("알 수 없는 장르: " + performance.getPlay().type().name());
    }

    public int volumeCredits() {
        return Math.max(performance.getAudience() - 30, 0);
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
