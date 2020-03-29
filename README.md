# 6-SemAssignments
Hello reviewer, please locate the folder with the assignments name, there you will find the awesome solution.

**For the current TEST assignment: jesperBankTesting for the contract, and backendBankMock for the mocked backend that implements the contract**
 
- jesperBankTesting contains the contract of which a bankend should implement and that a frontend should expect to be able to call via restendpoints
- backendBankMock implements this contract using a bunch of dummies and whiteboxs tests that the contract integration is correct, and that each method works and returns the type of which is expected
We have used a top down implementation from our toolbox, so that the facade is the driver and uses stubs to execute its tests


**SEARCH TREE: binarySearchTree folder**
- It is an implementation of AVL tree, ive tried to make as many comments as possible to explain the code, as you may not have done the same one

**Algortihm Mini project 2 AIRPORT: miniproject2 folder**
- Implemented by continously implementing a max heap each time a dequeue must happen
- implemented a comparator that can compare the diffrent priorities
- i only max heap when dequeueing because you may need to enqueue multiple before dequeueing and i thought it would max sense to not max heap over and over again, and therefor only do it when dequeueing
