FROM maven:3.5.2-jdk-8 AS build
WORKDIR /usr/src/app
COPY . ./
RUN mvn -f ./pom.xml clean package

FROM openjdk:8
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/backend/target/dashboard-1.0.0.jar ./dashboard-1.0.0.jar 
EXPOSE 8080

CMD ["java","-jar","./dashboard-1.0.0.jar"]
