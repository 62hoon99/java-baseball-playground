package baseball;

public enum BaseBallStatus {
    STRIKE, BALL, NOTHING;

    public boolean match(BaseBallStatus status) {
        return this.equals(status);
    }
}
