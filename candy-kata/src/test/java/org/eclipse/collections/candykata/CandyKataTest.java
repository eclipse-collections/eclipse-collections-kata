/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.candykata;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.sorted.SortedBag;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CandyKataTest
{
    @Test
    @Tag("KATA")
    public void topCandy()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        // Hint: Flatten the Bags of Candy into a single Bag
        Bag<Candy> bigBagOfCandy = null;

        // Hint: Find the top occurrence in the bag and convert that to a set.
        MutableSet<Candy> mostCommon = null;

        var expectedSet = Sets.mutable.with(Candy.REESES_PIECES);
        Assertions.assertEquals(expectedSet, mostCommon);
    }

    @Test
    @Tag("KATA")
    public void commonInTop10()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        // Hint: Find the top 10 occurrences of Candy in each of the bags and intersect them.
        MutableSet<Candy> commonInTop10 = null;

        var expectedSet = Sets.mutable.with(Candy.REESES_PIECES, Candy.CRUNCH);
        Assertions.assertEquals(expectedSet, commonInTop10);
    }

    @Test
    @Tag("KATA")
    public void lessThan30()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        // Hint: Flatten the Bags of Candy into a single Bag
        Bag<Candy> bigBagOfCandy = null;

        // Find candies that are less than 30 in number in the big bag of candy and
        // convert them to a string with its item count like so: "{WHOPPERS=28}
        // Hint: use Bag#toStringOfItemToCount() and sort the items in the bag
        // before converting them to a string
        // Uncomment the @Test and @Solution annotations before running the test
        String stringOfItemToCount = null;
        var expected = "{WHOPPERS=28, TWIX=26, NERDS=28, HERSHEYS_KISSES=24, SWEDISH_FISH=26}";
        Assertions.assertEquals(expected, stringOfItemToCount);
    }

    private MutableList<Bag<Candy>> collectBagsOfCandy()
    {
        return SchoolGroup.all().collect(SchoolGroup::trickOrTreat).toList();
    }
}
