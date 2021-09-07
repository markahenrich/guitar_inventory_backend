FROM openjdk:11
ADD guitarinventory/target/guitar-inventory.jar guitar-inventory.jar
ENV DB_HOST=host.docker.internal
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "guitar-inventory.jar"]