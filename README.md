README 1.0

Technology:
1. Java - version 1.8
2. Eclipes - version Photon Release (4.8.0)


Run Automation:
- Windows or MAC
- Default browser: Google Chrome

How to run:
----------
1. Install latest maven then set environment path.
2. Go to project directory by $cd mailchimp.
3. Follow the following steps.

To build this project
---------------------
mvn clean install

To run this project
-------------------
mvn compile exec:java -Dexec.mainClass=com.mailchimp.automation.MailChimpApp -Dexec.cleanupDaemonThreads=false


CSV File
---------
Go to Workspace > mailchimp > data

Test script
-----------
Go to Project > package[com.mailchimp.automation.testcases] > AboutPageTest.java