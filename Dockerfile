FROM maven:3-openjdk-8 AS build
RUN mkdir /usr/src/project
COPY . /usr/src/project
WORKDIR /usr/src/project
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
RUN mkdir /project
COPY --from=build /usr/src/project/target/demo-0.0.1-SNAPSHOT.jar /project/
WORKDIR /project
CMD java -jar demo-0.0.1-SNAPSHOT.jar