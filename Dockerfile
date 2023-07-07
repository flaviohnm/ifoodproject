FROM java:20
EXPOSE 8081
ADD /target/manager.jar manager.jar
ENTRYPOINT ["java","-jar","manager.jar"]