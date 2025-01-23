package refactoring.ch1;

public class Performance {

    private final String playId;
    private final int audience;
    private final Play play;

    public Performance(String playId, int audience, Play play) {
        this.playId = playId;
        this.audience = audience;
        this.play = play;
    }

    public Performance(String playId, int audience) {
        this.playId = playId;
        this.audience = audience;
        this.play = null;
    }

    public String getPlayId() {
        return playId;
    }

    public int getAudience() {
        return audience;
    }

    public Play getPlay() {
        return play;
    }
}
