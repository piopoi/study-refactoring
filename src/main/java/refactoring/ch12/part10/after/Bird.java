package refactoring.ch12.part10.after;

public class Bird {

    private final String name;
    protected final String plumage;
    private final SpeciesDelegate speciesDelegate;

    public Bird(BirdData birdData) {
        this.name = birdData.getName();
        this.plumage = birdData.getPlumage();
        this.speciesDelegate = selectSpeciesDelegate(birdData);
    }

    private SpeciesDelegate selectSpeciesDelegate(BirdData birdData) {
        return switch (birdData.getType()) {
            case "유럽 제비" -> new EuropeanSwallowDelegate(birdData, this);
            case "아프리카 제비" -> new AfricanSwallowDelegate(birdData, this);
            case "노르웨이 파랑 앵무" -> new NorwegianBlueParrotDelegate(birdData, this);
            default -> new SpeciesDelegate(birdData, this);
        };
    }

    public String getPlumage() {
        return speciesDelegate.getPlumage();
    }

    public int getAirSpeedVelocity() {
        return speciesDelegate.getAirSpeedVelocity();
    }

    public String getName() {
        return name;
    }
}
