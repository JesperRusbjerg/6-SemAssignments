# 6-SemAssignments
Hello reviewer, please locate the folder with the assignments name, there you will find the awesome solution.
**Please look in JesperBankTesting**
- in src/main/java/dk/cphbusiness/rest -> you will find a simple implementation of a rest api based on bank accounts which will later be used for my frontend
- in src/test/java/dk.cphbusiness/banking/restTest -> you will find an example of this rest API being tested

The way it works: Before the test runs, it sets the DBConeection to the test database, then the tests are performed and the connection is swapped back to the realDB connection.. The tests run on a virtual web server that gets created to run the given tests :)

