
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;


public class TennisGame1 implements TennisGame {
    
    private int player1Points = 0;
    private int player2Points = 0;
    private final String player1Name;
    private final String player2Name;
    private Hashtable scoreDict;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        
        scoreDict = new Hashtable();
        this.populateDictionaryWithScores();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Points += 1;
        }
        else if (playerName.equals(player2Name)) {
            player2Points += 1;
        }
    }

    public String getScore() {
        String points1 = Integer.toString(player1Points);
        String points2 = Integer.toString(player2Points);
        String scoreKey = points1 + ", " + points2;
        
        String score = (String) scoreDict.get(scoreKey);
        return score;
        
//        String score;
//        if (player1Points == player2Points) {
//            score = getTieScore();
//        }
//        else if (player1Points >= 4 || player2Points >= 4) {
//            score = getWinnerOrAdvantageScore();
//        }
//        else {
//            score = getNonSpecialScore();
//        }
//        return score;
    }

    private String getNonSpecialScore() {
        String score = "";
        score += convertPointToScore(player1Points);
        score += "-";
        score += convertPointToScore(player2Points);
        return score;
    }

    private String convertPointToScore(int points) {
        switch(points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String getWinnerOrAdvantageScore() {
        String score;
        int minusResult = player1Points - player2Points;
        if (minusResult==1) {
            score ="Advantage player1";
        }
        else if (minusResult ==-1) {
            score ="Advantage player2";
        }
        else if (minusResult>=2) {
            score = "Win for player1";
        }
        else {
            score ="Win for player2";
        }
        return score;
    }

    private String getTieScore() {
        String score;
        switch (player1Points) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
                
        }
        return score;
    }
    
    
    
    private void populateDictionaryWithScores() {
        scoreDict.put("0, 0", "Love-All" );
        scoreDict.put("1, 1", "Fifteen-All" );
        scoreDict.put("2, 2", "Thirty-All");
        scoreDict.put("3, 3", "Deuce");
        scoreDict.put("4, 4", "Deuce");

        scoreDict.put("1, 0", "Fifteen-Love");
        scoreDict.put("0, 1", "Love-Fifteen");
        scoreDict.put("2, 0", "Thirty-Love");
        scoreDict.put("0, 2", "Love-Thirty");
        scoreDict.put("3, 0", "Forty-Love");
        scoreDict.put("0, 3", "Love-Forty");
        scoreDict.put("4, 0", "Win for player1");
        scoreDict.put("0, 4", "Win for player2");

        scoreDict.put("2, 1", "Thirty-Fifteen");
        scoreDict.put("1, 2", "Fifteen-Thirty");
        scoreDict.put("3, 1", "Forty-Fifteen");
        scoreDict.put("1, 3", "Fifteen-Forty");
        scoreDict.put("4, 1", "Win for player1");
        scoreDict.put("1, 4", "Win for player2");

        scoreDict.put("3, 2", "Forty-Thirty");
        scoreDict.put("2, 3", "Thirty-Forty");
        scoreDict.put("4, 2", "Win for player1");
        scoreDict.put("2, 4", "Win for player2");

        scoreDict.put("4, 3", "Advantage player1");
        scoreDict.put("3, 4", "Advantage player2");
        scoreDict.put("5, 4", "Advantage player1");
        scoreDict.put("4, 5", "Advantage player2");
        scoreDict.put("15, 14", "Advantage player1");
        scoreDict.put("14, 15", "Advantage player2");
        scoreDict.put("6, 4", "Win for player1");
        scoreDict.put("4, 6", "Win for player2");
        scoreDict.put("16, 14", "Win for player1");
        scoreDict.put("14, 16", "Win for player2");
    }
    
}
