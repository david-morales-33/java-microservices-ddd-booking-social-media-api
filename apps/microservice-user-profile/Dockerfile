FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace

COPY pom.xml pom.xml

COPY libs/shared-kernel/pom.xml libs/shared-kernel/pom.xml
COPY libs/shared-kernel/src libs/shared-kernel/src

COPY libs/persistence/pom.xml libs/persistence/pom.xml
COPY libs/persistence/src libs/persistence/src

COPY libs/bus/pom.xml libs/bus/pom.xml
COPY libs/bus/src libs/bus/src

COPY apps/microservice-user-profile/pom.xml apps/microservice-user-profile/pom.xml
COPY apps/microservice-user-profile/src apps/microservice-user-profile/src

COPY apps/microservice-social-graph/pom.xml apps/microservice-social-graph/pom.xml

RUN mvn -f pom.xml -pl apps/microservice-user-profile -am clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /workspace/apps/microservice-user-profile/target/microservice-user-profile-1.0.0.jar app.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
