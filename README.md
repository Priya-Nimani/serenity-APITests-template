## Automated Rest API testing with Serenity, Cucumber and Maven

# Project Title

A sample example of Serenity framework implementing BDD-style automated API tests, running against http://api.postcodes.io/postcodes/

### Prerequisites
In order to use this framework you need to have JDK 1.8 downloaded
Set compiler setting to Java 8 within project settings
Also add the Gherkin and cucumber for java plugin within your IDE
 
### Setup
JDK 1.8 can be downloaded from
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

For plugin navigate to Settings/Plugins and add the Gherkin and Cucumber for Java plugin

## Running the tests
Tests can be run using the CustomTestRunner or by using below maven commands

Create a maven run configuration with following goals-

| Test to be executed                            | Command line to use                                                                                                                                 | Comments                                                       |
| -----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------:| --------------------------------------------------------------:|
| Exceute all the tests                          | clean verify -Dcucumber.options=--tags @version=customTestTag   |  Scenarios with tag @version=customTestTag                     |
| To generate the aggregate report               | -Pserenity serenity:aggregate -Dserenity.outputDirectory=./target/site/serenity                                                                     |  Report named 'index.html' generated in `target/site/serenity` |


### Break down into end to end tests
The customAPITest.feature is to test the Postcode and Geolocation API

## Built With

* [Serenity-Cucumber](http://thucydides.info/docs/serenity-staging/) - The BDD framework used
* [Maven](https://maven.apache.org/) - Dependency Management


