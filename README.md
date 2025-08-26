# Web Framework for REST Services and Static File Management

This project extends an existing web server into a full-featured framework, enabling REST backend services alongside static file management. It provides tools for defining REST services with lambda functions, handling query parameters, and specifying static file locations, simplifying modern web application development.


## Getting Started

The following instructions will allow you to run the project locally on your machine.

### Prerequisites

You need to have the following installed:

1. **Java 21** (recommended)  
   Verify your version with:

   ```
   java -version
    ```
   Example output:

    ```
    java version "21.0.2" 2024-01-16 LTS
    Java(TM) SE Runtime Environment (build 21.0.2+13-LTS-58)
    Java HotSpot(TM) 64-Bit Server VM (build 21.0.2+13-LTS-58, mixed mode, sharing)
    ```

2. **Maven 3.9.x**
   
   Download from Maven Official Site.
   Verify installation with:
   ```
   mvn -v
   ```

   Example output:
   ```
   Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
   Maven home: /usr/local/apache-maven
   Java version: 21.0.2, vendor: Oracle Corporation
   ```

3. **Git**

   To clone the repository. Verify with:
   ```
   git --version
   ```

### Installation

1. Clone the repository and navigate to the folder containing the `pom.xml` file using the following commands:

   ```sh
   git clone https://github.com/AndresSu2342/AREP_MICROFRAMEWORKS_WEB.git
   cd AREP_MICROFRAMEWORKS_WEB
   ```

2. Build the project:

   ```sh
   mvn clean package
   ```

   The console output should look something like this:

   ```sh
   [INFO] Building jar: C:\Users\cesar.borray-s\Downloads\httpserver1\target\httpserver1-1.0-SNAPSHOT.jar
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  5.460 s
   [INFO] Finished at: 2025-08-25T23:39:05-05:00
   [INFO] ------------------------------------------------------------------------
   ```

3. Run the application:

      ```sh
      java -cp target/httpserver1-1.0-SNAPSHOT.jar com.mycompany.httpserver1.WebApplication
      ```
   The console should display the following message:
      ```sh
      Listo para recibir ...
      ```
   You can now access static resources like `index.html` or other resources stored in the `resources/static` folder.

4. Search in the browser http://localhost:35000/index.html

   ![index.html](src="https://github.com/user-attachments/assets/94258ca5-8e99-4395-93f1-662df66fd369" )
   ![index.html](https://github.com/user-attachments/assets/94258ca5-8e99-4395-93f1-662df66fd369)


