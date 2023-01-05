package com.workspace.demo.leetcode.array;

import java.util.*;

/**
 * 1366. Rank Teams by Votes
 * Example 1:
 * <p>
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation:
 * Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
 * Team B was ranked second by 2 voters and ranked third by 3 voters.
 * Team C was ranked second by 3 voters and ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team, and team B is the third.
 * Example 2:
 * <p>
 * Input: votes = ["WXYZ","XYZW"]
 * Output: "XWYZ"
 * Explanation:
 * X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position.
 * Example 3:
 * <p>
 * Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * Explanation: Only one voter, so their votes are used for the ranking.
 */

class Candidate {
    char c;
    int[] counts;

    public Candidate(char c, int length) {
        this.c = c;
        this.counts = new int[length];
    }

    public void increment(int i) {
        counts[i]++;
    }
}


public class RankTeamsByVotes {


    public static String rankTeams(String[] votes) {
        int length = votes[0].length();
        int[][] counts = new int[length][length];

        Map<Character, Candidate> map = new HashMap();
        for (String v : votes) {
            for (int i = 0; i < length; i++) {
                char c = v.charAt(i);
                if (!map.containsKey(c))
                    map.put(c, new Candidate(v.charAt(i), length));
                Candidate can = map.get(c);
                can.increment(i);
            }
        }

        List<Candidate> candidates = new ArrayList<>(map.values());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i< length;i++) {
            final int idx = i;
            Collections.sort(candidates, new Comparator<Candidate>() {
                @Override
                public int compare(Candidate a, Candidate b) {
                    int j = 0;
                    while( j < length) {
                        if(b.counts[j] - a.counts[j] !=0)
                            return b.counts[j] - a.counts[j];
                        j++;

                    }
                    return 0;
                }
            });
            sb.append(candidates.remove(0).c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
//        String[] votes = new String[]{"WXYZ","XYZW"};
        String[] votes = new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        String out = rankTeams(votes);
        System.out.println("out = " + out);
    }
}
