/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.jacksonkata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

public class Exercise3Test
{
    /**
     * Follow <a href="https://github.com/eclipse-collections/eclipse-collections/blob/master/docs/jackson.md#serializing-directly">
     * Serializing directly instructions</a> to specify a proper type reference on line 42.
     * Pay special attention to the text in bold.
     * @throws JsonProcessingException
     */
    @Test
    @Tag("KATA")
    public void collectionOfPetsSerialization() throws JsonProcessingException
    {
        MutableList<Pet> pets = Lists.mutable.of(
                new Pet(PetType.CAT, "George", 1),
                new Pet(PetType.DOG, "Mike", 3),
                new Pet(PetType.SNAKE, "Peter", 2));

        ObjectMapper objectMapper = ObjectMapperUtils.createObjectMapperWithEclipseCollectionsSupport();
        String serializedPets = objectMapper.writeValueAsString(pets);
        MutableList<Pet> deserializedPets = objectMapper.readValue(serializedPets, MutableList.class);
        Assert.assertEquals(pets, deserializedPets);
    }

    /**
     * Follow <a href="https://github.com/eclipse-collections/eclipse-collections/blob/master/docs/jackson.md#serializing-directly">
     * Serializing directly instructions</a> to specify a proper type reference on line 64.
     * Pay special attention to the text in bold.
     * @throws JsonProcessingException
     */
    @Test
    @Tag("KATA")
    public void immutableCollectionOfPetsSerialization() throws JsonProcessingException
    {
        ImmutableList<Pet> pets = Lists.mutable.of(
                new Pet(PetType.HAMSTER, "Jeff", 2),
                new Pet(PetType.TURTLE, "Sam", 1),
                new Pet(PetType.BIRD, "John", 3)).toImmutable();

        ObjectMapper objectMapper = ObjectMapperUtils.createObjectMapperWithEclipseCollectionsSupport();
        String serializedPets = objectMapper.writeValueAsString(pets);
        ImmutableList<Pet> deserializedPets =
                objectMapper.readValue(serializedPets, ImmutableList.class);
        Assert.assertEquals(pets, deserializedPets);
    }
}
