FROM openjdk:17-oracle

ARG JAR_FILE=/lemonade-api/build/libs/lemonade-api.jar
COPY ${JAR_FILE} /lemonade-api.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/lemonade-api.jar"]