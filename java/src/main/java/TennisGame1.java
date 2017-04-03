


import java.util.Hashtable;


public class TennisGame1 implements TennisGame {
    
    private int player1Points = 0;
    private int player2Points = 0;
    private final String player1Name;
    private final String player2Name;
    
    /**
     * Dictionary to find scores from given points. 
     * The key is the points of player1 and player2. The value is the score
     * equivalent of that point combination. Both key and value are strings, 
     * and all possible combinations are checked.
     */ 
    private Hashtable scoreDict;

    /**
     * Construct an object by setting player names and building the score
     * dictionary.
     * @param player1Name String name for player 1.
     * @param player2Name String name for player 2.
     */
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        
        scoreDict = new Hashtable();
        this.populateDictionaryWithScores();
    }

    /**
     * Increments the player that won the most recent point by one. Only 
     * increments if the parameter value is a valid player's name. Else it does
     * nothing.
     * @param playerName 
     */
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Points += 1;
        }
        else if (playerName.equals(player2Name)) {
            player2Points += 1;
        }
    }

    /**
     * Returns the score of current game state. The point combination must
     * already exist in dictionary else it returns null.
     * @return string describing scores of the two players.
     */
    public String getScore() {
        String points1 = Integer.toString(player1Points);
        String points2 = Integer.toString(player2Points);
        String scoreKey = points1 + ", " + points2;
        
        String score = (String) scoreDict.get(scoreKey);
        return score;
    }

    /**
     * Adds key value pairs of every possible score combination to scoreDict.
     * The key is the points of player1 and player2. The value is the score
     * equivalent of that point combination.
     */
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
