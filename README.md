<div align="center">
    <h1>Maven Template</h1>
    <br>
    <a href="https://codeclimate.com/github/niklas2810/maven-template/maintainability">
        <img alt="codeclimate maintainability" src="https://img.shields.io/codeclimate/maintainability/niklas2810/maven-template?logo=Code%20Climate&style=for-the-badge"/></a>
    <a href="https://codeclimate.com/github/niklas2810/maven-template/test_coverage">
        <img alt="codeclimate test coverage" src="https://img.shields.io/codeclimate/coverage/niklas2810/maven-template?logo=Code%20Climate&style=for-the-badge"/></a>
    <br>
    <a href="https://codeclimate.com/github/niklas2810/maven-template/issues">
        <img alt="codeclimate issues" src="https://img.shields.io/codeclimate/issues/niklas2810/maven-template?logo=Code%20Climate&style=for-the-badge"/>
    </a>    
    <a href="https://github.com/niklas2810/maven-template/actions?query=workflow%3A%22Unit+Tests%22">
    <img alt="unit testing" src="https://img.shields.io/github/workflow/status/niklas2810/maven-template/Unit%20Testing?logo=GitHub&label=Unit%20Tests&style=for-the-badge"/></a>
    <br>
    <br>   
</div> 

Hey there! This is my maven template, containing the most
basic features I need for nearly every project I do in Java.

**Feature overview:**

- Automated unit tests ([GitHub Actions](.github/actions/testing.yml))
- Automated code coverage ([GitHub Actions](.github/actions/coverage.yml))
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
