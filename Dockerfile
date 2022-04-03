FROM openjdk:8-jre-alpine
LABEL maintainer="ryanucheka@gmail.com"
#VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/zatech-app-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} ZatechApp.jar
ENTRYPOINT ["java","-jar","ZatechApp.jar"]