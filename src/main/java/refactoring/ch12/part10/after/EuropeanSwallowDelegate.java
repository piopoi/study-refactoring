package refactoring.ch12.part10.after;

public class EuropeanSwallowDelegate extends SpeciesDelegate {

    public EuropeanSwallowDelegate(BirdData birdData, Bird bird) {
        super(birdData, bird);
    }

    public int getAirSpeedVelocity() {
        return 35;
    }
}
