FROM maven:3.5-jdk-8-alpine
ADD target/bmtsys_service.jar bmtsys_service.jar
ENTRYPOINT ["java","-jar","bmtsys_service.jar"]