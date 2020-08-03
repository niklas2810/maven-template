<div align="center">
    <h1>Maven Template</h1>
    <br>
    <a href="https://codeclimate.com/github/niklas2810/maven-template/maintainability">
        <img alt="codeclimate maintainability" src="https://api.codeclimate.com/v1/badges/32b02cdb535c901f3280/maintainability" />
    </a>
    <a href="https://codeclimate.com/github/niklas2810/maven-template/test_coverage">
        <img alt="codeclimate test coverage" src="https://api.codeclimate.com/v1/badges/32b02cdb535c901f3280/test_coverage" />
    </a>
    <br>
    <a href="https://github.com/niklas2810/maven-template/actions?query=workflow%3A%22Unit+Tests%22">
        <img alt="unit tests" src="https://img.shields.io/github/workflow/status/niklas2810/maven-template/Unit%20Tests?logo=GitHub&style=flat-square"/></a>
    <br>
    <br>   
</div> 

Hey there! This is my maven template, containing the most
basic features I need for nearly every project I do in Java.

**Quick hints:**

This is a very biased approach to creating a Maven project. You might want to use other tools
or configurations, feel free to adjust the repo to your needs!

Based on [github/renaming](https://github.com/github/renaming), the **default branch** is called `main`.
All development activity should be committed into the `development` branch. All other branches
(e.g. _feature/_ and _bug/\*_) should be pulled into the `development` branch, which again can be merged
into `main` when needed. Please keep in mind that the branch name is hardcoded in all [actions](.github/workflows)!

**Setup:**

- Clone this project using `git clone https://github.com/niklas2810/maven-template`.
- Remove the git history by deleting the `.git` folder.
- Create a new initial commit.
- Push your project to GitHub.
- Follow the steps described below.

Sooner or later, the project [Maven Initialize](https://github.com/niklas2810/maven-initialize) will
automate some of these steps.

**Feature overview:**

- Automated unit tests ([GitHub Actions](.github/workflows/testing.yml))
- Automated code coverage ([GitHub Actions](.github/workflows/coverage.yml))
    - Automated upload to Code Climate
    - Automated deployment to GitHub Pages
        - HTML formatting via [tidy](http://www.html-tidy.org/)
- Code Review & Coverage analysis ([Code Coverage](https://codeclimate.com/quality/))
- Logging Framework (logback-classic)
    - Including configuration files for both runtime and test environment
    - Sentry integration for error logging
-  Testing Framework (JUnit 5)
    - Test cases for all classes (~75% coverage due to Sentry edge cases) 
- POM setup for shaded packaging
- Packaged build information inside of the BuildInfo class 

**What you need to do yourself:**

🤖 marks the steps which are covered by the Maven Initializer 
located at [/initializer.jar](initializer.jar).

1. Change the package path, project name, url, etc. in `pom.xml`.
2. [Add the project](https://codeclimate.com/github/repos/new) to Code Climate.
3. Activate GitHub features for Code Climate under "Repo Settings > GitHub".
4. Copy your `Test Reporter ID` under "Repo Settings > Test Coverage" and add it in
your GitHub repository under "Settings > Secrets". Use the name `CODECLIMATE_REPORTER`.
This will ensure that GitHub Actions uploads your code coverage to Code Climate.
5. Adjust the Project URL for the [Auto-Assign Action](.github/workflows/assign.yml).
6. Adjust the badge links in your [README](README.md).
7. (Optional) When building libraries, you might want to remove the shade plugin and add `install`
instructions.
8. (Optional) You might want to add automated builds on [Docker Hub](https://hub.docker.com) to 
publish your application.
9. (Optional) Configure [Sentry](https://sentry.io).
10. (Optional) Configure the GitHub Pages files in the [pages directory](pages) or directly in the
gh-pages branch.
