FROM tomcat:9.0.16-jre11-slim
MAINTAINER Kok How, Teh <kokhow.teh@taiger.com>
RUN rm -rf /usr/local/tomcat/webapps/docs /usr/local/tomcat/webapps/examples /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/host-manager /usr/local/tomcat/webapps/manager
ADD target/graphql-book /usr/local/tomcat/webapps/graphql-book
EXPOSE 8080
CMD ["catalina.sh", "run"]
