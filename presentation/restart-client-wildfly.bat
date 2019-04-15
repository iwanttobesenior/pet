docker stop client_wildfly

docker rm client_wildfly

docker build -t kulbaka/client_wildfly -f wildfly.dockerfile .

docker run -d --name=client_wildfly --link mysqL:mysqL -p 8099:8080 -p 9990:9990 kulbaka/client_wildfly