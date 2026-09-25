cd Docker
docker build -t mysql-springexp2:latest .
docker run --name mysql-springexp2 -d -p 3306:3306 mysql-springexp2

en mysql 

use dbsemana2;
grant all on dbsemana2.* to 'user'@'%';


./mvnw clean spring-boot:run
