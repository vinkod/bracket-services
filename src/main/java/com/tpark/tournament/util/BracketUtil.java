package com.tpark.tournament.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Created by vk015735 on 6/15/17.
 */
public class BracketUtil {

    public List<Long> determineMatchesPerRoundInSinlgeElimination(long participantCount) {
        // If there are 8 people and it is a single elimination, everyone except one, will have to lose in 7 matches.
        long totalMatches = participantCount - 1;
        List<Long> matchesPerRound = new ArrayList<>();

        long matchesAdded = 0;
        long nextRoundMatches = 1;
        while (totalMatches > matchesAdded) {
            matchesPerRound.add(nextRoundMatches);
            matchesAdded = matchesAdded + nextRoundMatches;
            nextRoundMatches = matchesAdded + (nextRoundMatches * 2) > totalMatches ? totalMatches - matchesAdded : nextRoundMatches * 2;
        }

        return ImmutableList.copyOf(matchesPerRound).reverse().asList();
    }
}
