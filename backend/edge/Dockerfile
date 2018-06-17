FROM java:8
FROM maven:3

WORKDIR edge

ADD . .

RUN mvn clean install

CMD java -jar target/edge.jar
