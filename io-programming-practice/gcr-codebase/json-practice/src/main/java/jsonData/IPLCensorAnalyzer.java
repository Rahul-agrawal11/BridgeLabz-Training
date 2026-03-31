package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class IPLCensorAnalyzer {

    // ---------- CENSOR RULES ----------
    static String maskTeam(String team) {
        int idx = team.indexOf(" ");
        return (idx != -1) ? team.substring(0, idx) + " ***" : "***";
    }

    static String redactPlayer() {
        return "REDACTED";
    }

    // ---------- JSON PROCESSING ----------
    static void processJson(String input, String output) throws Exception {

        String content = Files.readString(Path.of(input));
        JSONArray matches = new JSONArray(content);

        for (int i = 0; i < matches.length(); i++) {

            JSONObject match = matches.getJSONObject(i);

            // Mask teams
            String team1 = match.getString("team1");
            String team2 = match.getString("team2");

            String maskedTeam1 = maskTeam(team1);
            String maskedTeam2 = maskTeam(team2);

            match.put("team1", maskedTeam1);
            match.put("team2", maskedTeam2);
            match.put("winner", maskTeam(match.getString("winner")));

            // Redact player of the match
            match.put("player_of_match", redactPlayer());

            // Mask score object keys
            JSONObject score = match.getJSONObject("score");
            JSONObject maskedScore = new JSONObject();

            Iterator<String> keys = score.keys();
            while (keys.hasNext()) {
                String team = keys.next();
                maskedScore.put(maskTeam(team), score.getInt(team));
            }

            match.put("score", maskedScore);
        }

        Files.writeString(Path.of(output), matches.toString(2));
    }

    // ---------- CSV PROCESSING ----------
    static void processCsv(String input, String output) throws Exception {

        List<String> lines = Files.readAllLines(Path.of(input));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        writer.write(lines.get(0)); // header
        writer.newLine();

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");

            data[1] = maskTeam(data[1]); // team1
            data[2] = maskTeam(data[2]); // team2
            data[4] = redactPlayer();    // player_of_match

            writer.write(String.join(",", data));
            writer.newLine();
        }

        writer.close();
    }

    // ---------- MAIN ----------
    public static void main(String[] args) throws Exception {

        processJson(
            "src/main/resources/JsonBeforeCensorship.json",
            "src/main/resources/JsonAfterCensorship.json"
        );

        processCsv(
            "src/main/resources/CSVBeforeCensorship.csv",
            "src/main/resources/CSVAfterCensorship.csv"
        );

        System.out.println("IPL data censored successfully");
    }
}