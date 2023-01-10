FROM openjdk

COPY target/*.jar forumapp.jar

ENTRYPOINT ["java","-jar","/forumapp.jar"]