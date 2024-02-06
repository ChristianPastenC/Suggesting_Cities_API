package com.example.largecities.utils;

import com.example.largecities.models.City;

public class ScoreMatching {

    public static float calculateScore(City cityA, City cityB) {
        String[] auxName = cityA.getName().split(",");

        float scoreName = calculateStrMatch(auxName[0], cityB.getName());
        float scoreLat = calculateStrMatch(Double.toString(cityA.getLatitude()), Double.toString(cityB.getLatitude()));
        float scoreLng = calculateStrMatch(Double.toString(cityA.getLongitude()), Double.toString(cityB.getLongitude()));

        if (scoreName > 0.9) {
            return scoreName;
        }
        return (float) (((scoreName * 2.8) + (scoreLat * 0.1) + (scoreLng * 0.1)) / 3);
    }

    public static float calculateStrMatch(String s1, String s2) {
        int maxLength = Math.max(s1.length(), s2.length());
        int editDistance = levenshteinDistance(s1, s2);

        float similarity = 1.0f - (float) editDistance / maxLength;

        return Math.max(0.0f, Math.min(1.0f, similarity));
    }

    public static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
