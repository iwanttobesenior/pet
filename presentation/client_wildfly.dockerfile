FROM jboss/wildfly:latest
LABEL author="Kul'baka Alex"

ADD /target/client.war /opt/jboss/wildfly/standalone/deployments/