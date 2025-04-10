package refactoring.ch12.part10.before;

public class AfricanSwallow extends Bird {

    private final int numberOfCoconuts;

    public AfricanSwallow(BirdData birdData) {
        super(birdData);
        this.numberOfCoconuts = birdData.getNumberOfCoconuts();
    }

    @Override
    public int getAirSpeedVelocity() {
        return 40 - 2 * numberOfCoconuts;
    }
}
