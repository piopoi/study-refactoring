package refactoring.ch12.part10.before;

import static refactoring.utils.StringUtils.isBlank;

public class NorwegianBlueParrot extends Bird {

    private final int voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(BirdData birdData) {
        super(birdData);
        this.voltage = birdData.getVoltage();
        this.isNailed = birdData.isNailed();
    }

    @Override
    public String getPlumage() {
        if (voltage > 100) {
            return "그을렸다";
        } else {
            return !isBlank(super.plumage) ? super.plumage : "예쁘다";
        }
    }

    @Override
    public int getAirSpeedVelocity() {
        return isNailed ? 0 : (10 + voltage / 10);
    }
}
