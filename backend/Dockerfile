FROM java:8
FROM maven:3

WORKDIR backend

ADD . .

RUN mvn clean install -P docker

ENTRYPOINT java -jar core/target/financial-service.jar
