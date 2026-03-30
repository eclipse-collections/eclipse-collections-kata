<!--
  ~ Copyright (c) 2022 The Bank of New York Mellon.
  ~ All rights reserved. This program and the accompanying materials
  ~ are made available under the terms of the Eclipse Public License v1.0
  ~ and Eclipse Distribution License v. 1.0 which accompany this distribution.
  ~ The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  ~ and the Eclipse Distribution License is available at
  ~ http://www.eclipse.org/org/documents/edl-v10.php.
  -->
# **What is the Top Methods Kata?**
The Tops Methods Kata is a simple Code Kata with a set of tests that a developer can complete to quickly familiarize themselves with the top 25 methods available in [Eclipse Collections](https://github.com/eclipse-collections/eclipse-collections). The kata was first shared as a blog [here](https://medium.com/javarevisited/my-25-favorite-eclipse-collections-apis-a51589ee5c4a?source=friends_link&sk=4376b5fd10ccefe47c4f56905cc89846).

The top 25 methods that can be learned in this kata are:

* [with](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/factory/list/MutableListFactory.html#with(T...)) - Collection factory method
* [collect](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#collect(org.eclipse.collections.api.block.function.Function)) - Transform a collection from one type to another
* [of](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/factory/set/MutableSetFactory.html#of(T...)) - Alt collection factory method - [Preposition Preference](https://medium.com/javarevisited/preposition-preference-1f1c709b098b?source=friends_link&sk=c6086d0f5d5da60e8f18ebbfa7c911f7)
* [select](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#select(org.eclipse.collections.api.block.predicate.Predicate)) - Filter a collection inclusively
* [reject](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#reject(org.eclipse.collections.api.block.predicate.Predicate)) - Filter a collection exclusively
* [count](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#count(org.eclipse.collections.api.block.predicate.Predicate)) - Count elements based on a predicate
* [anySatisfy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#anySatisfy(org.eclipse.collections.api.block.predicate.Predicate)) - Return true if any elements match a predicate
* [allSatisfy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#allSatisfy(org.eclipse.collections.api.block.predicate.Predicate)) - Return true if all elements match a predicate
* [noneSatisfy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#noneSatisfy(org.eclipse.collections.api.block.predicate.Predicate)) - Return true if no elements match a predicate
* [groupBy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#groupBy(org.eclipse.collections.api.block.function.Function)) - Group elements based on a Function
* [countBy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#countBy(org.eclipse.collections.api.block.function.Function)) - Count elements by a Function
* [makeString](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#makeString(java.lang.String,java.lang.String,java.lang.String)) - Convert a collection to a String using separators
* [toImmutable](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/list/MutableList.html#toImmutable()) - Convert a collection to an immutable equivalent
* [asLazy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#asLazy()) - Create a lazy view on the collection
* [containsBy](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#containsBy(org.eclipse.collections.api.block.function.Function,V)) - Check containment of a value based on a Function
* [detectWith](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#detectWith(org.eclipse.collections.api.block.predicate.Predicate2,P)) - Find the first element that matches a Predicate
* [detectWithIfNone](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#detectWithIfNone(org.eclipse.collections.api.block.predicate.Predicate2,P,org.eclipse.collections.api.block.function.Function0)) - Same as detectWith, but handles case of none
* [injectInto](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#injectInto(IV,org.eclipse.collections.api.block.function.Function2)) - Continuum Transfunctioner - Its mystery is only exceeded by its power
* [partition](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#partition(org.eclipse.collections.api.block.predicate.Predicate)) - Splits a collection based on Predicate
* [chunk](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#chunk(int)) - Breaks a collection into chunks based on a size
* [sumByInt](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#sumByInt(org.eclipse.collections.api.block.function.Function,org.eclipse.collections.api.block.function.primitive.IntFunction)) - Sums a collection by a key Function and int value
* [collectInt](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#collectInt(org.eclipse.collections.api.block.function.primitive.IntFunction)) - Eight primitive versions of collect
* [flatCollectChar](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/RichIterable.html#flatCollectChar(org.eclipse.collections.api.block.function.Function,R)) - Eight primitive versions of flatCollect
* [asParallel](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/list/ListIterable.html#asParallel(java.util.concurrent.ExecutorService,int)) - Returns a performant Lazy ParallelIterable
* [distinct](https://www.eclipse.org/collections/javadoc/10.4.0/org/eclipse/collections/api/list/MutableList.html#distinct()) - Returns the distinct values in a List

The domain of the Top Methods Kata includes the `Fruit` class.

# Getting Started

Complete the exercises in the tests folder.

* [Tests Folder](./src/test/java/org/eclipse/collections/topmethodskata/)

The Person class is in the main folder.

* [Domain Folder](./src/main/java/org/eclipse/collections/topmethodskata/)
