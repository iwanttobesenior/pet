FROM tomcat:8.5.39-jre11
ADD /target/admin.war /usr/local/tomcat/webapps/
