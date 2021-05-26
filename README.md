# PetStore API 
This project is developed for automated testing of the Petstore API. Swagger endpoint - https://petstore.swagger.io/#/

## Test Cases
API requests related only to Pets have been automated. Following test cases are part of this project.

- Add Pet
- View Pet
- Update Pet
- Update Pet By Id
- Find Pet By Id
- Find Pet By Status
- Upload Pet Image


## Framework

**REST Assured for API Testing**
Rest assured makes testing of http requests easier. It also provides the given, when and then format to write tests which are easier to understand.

**TestNG is used as the testing framework**
Testing frameworks makes writing test cases easy. It also provides features like setup and grouping fo tests.

**Maven is used for dependency management and build**
We are using multiple libraries and Maven makes it extremely easy to make available all required libraries. Also less configuration is required to build tests on a new machine.


## Pre-requisites

__Step 1: Install Maven 3.0.3+__

[Download from here](http://maven.apache.org/download.html)

__Step 2: Ensure maven binaries are on your PATH (ie. you can run `mvn` from anywhere)__

Follow the installation instructions from [here](http://www.baeldung.com/install-maven-on-windows-linux-mac).


## Running Tests

In both the cases, results are available in [Calliope](http://calliope.pro/).

###Running locally
- Clone this git project

- Navigate to the root of the project and run the below command

```
mvn test
```

Uploading Results
- Create an account at Calliope.pro and get the details. Add the api_key and the profileid from the Calliope account to the config.properties files at src/main/resources/

- Execute the calliope_results shell script from the root
```
sh calliope_results
```

###Running via CircleCI

- Fork this project on github.

- Login to [CircleCI](https://app.circleci.com/) using github credentials.

- Navigate to Projects. The forked project should be available in the list. Click on "Set up Project"

- Skip the step to add Sample configs.

- Click on "Use Existing Config" and then "Start Building".

- Click on "Project Settings" and then "Environment Variables".

- Add the "api_key" and "profileid" environment variables from Calliope.

- Come back to the "Dashboard" and Select main branch and click on "Run Pipeline".