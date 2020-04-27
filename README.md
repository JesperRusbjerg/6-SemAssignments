# 6-SemAssignments
Hello reviewer, please locate the folder with the assignments name, there you will find the awesome solution.

**For the current TEST assignment: jesperBankTesting for the backend where DB setup and mocks are**
 
- In the src/java folder you will find a Datalayer package with a implementation of the datalayer interface, this interface can also be used to mock a datalayer
- in the test folder you will find tests for the implemented datalayer, where there also is a strategy for the database mock and tear up / tear down between each test.. The tear up / tear down is made in the DBSetup class


**SEARCH TREE: binarySearchTree folder**
- It is an implementation of AVL tree, ive tried to make as many comments as possible to explain the code, as you may not have done the same one

**Algortihm Mini project 2 AIRPORT: miniproject2 folder**
- Implemented by continously implementing a max heap each time a dequeue must happen
- implemented a comparator that can compare the diffrent priorities
- i only max heap when dequeueing because you may need to enqueue multiple before dequeueing and i thought it would max sense to not max heap over and over again, and therefor only do it when dequeueing
