FROM openjdk:17
RUN mkdir -p /opt/rrpay/bugtracker/lib && mkdir -p /var/log/rrpay
ADD target/bug-tracker-0.0.2-SNAPSHOT.jar /opt/rrpay/bugtracker/lib/bug-tracker-0.0.2-SNAPSHOT.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container","/opt/rrpay/bugtracker/lib/bug-tracker-0.0.2-SNAPSHOT.jar"]