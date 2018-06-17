FROM java:8
FROM maven:3

WORKDIR backend

ADD . .

RUN mvn clean install -P docker

CMD java -jar core/target/core.jar
