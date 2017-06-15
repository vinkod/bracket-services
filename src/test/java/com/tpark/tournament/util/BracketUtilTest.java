package com.tpark.tournament.util;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Created by vk015735 on 6/15/17.
 */
public class BracketUtilTest {
    BracketUtil util = new BracketUtil();

    @Test
    public void testDetermineMatchesPerRoundInSinlgeElimination() {
        Assert.assertEquals(ImmutableList.of(), util.determineMatchesPerRoundInSinlgeElimination(Long.MIN_VALUE));
        Assert.assertEquals(ImmutableList.of(), util.determineMatchesPerRoundInSinlgeElimination(-1));
        Assert.assertEquals(ImmutableList.of(), util.determineMatchesPerRoundInSinlgeElimination(0));
        Assert.assertEquals(ImmutableList.of(), util.determineMatchesPerRoundInSinlgeElimination(1));
        Assert.assertEquals(ImmutableList.of(1L), util.determineMatchesPerRoundInSinlgeElimination(2));
        Assert.assertEquals(ImmutableList.of(1L, 1L), util.determineMatchesPerRoundInSinlgeElimination(3));
        Assert.assertEquals(ImmutableList.of(2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(4));
        Assert.assertEquals(ImmutableList.of(1L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(5));
        Assert.assertEquals(ImmutableList.of(2L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(6));
        Assert.assertEquals(ImmutableList.of(3L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(7));
        Assert.assertEquals(ImmutableList.of(4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(8));
        Assert.assertEquals(ImmutableList.of(1L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(9));
        Assert.assertEquals(ImmutableList.of(2L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(10));
        Assert.assertEquals(ImmutableList.of(3L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(11));
        Assert.assertEquals(ImmutableList.of(4L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(12));
        Assert.assertEquals(ImmutableList.of(5L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(13));
        Assert.assertEquals(ImmutableList.of(6L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(14));
        Assert.assertEquals(ImmutableList.of(7L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(15));
        Assert.assertEquals(ImmutableList.of(8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(16));
        Assert.assertEquals(ImmutableList.of(1L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(17));
        Assert.assertEquals(ImmutableList.of(2L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(18));
        Assert.assertEquals(ImmutableList.of(3L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(19));
        Assert.assertEquals(ImmutableList.of(4L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(20));
        Assert.assertEquals(ImmutableList.of(5L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(21));
        Assert.assertEquals(ImmutableList.of(6L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(22));
        Assert.assertEquals(ImmutableList.of(7L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(23));
        Assert.assertEquals(ImmutableList.of(8L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(24));
        Assert.assertEquals(ImmutableList.of(9L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(25));
        Assert.assertEquals(ImmutableList.of(10L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(26));
        Assert.assertEquals(ImmutableList.of(11L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(27));
        Assert.assertEquals(ImmutableList.of(12L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(28));
        Assert.assertEquals(ImmutableList.of(13L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(29));
        Assert.assertEquals(ImmutableList.of(14L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(30));
        Assert.assertEquals(ImmutableList.of(15L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(31));
        Assert.assertEquals(ImmutableList.of(16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(32));
        Assert.assertEquals(ImmutableList.of(1L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(33));
        Assert.assertEquals(ImmutableList.of(2L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(34));
        Assert.assertEquals(ImmutableList.of(31L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(63));
        Assert.assertEquals(ImmutableList.of(32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(64));
        Assert.assertEquals(ImmutableList.of(36L, 32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(100));
        Assert.assertEquals(ImmutableList.of(64L, 32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(128));
        Assert.assertEquals(ImmutableList.of(2L, 64L, 32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(130));
        Assert.assertEquals(ImmutableList.of(512L, 256L, 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(1024));
        Assert.assertEquals(ImmutableList.of(1L, 512L, 256L, 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L), util.determineMatchesPerRoundInSinlgeElimination(1025));

    }

}
