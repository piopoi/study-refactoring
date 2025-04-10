package refactoring.ch12.part10.after;

import static refactoring.utils.StringUtils.*;

public class SpeciesDelegate {

    private Bird bird;

    public SpeciesDelegate(BirdData birdData, Bird bird) {
        this.bird = bird;
    }

    public String getPlumage() {
        return !isBlank(bird.plumage) ? bird.plumage : "보통이다";
    }

    public int getAirSpeedVelocity() {
        return 0;
    }

    public Bird getBird() {
        return bird;
    }
}
