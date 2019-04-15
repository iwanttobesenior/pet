docker stop admin_tomcat

docker rm admin_tomcat

docker build -t kulbaka/tomcat -f tomcat.dockerfile .

docker run -d --name=admin_tomcat -p 8060:8080 --link mysqL:mysqL kulbaka/tomcat
