## 📌 Project Overview

This is a Selenium automation project written in Java using the TestNG framework and built with Maven. The goal is to automate user interactions on the website [Intervue.io](https://www.intervue.io).

The test suite performs the following key actions:
- Launches the Intervue.io homepage.
- Hovers over various top navigation bar items (Products, Solutions, Pricing, Resources, Contact Us).
- Clicks on the **Login** button and selects the **Company Login** option.
- Logs into the platform using provided credentials.
- Enters a search term (e.g., "Hello") into the candidate search field.
- Clicks on one of the search suggestions.
- Logs out of the platform and exits the browser.

---

## 🔧 Project Setup

To get started with the project, follow these steps:

1. **Install Java**  
   Make sure Java JDK 8 or higher is installed on your machine. You can check this by running `java -version` in your terminal.

2. **Install Maven**  
   Download and install Apache Maven. After installation, verify it by running `mvn -version`.

3. **Set up ChromeDriver**  
   Download the appropriate version of ChromeDriver that matches your Google Chrome browser.  
   - Add the driver to your system `PATH`, or  
   - Set it directly in your code using `System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");` if needed.

4. **Clone the Repository**  
   Use Git to clone the repository to your local machine:
   ```bash
   git clone gh repo clone anirudhduvedi/MavenProjectIntervueIo
   ```

5. **Add the Test Data File**  
   Create a file named `testData.properties` in `src/test/resources/` and add the following values:
   ```properties
   baseUrl=https://www.intervue.io/
   email=neha@intervue.io
   password=Ps@neha@123
   searchText=Hello
   ```


---

## 🚀 Running the Project

Once setup is complete, you can execute the tests using Maven:

```bash
mvn test
```

This will:
- Open Chrome browser.
- Navigate to the homepage.
- Hover over the menu bar options.
- Initiate login via company login.
- Fill out the email and password.
- Perform a search for the text provided in your test data.
- Click on the first result from the suggestion list.
- Log out of the session.

The tests are organized using TestNG with defined priorities to maintain execution order.

---

## 🗂 Project Structure

Here's a quick breakdown of the project layout:

```
project-root/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── intervue_test/
│   │   │       ├── Login_test.java
│   │   │       └── utils/
│   │   │           └── TestDataLoader.java
│   │   └── resources/
│   │       └── testData.properties
│
├── pom.xml
└── README.md
```

---

## 📚 Technologies Used

- Java
- Maven
- Selenium WebDriver
- TestNG
- ChromeDriver

---
