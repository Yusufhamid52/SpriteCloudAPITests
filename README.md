# SpriteCloudAPITests

## Overview

This is a maven project created using **TestNG Framework with Java**.

**HttpURLConnection** is used for creating a http connection to the APIs by passing the request and parsing the response to get the desired results for respective test case scenarios.

**Extent Report** is used for creating reports with logs and screenshot (only in case of failure). **TestNG framework** is used for executing the tests.

**TestCases** folder contains Pet Swagger API Tests.docx which has 2 API test cases with description, steps and expected result.

## Project hierarchy

* **src/main/java** : Consists of 2 packages - 
  1. **httpConnection :** It has 1 java class defined below
      * APIConnectionSetUp : It has the entire http connection setup to send request and get response from the APIs. 
  2. **Utils :** It has 2 java classes defined below
      * Constants : It consists of the API end points.
      * JsonUtility : It consists of the json parsing method.

* **src/test/java** : Consists of 2 packages - 
   1. **petStoreSwaggerAPITests :** It has 2 java classes defined below
        * APITests : It consists of API tests created for the exercise.
        * APITestSetUp : It is the base class with TestNG before and after methods.
        
   2. **testNG_xmls :** It consists of TestNG xml suite for running all the tests.

## Test reports 
   There are 2 types of reports available in this project. 
   1. **Extent reports :** /test-extent
      These are custom reports I created which consists of test method name and pass and fail status. Also, I have added logs to describe each test step while the         test runs.
      They also have very nice pictorial represenatation of test runs in the form of colorful graphs. 
      
   2. **Maven reports :** /target/surefire-reports/emailable-report.html
      These reports are generated as part of maven test run and provides good details of each test execution. 
      
## Calliope
Please find this link for my test results uploaded to calliope https://app.calliope.pro/reports/108712

## How to run tests locally
### Pre-requisite :
    1.  Required an IDE (Eclipse or intelliJ)
    2.  Java (JDK and JRE) installed in the PC and JAVA_HOME set in environment variable (windows) or bash profile (mac).
    3.  Maven installed and M2_HOME set in environment variable (windows) or bash profile (mac).
    4.  Git installed 
    
### Steps to download the project in IDE: 
   1. Open command prompt and go to the path where the project is to be downloaded
   2. Run `git clone <url>`. Get the url from the project path https://github.com/Yusufhamid52/SpriteCloudAPITests. 
   3. Open IDE and go to File > Open and choose the git cloned project.

### Steps to run the project using TestNG:
   1. Verify if the project is visible in project panel.
   2. Add TestNG to the IDE. If the project is in eclipse, go to Help > Eclipse Marketplace > enter TestNG in search. 
   3. Go to src/test/java/testNG_xmls/testng.xml. 
   4. Right click and run as TestNG suite.
   5. After test run the reports are generated in folder *test-extent*

### Steps to run the project using Maven:
   1. Right click on the project, Run as > maven clean
   2. After step 1 is successful, right click on the project, Run as > maven test
   3. After test run the reports are generated in target > surefire-reports > emailable-report.html. Also, the reports are generated in folder *test-extent*. 

## How to run tests using CI/CD
### Pre-requisite :
    1. Download and install Jenkins war file from https://www.jenkins.io/
    2. Open command prompt and go to the path where jenkins is installed on the machine
    3. Run the command `java -jar jenkins.war`. This starts jenkins server locally on the machine.
    4. Go to browser and open `localhost:8080`. This will open the jenkins start page where it will ask for admin password. In windows open        "C:/Users/<username>/.jenkins/secret". Paste the key from this file to admin password tab. Click next.
    5. On next page, set a new user for jenkins or just continue as admin.
    6. Jenkins is started. Create a new maven job to run the project from github and check the build for results. 
    
## Selected scenarios, approach and importance
    * The tests selected in the API test doc are to check the `Get` request and response on the website petstoreswagger.
    * The first test is to verify the connection is established to pet store API and retrieve pet details of available pets. This is an important test from my point       of view as it returns the available pets in the store.
    * The second test is to retrieve pet details using petID from the response received in test 1. This is important as it gives you detail of the pets by ID.

### Next steps to the project 
    * Add more test to add, delete and modify pet with required permissions. (Was not able to add these tests as part of this assignment as I was getting a 405           response from the API).
    * Increase coverage on other departments such as store, inventory etc. (Again was not able to make the API connection due to lack of permissions)
