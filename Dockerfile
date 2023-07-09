FROM gradle:latest AS BUILD
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:latest
ENV JAR_NAME=app.jar
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME/build/ .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/libs/$JAR_NAME