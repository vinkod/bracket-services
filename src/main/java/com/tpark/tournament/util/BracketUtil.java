package com.tpark.tournament.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * Created by vk015735 on 6/15/17.
 */
public class BracketUtil {

    public List<Long> determineMatchesPerRoundInSinlgeElimination(long participantCount) {
        if (participantCount < 0) {
            throw new IllegalArgumentException("participantCount cannot be less than 0");
        }
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

    public List<MactchUp> setupMatchesPerRoundSingleElimination(long participantCount, List<Long> matches) {
        Preconditions.checkArgument(participantCount >= 0, "participantCount cannot be less than 0");
        Preconditions.checkNotNull(matches);
        if (matches.isEmpty()) {
            return Collections.emptyList();
        }

        long firstRoundMatches = matches.get(0);
        long topSeedInFirstRound = firstRoundMatches * 2 == participantCount ? 1 : participantCount - (firstRoundMatches * 2) + 1;
        long lastSeedInFirstRound = participantCount;
        List<MactchUp> matchups = new ArrayList<>();
        while (firstRoundMatches > 0) {
            matchups.add(new MactchUp(topSeedInFirstRound++, lastSeedInFirstRound--));
            firstRoundMatches--;
        }

        return matchups;
    }

    public class MactchUp {
        long seed1;
        long seed2;

        MactchUp(long seed1, long seed2) {
            this.seed1 = seed1;
            this.seed2 = seed2;
        }

        @Override
        public String toString() {
            return "MactchUp{" + "seed1=" + seed1 + ", seed2=" + seed2 + '}';
        }
    }

}
