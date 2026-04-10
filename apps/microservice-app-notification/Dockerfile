FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace

#GESTOR PADRE
COPY pom.xml pom.xml

#DEPENDENCIAS DEL PROYECTO Y SUS RESPECTIVOS GESTORES
COPY libs/shared-kernel/pom.xml libs/shared-kernel/pom.xml
COPY libs/shared-kernel/src libs/shared-kernel/src

COPY libs/infrastructure/pom.xml libs/infrastructure/pom.xml
COPY libs/infrastructure/src libs/infrastructure/src

COPY libs/bus/pom.xml libs/bus/pom.xml
COPY libs/bus/src libs/bus/src

#PROYECTO PRINCIPAL Y SU REPECTIVO GESTOR
COPY apps/microservice-app-notification/pom.xml apps/microservice-app-notification/pom.xml
COPY apps/microservice-app-notification/src apps/microservice-app-notification/src

#GESTORES HIJOS (EL GESTOR PADRE LOS REQUIRE)
COPY apps/microservice-user-profile/pom.xml apps/microservice-user-profile/pom.xml
COPY apps/microservice-social-graph/pom.xml apps/microservice-social-graph/pom.xml

RUN mvn -f pom.xml -pl apps/microservice-app-notification -am clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /workspace/apps/microservice-app-notification/target/microservice-app-notification-1.0.0.jar app.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
