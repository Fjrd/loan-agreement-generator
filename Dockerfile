FROM openjdk:18-jdk-alpine3.14 AS BUIDER

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN ./mvnw clean
RUN ./mvnw package -DskipTests

FROM openjdk:18-jdk-alpine3.14

COPY --from=BUIDER /app/target/*.jar app.jar