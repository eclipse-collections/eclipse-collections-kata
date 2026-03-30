<!--
  ~ Copyright (c) 2022 The Bank of New York Mellon.
  ~ All rights reserved. This program and the accompanying materials
  ~ are made available under the terms of the Eclipse Public License v1.0
  ~ and Eclipse Distribution License v. 1.0 which accompany this distribution.
  ~ The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  ~ and the Eclipse Distribution License is available at
  ~ http://www.eclipse.org/org/documents/edl-v10.php.
  -->
# **What is the Converter Method Kata?**
The Converter Method Kata is a basic Code Kata with a set of exercises that a developer can complete to familiarize themselves with the converter method APIs available in [Eclipse Collections](https://github.com/eclipse-collections/eclipse-collections).

Converter methods are methods that allow you to convert from one collection type to another. For example, if you have a `MutableList` and want to convert it to a `MutableSet`, you can use the `toSet()` method. Converter methods are available for both object and primitive collections, and there is support for `Collector` implementations on `Collectors2` for converting from JDK types to Eclipse Collections types. Methods that are prefixed with "to" in Eclipse Collections will always create a new copy of the contents in the target type.

The domain of the Converter Method Kata includes the `Person` class.

# Getting Started

Complete the exercises in the tests folder.

* [Tests Folder](./src/test/java/org/eclipse/collections/convertermethodkata/)

The Person class is in the main folder.

* [Domain Folder](./src/main/java/org/eclipse/collections/convertermethodkata/)
