FROM openjdk:11-jdk-oraclelinux7
COPY cm-coding-backend.jar /
#COPY keystore /Users/chrisatkins/myssl/keystore
#COPY truststore /Users/chrisatkins/myssl/truststore

ENTRYPOINT ["java", "-jar", "cm-coding-backend.jar"]

#FROM ubuntu:18.04
#RUN apt --yes update
#RUN apt --yes upgrade
#RUN apt-get install --yes software-properties-common
#RUN add-apt-repository ppa:linuxuprising/java
#RUN apt --yes update
#RUN echo debconf shared/accepted-oracle-license-v1-2 select true | debconf-set-selections
#RUN echo debconf shared/accepted-oracle-license-v1-2 seen true | debconf-set-selections
#COPY jdk-11.0.4_linux-x64_bin.tar.gz /var/cache/oracle-jdk11-installer-local/
#RUN apt install --yes oracle-java11-installer-local
#RUN apt install --yes oracle-java11-set-default-local
#COPY cm-coding-backend.jar /
#ENTRYPOINT ["java", "-jar", "/cm-coding-backend.jar"]
