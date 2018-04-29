# ECU-1010

## Assignment 05
### Assignment Description
This assignment was broken into 2 parts; however, extra credit points were available, thus resulting in one part having two alternative versions:
- <b>CardConverter.java:</b> A simple program that accepts a value and suit, converting it into a full card name (for example, KD being the “King of Diamonds”); error handling was not required for this assignment, thus any value not within the constraints will return unwanted results
- <b>Calculator.java | CalculatornoLoop.java:</b> A simple calculator that can execute a single operation on two integers entered by the user. Extra credit was provided if an alternate version was provided that did not rely on a loop.
### Source Files
<b>Part 1:</b> CardConverter.java <br/>
<b>Part 2:</b> Calculator.java, CalculatornoLoop.java <br/>
### Compilation, Testing, and Known Issues
```
Part 1:
Compile: javac CardConverter.java
Testing: java CardConverter

Part 2:
Compile: javac Calculator.java
Testing: java Calculator

Part 2B:
Compile: javac CalculatornoLoop.java
Testing: java CalculatornoLoop
```
Issues (Part 2):
- The original Calculator program can accept an equation in the format of “a+b,” but CalculatornoLoop will throw a Scanner error, as it reads an integer, the next token, and then a secondary integer. (The capacity to enter a non-space-delimited equation was discarded in favor of eliminating the loop)
