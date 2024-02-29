# Java Typer Error Handling with Sealed Interfaces

### Overview
This short demo showcases the use of Java sealed interfaces when implementing Typed Error Handling.

It's considered a bad practice to use checked / unchecked exceptions as ways to control the logical flow of an application. Modern Java language features like sealed interfaces and pattern matching provide a way to handle all expected logical branches of an app in a secure, performant and elegant way.

### Exploring the demo
The repo consists of 3 branches:
* `main` uses exceptions to drive the application logic
* `feature/refactor-with-sealed-classes` shows a version that uses sealed interfaces
* `feature/refactor-with-sealed-classes-and-optional` shows a version that uses the now common return type of `Optional<T>` for the `findByEmail` repo method.

### Additional Links
* [Functional Error Handling with Java](https://softwaremill.com/functional-error-handling-with-java-17/)
* [Intro to VAVR's Either type](https://www.baeldung.com/vavr-either) - a more generic approach of typed error handling
