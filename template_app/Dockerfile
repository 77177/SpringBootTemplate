FROM openjdk:8-jre-alpine

COPY /target/template_app-1.0-SNAPSHOT.jar /

CMD ["java","-jar","-Dspring.profiles.active=docker","template_app-1.0-SNAPSHOT.jar"]