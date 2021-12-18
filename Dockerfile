FROM openjdk:8
COPY ./build/libs/homeinsurancemanagementsystem-0.0.1-SNAPSHOT.jar homeinsurancemanagementsystem-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "homeinsurancemanagementsystem-0.0.1-SNAPSHOT.jar"]