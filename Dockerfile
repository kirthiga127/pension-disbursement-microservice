FROM adoptopenjdk/openjdk15:alpine-jre
VOLUME /tmp
EXPOSE 8300
ADD target/*.jar pensiondisbursement-microservice.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /pensiondisbursement-microservice.jar" ]
