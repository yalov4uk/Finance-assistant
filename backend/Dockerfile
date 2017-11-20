FROM java:8
FROM maven

WORKDIR backend

ADD . .

RUN ["mvn", "clean"]

RUN ["mvn", "install"]

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar core/target/financial-service.jar" ]
