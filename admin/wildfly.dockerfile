FROM jboss/wildfly:latest
LABEL author="Kul'baka Alex"

ADD /target/admin.war /opt/jboss/wildfly/standalone/deployments/