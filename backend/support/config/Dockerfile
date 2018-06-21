FROM java:8
FROM maven:3

WORKDIR config

ADD . .

RUN mvn clean install -P docker

CMD java -jar target/config.jar
