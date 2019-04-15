docker stop client_tomcat

docker rm client_tomcat

docker build -t kulbaka/client_tomcat -f client_tomcat.dockerfile .

docker run -d --name=client_tomcat -p 8050:8080 --link mysqL:mysqL kulbaka/client_tomcat