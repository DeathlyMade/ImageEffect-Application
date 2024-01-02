# ImageEffect Application Project

## About
The project involved a team of six members, and it was a mandatory assignment for our Programming - 2 course at the end of the third semester. We all contributed to getting it done successfully.

## Tech Stack
1. Java
2. C++
3. Angular
4. JavaScript
5. HTML
6. CSS

## Description
The ImageEffect Application is a comprehensive tool designed to apply various photo effects to images. It is intended for users who want to quickly and easily enhance their images with different effects.

## Main Features
- Effect Application: Users can click on a particular effect, and the application will apply this effect to the image. The transformed image is then displayed on the website.
- Downloadable Results: After applying the desired effects, users have the option to download the resulting image.
- Log Tracking: The application keeps track of logs using file I/O, providing a history of user actions and system operations.
- Cross-Language Integration: The core effect application codes are written in C++, while the user interface and control logic are implemented in Java. The project uses Java Native Interface (JNI) to connect the C++ code with the Java code, allowing for efficient cross-language operations.

## Installation
1. Clone the repository using
```
git clone https://github.com/DeathlyMade/Programming-2-project.git
```
2. Open a new terminal
3. Navigate into Backend folder using `cd ImageEffectBackend`
4. Make changes in `Makefile` (change the `JAVA_HOME` variable and replace `darwin` with `Win32` if you are using Windows or with `linux` if you are using Linux)
5. Execute the Make file using `make clean` and `make`
6. Navigate to `P2-2023-Project/ImageEffectBackend/pom.xml` to load the Maven dependencies  - If you are using IntelliJ just click on the "Load Maven dependencies" pop-up. If you are using other IDEs then use `./mvnw clean package`
7. Run SpringBoot - Navigate to `P2-2023-project/ImageEffectBackend/src/main/java/com/iiitb/ImageEffectApplication/ImageEffectApplication.java` and click on "Run" if you are using IntelliJ, otherwise run the `.jar` file created inside the `target` folder using `java -jar target/imageEffectApplication-0.0.1-SNAPSHOT.jar`.
8. Open a new terminal
9. Navigate to ImageEffectFrontend using `cd ImageEffectFrontend`
10. Load Node modules using `npm i`
11. Run the server using `npm start`

## Usage
Open your web browser and navigate to [https://localhost:4200/](https://localhost:4200/) to access the website.

## Individual User Contributions

- Hash Modani: Contributed in writing CPP logic for effects
- Mohammad Owais: Contributed in writing CPP logic for effects
- Divyam: Made `effectImplementations` Package and `Handled Exceptions`
- Aaditya Gole: Contributed to `loggingService` and `Threads`
- Daksh Rajesh: Contributed to `loggingService` and `Threads`
- Sarvesh Kumar A: Contributed to `loggingService` and `PhotoEffectService`
