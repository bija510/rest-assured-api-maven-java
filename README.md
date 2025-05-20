# **Rest-assured-maven-java**

## 👋 Introduction
Rest Assured is a Java library used for testing RESTful APIs, providing a simple and intuitive way to interact with and validate API endpoints. It's designed to make API testing easier and more readable, particularly in Java, where traditional testing can be more verbose. Rest Assured allows you to send requests, validate responses, and perform assertions with a clean, chained syntax. 

## ✨ Key Features
* Fluent Java DSL – Easy-to-read and write syntax for HTTP requests and validations.

* Supports All HTTP Methods – GET, POST, PUT, DELETE, PATCH, etc.

* JSON/XML Support – Built-in parsing and validation of JSON and XML responses.

* Integration with Testing Frameworks – Works seamlessly with JUnit, TestNG, etc.

* Request/Response Specification Reuse – Allows reusing common request/response settings.

* Built-in Assertions – Easy validation of status codes, headers, body content.

* Authentication Support – Supports OAuth, OAuth2, Basic, Digest, and form authentication.

* Logging Capabilities – Can log requests and responses for debugging.

* Path and Query Parameter Support – Simplifies parameter handling.

* Custom Filters – Enables custom behavior or logging at request/response level.

## 🗂️ Platform Supported by Rest-Assured

# Rest Assured Platform Support

| Category            | Supported Platforms/Tools                      | Notes                                              |
|---------------------|------------------------------------------------|----------------------------------------------------|
| **Operating Systems** | Windows, macOS, Linux                         | Any OS with JVM support                            |
| **Java Versions**     | Java 8 and above                              | Required for compatibility with newer features     |
| **Build Tools**       | Maven, Gradle                                 | Widely supported in Java projects                  |
| **IDEs**              | IntelliJ IDEA, Eclipse, VS Code (with plugin) | Any IDE that supports Java                         |
| **CI/CD Tools**       | Jenkins, GitHub Actions, GitLab CI, etc.      | Works in any CI/CD with Java installed             |
| **Other JVM Languages** | Kotlin, Groovy, Scala                        | Usable via JVM, but primarily designed for Java    |
| **Non-JVM Environments** | ❌ Not supported                            | Not compatible with Python, Node.js, .NET, etc.    |


## 📜 Languages Supported by Rest-Assured

| Language   | Support Level      | Notes                                                                                 |
|------------|--------------------|-------------------------------------------------------------------------------------- |
| Java       | ✅ Fully supported | The default and native language                                                       |

## 📁 Inferred Folder Structure
```js
rest-assured-api-maven-java/
├── .github/                  # GitHub Actions workflows
├── .idea/                    # IntelliJ IDEA project files
├── Configurations/           # Custom configuration files
├── Data/                     # Test data files
├── allure-results/           # Allure test report outputs
├── src/
│   ├── main/
│   │   └── java/             # Main source code (if any)
│   └── test/
│       └── java/             # Test source code
│           ├── tests/        # Test classes
│           └── utils/        # Utility classes
├── .gitignore                # Git ignore file
├── README.md                 # Project documentation
├── pom.xml                   # Maven project configuration
└── rest-assured-api-maven-java.iml  # IntelliJ IDEA project file
```

## 🧩 Folder Descriptions
* .github/workflows: Contains GitHub Actions workflows for CI/CD pipelines.

* .idea: Project-specific files for IntelliJ IDEA.

* Configurations: Custom configuration files for the project.

* Data: Test data files used in the API tests.

* allure-results: Directory where Allure test report outputs are stored.

* src/test/java/tests: Java classes containing the API test cases.

* src/test/java/utils: Utility classes to assist with the tests.

* pom.xml: Maven configuration file that manages project dependencies and build settings

## 📥 Download, Install and Setup.
#### Eclipse IDE Download 
- https://www.eclipse.org/downloads/packages/
#### Install TestNG in Eclipse  
- Help >> Eclipse Market place >> search >> testng >> Install.

#### Install Java JDK
- https://www.oracle.com/java/technologies/downloads/#jdk21-windows
- x64 Installer option to download the .exe
```
1. Install next .... finished
2. Setting JAVA_HOME:
3. R-click on "This PC" and select "Properties" >> Advanced system settings >> Environment Variables.
4. System Variable >> new >> Variable name = JAVA_HOME & Variable value = C:\Program Files\Java\jdk-21 >> OK
5. System variable >> path >> edit >> new >>  C:\Program Files\Java\jdk-21\bin >> OK
6. Command Prompt : java --version >> will display Java Version.
```
#### Install Apache Maven
- Download Apache maven: https://maven.apache.org/download.cgi
- Files >> Binary zip archive >> apache-maven-3.9.9-bin.zip
```
1. Install next .... finished
2. Setting MAVEN_HOME:
3. R-click on "This PC" and select "Properties" >> Advanced system settings >> Environment Variables.
4. User Variable >> new >> Variable name = MAVEN_HOME & Variable value = C:\Program Files\apache-maven-3.9.9 >> OK
5. System variable >> path >> edit >> new >>  C:\Program Files\apache-maven-3.9.9\bin
6. Command Prompt : mvn -v >> will display Maven Version.
```
#### For the pom.xml dependencies
- https://mvnrepository.com/

## ▶️ Running the test suites
```
# 1.  Running the smoke test suite
mvn clean test -DtestngFile=smoke-test-suite.xml

# 2. Running the Sanity test suite
mvn clean test -DtestngFile=sanity-test-suite.xml

# 3. Running the Regression test suite
mvn clean test -DtestngFile=regression-test-suite.xml

```

## 📊  Report
1. Maven surefire report
   target/surefire-reports/`index.html`

2. TestNG Report
   test-output/`index.html`

3. Allure Report
   install `scoop` window powershell : iwr -useb get.scoop.sh | iex
   install `allure` command: scoop install allure
   cmd command : `allure serve allure-results`

