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

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CandyKataSolutionsTest
{
    @Test
    @Tag("SOLUTION")
    public void topCandy()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        Bag<Candy> bigBagOfCandy =
                bagsOfCandy.flatCollect(bag -> bag).toBag();

        MutableSet<Candy> mostCommon =
                bigBagOfCandy.topOccurrences(1)
                        .collect(ObjectIntPair::getOne)
                        .toSet();

        var expectedSet = Sets.mutable.with(Candy.REESES_PIECES);
        Assertions.assertEquals(expectedSet, mostCommon);
    }

    @Test
    @Tag("SOLUTION")
    public void commonInTop10()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        MutableSet<Candy> commonInTop10 =
                bagsOfCandy.collect(
                        bag -> bag.topOccurrences(10)
                                .collect(ObjectIntPair::getOne)
                                .toSet())
                        .reduce(MutableSet::intersect)
                        .get();

        var expectedSet = Sets.mutable.with(Candy.REESES_PIECES, Candy.CRUNCH);
        Assertions.assertEquals(expectedSet, commonInTop10);
    }

    @Test
    @Tag("SOLUTION")
    public void lessThan30()
    {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        Bag<Candy> bigBagOfCandy = null;

        String stringOfItemToCount = null;

        var expected = "{WHOPPERS=28, TWIX=26, NERDS=28, HERSHEYS_KISSES=24, SWEDISH_FISH=26}";
        Assertions.assertEquals(expected, stringOfItemToCount);
    }

    private MutableList<Bag<Candy>> collectBagsOfCandy()
    {
        return SchoolGroup.all().collect(SchoolGroup::trickOrTreat).toList();
    }
}
