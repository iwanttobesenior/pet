FROM tomcat:8.5.39-jre11
LABEL author="Kul'baka Alex"

ADD /target/client.war /usr/local/tomcat/webapps/
