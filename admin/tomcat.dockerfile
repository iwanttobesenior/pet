FROM tomcat:8.5.39-jre11
LABEL author="Kul'baka Alex"

ADD /target/admin.war /usr/local/tomcat/webapps/
