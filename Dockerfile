FROM tomcat:latest
COPY target/*.war /usr/local/tomact/webapps/
