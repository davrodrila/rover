# README #

My solution to the Mars Rover code kata. My main goal with this was to teach myself TDD, though I ended up learning a few things here and there.

# Requirements #

Maven and Java. Since I'm using multi catch Exceptions, at least Java 7 is required. The maven-compiler plugin is set up to use Java 7, so you will encounter problems with a lower version of Java.

# Executing the program #

This project was developed with IntelliJ IDEA, but it's a plain old Maven project. There is a variety of tests to ensure everything works, which you can run with `mvn test`.

If you wish to try out different use cases, there is a main method set up with a loop where you can feed data to the program, located in the Program class. You can directly execute it with `mvn exec:java` 