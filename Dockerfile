FROM adoptopenjdk/openjdk15:alpine-jre
EXPOSE 8300
ADD target/pensiondisbursement-microservice.jar pensiondisbursement-microservice.jar
ENTRYPOINT ["java","-jar","/pensiondisbursement-microservice.jar"]