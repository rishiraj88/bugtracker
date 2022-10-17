FROM openjdk:17
RUN mkdir -p /opt/rpay/bugtracker/lib && mkdir -p /var/log/rpay
ADD target/bug-tracker-0.0.1-SNAPSHOT.jar /opt/rpay/bugtracker/lib/bug-tracker-0.0.1-SNAPSHOT.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container","/opt/rpay/bugtracker/lib/bug-tracker-0.0.1-SNAPSHOT.jar"]