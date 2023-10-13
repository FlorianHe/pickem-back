FROM openjdk:17
COPY target/*.jar Pickem-api.jar
ENTRYPOINT ["java", "-jar", "/Pickem-api.jar"]