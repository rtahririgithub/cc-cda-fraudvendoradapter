# **SonarQube Integration for Java**

This sample application includes a github workflow for kicking off unit tests, reporting the test results and code coverage, then running a SonarQube scan
via `sonar-maven-plugin`. This is triggered when a pull request is created or updated - or it can be triggered manually in the Github Actions tab (which is useful when you want to scan the `main` branch.)
The steps executed in this workflow are defined in [sonarqube-scan-java.yml](../.github/workflows/sonarqube-scan-java.yml).

Note that **SonarQube does not generate the code coverage results by itself**. It is merely reporting the code coverage it reads from `target/site/jacoco/jacoco.xml`
which is created/updated when `mvn test` is run.

## **Configuring SonarQube Properties in Maven**
Normally, SonarQube project are configured through a file named `sonar-project.properties`. However when using `sonar-maven-plugin`, the file is ignored.
Instead, properties must be declared in [pom.xml](../pom.xml) or through the command line (see [sonarqube-scan-java.yml](../.github/workflows/sonarqube-scan-java.yml)
and notice the `-Dsonar...` arguments when running `mvn test`.)

These properties can be useful for excluding configuration files, differentiating source files from test files based on names, etc. SonarQube's documentation
for this can be found [here](https://docs.sonarqube.org/latest/project-administration/narrowing-the-focus/), though we will mention the following properties:
- `sonar.sources` is used to identify the directories that contain source files (including source files in its subdirectories - and so on.) SonarQube will
scan any file under the listed directories as a source file, unless that file is excluded by `sonar.exclusions`.
- `sonar.exclusions` is used to exclude certain files identified under `sonar.sources`. Files are excluded through filters - any file that matches at least
one of the filters will be excluded from the scan.
- `sonar.tests` is used to identify the directories that contain test code files.
- `sonar.test.inclusions` is used to identify test files under `sonar.tests` via filters. Only files that satisfy at least one of the listed filters will be
included as a test file.

An important note: the set of files identified as source files and the set of files identified as test files **MUST BE DISJOINT**. In other words, no file
should be considered both "source" and "test" or else the scan will fail.