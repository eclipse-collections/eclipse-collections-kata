<!--
  ~ Copyright (c) 2023 Goldman Sachs and others.
  ~ All rights reserved. This program and the accompanying materials
  ~ are made available under the terms of the Eclipse Public License v1.0
  ~ and Eclipse Distribution License v. 1.0 which accompany this distribution.
  ~ The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  ~ and the Eclipse Distribution License is available at
  ~ http://www.eclipse.org/org/documents/edl-v10.php.
  -->
[![][license-epl img]][license-epl]
[![][license-edl img]][license-edl]
[![][actions img]][actions]  
[![][actions-solutions img]][actions-solutions]

<a href="https://www.eclipse.org/collections/"><img src="https://github.com/eclipse/eclipse-collections-kata/blob/master/docs/shared/eclipse-collections-logo.png" height="50%" width="50%"></a>

## Eclipse Collections Kata 
A [kata](https://en.wikipedia.org/wiki/Kata) is an exercise in martial arts. 
A [code kata](http://codekata.com/) is an exercise in programming which helps hone your skills through practice and repetition. 
The Eclipse Collections Kata is a fun way to help you learn idiomatic Eclipse Collections usage. 
This particular kata is set up as a series of unit tests which fail. 
Your task is to make them pass, using Eclipse Collections.

## What you will need to build the katas
1. JDK 11 (use [pom.xml](./pom.xml) to build project) or JDK 17 (use [pom-jdk17.xml](./pom-jdk17.xml) to build project)
2. Maven 3.6.1+
3. IDE of your choice that has support for JDK 11 or JDK 17

## Initialize Kata
Clone this repo or simply download and extract the master [zip file](https://github.com/eclipse/eclipse-collections-kata/archive/master.zip), 
then follow the instructions below for your IDE/platform. 


### Eclipse users

You can import the project from "Import" => "General" => "Existing Projects into Workspace".
Select "eclipse-collections-kata" directory as root directory, 
make sure to choose "Search for nested projects" option and finish.
### IntelliJ IDEA users

Initialize IntelliJ IDEA project with the command below. 

You can open the project from "File" => "Open..." => choose "eclipse-collections-kata" folder.

### NetBeans users

##### Linux/Mac/Windows:

_Open as a Maven project_

You can open the project directly from "File" => "Open Project..." => choose "eclipse-collections-kata" folder.
In the "Open Project" dialog you might select the option "Open Required Projects" to automatically open the two modules.

## Work on Kata exercises
There are seven separate Java 11 katas under different directories:

1. [Pet Kata](pet-kata)
2. [Company Kata](company-kata)
3. [Candy Kata](candy-kata)
4. [Converter Method Kata](converter-method-kata)
5. [Top Methods Kata](top-methods-kata)
6. [Lost and Found Kata](lost-and-found-kata)
7. [Jackson Kata](jackson-kata)

There are also Java 17 katas supported as well:

1. [Records Kata](record-kata)
2. [Haiku Kata](haiku-kata)
3. [Wordle Kata](wordle-kata)
 
> By default, the project is set up to build JDK 11 compatible katas. To work on katas that use Java 17, use/import [pom-jdk17.xml](./pom-jdk17.xml) instead to build the project. 

To get started, you can refer to slides for the [Instruction and Pet Kata](http://eclipse.github.io/eclipse-collections-kata/) to learn how to set-up Kata, basic features of Eclipse Collections corresponding to each Pet Kata exercise and then solutions. 
Check out the [pet kata solutions module tests](https://github.com/eclipse/eclipse-collections-kata/tree/master/pet-kata-solutions/src/test/java/org/eclipse/collections/petkata) for your reference.

To learn wider range of functionalities, slides for [Company Kata](http://eclipse.github.io/eclipse-collections-kata/company-kata) are now available online as well. 

To learn more about the Bag data structure, take a look at the [Candy Kata](candy-kata).

Check out [Lost and Found Kata](lost-and-found-kata) and [solutions](lost-and-found-kata-solutions) to learn more advanced data structures and APIs in Eclipse Collections, many of which will have no equivalent in the JDK today.

Enjoy happy learning with Eclipse Collections Kata!

## How to Contribute
We welcome contributions! We accept contributions via pull requests here in GitHub. Please see [How To Contribute](CONTRIBUTING.md) (from the [Eclipse Collections](https://github.com/eclipse/eclipse-collections) project) to get started.


## Reference Guide
The [Eclipse Collections Reference Guide](https://github.com/eclipse/eclipse-collections/blob/master/docs/0-RefGuide.adoc) is a great way to get an overview of the extensive features available in the framework.


## Presentations
The [API Design of Eclipse Collections](http://eclipse.github.io/eclipse-collections-kata/api-design) covers the design 
decisions that went into making Eclipse Collections and guiding its evolution from Java 4 through Java 17. 
The content of the presentation is also available in a convenient to read [markdown format](https://github.com/eclipse/eclipse-collections-kata/blob/master/docs/api-design/slides.md). 

[actions]:https://github.com/eclipse/eclipse-collections-kata/actions?query=workflow%3A%22Eclipse+Collections+Kata+CI+Build%22
[actions img]:https://github.com/eclipse-collections/eclipse-collections-kata/actions/workflows/maven.yml/badge.svg

[actions-solutions]:https://github.com/eclipse/eclipse-collections-kata/actions?query=workflow%3A%22Eclipse+Collections+Kata+Solutions+CI+Build%22
[actions-solutions img]:https://github.com/eclipse/eclipse-collections-kata/actions/workflows/solutions.yml/badge.svg?branch=master

[license-epl]:LICENSE-EPL-1.0.txt
[license-epl img]:https://img.shields.io/badge/License-EPL-blue.svg

[license-edl]:LICENSE-EDL-1.0.txt
[license-edl img]:https://img.shields.io/badge/License-EDL-blue.svg
