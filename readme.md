# EventEase : Event Management System developed using Java Spring framework

## The project is deployed <a href='https://ems-spring-boot.onrender.com'>here</a>.


## To run project directly (using Docker) :-

#### 1. Install <a href='https://docs.docker.com/engine/install/'>Docker</a>

#### 2. Pull Docker image for the project:
```sh
docker pull dhruvink79/ems-spring-boot
```

#### 3. Provide <code>ENV</code> variables and spin up the docker container
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


## Major Functionalities :

### Club Admin user
1. login/signup as admin user.
2. organize event.
3. update event details.
4. cancel upcoming events.
5. view participation details.

### Student user
1. student register and login.
2. participate and cancel participation in an event.
3. view participation history.


## ER diagram :
<img src='./EMS_ER_diagram.jpeg'/>


## System Screenshots :

#### 1. club dashboard
<img src='./clubDashboard.jpg'/>

#### 2. organize event
<img src='./addEvent.jpg'/>

#### 3. event details
<img src='./eventDetails.jpg'/>

#### 4. student registration
<img src='./studentReg.jpg'/>

#### 5. student dashboard
<img src='./studentDashboard.jpg'/>

#### 6. participation history
<img src='./studentParticipatedEvents.jpg'/>


##### some useful links : https://www.baeldung.com/spring-data-derived-queries
