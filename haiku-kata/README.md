<!--
  ~ Copyright (c) 2023 The Bank of New York Mellon.
  ~ All rights reserved. This program and the accompanying materials
  ~ are made available under the terms of the Eclipse Public License v1.0
  ~ and Eclipse Distribution License v. 1.0 which accompany this distribution.
  ~ The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  ~ and the Eclipse Distribution License is available at
  ~ http://www.eclipse.org/org/documents/edl-v10.php.
  -->
# **What is the Haiku Kata?**
The Haiku Kata is an intermediate Code Kata with a set exercises that a developer can complete to familiarize themselves with the String APIs available in [Eclipse Collections](https://github.com/eclipse-collections/eclipse-collections), as well as the chars() method available on the String class for the JDK section of the kata.

The domain of the Haiku Kata includes the `HaikuCollection`, `TextProcessorEC`, and `TextProcessorJDK` classes. The kata uses advanced features like Java Text Blocks, Java Records, and Switch Expressions which are available in JDK 17.

This kata is based on the following blog by Donald Raab: [Haiku for Java using Text Blocks](https://medium.com/javarevisited/haiku-for-java-using-text-blocks-6b7862ccd067?source=friends_link&sk=b52fc20b49e4cd062a85ddc03cf5b385).
The blog was also covered in JEP Café Episode #9 on YouTube by José Paumard: [Refactoring Java 8 code with Java 17 new features](https://www.youtube.com/watch?v=wW7uzc61tZ8).

# Getting Started

Checkout the [work on kata exercises](../README.md#work-on-kata-exercises) section. 

Run the tests for specific frameworks in the tests folder.

* [Eclipse Collections Tests](./src/test/java/org/eclipse/collections/haikukata/TextProcessorECTest.java)
* [Java Streams Tests](./src/test/java/org/eclipse/collections/haikukata/TextProcessorJDKTest.java) 

You will need to change code in the domain classes to get the tests to pass.

* [Domain Folder](./src/main/java/org/eclipse/collections/haikukata)
