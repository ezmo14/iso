There is a separate file for first and second tasks. [You can find it here](../Task1And2.md)

3rd Part and 4th part: Automated tests for facebook registration and login scenarios Automated tests for Best Buy APIs
=================

Project with data driven with Selenium and TestNG for the following scenarios (Facebook task)

* TC#1 signup-password empty
* TC#2 signup-email do not match
* TC#3 signup-Empty names
* TC#4 signup-empty email
* TC#5 signup-Password length
* TC#6 signup-do not set date of birth
* TC#7 signup-gender is not chosen
* TC#8 signup-user with famous names
* TC#9 signup-invalid firstname characters
* TC#10 signup-iregular user names
* TC#11 signup-lastname length
* TC#12 login-empty password
* TC#13 login-empty email
* TC#14 login-wrong password
* TC#15 login-valid login

The data is stored in login and signup tabs in data.xls, more testcases can be added in the future such as signup with existing id.

The project consists of the following:
--------------------------------------
* Third task Files are stored under src/test/java are the following
<ul>
	<li>Helpers.java in package org.automation.helpers which has supporting functions which help in reading the xls for example</li>
	<li>org.automation.pagefactory with each page (locators and functions)</li>
	<li>org.automation.testrunner with Runner.java which assigns the dataprovider and data and manages the frontend automation</li>
</ul>

* Fourth task depends on ApiTestRunner.java under org.automation.testrunner. REST assured along with Testng is used. It depends on Helpers to read the data from data.xls from api tab. only a single record is used and product endpoint is tested.

The following cases are covered for fourth task:
================================================
* Create product
* Get All products
* Try to get product with invalid id
* Create product with empty data
* Update product that was created (depends on creation)
* Delete product that was created (depends on creation)
* Try to delete product that was deleted.


Installation:
--------------
This project is a maven project, and can be imported in eclipse/intellij. The chrome driver should to be stored in src\chromedriver.exe, the version should be the same as the chrome browser on your machine and can be downloaded it from https://chromedriver.chromium.org/downloads.

You will find testng file including the runners. In total with the api tests, there are 22 testcases. 15 testcases for task 3 and 7 for task 4. Be sure to start api-playground by typing npm start.

![image](https://user-images.githubusercontent.com/32613878/116465151-21fc0c00-a86d-11eb-877c-6c7cb1dfa897.png)
