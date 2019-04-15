docker stop admin_glassfish

docker rm admin_glassfish

docker build -t kulbaka/glassfish -f src/main/resources/docker/admin-glassfish.dockerfile .

docker run -d --name=admin_glassfish --link mysqL:mysqL -p 8080:8080 -p 4848:4848 -e ADMIN_PASSWORD=admin kulbaka/glassfish