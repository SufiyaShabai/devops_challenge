# STAGE 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# STAGE 2: Create the runtime image
FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
WORKDIR /app
COPY --from=build /app/target/simpleTimeService-0.0.1-SNAPSHOT.jar app.jar
RUN chown -R spring:spring /app
USER spring
ENTRYPOINT ["java", "-jar", "app.jar"]

