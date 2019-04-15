docker stop client_glassfish

docker rm client_glassfish

docker build -t kulbaka/client_glassfish -f wildfly.dockerfile .

docker run