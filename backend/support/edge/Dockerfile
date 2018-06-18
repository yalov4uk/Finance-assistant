FROM java:8
FROM maven:3

WORKDIR edge

ADD . .

RUN mvn clean install -P docker

CMD java -jar target/edge.jar
