package org.example;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * A software that takes as an input a CSV file where every entry represents the results of a biathlon athlete:
 * Based on the entries identifying the first 3 places (Winner, Runner-up and Third Place)
 * Each athlete has a time-results for the entire skiing session, and 3 shooting range results
 * Each shooting range has 5 shot results
 * For every missed shot the athlete obtains a 10 second penalty which affects the final time-result
 * Final standings are based on the time-results that have been updated with the shooting range results
 */
public class Biathlon {
    List<Athlete> athletes = new ArrayList<>();

    /**
     * Parsing a line of the CSV file
     *
     * @param line
     * @return a list of strings from between the delimiter
     */
    public static List<String> parseLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    /**
     * Converts from the String time format (mm:ss) to integer (seconds)
     *
     * @param stringTime
     * @return seconds
     */
    public static int stringToSeconds(String stringTime) {
        String[] arrOfStr = stringTime.split(":");
        int minute = Integer.parseInt(arrOfStr[0]);
        int second = Integer.parseInt(arrOfStr[1]);
        return minute * 60 + second;
    }

    /**
     * Converts from integer (seconds) to String time format (mm:ss)
     *
     * @param second
     * @return
     */
    public static String secondsToString(int second) {
        return second / 60 + ":" + second % 60;
    }

    public static void main(String[] args) {
        Biathlon app = new Biathlon();
        Scanner scanner = null;
        try {
            scanner = new Scanner(
                    new File("C:\\Users\\andi1\\IdeaProjects\\SkiBiathlonStandings\\src\\main\\java\\org\\example\\results.csv"));
            while (scanner.hasNextLine()) {
                List<String> temp = parseLine(scanner.nextLine());
                int seconds = stringToSeconds(temp.get(3));
                app.athletes.add(new Athlete(temp.get(1), seconds, temp.get(4), temp.get(5), temp.get(6)));
            }
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(0);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        app.displayResults(app.athletes);
    }

    /**
     * Sorting the athletes based on the final time result
     *
     * @param athletes
     * @return sorted list of athletes
     */
    public List<Athlete> displayResults(List<Athlete> athletes) {
        Collections.sort(athletes, new FinalTimeComparator());
        athletes.get(0).position = Position.WINNER;
        athletes.get(1).position = Position.RUNNER_UP;
        athletes.get(2).position = Position.THIRD_PLACE;
        for (Athlete athlete : athletes) {
            System.out.println(athlete.position.getPosName() + " - " + athlete.name + " " + secondsToString(athlete.finalTime)
                    + " (" + secondsToString(athlete.time) + " + " + athlete.penalty + ")");
        }
        return athletes;
    }
}
