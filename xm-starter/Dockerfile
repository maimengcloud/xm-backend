FROM openjdk:8u212-jre-alpine3.9

ENV JVM_ARG="-Xms1G"

ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT java -Duser.timezone=GMT+08:00 ${JVM_ARG} -jar /app.jar