package refactoring.ch12.part10.before;

import static refactoring.utils.StringUtils.isBlank;

public class Bird {

    private final String name;
    protected final String plumage;

    public Bird(BirdData birdData) {
        this.name = birdData.getName();
        this.plumage = birdData.getPlumage();
    }

    public String getName() {
        return name;
    }

    public String getPlumage() {
        return !isBlank(plumage) ? plumage : "보통이다";
    }

    public int getAirSpeedVelocity() {
        return 0;
    }
}
