
# Example Automation test

Example Automation test is a maven project created by Damián Attademo to analyze google search behaviour on Windows.

Developed with:
  - Maven
  - TestNG
  - Log4jS
  - Selenium
  - Java
  
Use:
  - Chrome 60-61 (Current ChromeDriver: 2.33)

# How to run test?

  1. Clone this project
```sh
git clone git@github.com:dattademo/example.git
```
  ---------------------------
  	Running test from Eclipse
	
	2.a. Install TestNG plugin on Eclipse, link: http://beust.com/eclipse
  
	See: [steps](http://toolsqa.com/selenium-webdriver/install-testng/)
      
	2.b. Import MAVEN project from eclipse
 
	2.c. Browse path: src/test/java/testng
  
	2.d. Click secondary mouse button over "SeleniumSearchTest.xml"
  
	2.e. Click on "Run as" -> "TestNG Suite"
  
  ---------------------------
  	Running test from Windows Console
  
	3.a. Install java and maven
  
	3.b. Open project folder on console
  
	3.c. Run this command: mvn test -DsuiteXmlFile=".\src\test\java\testng\SeleniumSearchTest.xml"  
  

# What does this test do?
Starts a browser (default:chrome, can be switched from SeleniumSearchTest.xml -> Available browsers: chrome, firefox, ie).
Searches for "Seleniumhq".
Selects first result link and clicks on it.
Wait for SeleniumHQ page to load.
Verify that URL and Page Title are the correct ones.

In case of test fail: a screenshot is triggered and tracked on console log.
