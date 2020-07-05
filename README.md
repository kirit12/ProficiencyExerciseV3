# ProficiencyExerciseV3

Prerequisite:

Install Maven (Version: apache-maven-3.6.1)
Innstall Java (Version: 1.8)
Appium (Version: 1.17.1)

To automate ebay application on android device.
Start appium server externally , Stop when execution done
Please make sure you have capabilities.json under caps folder.
Add package name and mobile device id in folder \src\test\resources\TestData.xlsx
To Sign in application update your username and password in TestData.xlsx file.
To provide your Android Device UDID in TestData.xlsx file.
Product will be succesfully will get added to cart.
Logg are genarate in log>Application Log.log file.
ATU report genarate under ATU_Report folder > index.html and Default TestNg report will be used for reporting.
Src>Main>Java contains Pages and implementation methods
Src>Test contains TestCases.
For Test cases utilisation extend BaseClass in other Testcases.
For build genarate using Maven.
To Run the test on android Run open command Prompt and go to folder path and run below commands.
	> mvn clean
	> mvn test
	
 