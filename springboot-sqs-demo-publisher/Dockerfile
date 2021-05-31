#FROM gradle:5.1-jdk8-alpine

#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/mvn/src
#RUN mvn clean build -x test


FROM adoptopenjdk/openjdk11



# do mvn build

#ENV PATH=$PATH:/usr/local/bin
#RUN source ~/.bashrc
#RUN mvn clean install

# add directly the jar
ADD target/sqs-push-0.0.1-SNAPSHOT.jar sqs-push.jar


# to create a modification date
RUN sh -c 'touch sqs-push.jar'

CMD ["java", "-jar", "sqs-push.jar"]

#VOLUME /tmp

EXPOSE 9090