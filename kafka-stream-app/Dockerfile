FROM openjdk:21-jdk

COPY kafka_stream_app/target/kafka_stream_app-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "/kafka_stream_app-0.0.1-SNAPSHOT.jar" ]