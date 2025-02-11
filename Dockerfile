FROM maven:3.8.5-openjdk-17-slim AS build
VOLUME /tmp
COPY src /home/app/src
COPY pom.xml /home/app

FROM eclipse-temurin:17.0.3_7-jre

VOLUME /tmp
COPY target/*.jar app.jar

# Configure Certificates
COPY trustcerts/* /tmp/trustcerts/
RUN for certs in `ls /tmp/trustcerts/*.crt`; do keytool -importcert -keystore $JAVA_HOME/lib/security/cacerts -alias `echo $certs|awk -F "/" '{print $4}'` -file $certs -noprompt -trustcacerts -storepass changeit; done &&\
rm -r /tmp/trustcerts

ENV SPRING_PROFILES_ACTIVE=non-prod
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-Dspring.jdbc.getParameterType.ignore=true","-jar","app.jar"]
