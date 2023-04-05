package org.example;
import java.util.Comparator;
public class FinalTimeComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
        return a1.finalTime < a2.finalTime ? -1 : a1.finalTime == a2.finalTime ? 0 : 1;
    }
}
