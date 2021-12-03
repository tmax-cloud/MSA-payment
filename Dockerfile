FROM docker.io/openjdk:11-jdk
LABEL PROJECT_NAME=payment \
      PROJECT=payment

COPY target/payment-0.0.1-SNAPSHOT.jar  payment.jar
EXPOSE 8079 8079
ENTRYPOINT ["java","-jar","/payment.jar"]
