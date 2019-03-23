#image to postgre DBMS





#image to build apache WebServer






#image to ubuntu os
FROM ubuntu:latest

RUN apt-get -y update
RUN apt-get -y install apache2
RUN echo 'hello..!' > /var/www/html/index.html

CMD ["/usr/sbin/apache2ctl","-DFOREGROUND"]
EXPOSE 80
