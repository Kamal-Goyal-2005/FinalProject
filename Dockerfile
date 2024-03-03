FROM openjdk:11-alpine
WORKDIR /app
EXPOSE 8080
COPY target/medicineorderspringrest-0.0.1-SNAPSHOT.war /app/medicineorderspringrest-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "medicineorderspringrest-0.0.1-SNAPSHOT.war"]
