version: '3'
services:
  web:
    # Path to dockerfile.
    # '.' represents the current directory in which
    # docker-compose.yml is present.
    build: .

    # Mapping of container port to host
    
    ports:
      - "5000:5000"
    # Mount volume 
    volumes:
      - "/usercode/:/code"

    # Link database container to app container 
    # for reachability.
    links:
      - "database:backenddb"
    
  database:

    # image to fetch from docker hub
    image: mysql/mysql-server:5.7

    # Environment variables for startup script
    # container will use these variables
    # to start the container with these define variables. 
    environment:
      - "MYSQL_ROOT_PASSWORD=root"
      - "MYSQL_USER=testuser"
      - "MYSQL_PASSWORD=admin123"
      - "MYSQL_DATABASE=backend"
    # Mount init.sql file to automatically run 
    # and create tables for us.
    # everything in docker-entrypoint-initdb.d folder
    # is executed as soon as container is up nd running.
    volumes:
      - "/usercode/db/init.sql:/docker-entrypoint-initdb.d/init.sql"

The Compose file is in YAML format. It’s a very simple language. You can validate your YAML file using any of the online validator tools. Here is one for the reference.
version ‘3’: Like other software, docker-compose also started with a version 1.0. At the time of writing this course, the current latest version of Compose file is 3.7.
We have specified what version of Compose file we will be using and Docker will provide the features accordingly.

Compose versions are backwards compatible, hence I suggest you use the latest version.
services: The services section defines all the different containers to be created. We have two services namely, web and database. In Compose version 3, we can have multiple containers of the same service as well.

We will see that in the next section, but if you are curious, you can check here under the deploy section in the compose file.
- web: This is the name of our Flask app service. It can be anything. Docker Compose will create containers with this name.
- build: This clause specifies the Dockerfile location. ‘.’ represents the current directory where the docker-compose.yml file is located and Dockerfile is used to build an image and run the container from it. We can also enter a path to Dockerfile there.
- ports: The ports clause is used to map or expose the container ports to the host machine. If you remember, we used -p 5000:5000 while running the container using Docker. This will do the same work for us.
- volumes: This is the same as the -v option used to mount disks in Docker. Here, we are attaching our code files directory to the containers, ./code directory so that we don’t have to rebuild the images for every change in the files.

This will also help in auto-reloading the server when running in debug mode.
- links: Links literally links one service to another. In the bridge network, we have to specify which container should be accessible to which container using a link to respective containers.
Here, we are linking the database container to the web container, so that our web container can reach the database in the bridge network.
- image: If we don’t have a Dockerfile and want to run a service directly using an already built image, we can specify the image location using the ‘image’ clause. Compose will pull the image and fork a container from it.
- environment: Any environment variable that needs to be set up in the container can be created using the ‘environment’ clause. This does the same work as the -e argument in Docker while running a container.

Docker-compose commands:
    docker-compose
    docker-compose build
    docker-compose images
    docker-compose run
    docker-compose up
    docker-compose stop
    docker-compose rm
    docker-compose start
    docker-compose restart
    docker-compose ps
    docker-compose down
    docker-compose logs


version: '3'
services:
  web:
    # Path to dockerfile.
    # '.' represents the current directory in which
    # docker-compose.yml is present.
    build: .

    # Mapping of container port to host
    
    ports:
      - "5000:5000"
    # Mount volume 
    volumes:
      - "/usercode/:/exercise_3"

    # Link database container to app container 
    # for rechability.
    links:
      - "database:exercisedb"

    command: ["flask", "run"]

    environment:
      - "FLASK_RUN_HOST=0.0.0.0"

    depends_on:
      - database
    
  database:

    # image to fetch from docker hub
    build:
      context: ./db
      dockerfile: Dockerfile-db
    #image: mysql/mysql-server:5.7

    # Environment variables for startup script
    # container will use these variables
    # to start the container with these define variables. 
    environment:
      - "MYSQL_ROOT_PASSWORD=root"
      - "MYSQL_USER=testuser"
      - "MYSQL_PASSWORD=admin123"
      - "MYSQL_DATABASE=backend"
      
    # Mount init.sql file to automatically run 
    # and create tables for us.
    # everything in docker-entrypoint-initdb.d folder
    # is executed as soon as container is up nd running.
    volumes:
      - "/usercode/db/init.sql:/docker-entrypoint-initdb.d/init.sql"
    
Web #
The very first thing is to set up the basic skeleton using build and ports keyword for our web service.

Next, we check what the working directory is in Dockerfile and mount the host volume accordingly.

Then we cross-check the DB credentials used in the app.py file. If it is changed, match those in the links section, because links will decide what should be the reachable hostname of the database service.

command: Here comes the tricky one. This will pass the command to the container to execute. If you cross-check the Dockerfile, you will notice there is no CMD or ENTRYPOINT at the end to make a container executable. So, we are passing the command to run the Flask app from the docker-compose.yml file itself.

environment: This is not a very tricky one, but if you do not set the FLASK_RUN_HOST variable to 0.0.0.0, you won’t be able to access it outside of the container.

Database #
There is nothing new in this section. But you have to focus on the environment variables passed to it because this will be used by the application and any spelling mistake in these will result in a connection failure between the app and the database.
Writing down password and DB credentials in code files is not good practice. So at the end of this course, you will learn how to pass those to the application as well as to the container.
In the next section, you will learn some advanced topics of the Docker system which will strengthen your Docker skills. After solving this tricky exercise, you must be eager to learn some advanced topics.


Network terminologies and commands #
There are some terminologies used in Networking. Some of them are:
- Hostname: This is the most-frequently-used word. It’s the name of the machine to identify it in a network.
- ping: ping <hostname>/<ip> command is used to check the connectivity of machine from the machine from which the command is run.
- subnet: This is a small isolated part of a network. It is like creating boundaries to a particular part in the same network.
- DNS: This is like a phone directory. All the reachable hosts are mapped in this domain name service/system using IP and hostname so that you can either reach them by name or IP.
/etc/hosts: This is the important file. This file has all the reachable hosts with their IP addresses. We will frequently refer to this file.

As you can see in the diagram, we have connected the container’s port 5000 to the host’s 5000 and as a result, we can access whatever is running on the 5000 port on the container.
Coming to the database container, it will be in the same network as our app container. Hence, we can access the database from our app container.
Since there is no interface to the database container from the host machine, we won’t be able to access the DB from the host machine. If needed, we can create an interface and access it from the host.

By default, all containers run in the default network space of Docker. Hence, every container can communicate with others. We can create network isolation if it is needed.

By default, Docker creates three networks.

Run the docker network ls command like so:

$ docker network ls
NETWORK ID          NAME                DRIVER              SCOPE
915fe26ffbc8        bridge              bridge              local
3ac2c0505d62        host                host                local
753c94184c7b        none                null                local

All containers that belong to this network are part of the same subnet, so communication between containers in this network can occur via IP addressing.
A drawback of the default bridge network is that automatic service discovery of containers using DNS is not supported. Therefore, if you want containers that belong to the default network to be able to talk to each other, you must use the --link option to statically allow communications to occur. Additionally, communication requires port forwarding between containers.

docker-entrypoint-initdb.d explanation #
Any SQL script present in docker-entrypoint-initdb.d folder is executed by Docker as soon as a container is up and running.

So, to leverage this feature, we will mount the db/init.sql file onto Docker’s initdb.d/ folder using -v argument while running the container and do the following:

Stop the existing MySQL container
Remove it using the Docker rm command
Type docker run --name mysql -d -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=backend -e MYSQL_USER=testuser -e MYSQL_PASSWORD=admin123 -v <Path/to/Project/>/Docker/db/init.sql:/docker-entrypoint-initdb.d/init.sql mysql/mysql-server:5.7
We have just added two new things in the command:

-v <Path/to/Project/>/Docker/db/init.sql:/docker-entrypoint-initdb.d/init.sql to mount the DB startup script and -d to run the container in the background.
Next, stop the app container, build a new image for our new code docker build -t flask_app:2.0, and run using docker run --link "mysql:backenddb" -p 5000:5000 flask_app:2.0.

Writing a Dockerfile
Docker commands
    FROM
    WORKDIR
    ENV
    COPY
    RUN
    CMD
    ENTRYPOINT
    
FROM #
The FROM keyword tells Docker which base image to use or what should be the main platform for this image.

The Python:3.9-rc-buster image is a Linux-based image which has Python installed and no other additional programs or software.

WORKDIR #
The WORKDIR instruction sets a working directory for other Docker instructions such as RUN and CMD.

If we do not specify a working directory, we have to provide a full path for running our app.py file while using the RUN instruction.

ENV #
The ENV instruction sets an environment variable required for the flask app. We can skip these ENV steps, but you have to provide those variables using .flaskenv file.

Here, we are setting host to 0.0.0.0 which means we can access the app using any IP within the container.

Setting up a host to 0.0.0.0 is required if you are running the app inside the container and want to access it outside. If you change it to anything else, you won’t be able to access the app from the host machine.

COPY #
The COPY instruction literally copies the file from one location to another. COPY SOURCE DESTINATION is the syntax of the command.

Here, we are copying the requirements.txt file first so that we will have all the libraries installed before copying all the files.

RUN #
The RUN instruction will execute any commands in a new layer on top of the current image and commit the results. The resulting committed image will be used for the next step in the Dockerfile.

In the previous section, we learnt about layers. The RUN instruction creates a new layer here. It runs the commands provided as an argument in that layer.

One benefit of running requirements before copying all the files is whenever a change occurs in project files, we don’t have to build requirements again and Docker will use a cached layer for requirements.

CMD #
CMD runs the command inside the container once a container is forked or created from an image. You can only have one CMD instruction in a Dockerfile. If multiple CMD instructions are used, the last one will be executed.

Here, once the container is created, the CMD command will run our project.

We have one more frequently-used instruction.

ENTRYPOINT #
The ENTRYPOINT instruction can be used if you want to configure your container as an executable. If you want to override CMD while running a container, use ENTRYPOINT,

for example, ENTRYPOINT [“flask”, “run”]

 docker ps
CONTAINER ID   IMAGE              COMMAND                  CREATED       STATUS       PORTS                    NAMES
c60b970c9eee   twoay/molecare     "sh /entrypoint.sh"      5 hours ago   Up 5 hours   0.0.0.0:8081->8081/tcp   molecare-app
8d6953d349ef   backend_database   "docker-entrypoint.s…"   5 hours ago   Up 5 hours   0.0.0.0:5434->5432/tcp   molecare-db


    version: '3.7'
    services:
      web:
        # Path to dockerfile.
        # '.' represents the current directory in which
        # docker-compose.yml is present.
    
        image: venky8283/flask_app:4.0
    
        # Mount volume 
        volumes:
          - "./app/:/code:ro"
        
        networks:
          - app
        
        deploy:
          replicas: 2
          resources:
            limits:
              cpus: '0.50'
              memory: 1024M
            reservations:
              cpus: '0.10'
              memory: 500M
        
      database:
    
        # image to fetch from docker hub
        image: mysql/mysql-server:5.7
    
        # Environment variables for startup script
        # container will use these variables
        # to start the container with these define variables. 
        env_file:
          - ./.env
    
        # Mount init.sql file to automatically run 
        # and create tables for us.
        # everything in docker-entrypoint-initdb.d folder
        # is executed as soon as container is up nd running.
        volumes:
          - "./db/init.sql:/docker-entrypoint-initdb.d/init.sql:ro"
        
    
        deploy:
          replicas: 2
          resources:
            limits:
              cpus: '0.50'
              memory: 1024M
            reservations:
              cpus: '0.10'
              memory: 500M
        
    
        networks:
          - app
      
      viz:
    
        # Visualizer image for swarm cluster.
    
        image: dockersamples/visualizer
    
        # Mapping container ports to host port
    
        ports: 
    
          - "8080:8080"
    
        # Mounting docker socket to container.
        
        volumes:
    
          - "/var/run/docker.sock:/var/run/docker.sock"
        
        networks:
          - app
      
      nginx:
    
        # Application / Proxy server for our production flask app.
    
        image: nginx:1.13.3
    
        # Mount SSL and non SSL ports to redirect localhost trafic to 
        # Nginx. 
    
        ports:
          - "443:443"
          - "80:80"
        
        # Mount self signed certificates and configuration file as read only
        # to the container.
    
        volumes:
          - ./nginx/nginx.conf:/etc/nginx/conf.d/nginx.conf:ro
          - ./nginx/certs:/etc/nginx/certs:ro
        
        
        # Deploy replicas to divide load to two services.
    
        deploy:
          replicas: 2
          resources:
            limits:
              cpus: '0.50'
              memory: 1024M
            reservations:
              cpus: '0.10'
              memory: 500M
    
        # Attach network to establish connection 
        # between flask app and nginx. 
    
        networks:
          - app
   
    networks:
      app:
        
In a Docker Compose environment, a service can simply contact another service via a Docker Compose link and then use the service name as the hostname. So it could use a URL like http://order/ to contact the order microservice.
Docker Compose links offer some kind of service discovery, that is, a way for microservices to find other microservices. Synchronous microservices require a form of service discovery.
Docker Compose links extend Docker links. Docker links only allow communication. Docker Compose links also implement load balancing and set the start order so that the dependent Docker containers start first.

Ports #
In addition, Docker Compose can bind ports from the containers to the ports of the Docker host where the Docker containers run.

Volumes #
Docker Compose can also provide volumes. These are file systems that can be shared by multiple containers. This allows containers to communicate by exchanging files.
