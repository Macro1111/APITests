# APITests

APITests is an automated Java project that validates the main functionalities of the "PerfDog" pet store API, based on the [Swagger Petstore API documentation](https://petstore.swagger.io). The test suite simulates real-world API usage, ensuring that essential features such as user registration, authentication, product browsing, and order processing work as expected from an end-user perspective.

> **⚠️ Warning:**  
> The PerfDog server is a public server, which means that other users may be interacting with and modifying the data simultaneously during the execution of your tests. This can cause unexpected results or test failures unrelated to problems in your code. If a test fails, it is recommended to re-run and review the case to determine if the failure was due to interference from other users.  
>
> The development of the tests was conditioned by the public nature of the server, as described above.  
>
> Additionally, some `waits` have been added to the tests because the database updates on the public server can be slow and are affected by concurrent user activity. These waits help ensure the reliability of assertions, but occasional timing issues may still arise for the same reason.

## Tested Functionalities

The automated suite covers the following scenarios, each as an independent and isolated test:

1. Create a user and log in with the newly created user.
2. List all pets with status "available".
3. Retrieve information for a specific pet.
4. Create a purchase order for a pet.
5. Log out from the application.

## Technologies Used

- Java 21 (source/target)
- Maven (Project build & dependency manager)
- io.rest-assured: 5.4.0 (API testing)
- org.testng: 7.9.0 (Test runner)
- org.projectlombok: 1.18.32 (Boilerplate code reduction)
- org.hamcrest: 2.2 (Assertions)
- com.fasterxml.jackson.core:jackson-databind: 2.17.2 (JSON serialization/deserialization)
- org.awaitility: 4.2.0 (Asynchronous testing)
- UTF-8 encoding

## Project Structure

```
APITests/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── globan/
│                   └── automation/
│                       └── tests/
│                           └── AllTests.java
├── suite-full.xml
├── pom.xml
└── README.md
```

- **AllTests.java**: Main test class containing all automated scenarios, one test per required functionality.
- **suite-full.xml**: TestNG suite to run all tests sequentially.

## How It Works

- Each test is independent and does not rely on the results or state of other tests.
- The tests cover real-world user actions, such as user creation, authentication, listing available pets, consulting pet details, purchasing, and logging out.
- All requests and assertions are built using RestAssured, ensuring easy-to-read and maintainable code.
- The test runner is TestNG, which allows for flexible test execution and reporting.

### Example Test (from AllTests.java)

```java
@Test(priority = 1, testName ="1-2 User creation and login")
public void userCreatedAndLogin() {
    Response response = createAndLoginUser();
    Assert.assertEquals(response.getStatusCode(),200, "The login was not successful");
}
```

### Test Suite Configuration

The suite-full.xml file runs all the main automated tests in sequence:

```xml
<suite name="Full Suite" parallel="false">
    <test name="Tests full suite">
        <classes>
            <class name="com.globan.automation.tests.AllTests"/>
        </classes>
    </test>
</suite>
```

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Macro1111/APITests.git
   cd APITests
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Run the test suite:**
   ```bash
   mvn test -DsuiteXmlFile=suite-full.xml
   ```

4. **Review the reports:**
   Test reports will be generated in the `target/surefire-reports` directory.

## API Reference

All tests are based on the official Swagger Petstore API:  
[https://petstore.swagger.io](https://petstore.swagger.io)

## Contribution

Contributions are welcome! Please open issues or submit pull requests for improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

Developed by [Macro1111](https://github.com/Macro1111).

---

For more information, refer to the main test class [AllTests.java](https://github.com/Macro1111/APITests/blob/master/src/test/java/com/globan/automation/tests/AllTests.java).
