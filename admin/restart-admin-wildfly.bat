docker stop admin_wildfly

docker rm admin_wildfly

docker build -t kulbaka/admin_wildfly -f wildfly.dockerfile .

docker run -d --name=admin_wildfly --link mysqL:mysqL -p 8099:8080 -p 9990:9990 kulbaka/admin_wildfly