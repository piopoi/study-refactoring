package refactoring.ch12.part10.before;

public class BirdFactory {
    public static Bird create(BirdData birdData) {
        switch (birdData.getType()) {
            case "유럽 제비":
                return new EuropeanSwallow(birdData);
            case "아프리카 제비":
                return new AfricanSwallow(birdData);
            case "노르웨이 파랑 앵무":
                return new NorwegianBlueParrot(birdData);
            default:
                return new Bird(birdData);
        }
    }
}
