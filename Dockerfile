FROM amazoncorretto:8
WORKDIR /app
COPY ./target/gesthor.jar .
ENTRYPOINT java -jar gesthor.jar
