package refactoring.ch12.part10.after;

import static refactoring.utils.StringUtils.isBlank;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {

    private int voltage;
    private boolean isNailed;

    public NorwegianBlueParrotDelegate(BirdData birdData, Bird bird) {
        super(birdData, bird);
        this.voltage = birdData.getVoltage();
        this.isNailed = birdData.isNailed();
    }

    public int getAirSpeedVelocity() {
        return isNailed ? 0 : (10 + voltage / 10);
    }

    public String getPlumage() {
        if (voltage > 100) {
            return "그을렸다";
        } else {
            return !isBlank(super.getBird().plumage) ? super.getBird().plumage : "예쁘다";
        }
    }
}
