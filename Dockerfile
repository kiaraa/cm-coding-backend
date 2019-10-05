FROM openjdk:14-jdk-oraclelinux7
COPY cm-coding-backend.jar /
#COPY keystore /Users/chrisatkins/myssl/keystore
#COPY truststore /Users/chrisatkins/myssl/truststore
ENV MYSQL_PASSWORD=ohhello
ENV MYSQL_CONNECTION_STRING=jdbc:mysql://127.0.0.1:3306/cmcoding
CMD java -jar cm-coding-backend.jar --spring.datasource.password=$MYSQL_PASSWORD --spring.datasource.url=$MYSQL_CONNECTION_STRING