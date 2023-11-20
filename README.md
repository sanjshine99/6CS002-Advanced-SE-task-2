# 6CS002-Advanced-SE-task-2
## Task Details: Refactoring

You should start with small safe refactorings that help you understand the code and put it in a format that facilitates regression testing. This should mainly involve decomposing long methods and renaming identifiers. Refactorings that increase the chances of  introducing defects should not be done before regression testing is in place. Unit tests must be written to test the functionality of the resulting code. You should aim to do as little refactoring as possible before writing your tests, consisting mainly of isolating the entry points into the main functionality so as to enable testing of them. You should aim to decouple user interface code for other functionality. You do not need to formally test the user interface

When sufficient test cases are in place you may go ahead and fully refactor the code. You should do this systematically, ensuring that all test cases pass before moving on to other refactorings. After each successful refactoring you should commit your code to your repository, which will not only document your work but also act as a backup so that you may rollback if you introduce defects into the program. For larger refactorings you may need to restructure your tests, which should be documented in your commit logs. You should ideally address all the problems documented in Task 1.

You must submit a pdf  file that contains:
•	Your refactored source code.
•	Your JUnit test cases. The grade for this relates to the thoroughness of testing and the confidence that the application has not been compromised.
•	You should not try to implement design patterns at this stage.
•	A copy of the “Bad Smells and Simple Refactorings Checklist” annotated to explain where you have applied one example of each one that is appropriate to the code.
