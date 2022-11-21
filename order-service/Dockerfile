FROM openjdk:11
EXPOSE 8070
ADD target/order-service.jar order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]