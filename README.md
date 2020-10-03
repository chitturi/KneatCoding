KNEAT AUTOMATION TASKS
---
There are two feature files in this task

```
1-Starfilter.feature
2-Suanafilter.feature
```

To Run this feature you need cucumber, maven, java installed in your IDE or in your laptop if you run from Command Line

Run from Command line:


To run all feature files.It will pick by default Chrome browser and runs it

```
mvn test
```

To run all feature files in Firefox browser

```
mvn test -DbrowserType="firefox"
```

To run all feature files in Chrome browser

```
mvn test -DbrowserType="chrome"
```

To run only SpaAndSuanafilter.feature file

```
mvn test -Dcucumber.options="--tags @SpaAndSuanafeature"
```

To run only Starfilter.feature file in firefox browser

```
mvn test -Dcucumber.options="--tags @Starfeature" -DbrowserType="firefox"
```

If you want to run Specific scenario from a feature just add name of the scenario next to --tags option

```
Example: mvn test -Dcucumber.options="--tags @Spascenario"
``````
Above example only scenario tagged with filter of Spa.



