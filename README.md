README 1.0

Technology:
1. Java - version 1.8
2. Eclipes - version Mars.2 Release 4.5.2
3. Selenium Web Driver - Java Library 3.13.0

Run Automation:
- MAC
- Default browser: Google Chrome

How to run:
----------
1. Install latest maven then set environment path.
2. Go to project directory.
3. Follow the following steps.


To build this project
---------------------
mvn build

To run this project
-------------------
mvn exec:java -Dexec.mainClass=com.mailchimp.automation.MailChimpApp -Dexec.cleanupDaemonThreads=false


CSV File:
1. Go to Workspace > mailchimp > data

Test script:
1. Go to Project > package[com.mailchimp.automation.testcases] > AboutPageTest.java