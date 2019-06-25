FROM openjdk:8-jre-alpine

WORKDIR $HOME/santatecla-relaciones-1/relaciones/

CMD .mvnw install

COPY /target/relaciones-0.0.1-SNAPSHOT.jar $HOME/santatecla-relaciones-1/relaciones/

EXPOSE 8443

CMD java -jar relaciones-0.0.1-SNAPSHOT.jar