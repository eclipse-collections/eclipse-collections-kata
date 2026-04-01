/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.lostandfoundkata.primitive.immutable;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.IntBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link ImmutableIntBag#newWith(int)} <br>
 * {@link ImmutableIntBag#newWithAll(IntIterable)} <br>
 * {@link ImmutableIntBag#newWithout(int)} <br>
 * {@link ImmutableIntBag#newWithoutAll(IntIterable)} <br>
 * <p/>
 * Filtering: <br>
 * {@link ImmutableIntBag#select(IntPredicate)} <br>
 * {@link ImmutableIntBag#reject(IntPredicate)} <br>
 * <p/>
 * {@link ImmutableIntBag#collectInt(IntToIntFunction, MutableIntCollection)} <br>
 * {@link ImmutableIntBag#collect(IntToObjectFunction)} <br>
 * <p/>
 * {@link ImmutableIntBag#chunk(int)} <br>
 * <p/>
 * {@link ImmutableIntBag#anySatisfy(IntPredicate)} <br>
 * {@link ImmutableIntBag#allSatisfy(IntPredicate)} <br>
 * {@link ImmutableIntBag#noneSatisfy(IntPredicate)} <br>
 * {@link ImmutableIntBag#contains(int)} <br>
 * {@link ImmutableIntBag#containsAny(int...)} <br>
 * {@link ImmutableIntBag#containsAll(int...)} <br>
 * {@link ImmutableIntBag#containsNone(int...)} <br>
 * <p/>
 * {@link ImmutableIntBag#toImmutable()} <br>
 * {@link ImmutableIntBag#toSet()} <br>
 * {@link ImmutableIntBag#toBag()} <br>
 * {@link ImmutableIntBag#toSortedList()} <br>
 * {@link ImmutableIntBag#toArray()} <br>
 * {@link ImmutableIntBag#toSortedArray()} <br>
 * {@link ImmutableIntBag#toString()} <br>
 * {@link ImmutableIntBag#makeString(String)} <br>
 * <p/>
 * {@link ImmutableIntBag#sum()} <br>
 * {@link ImmutableIntBag#average()} <br>
 * {@link ImmutableIntBag#averageIfEmpty(double)} <br>
 * {@link ImmutableIntBag#median()} <br>
 * {@link ImmutableIntBag#medianIfEmpty(double)} <br>
 * {@link ImmutableIntBag#min()} <br>
 * {@link ImmutableIntBag#minIfEmpty(int)} <br>
 * {@link ImmutableIntBag#max()} <br>
 * {@link ImmutableIntBag#maxIfEmpty(int)} <br>
 * {@link ImmutableIntBag#summaryStatistics()} <br>
 * <p/>
 * {@link ImmutableIntBag#occurrencesOf(int)} <br>
 * {@link ImmutableIntBag#topOccurrences(int)} <br>
 * {@link ImmutableIntBag#bottomOccurrences(int)} <br>
 * {@link PrimitiveTuples#pair(int, int)} <br>
 * @see IntIntPair <br>
 */
public class ImmutableIntBagTest
{
    public final ImmutableIntBag bag = IntBags.immutable.with(1, 2, 2, 3, 3, 3);

    @Test
    public void newWithAndWithout()
    {
        // Add the values 4 and 5 to the bag using newWith
        ImmutableIntBag bagWith = this.bag;
        Assertions.assertEquals(IntBags.immutable.with(1, 2, 2, 3, 3, 3, 4, 5), bagWith);
        Assertions.assertNotSame(this.bag, bagWith);

        // Add the values 6, 7, 8 to the bag using newWithAll
        ImmutableIntBag bagWithAll = bagWith.newWithAll(IntLists.immutable.empty());
        Assertions.assertEquals(IntBags.immutable.with(1, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8), bagWithAll);
        Assertions.assertNotSame(this.bag, bagWithAll);

        // Remove the values 7 and 8 from the bag using newWithout
        ImmutableIntBag bagWithout = bagWithAll;
        Assertions.assertEquals(IntBags.immutable.with(1, 2, 2, 3, 3, 3, 4, 5, 6), bagWithout);
        Assertions.assertNotSame(this.bag, bagWithout);

        // Remove the values 4, 5, 6 from the bag using newWithoutAll
        ImmutableIntBag bagWithoutAll = bagWithout.newWithoutAll(IntLists.immutable.empty());
        Assertions.assertEquals(IntBags.immutable.with(1, 2, 2, 3, 3, 3), bagWithoutAll);
        Assertions.assertNotSame(this.bag, bagWithoutAll);
    }

    @Test
    public void select()
    {
        IntPredicate isEven = each -> each % 2 == 0;
        // Filter the bag inclusively based on the isEven predicate
        ImmutableIntBag evens = this.bag;
        Assertions.assertEquals(IntBags.immutable.with(2, 2), evens);
    }

    @Test
    public void reject()
    {
        IntPredicate isEven = each -> each % 2 == 0;
        // Filter the bag exclusively based on the isEven predicate
        ImmutableIntBag odds = this.bag;
        Assertions.assertEquals(IntBags.immutable.with(1, 3, 3, 3), odds);
    }

    @Test
    public void collectInt()
    {
        // Create a transformed IntBag multiplying each value by 2
        MutableIntBag timesTwo = this.bag.collectInt(each -> each, IntBags.mutable.empty());
        var expectedIntBag = IntBags.mutable.with(2, 4, 4, 6, 6, 6);
        Assertions.assertEquals(expectedIntBag, timesTwo);
    }

    @Test
    public void collect()
    {
        // Create a transformed bag converting each int to a String
        ImmutableBag<String> strings = this.bag.collect(each -> "");
        var expectedStringBag = Bags.mutable.with("1", "2", "2", "3", "3", "3");
        Assertions.assertEquals(expectedStringBag, strings);
    }

    @Test
    public void chunk()
    {
        // Chunk the bag two elements at a time
        RichIterable<IntIterable> chunk = null;
        Assertions.assertEquals(3, chunk.size());
    }

    @Test
    public void anySatisfy()
    {
        IntPredicate isEven = each -> each % 2 == 0;
        // Check if any of the elements are even
        Assertions.assertTrue(this.bag.anySatisfy(each -> false));
    }

    @Test
    public void allSatisfy()
    {
        IntPredicate isEven = each -> each % 2 == 0;
        // Check if all of the elements are even
        Assertions.assertFalse(this.bag.allSatisfy(each -> true));
    }

    @Test
    public void noneSatisfy()
    {
        IntPredicate isEven = each -> each % 2 == 0;
        // Check if none of the elements are even
        Assertions.assertFalse(this.bag.noneSatisfy(each -> false));
    }

    @Test
    public void contains()
    {
        // Check contains (hint: remove the !)
        Assertions.assertTrue(!this.bag.contains(3));
        Assertions.assertFalse(!this.bag.contains(6));
    }

    @Test
    public void containsAny()
    {
        // Check containsAny (hint: remove the !)
        Assertions.assertTrue(!this.bag.containsAny(2, 7));
        Assertions.assertFalse(!this.bag.containsAny(0, 7));
    }

    @Test
    public void containsAll()
    {
        // Check containsAll (hint: remove the !)
        Assertions.assertTrue(!this.bag.containsAll(2, 3));
        Assertions.assertFalse(!this.bag.containsAll(2, 7));
    }

    @Test
    public void containsNone()
    {
        // Check containsNone (hint: remove the !)
        Assertions.assertFalse(!this.bag.containsNone(2, 7));
        Assertions.assertTrue(!this.bag.containsNone(0, 7));
    }

    @Test
    public void toImmutable()
    {
        // Convert immutable bag to an immutable bag
        ImmutableIntBag immutableIntBag = null;
        Assertions.assertSame(this.bag, immutableIntBag);
    }

    @Test
    public void toList()
    {
        // Convert to a MutableIntList
        MutableIntList list = null;
        Assertions.assertEquals(IntLists.mutable.with(1, 2, 2, 3, 3, 3), list.sortThis());
    }

    @Test
    public void toSet()
    {
        // Convert to a MutableIntSet
        MutableIntSet set = null;
        Assertions.assertEquals(IntSets.mutable.with(1, 2, 3), set);
    }

    @Test
    public void toSortedList()
    {
        // Convert to a sorted MutableIntList
        MutableIntList sortedList = null;
        Assertions.assertEquals(IntLists.mutable.with(1, 2, 2, 3, 3, 3), sortedList);
    }

    @Test
    public void toArray()
    {
        // Convert to an int array
        int[] ints = null;
        Arrays.sort(ints);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 3, 3}, ints);
    }

    @Test
    public void toSortedArray()
    {
        // Convert to a sorted int array
        int[] sortedInts = null;
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 3, 3}, sortedInts);
    }

    @Test
    public void testToString()
    {
        // Convert to a String
        String string = null;
        CharAdapter toStringAdapter = Strings.asChars(string);
        Assertions.assertEquals(1, toStringAdapter.count(each -> each == '1'));
        Assertions.assertEquals(2, toStringAdapter.count(each -> each == '2'));
        Assertions.assertEquals(3, toStringAdapter.count(each -> each == '3'));
    }

    @Test
    public void makeString()
    {
        // Convert to a String separated by "/"
        String makeString = null;
        CharAdapter makeStringAdapter = Strings.asChars(makeString);
        Assertions.assertEquals(1, makeStringAdapter.count(each -> each == '1'));
        Assertions.assertEquals(2, makeStringAdapter.count(each -> each == '2'));
        Assertions.assertEquals(3, makeStringAdapter.count(each -> each == '3'));
    }

    @Test
    public void sum()
    {
        // Calculate the sum of this.bag
        long sum = 0L;
        Assertions.assertEquals(14L, sum);
    }

    @Test
    public void averageIfEmpty()
    {
        // Calculate the average of this.bag
        double average = 0.0;
        Assertions.assertEquals(2.3, average, 0.1);
    }

    @Test
    public void medianIfEmpty()
    {
        // Calculate the median of this.bag
        double median = 0.0;
        Assertions.assertEquals(2.5, median, 0.0);
    }

    @Test
    public void minIfEmpty()
    {
        // Calculate the min of this.bag
        int min = 0;
        Assertions.assertEquals(1, min);
    }

    @Test
    public void maxIfEmpty()
    {
        // Calculate the max of this.bag
        int max = 0;
        Assertions.assertEquals(3, max);
    }

    @Test
    public void summaryStatistics()
    {
        // Calculate the summaryStatistics of this.bag
        IntSummaryStatistics stats = new IntSummaryStatistics();
        Assertions.assertEquals(14L, stats.getSum());
        Assertions.assertEquals(1, stats.getMin());
        Assertions.assertEquals(3, stats.getMax());
    }

    @Test
    public void occurrencesOf()
    {
        // Find the occurrencesOf 1 in this.bag
        Assertions.assertEquals(1, this.bag.occurrencesOf(0));
        // Find the occurrencesOf 2 in this.bag
        Assertions.assertEquals(2, this.bag.occurrencesOf(0));
        // Find the occurrencesOf 3 in this.bag
        Assertions.assertEquals(3, this.bag.occurrencesOf(0));
    }

    @Test
    public void topOccurrences()
    {
        // Find the number 1 topOccurrence of this.bag
        ImmutableList<IntIntPair> topPairs = null;
        Assertions.assertEquals(PrimitiveTuples.pair(3, 3), topPairs.getFirst());
    }

    @Test
    public void bottomOccurrences()
    {
        // Find the number 1 bottomOccurrence of this.bag
        ImmutableList<IntIntPair> bottomPairs = null;
        Assertions.assertEquals(PrimitiveTuples.pair(1, 1), bottomPairs.getFirst());
    }
}
