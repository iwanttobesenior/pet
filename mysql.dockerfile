FROM mysql:8.0
LABEL author="Kul'baka Alex"


ENV MYSQL_ROOT_PASSWORD=root \
       MYSQL_USER=kulbaka \
       MYSQL_PASSWORD=root \
       MYSQL_DATABASE=example

VOLUME C:/Users/User/Desktop/dockervolumes/mysql/example

