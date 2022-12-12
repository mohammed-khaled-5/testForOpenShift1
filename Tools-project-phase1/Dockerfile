FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM maven:3.8.6-eclipse-temurin-17-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/Tools-project-phase1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Tools-project-phase1-0.0.1-SNAPSHOT.jar"]