FROM openjdk:14-jdk-oraclelinux7
COPY cm-coding-backend.jar /
#COPY keystore /Users/chrisatkins/myssl/keystore
#COPY truststore /Users/chrisatkins/myssl/truststore
CMD ["java", "-jar", "cm-coding-backend.jar"]