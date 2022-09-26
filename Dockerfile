FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/Employee-Management-0.0.1.jar Employee-Management-0.0.1.jar
ENTRYPOINT ["java","-jar","/Employee-Management-0.0.1.jar"]