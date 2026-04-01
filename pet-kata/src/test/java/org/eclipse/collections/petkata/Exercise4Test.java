/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.factory.list.primitive.MutableIntListFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableIntSetFactory;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.Math.abs;

/**
 * In this set of tests, wherever you see .stream() replace it with an Eclipse Collections alternative.
 * <p/>
 * {@link org.eclipse.collections.api.list.primitive.MutableIntList}<br>
 * {@link org.eclipse.collections.api.set.primitive.IntSet}<br>
 * {@link org.eclipse.collections.impl.factory.primitive.IntSets}<br>
 * {@link org.eclipse.collections.impl.block.factory.primitive.IntPredicates}<br>
 * {@link org.eclipse.collections.api.bag.MutableBag}<br>
 * {@link org.eclipse.collections.api.list.MutableList}<br>
 * {@link MutableIntListFactory#empty()}<br>
 * {@link MutableIntSetFactory#empty()}<br>
 * {@link MutableList#flatCollectInt(Function, MutableIntCollection)}<br>
 * {@link MutableIntList#toSet()}<br>
 * {@link MutableIntList#summaryStatistics()}<br>
 * {@link MutableIntList#minIfEmpty(int)}<br>
 * {@link MutableIntList#maxIfEmpty(int)}<br>
 * {@link MutableIntList#sum()}<br>
 * {@link MutableIntList#averageIfEmpty(double)}<br>
 * {@link MutableIntList#size()}<br>
 * {@link IntPredicates#greaterThan(int)}<br>
 * {@link MutableIntList#anySatisfy(IntPredicate)}<br>
 * {@link MutableIntList#allSatisfy(IntPredicate)}<br>
 * {@link MutableIntList#noneSatisfy(IntPredicate)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/pet-kata/#/8">Exercise 4 Slides</a>
 */
public class Exercise4Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getAgeStatisticsOfPets()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Try to use a MutableIntList here instead
        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
        var petAges = this.people
                .stream()
                .map(Person::getPets)
                .flatMap(List::stream)
                .mapToInt(Pet::getAge)
                .boxed()
                .collect(Collectors.toList());

        // Try to use an IntSet here instead
        var uniqueAges = Set.copyOf(petAges);

        // IntSummaryStatistics is a class in JDK 8 - Look at MutableIntList.summaryStatistics().
        var stats = petAges.stream().mapToInt(Integer::intValue).summaryStatistics();

        // Is a Set<Integer> equal to an IntSet?
        // Hint: Try IntSets instead of Set as the factory
        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, uniqueAges);

        // Try to leverage minIfEmpty, maxIfEmpty, sum, averageIfEmpty on IntList
        Assertions.assertEquals(stats.getMin(), petAges.stream().mapToInt(i -> i).min().orElse(0));
        Assertions.assertEquals(stats.getMax(), petAges.stream().mapToInt(i -> i).max().orElse(0));
        Assertions.assertEquals(stats.getSum(), petAges.stream().mapToInt(i -> i).sum());
        Assertions.assertEquals(stats.getAverage(), petAges.stream().mapToInt(i -> i).average().orElse(0.0), 0.0);
        Assertions.assertEquals(stats.getCount(), petAges.size());

        // Hint: JDK xyzMatch = Eclipse Collections xyzSatisfy
        Assertions.assertTrue(petAges.stream().allMatch(i -> i > 0));
        Assertions.assertFalse(petAges.stream().anyMatch(i -> i == 0));
        Assertions.assertTrue(petAges.stream().noneMatch(i -> i < 0));
    }

    @Test
    @Tag("KATA")
    @DisplayName("bobSmithsPetNamesAsString - 🐱 🐶")
    public void bobSmithsPetNamesAsString()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        //find Bob Smith
        Person person = this.people
                .stream()
                .filter(each -> each.named("Bob Smith"))
                .findFirst()
                .orElse(null);

        //get Bob Smith's pets' names
        String names = person.getPets()
                .stream()
                .map(Pet::getName)
                .collect(Collectors.joining(" & "));

        Assertions.assertEquals("Dolly & Spot", names);
    }

    @Test
    @Tag("KATA")
    public void immutablePetCountsByEmoji()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Hint: Try to replace the immutable Map<String, Long> with an ImmutableBag<String>
        Map<String, Long> countsByEmoji =
                Map.copyOf(this.people
                        .stream()
                        .flatMap(person -> person.getPets().stream())
                        .collect(Collectors.groupingBy(pet -> pet.getType().toString(), Collectors.counting())));

        Assertions.assertEquals(
                Bags.immutable.of("🐱", "🐱", "🐶", "🐶", "🐹", "🐹", "🐍", "🐢", "🐦"),
                countsByEmoji
        );
    }

    /**
     * The purpose of this test is to determine the top 3 pet types.
     */
    @Test
    @Tag("KATA")
    @DisplayName("topThreePets - 🐱 🐶 🐹")
    public void topThreePets()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Hint: The result of groupingBy/counting can almost always be replaced by a Bag
        // Hint: Look for the API on Bag that might return the top 3 pet types
        var favorites = this.people
                .stream()
                .flatMap(p -> p.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getType, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e -> -e.getValue()))
                .limit(3L)
                .collect(Collectors.toList());

        Verify.assertSize(3, favorites);

        // Hint: Look at PrimitiveTuples.pair(Object, int)
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.CAT, Long.valueOf(2)), favorites);
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.DOG, Long.valueOf(2)), favorites);
        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, Long.valueOf(2)), favorites);
    }

    @Test
    @Tag("KATA")
    public void getMedianOfPetAges()
    {
        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");

        // Try to use a MutableIntList here instead
        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
        var petAges = this.people
                .stream()
                .map(Person::getPets)
                .flatMap(List::stream)
                .mapToInt(Pet::getAge)
                .boxed()
                .collect(Collectors.toList());

        // Try to refactor the code block finding the median the JDK way
        // Use the EC median method
        var sortedPetAges = petAges.stream().sorted().collect(Collectors.toList());

        double median;
        if (0 == sortedPetAges.size() % 2)
        {
            // The median of a list of even numbers is the average of the two middle items
            median = sortedPetAges.stream().skip((sortedPetAges.size() / 2) - 1).limit(2L).mapToInt(i -> i).average().getAsDouble();
        }
        else
        {
            // The median of a list of odd numbers is the middle item
            median = sortedPetAges.get(abs(sortedPetAges.size() / 2)).doubleValue();
        }

        Assertions.assertEquals(2.0, median, 0.0);
    }
}
