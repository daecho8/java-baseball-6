package baseball.type;

public enum CountSpeaker {

    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼");

    final private String call;
    public String getCall() {
        return call;
    }
    private CountSpeaker(String call){
        this.call = call;
    }
}
