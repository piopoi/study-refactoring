package refactoring.ch12.part10.before;

public class EuropeanSwallow extends Bird {

    public EuropeanSwallow(BirdData birdData) {
        super(birdData);
    }

    @Override
    public int getAirSpeedVelocity() {
        return 35;
    }
}
