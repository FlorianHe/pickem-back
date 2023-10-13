FROM openjdk:17
COPY target/*.jar pickem-back.jar
ENTRYPOINT ["java", "-jar", "/pickem-back.jar"]