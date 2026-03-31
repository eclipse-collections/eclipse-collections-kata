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

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Random;
import java.util.stream.IntStream;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.factory.Lists;

/**
 * On Halloween, three different SchoolGroups go trick or treating at different times.
 */
public class SchoolGroup
{
    public static final ZoneId NEW_YORK = ZoneId.of("America/New_York");
    private static final LocalDate HALLOWEEN = LocalDate.of(2018, Month.OCTOBER, 31);
    private static final LocalTime ELEMENTARY_SCHOOL_START = LocalTime.NOON.plus(Duration.ofHours(3));
    private static final LocalTime MIDDLE_SCHOOL_START = ELEMENTARY_SCHOOL_START.plus(Duration.ofHours(2));
    private static final LocalTime HIGH_SCHOOL_START = MIDDLE_SCHOOL_START.plus(Duration.ofHours(2));
    private static final long CANDY_COUNT = 250L;

    private static final SchoolGroup ELEMENTARY_SCHOOL =
            new SchoolGroup(HALLOWEEN.atTime(ELEMENTARY_SCHOOL_START), CANDY_COUNT);
    private static final SchoolGroup MIDDLE_SCHOOL =
            new SchoolGroup(HALLOWEEN.atTime(MIDDLE_SCHOOL_START), CANDY_COUNT);
    private static final SchoolGroup HIGH_SCHOOL =
            new SchoolGroup(HALLOWEEN.atTime(HIGH_SCHOOL_START), CANDY_COUNT);

    private LocalDateTime time;
    private long candyCount;

    private SchoolGroup(LocalDateTime time, long candyCount)
    {
        this.time = time;
        this.candyCount = candyCount;
    }

    public static ImmutableList<SchoolGroup> all()
    {
        return Lists.immutable.with(ELEMENTARY_SCHOOL, MIDDLE_SCHOOL, HIGH_SCHOOL);
    }

    public Bag<Candy> trickOrTreat()
    {
        IntStream limit = new SecureRandom()
                .ints(0, Candy.values().length - 1)
                .limit(this.candyCount);
        return limit.mapToObj(i -> Candy.values()[i])
                .collect(Collectors2.toBag());
    }
}
