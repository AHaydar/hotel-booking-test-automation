# Hotel Booking UI Automation Testing
In this project we are going to create an automation framework using Java, Selenium and Testng. This project contains a couple of test scenarios (Create booking and Delete booking).

This file will also document the setup process as well as the test execution and reporting steps.

## Pre-requisites
* Install Java and Maven on your machine

## Setup
* Clone the github repository and open the project in Intellij
* Run `mvn clean install` to build the projects and run the test
* To run the tests, use one of the following methods:
  * Run this file in your IDE by right clicking it, selecting create TestNG file, then clicking run
  * Run the test from the command line, for example: `mvn -Dtest=AddBookingRecordTest test`
  * testng.xml - It includes the tests to be executed. Run it from your IDE. Alternatively run `mvn test` from command line. it is configured in the pom.xml file to run the testng.xml file


## Code Structure
The code and tests are structured as follows:
* Test
    * Java
        * pages -  this folder contains the pages classes, which contain a representation of the web page elements, and the interaction with these elements through methods we create
        * tests - this folder contains the tests written in TestNG
        * utilities - this folder contains the classes handling utilities and helpers
    * resources - this folder contains the resources such as configuration 

