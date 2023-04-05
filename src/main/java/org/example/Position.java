package org.example;
public enum Position {
    WINNER("Winner"), RUNNER_UP("Runner-up"), THIRD_PLACE("Third Place");
    private String posName;

    Position(String posName) {
        this.posName = posName;
    }

    public String getPosName() {
        return this.posName;
    }
}
