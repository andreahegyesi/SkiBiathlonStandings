package org.example;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BiathlonTest {
    @Test
    void parseLine() {
        Biathlon testApp = new Biathlon();
        String testString = "a,b,c";
        List<String> stringList = Arrays.asList("a", "b", "c");
        assertEquals(stringList, testApp.parseLine(testString));
    }

    @Test
    void displayResults() {
        Biathlon testApp = new Biathlon();
        List<Athlete> athleteList = new ArrayList<>();
        Athlete athlete1 = new Athlete("First name", 1810, "xxxxx", "xxxxx", "xxxxx");
        Athlete athlete2 = new Athlete("Second name", 1500, "xxoxx", "xxxxx", "xxxxx");
        Athlete athlete3 = new Athlete("Third name", 1000, "xoxox", "xooox", "xxxxx");
        athleteList.add(athlete1);
        athleteList.add(athlete2);
        athleteList.add(athlete3);
        List<Athlete> athleteListCopy = athleteList;
        assertEquals("Third name", testApp.displayResults(athleteList).get(0).name);
        assertEquals("Second name", testApp.displayResults(athleteList).get(1).name);
        assertEquals("First name", testApp.displayResults(athleteList).get(2).name);
    }

    @Test
    void createAthlete() {
        Biathlon testApp = new Biathlon();
        List<String> testString = Arrays.asList("12","Hegyesi Andrea","RO","3:20","xxxxx","xxoxx","xxxxx");
        Athlete testAthlete = testApp.createAthlete(testString);
        assertEquals("Hegyesi Andrea", testAthlete.name);
        assertEquals(200, testAthlete.time);
        assertEquals(10, testAthlete.penalty);
    }
}