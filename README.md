
# SDET Challenge Automation Test

This project contains automated tests for the SDET Challenge using Selenium WebDriver and JUnit 5.

The tests are designed to simulate the weighing of gold bars to find a fake bar in a web-based application.

## Project Structure

- **`src/main/java/pages`**: Contains the Page Object Model (POM) classes that represent web pages.
    - **`ChallengePage.java`**: Represents the web elements used in the challenge test class.


- **`src/test/java/test`**: Contains test classes and page initializers.
    - **`ChallengeTest.java`**: Contains the main test logic for solving the SDET Challenge.
    - **`PageInitializer.java`**: Initializes page objects for use in tests.


- **`src/test/java/utils`**: Contains utility classes for reusable code.
    - **`Constants.java`**: Holds constant values used across the tests, such as URLs.
    - **`Hooks.java`**: Provides setup and teardown methods for the WebDriver.
    - **`CommonMethods.java`**: Contains reusable methods for common actions like sending text and clicking buttons.

## Tools and Technologies

- **Java**: The programming language used for writing tests.
- **JUnit 5**: A testing framework used for writing and executing tests.
- **Selenium WebDriver**: A web automation tool used to interact with the web application.
- **WebDriverManager**: A library that helps manage WebDriver binaries automatically.
- **Maven**: A build automation tool used for managing dependencies and running tests.

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 17 or higher is installed on your system.
- **Maven**: Ensure that Maven is installed and configured on your system.
- IntelliJ, Eclipse, or other Java IDE.

## Installation and Running Tests

### Install Git

1. **Download and Install Git:**
    - Go to the [Git Download](https://git-scm.com/downloads) page.
    - Download the installer for your operating system (Windows, macOS, or Linux).
    - Follow the installation instructions provided by the installer.

2. **Verify Git Installation in terminal:**

   ```bash
   git --version
   ```

   Ensure that it returns the Git version.

### Running tests

### Option 1 - Running from Test Class

1. **Download and Install IntelliJ IDEA:**
    - Go to [IntelliJ IDEA](https://www.jetbrains.com/idea/) and download the Community Edition.
    - Follow the installation instructions for your operating system.

2. **Open IDE and Clone Project from Version Control:**
    - Open IntelliJ IDEA.
    - Go to **File** > **New** > **Project from Version Control**.
    - Enter the repository URL: `https://github.com/PawelMurdza/goldChallenge.git`.

3. **Navigate to `src/test/java/test/ChallengeTest`:**
    - In the Project tool window, go to `src/test/java/test/ChallengeTest`.
    - Right-click on `ChallengeTest` and select **Run 'ChallengeTest'**.

4. **View Reports:**
    - Navigate to `target/reports` to see the screenshot taken at the end of execution and reports.

### Option 2 - Running Using Maven from IntelliJ

1. **Open IDE and Clone Project from Version Control:**
    - Follow steps 1 and 2 from Option 1.

2. **Use Maven in IntelliJ:**
    - On the right-hand side of IntelliJ, click on the **Maven** tab (represented by an "M" icon).
    - The Maven section will expand.

3. **Run Maven Goals:**
    - Expand the `goldchallenge` project.
    - Navigate to **Lifecycle**.
    - Double-click on `clean` and then `test` to execute them.

4. **View Reports:**
    - Navigate to `target/reports` to see the screenshot taken at the end of execution and reports.

### Option 3 - Running from Command Line Using Maven

#### Install JDK

1. **Download and Install JDK 17 or Higher:**
    - Go to the [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) download page.
    - Download and install the appropriate JDK for your operating system.

2. **Set the `JAVA_HOME` Environment Variable:**

    - **Windows:**
        - Click on **Start** and type **Edit the system environment variables**.
        - Click on **Environment Variables**.
        - Under **System variables**, click **New** and enter `JAVA_HOME` as the variable name and the JDK installation path as the value (e.g., `C:\Program Files\Java\jdk-17`).
        - Add `%JAVA_HOME%\bin` to your **Path** variable.

    - **macOS/Linux:**
        - Open a terminal and edit your shell profile file (e.g., `~/.bashrc`, `~/.zshrc`, or `~/.bash_profile`).
        - Add the following lines:

      ```bash
      export JAVA_HOME=$(/usr/libexec/java_home -v 17)
      export PATH=$JAVA_HOME/bin:$PATH
      ```

    - Reload the shell profile:

      ```bash
      source ~/.bashrc  # or source ~/.zshrc, depending on your shell
      ```

3. **Verify Java Installation:**

   ```bash
   java -version
   ```

   Ensure that it returns a version indicating JDK 17.

#### Install Maven

1. **Download and Install Maven:**
    - Go to the [Apache Maven Download](https://maven.apache.org/download.cgi) page.
    - Download the binary archive (e.g., `apache-maven-3.x.x-bin.zip` or `apache-maven-3.x.x-bin.tar.gz`).
    - Extract the archive to a directory of your choice (e.g., `C:\Apache\Maven` or `/usr/local/apache-maven`).

2. **Set the `MAVEN_HOME` Environment Variable:**

    - **Windows:**
        - Follow the same steps as setting `JAVA_HOME` but use `MAVEN_HOME` with the path to your Maven directory (e.g., `C:\Apache\Maven`).
        - Add `%MAVEN_HOME%\bin` to your **Path** variable.

    - **macOS/Linux:**
        - Edit your shell profile and add the following lines:

      ```bash
      export MAVEN_HOME=/path/to/apache-maven
      export PATH=$MAVEN_HOME/bin:$PATH
      ```

      Replace `/path/to/apache-maven` with the actual path to your Maven installation.

    - Reload the shell profile:

      ```bash
      source ~/.bashrc  # or source ~/.zshrc, depending on your shell
      ```

3. **Verify Maven Installation:**

   ```bash
   mvn -version
   ```

   Ensure that it returns the Maven version and your Java home correctly.

#### Running Tests from Command Line

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/PawelMurdza/goldChallenge.git
   cd C:\Users\your_user\IdeaProjects\goldChallenge
   ```

2. **Run Tests Using Maven:**

   Execute the following command in the terminal to run the tests:

   ```bash
   mvn clean test
   ```

3. **View Reports:**

   Navigate to `target/reports` to see the screenshot taken at the end of execution and reports.
