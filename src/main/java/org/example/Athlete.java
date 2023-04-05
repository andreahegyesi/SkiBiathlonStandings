package org.example;
import java.util.List;
public class Athlete {
    public String name;
    public int time;
    public int finalTime;
    public int penalty;
    public Position position;
    private String firstShot;
    private String secondShot;
    private String thirdShot;

    public Athlete(String name, int time, String firstShot, String secondShot, String thirdShot) {
        this.name = name;
        this.time = time;
        this.firstShot = firstShot;
        this.secondShot = secondShot;
        this.thirdShot = thirdShot;
        this.penalty = calculatePenalty();
        this.finalTime = this.time + this.penalty;
    }

    @Override
    public String toString() {
        return "Athlete [name= " + name + ", time= " + time + ", firstShot =" + firstShot
                + ", secondShot= " + secondShot + ", thirdShot= " + thirdShot + "]";
    }

    public int calculatePenalty() {
        int penalty = 0;
        for (int i = 0; i < firstShot.length(); i++) {
            if (firstShot.charAt(i) == 'o') {
                penalty += 10;
            }
        }
        for (int i = 0; i < secondShot.length(); i++) {
            if (secondShot.charAt(i) == 'o') {
                penalty += 10;
            }
        }
        for (int i = 0; i < thirdShot.length(); i++) {
            if (thirdShot.charAt(i) == 'o') {
                penalty += 10;
            }
        }
        return penalty;
    }
}

