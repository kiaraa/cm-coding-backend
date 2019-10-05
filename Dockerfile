FROM openjdk:14-jdk-oraclelinux7
COPY cm-coding-backend.jar /
#COPY keystore /Users/chrisatkins/myssl/keystore
#COPY truststore /Users/chrisatkins/myssl/truststore
ENV MYSQL_PASSWORD=ohhello
ENV MYSQL_CONNECTION_STRING=jdbc:mysql://127.0.0.1:3306/cmcoding
ARG MYSQL_PASSWORD_ARG=$MYSQL_PASSWORD
ARG MYSQL_CONNECTION_STRING_ARG=$MYSQL_CONNECTION_STRING
CMD ["java", "-jar", "cm-coding-backend.jar", "--spring.datasource.password=$MYSQL_PASSWORD_ARG", "--spring.datasource.url=$MYSQL_CONNECTION_STRING_ARG"]