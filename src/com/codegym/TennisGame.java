package com.codegym;

public class TennisGame {

    public static final String ALL = "-All";
    public static final String DEUCE = "Deuce";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";


    public static String getScore(String player1Name, String player2Name, int score1, int score2) {
        if (score1 == score2) {
            return getScoreDeuce(player1Name, player2Name, score1);
        } else if (score1 >= 4 || score2 >= 4) {
            return getScoreTieBreak(player1Name, player2Name, score1, score2);
        } else {
            return getScoreNomarl(player1Name, player2Name, score1, score2);
        }
    }

    public static String scoreToString(int score) {
        switch (score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return "";
        }
    }


    public static String getScoreDeuce(String player1Name, String player2Name, int score) {
        if (score >= 4) {
            return DEUCE;
        } else {
            return scoreToString(score) + ALL;
        }
    }

    public static String getScoreTieBreak(String player1Name, String player2Name, int score1, int score2) {
        int scoreDifference = score1 - score2;
        if (scoreDifference == 1) return ADVANTAGE_PLAYER_1;
        else if (scoreDifference == -1) return ADVANTAGE_PLAYER_2;
        else if (scoreDifference >= 2) return WIN_FOR_PLAYER_1;
        else return WIN_FOR_PLAYER_2;
    }

    public static String getScoreNomarl(String player1Name, String player2Name, int score1, int score2) {
        return scoreToString(score1) + "-" + scoreToString(score2);
    }
}