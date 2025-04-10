package refactoring.ch12.part10.after;

public class AfricanSwallowDelegate extends SpeciesDelegate {

    private int numberOfCoconuts;

    public AfricanSwallowDelegate(BirdData birdData, Bird bird) {
        super(birdData, bird);
        this.numberOfCoconuts = birdData.getNumberOfCoconuts();
    }

    public int getAirSpeedVelocity() {
        return 40 - 2 * numberOfCoconuts;
    }
}
