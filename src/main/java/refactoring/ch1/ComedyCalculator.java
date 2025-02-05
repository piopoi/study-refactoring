package refactoring.ch1;

public class ComedyCalculator extends PerformanceCalculator {

    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 30000;
        if (getPerformance().getAudience() > 20) {
            result += 10000 + 500 * (getPerformance().getAudience() - 20);
        }
        result += 300 * getPerformance().getAudience();
        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (int) Math.floor(getPerformance().getAudience() / 5.0);
    }
}
