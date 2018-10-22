FROM maven:3.5-jdk-8

WORKDIR /app

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests

EXPOSE 8888
LABEL maintainer=“shashimald@gmail.com”
ADD ./target/shoppingsocieties-0.0.1-SNAPSHOT.jar shoppingsocieties-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","shoppingsocieties-0.0.1-SNAPSHOT.jar"]