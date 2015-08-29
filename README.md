# README #

My solution to the coding test I was given, the Rover control program.

# A few words about the program #

My main focus during the development of this was to keep things clean and simple, I wanted to avoid ending up with lot's of if-nesting to solve the problem of turning the robot around, I wanted to focus on giving a properly designed OO solution, that's why the State pattern is used for both the program state of the controller and to contain the direction the Rover is facing.

# What I learned #

Looking at the commit history, I was putting a lot of logic on the RoverController class and waited way too long to refactor it and reduce it's size and responsibilities. By the time I decided it was getting out of hand, I had to do a lot of moving around, which I wouldn't have to do had I done it right off the bat. Thankfully the changes were mostly internal, and most of the unit test I had written so far were mostly unnafected, but on a real life scenario, this could've costed me quite some time.

# Requirements #

Maven and Java. Since I'm using multi catch Exceptions, at least Java 7 is required. The maven-compiler plugin is set up to use Java 7, so you will encounter problems with a lower version of Java.

# Executing the program #

This project was developed with IntelliJ IDEA, but it's a plain old Maven project. There is a variety of tests to ensure everything works, which you can run with `mvn test`. In the email there were two use cases attached, and in the TestRoverController class those are tested for convenience.

If you wish to try out different use cases, there is a main method set up with a loop where you can feed data to the program, located in the Program class. You can directly execute it with `mvn exec:java` 