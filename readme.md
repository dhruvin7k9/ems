# Event Management System developed using Java Spring framework

## The project is deployed <a href='https://ems-spring-boot.onrender.com'>here</a>.

## To run project directly (using Docker)

### 1. Install <a href='https://docs.docker.com/engine/install/'>Docker</a>

### 2. Pull Docker image for the project:
```sh
docker pull dhruvink79/ems-spring-boot
```

### 3. Provide <code>ENV</code> variables and spin up the docker container

```sh
docker run -it -p 8080:8080 \
MYSQL_HOST= \
MYSQL_DATABASE= \
MYSQL_PORT= \
MYSQL_USER= \
MYSQL_PASSWORD= \
dhruvink79/ems-spring-boot
```

#### Now you are up and running.

##### some useful links : https://www.baeldung.com/spring-data-derived-queries
