FROM java:8
FROM maven:3

WORKDIR edge

ADD . .

RUN mvn clean install

CMD java -jar -Dspring.profiles.active=docker target/edge.jar
