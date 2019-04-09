docker stop admin_wildfly

docker rm admin_wildfly

docker build -t kulbaka/wildfly -f wildfly.dockerfile .

docker run -d --name=admin_wildfly -p 8061:8080 --link mysqL:mysqL kulbaka/wildfly