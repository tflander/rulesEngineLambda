# rulesEngineLambda

Demonstration of creating a rules engine using familiar object-oriented techniques, then refactoring it using functional programming.

Given data, find the first rule that applies to that data, process according to that rule, and return the result.

The code was developed and refactored in a single branch under different package names.

## The progression:

### package aaaObjectWay -- initial development

Rules are implemented through a polymorphic object model.  The rules engine uses brute force logic to decide which rule to create and return to process the data and return a result.

### package bbbFirstRefactor

Move the brute force logic from the rules engine to a predicate in the rule.  We test the predicate to see if the rule applies to the given data.

### package cccSecondRefactor

Removed the polymorphic object model.  The over-ridden sub-class methods are replaced with a supplier to do the processing and return the final result.
The tests become very simple and expressive, as we are now only testing the expected result, rather than the application of the polymorphic object model.

### package dddthirdRefactor

Created a rule builder.  This gives us a fluent API for the maintenance of rules.  We don't have to create lambdas manually anymore.
