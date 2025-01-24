FROM bellsoft/liberica-openjdk-alpine:23.0.1

WORKDIR /app

COPY ./target/webapp-dropshot-backend-0.0.1.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]