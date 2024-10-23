import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static final int match_id = 0;
    private static final int season = 1;
    private static final int team_1 = 4;
    private static final int team_2 = 5;
    private static final int toss_winner = 6;
    private static final int winner = 10;
    private static final int player_of_match = 13;

    private static final int deliveryMatch_id = 0;
    private static final int inings = 1;
    private static final int batting_team = 2;
    private static final int bowling_team = 3;
    private static final int batsman_name = 6;
    private static final int bowler_name = 8;
    private static final int legbyRuns = 12;
    private static final int noballRuns = 13;
    private static final int total_runs = 17;
    private static final int extraRun = 16;
    private static final int batsmanRun = 15;
    private static final int wide_runs = 11;
    private static final int  dismissedPlayerName = 18;
    private static final int dismissalKind = 19;
    private static final int superOver = 9;





    private static List<Delivery> getDeliveriesData() {
        List<Delivery> deliveries = new ArrayList<>();
        String filepath = "./data/deliveries.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");

                Delivery delivery = new Delivery();
                delivery.setBatsmanRuns(Integer.parseInt(rowData[batsmanRun]));
                delivery.setNoballRuns(Integer.parseInt(rowData[noballRuns]));
                delivery.setWideRuns(Integer.parseInt(rowData[wide_runs]));
                delivery.setBatsman(rowData[batsman_name]);
                delivery.setBolwer(rowData[bowler_name]);
                delivery.setExtraRuns(Integer.parseInt(rowData[extraRun]));
                delivery.setTotalRuns(Integer.parseInt(rowData[total_runs]));
                delivery.setDeliveryMatchId(Integer.parseInt(rowData[deliveryMatch_id]));
                delivery.setLegByRuns(Integer.parseInt(rowData[legbyRuns]));
                delivery.setBattingTeam(rowData[batting_team]);
                delivery.setBowlingTeam(rowData[bowling_team]);
                delivery.setSuperOver(Integer.parseInt(rowData[superOver]));
                delivery.setInings(Integer.parseInt(rowData[inings]));


                if (rowData.length > 18) {
                    delivery.setPlayerDismissed(rowData[dismissedPlayerName]);
                    delivery.setDismissalKind(rowData[19]);
                } else {
                    delivery.setPlayerDismissed(null);
                    delivery.setDismissalKind(null);
                }

                deliveries.add(delivery);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return deliveries;
    }



    private static List<Match> getMatchData() {
        List<Match> matches = new ArrayList<>();
        String filepath = "./data/matches.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] matchData = line.split(",");

                Match match = new Match();
                match.setSeason(matchData[season]);
                match.setWinner(matchData[winner]);
                match.setMatchId(Integer.parseInt(matchData[match_id]));
                match.setTeam1(matchData[team_1]);
                match.setTeam2(matchData[team_2]);
                match.setTossWinner(matchData[toss_winner]);
                match.setPlayerOfMatch(matchData[player_of_match]);

                matches.add(match);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }



    public static void main(String[] args) {

        List<Match> matches = getMatchData();
        List<Delivery> deliveries = getDeliveriesData();

//        for (Match match : matches)
//            System.out.println(match.getTeam1());
//    }
//        for (Delivery delivery : deliveries) {
//            System.out.println(delivery.getPlayerDismissed());
//        }
    }
}




