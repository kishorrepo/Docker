Change MySQL priveleges to allow remote users 

mysql -u root -p 
Enter password: root  

mysql>GRANT ALL ON *.* to root@'10.10.26.58' IDENTIFIED BY 'admin'; 
 

mysql>FLUSH PRIVILEGES; 
 

mysql>exit 

 

================================================================ 

 

Angular Containerization on docker: 

    Step 1: >>>ng build 

    Step 2: >>>docker build . -f Dockerfile.angular -t ngapp 

    Step 3: >>>docker run -p 4200:4200 ngapp 

 

====================================================== 

Spring Boot Containerization on docker: 

 

Step 1: create maven build of spring boot application   

>>>mvn clean install 

Step 2: Create docker build of it  

>>>docker build . -f Dockerfile.spring -t demo-docker  

Step 3: check image get created or not  

>>> docker images 

Step 4: Create MySQL container, the image will be picked from Docker Hub 

>>>docker run --name mysql-standalone_5.6 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -e MYSQL_USER=root -e MYSQL_PASSWORD=root -d mysql:5.6 

Step 5: Run docker image to start Container   

>>>docker run -p 8086:8086 --name demo-docker --link mysql-standalone_5.6:mysql -d demo-docker 

  

=============================================================     

Debugging inside Containerization docker: 

 

Check Logs: 

    MySql :    >>>docker logs mysql-standalone_5.6 

    Java  :    >>>docker logs demo-docker  

Mysql on docker: 

    Step 1: docker exec -it mysql-standalone_5.6 /bin/bash 

    Step 2: mysql -uuser -ppassword 

    Step 3: show databases; 

    Step 4: use databaseName 

    Step 5: show tables; 

     

 

Have you changed the passwords since you first tried running the containers? docker-compose does extra work to preserve volumes between runs (thus preserving the database); you may want to try ` 

>>>docker-compose rm –v 

 to delete everything and try starting it up again 

 

=============================================== 

Angular: 

    docker run -p 4200:4200 myapp 

    http://192.168.99.100:4200/AngularCrud 

  

Java API:     

    2) http://192.168.99.100:8086/api/getAll 

    1) http://192.168.99.100:8086/api/createEmployee 

  

======================================================== 

Docker Commands to Stop OR Remove multiple Containers 

>>>docker stop $(docker ps -a -q) 

>>>docker rm $(docker ps -a -q) 

>>>docker rmi $(docker images -a -q) 

     

 

Refereences 

===========      

 https://stackoverflow.com/questions/52971623/spring-boot-mysql-application-issues-using-docker-compose 

https://github.com/hirenpandit/docker-springboot-example 

http://blog.arungupta.me/docker-mysql-persistence/ 

 

 

Issues faced 

============ 

 

spring.datasource.hikari.initialization-fail-timeout=0 

 

This property controls whether the pool will "fail fast" if the pool cannot be seeded with an initial connection successfully. Any positive number is taken to be the number of milliseconds to attempt to acquire an initial connection; the application thread will be blocked during this period. If a connection cannot be acquired before this timeout occurs, an exception will be thrown. This timeout is applied after the connectionTimeout period. If the value is zero (0), HikariCP will attempt to obtain and validate a connection. If a connection is obtained, but fails validation, an exception will be thrown and the pool not started. However, if a connection cannot be obtained, the pool will start, but later efforts to obtain a connection may fail. A value less than zero will bypass any initial connection attempt, and the pool will start immediately while trying to obtain connections in the background. Consequently, later efforts to obtain a connection may fail. Default: 1