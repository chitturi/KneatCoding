#DING AUTOMATION TASKS#
---
##There are two feature files in this task#
```
1-APITesting.feature
2-PayPalLogin.feature
```

To Run this feature you need cucumber, maven, java installed in your IDE or in your laptop if you run from Command Line

###Run from Command line:

First run 

```
mvn clean install
```

To run only PayPalLogin.feature file

```
mvn test -Dcucumber.options="--tags @functionaltest"
```

To run only APITesting.feature file

```
mvn test -Dcucumber.options="--tags @APITest"
```

If you want to run Specific scenario from a feature just add name of the scenario next to --tags option

```
Example: mvn test -Dcucumber.options="--tags @login"
``````
Above example only scenario tagged with login will run.



