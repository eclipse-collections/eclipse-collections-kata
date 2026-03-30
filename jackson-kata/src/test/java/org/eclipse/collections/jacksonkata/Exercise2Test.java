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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

public class Exercise2Test
{
    /**
     * Follow <a href="https://github.com/eclipse-collections/eclipse-collections/blob/master/docs/jackson.md#jackson">
     * Object Mapper config instructions</a>
     * to enable Eclipse Collections Jackson serialization support in
     * {@link ObjectMapperUtils#createObjectMapperWithEclipseCollectionsSupport()}
     * <br>
     * <br>
     * Follow <a href="https://github.com/eclipse-collections/eclipse-collections/blob/master/docs/jackson.md#jackson">
     * JsonProperty documentation</a> to mark attributes pets, petsByAge and petsByType of class {@link Person}
     * as @JsonProperty to enable proper serialization.
     */
    @Test
    @Tag("KATA")
    public void serializePerson() throws JsonProcessingException
    {
        MutableList<Pet> pets = Lists.mutable.of(
                new Pet(PetType.HAMSTER, "Bobby", 1),
                new Pet(PetType.DOG, "Jackie", 2),
                new Pet(PetType.BIRD, "Sam", 3));

        ObjectMapper objectMapper = ObjectMapperUtils.createObjectMapperWithEclipseCollectionsSupport();
        String firstName = "Alex";
        String lastName = "Goldberg";
        Person person = new Person(firstName, lastName, 25);
        pets.forEach(pet -> person.addPet(pet.getType(), pet.getName(), pet.getAge()));

        String valueAsString = objectMapper.writeValueAsString(person);
        Person deserializedPerson = objectMapper.readValue(valueAsString, Person.class);

        Assert.assertEquals(firstName, deserializedPerson.getFirstName());
        Assert.assertEquals(lastName, deserializedPerson.getLastName());
        Assert.assertEquals(25, deserializedPerson.getAge());
        Assert.assertEquals(pets, Lists.mutable.withAll(deserializedPerson.getImmutablePets()));
    }
}
