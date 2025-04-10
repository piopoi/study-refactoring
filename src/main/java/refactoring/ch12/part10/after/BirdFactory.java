package refactoring.ch12.part10.after;

public class BirdFactory {
    public static Bird create(BirdData birdData) {
        return new Bird(birdData);
    }
}
