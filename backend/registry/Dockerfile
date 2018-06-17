FROM java:8
FROM maven:3

WORKDIR registry

ADD . .

RUN mvn clean install -P docker

CMD java -jar target/registry.jar
