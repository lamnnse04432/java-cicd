#FROM maven:3-openjdk-8 AS build
#RUN mkdir /usr/src/project
#COPY . /usr/src/project
#WORKDIR /usr/src/project
#RUN mvn dependency:go-offline
#RUN mvn -o clean package -DskipTests

# Sử dụng image Maven chính thức
FROM maven:3-openjdk-8 AS build

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép file pom.xml trước tiên
COPY pom.xml .

# Tải các dependency của Maven
RUN mvn dependency:go-offline

# Sao chép mã nguồn vào container
COPY src ./src

# Xây dựng ứng dụng
RUN mvn clean package

FROM openjdk:8-jre-alpine
RUN mkdir /project
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /project/
WORKDIR /project
RUN mkdir /config
CMD java -jar demo-0.0.1-SNAPSHOT.jar