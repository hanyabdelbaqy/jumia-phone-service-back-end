FROM openjdk:8-jdk-alpine
COPY target/jumia-phone-service-1.0.jar jumia-phone-service-v1.0.jar
ENV JAVA_OPTS=""
EXPOSE 9595
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/jumia-phone-service-v1.0.jar"]
