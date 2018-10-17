FROM java:8
FROM maven:alpine
WORKDIR /app
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
LABEL maintainer=“shashimald@gmail.com”
ADD ./target/shoppingsocieties-0.0.1-SNAPSHOT.jar shoppingsocieties-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","shoppingsocieties-0.0.1-SNAPSHOT.jar"]