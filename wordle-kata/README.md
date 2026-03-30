<!--
  ~ Copyright (c) 2023 The Bank of New York Mellon.
  ~ All rights reserved. This program and the accompanying materials
  ~ are made available under the terms of the Eclipse Public License v1.0
  ~ and Eclipse Distribution License v. 1.0 which accompany this distribution.
  ~ The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  ~ and the Eclipse Distribution License is available at
  ~ http://www.eclipse.org/org/documents/edl-v10.php.
  -->
# **What is the Wordle Kata?**
The Wordle Kata is an advanced Code Kata with a set exercises that a developer can complete to familiarize themselves with the String APIs available in [Eclipse Collections](https://github.com/eclipse-collections/eclipse-collections), as well as the chars() method available on the String class for the JDK section of the kata.

The domain of the Wordle Kata includes the `WordleEC` and `WordleJDK` classes. The kata uses advanced features like Java Records which are available in JDK 17.

This kata is based on the following blog by Donald Raab: [A Wordle JLDD Kata Challenge](https://medium.com/oracledevs/a-wordle-jldd-kata-challenge-b6fb1c89d8eb?source=friends_link&sk=0a8b6f949515cdc36fe7a7fff24097c6).
The blog was also covered in JEP Café Episode #10 on YouTube by José Paumard: [Leverage Java 17 New Features to Create Your Wordle Checker](https://www.youtube.com/watch?v=5--tDQIMqhY).

# Getting Started

Checkout the [work on kata exercises](../README.md#work-on-kata-exercises) section.

Run the tests for specific frameworks in the tests folder.

* [Eclipse Collections Tests](./src/test/java/org/eclipse/collections/wordlekata/WordleECTest.java)
* [Java Streams Tests](./src/test/java/org/eclipse/collections/wordlekata/WordleJDKTest.java) 

You will need to change code in the domain classes to get the tests to pass.

* [Domain Folder](./src/main/java/org/eclipse/collections/wordlekata)
