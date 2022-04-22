Use	Product
Developer machine	               | Docker Engine Community or Docker Desktop
Small server, small expectations   | Docker Engine Community
Serious stuff/Critical applications| Docker Engine Enterprise or Kubernetes

You may use the following commands for container management:

- docker ps: lists the containers that are still running. Add the -a switch in order to see containers that have stopped
- docker logs: retrieves the logs of a container, even when it has stopped
- docker inspect: gets detailed information about a running or stopped container
- docker stop: deletes a container that is still running
- docker rm: deletes a container

>docker ps
>docker ps -a

You can think of the docker run command as the equivalent of buying a new computer, executing some command on it, then throwing it away. Each time a container is created from an image, you get a new isolated and virgin environment to play with inside that container.
What you get inside the container depends on which image your container is based on. After the image name, you can pass the commands you want to execute inside the container.
Let’s illustrate the new-computer-that-you-trash metaphor using the alpine image. The alpine image is a very small Linux image that does enough for our purpose.

>docker run alpine printenv
#We are basically asking for a container to be created using the alpine image, and for the container to execute the printenv command that is one of the binary programs packed in the alpine image.

>docker run alpine printenv

>docker container prune -f
#This is the equivalent of running one docker rm command for each stopped container. The -f switch is an implicit confirmation to proceed and delete all stopped containers right away, instead of asking to confirm that operation.

We just saw how to run short-lived containers. They usually do some processing and display some output. However, there’s a very common use for long-lived containers: server containers. Whether you want to host a web application, an API, or a database, you want a container that listens for incoming network connections and is potentially long-lived.

In short, a server container
    - is long-lived
    - listens for incoming network connections
    
Up until now, we remained connected to the container from our command line using the docker run command, making it impractical for running long-lived containers.
To disconnect while allowing the long-lived container to continue running in the background, we use the -d or –detach switch on the docker run command.
Running a container as detached means that you immediately get your command-line back and the standard output from the container is not redirected to your command-line anymore.

By default, a container runs in isolation, and as such, it doesn’t listen for incoming connections on the machine where it is running. You must explicitly open a port on the host machine and map it to a port on the container.
Suppose I want to run the NGINX web server. It listens for incoming HTTP requests on port 80 by default. If I simply run the server, my machine does not route incoming requests to it unless I use the -p switch on the docker run command.
The -p switch takes two parameters; the incoming port you want to open on the host machine, and the port to which it should be mapped inside the container. For instance, here is how I state that I want my machine to listen for incoming connections on port 8085 and route them to port 80 inside a container that runs NGINX:
>docker run -d -p 8085:80 nginx
#You can view the web page locally by running a browser and querying the server for http://localhost:8085 URL.
Note the -d switch. It’s not mandatory, but since I’m running a server container it’s a good idea to keep in the background. After running the above program, an NGINX server container starts and you get its ID at the end.

Using a volume, you map a directory inside the container to a persistent storage. Persistent storages are managed through drivers, and they depend on the actual Docker host. They may be an Azure File Storage on Azure or Amazon S3 on AWS. With Docker Desktop, you can map volumes to actual directories on the host system; this is done using the -v switch on the docker run command.

Suppose you run a MySQL database with no volume:
>docker run -d mysql:5.7
#Any data stored in that database will be lost when the container is stopped or restarted. In order to avoid data loss, you can use a volume mount:
>docker run -v /your/dir:/var/lib/mysql -d mysql:5.7
#It will ensure that any data written to the /var/lib/mysql directory inside the container is actually written to the /your/dir directory on the host system. This ensures that the data is not lost when the container is restarted.

Each container is created from an image. You provide the image name to the docker run command. Docker first looks for the image locally and uses it when present. When the image is not present locally, it is downloaded from a registry.
When an image is published to a registry, its name must be:

<repository_name>/<name>:<tag>
tag is optional; when missing, it is considered to be latest by default
repository_name can be a registry DNS or the name of a registry in the Docker Hub

Docker provides the ability to package and run an application in a loosely isolated environment called a container. The isolation and security allow you to run many containers simultaneously on a given host. Containers are lightweight because they don’t need the extra load of a hypervisor, but run directly within the host machine’s kernel. This means you can run more containers on a given hardware combination than if you were using virtual machines
Container: A container is an instance of an image, which simulates the required environment with the use of the Linux kernel packaged in it. In the diagram, you can see app B is enclosed in one container. Similarly, you can enclose the other two apps as well.

Docker ecosystem #
Docker Registry: Docker maintains all the images in the registry and they can be pulled from the registry too
Docker Hub: This is the repository for all your custom-built images. Images can be pushed and accessed from the Hub
Docker Client: The CLI tool used to interact with the Docker server
Docker Daemon: The Docker server process responsible for pulling, pushing, and building the images. It is also used for running the container

As every image is built on top of Linux kernel, it has some common dependencies that can be reused by other images. Docker bundles these dependencies in one stack and these stacks are called layers.
Only the instructions RUN, COPY, and ADD create layers. Other instructions create temporary intermediate images and do not increase the size of the build. We will see in the next section what these instructions are.

docker pull \<images-name>:\<version> : pulls image from Docker registry
docker run \<images-name>:\<version> : runs container from mentioned image
docker ps : shows all running containers
docker ps -a: shows all available containers
docker exec: executes a command in a running container

Docker commit #
To commit changes to the container and create a new image from it, we need to change something in a container. We will not make it complex to work with it. We will create a Python program that will print today’s date and run it. After that, we will commit the changes, and it will create a new image for us, which will have our Python program in it forever.
Whenever you create a container from an image, it creates a new container without any data except the image data. We created the date-project image, which is a very small image. It has only one project file which we created in the container file system. If the container is removed before committing the changes, we will lose the data. So, it is always good practice to separate your data’s file system from the container’s file system.
Whenever a container is created, a file system is also created with it, which is a default Linux filesystem. Although Docker shares the OS’s kernel, there is a separation between file systems.

Docker’s bind mount and volumes can be used in such cases. Let’s check them out one by one.

Commands used in this lesson #
docker volume --help: to get the volume help
docker volume create: to create a new volume
docker inspect volume: to inspect the created volume
docker run -v: to mount a volume


Command	Action
docker ps	Lists all running containers. -a option will list stopped and running both
docker inspect [container_name]	Provides all info about the container
docker stop [container_name]	Stops the running container
docker kill [container_name]	Kills(stops) the container and removes the container from the system
docker rmi [image/s]	Removes the provided image
docker images	Lists all images on the system
docker exec [-it]	Executes command in a Docker container
docker system	Gets the Docker system information such as memory usage and housekeeping stuff
docker system prune	This command will save you from getting the “No memory left” nightmare with production systems


A Docker image is created using the docker build command and a Dockerfile file. The Dockerfile file contains instructions on how the image should be built.
The Dockerfile file can have any name. Naming it Dockerfile makes it easier for others to understand its purpose when they see that file in your project. It also means we don’t need to state the file name when using the docker build command.

A Dockerfile file always begins with a FROM instruction because every image is based on another base image. This is a powerful feature since it allows you to extend images that may already be complex.
>FROM debian:8

This is not enough. While I do get a Debian Linux basis, I am not running any command that could display “hello world.” This can be achieved using the CMD instruction. The CMD instruction specifies which executable is run when a container is created using your image and provides optional arguments.
Here’s an improved Dockerfile file that creates a Debian Linux-based image and instructs it to greet our users when a container spawns
>FROM debian:8
>CMD ["echo", "Hello world"]

Note that both the program to run and its arguments are provided as a JSON array of strings.

In order to create an image from my Dockerfile file, I need to run the docker build command. To do this, I type the following command in my terminal in the folder where the Dockerfile file lives:
>docker build -t hello .

The -t switch is used in front of the desired image. An image can be created without a name, it would have an auto-generated unique ID, so it is an optional parameter on the docker build command.
Note the dot at the end of the command above. It specifies which path is used as the build context (more about that later), and where the Dockerfile is expected to be found. Should my Dockerfile have another name or live elsewhere, I can add a -f switch in order to provide the file path.
The docker build command just created an image named hello. This image gets stored locally on the system, and it can then be run like any other image using the following command:
>docker run --rm hello

Sum up:
Create an image:
- Create a file named Dockerfile
- Run a docker build command
- Run a container from the image created

## The easiest way to deploy a web page
### dockerfile
    FROM nginx:1.15
    COPY index.html /usr/share/nginx/html

>docker build -t webserver .
>docker run --rm -it -p 8082:80 webserver

Apart from the nginx base image, you can see a COPY instruction. Its first parameter is the file to be copied from the build context and its second parameter is the destination directory inside the image.
The build context is basically the directory you provide to the docker build command. Its contents are available for COPY instructions to use, but only during the image build process. That means it’s available only for the instructions in the Dockerfile file, and files from it won’t be a part of the build image or containers that you’ll spawn from that image unless you use the COPY instruction. This is why we have a COPY instruction; we want the index.html file to be part of the /usr/share/nginx/html directory inside the image we create.

The above commands build a webserver from the Dockerfile file instructions, then start a container that listens to my machine’s 8082 port and redirect the incoming connections to the container’s 80 port. You can start a browser and point it to http://localhost:8082 to view it locally.

When I run the docker build command to create an image from a Dockerfile file, the resultant image is stored locally on the computer where the docker build command is run.

This allows me to run as many containers as I want from the locally created image, but the chances are that I want other computers to be able to run containers from the image I created. We’ll learn how to do that in the next chapter.
remove the webserver:latest image using any of the following two commands:
>docker rmi c067edac5ec1
>docker rmi webserver:latest

Earlier, we saw that image names include a name and a tag. As a quick reminder, an image name is:

<repository_name>/<name>:<tag>
tag is optional; when missing, it is considered to be latest by default
repository_name can be a registry DNS or the name of a registry in the Docker Hub

Why Would You Tag Your Images? #
Other reasons come to mind once you become more serious with your CI/CD pipeline. For instance, you may want any or all of the following features:

- Be able to roll back to a previous version of an image if you detect a problem with the latest image.
- Run different versions in different environments. For instance, the latest version in a test environment and the previous version in a production environment.
- Run different versions at the same time, routing some users to the latest version and some to the previous versions. This is known as a canary release.
Deploy different versions to different users, and be able to run whatever version on your development machine while you support them.

In order to apply a tag, just state it during your build command:
>docker build -t hello:1.0 .

Default value #
You may also want to define a default value for an environment variable, in case it isn’t provided when a container is created; this may be done in the Dockerfile file, using the ENV instruction. For instance, the following makes sure that if the name variable isn’t provided to the docker run command, it has a default value of Dockie:
>ENV name=Dockie

It’s good practice to add an ENV instruction for every environment variable your image expects since it documents your image.

### Use evn
    FROM node:11-alpine
    ENV diameter=4.0
    COPY compute.js .
    CMD node compute.js

Sometimes though, you need to store your data in a persistent file system.
When this need arises, use the VOLUME instruction as such:
>VOLUME /path/to/directory

The /path/to/directory is a path to a directory used inside the image. When a container is created using the docker run command, the -v switch can be used to map this directory to an actual volume on the host system.

A Docker Registry is basically an image store that offers the following functions:
    Ability to store various images.
    Ability to store various tags for the same image.
    An HTTP API that allows pushing images from a machine that produces them, or pull images to a machine that runs containers from those images.
    TLS-secured connection to the API in order to avoid man-in-the-middle attacks.

Whichever Registry you choose, publishing an image is a three-step process:
    Build your image (docker build) with the appropriate prefix name or tag (docker tag) an existing one appropriately.
    Log into the Registry (docker login).
    Push the image into the Registry (docker push).
    

>docker run --rm -it -p 8085:80 learnbook/webserver
# p open 8085 port in host IS

There’s a little variance to this. If you want to run an image that is stored in a private registry, you first need to log into the registry using the docker login command. Once this is done, you can docker pull the image. Should you want to run another container with that image later on, you don’t need to log in since the image is stored on your machine.

Files Included in Your Image #
Include only necessary files in your image. That may sound obvious, but it’s easy to include unwanted files.

First of all, avoid COPY instructions that are too broad. A typical example that should be avoided is:

COPY . .
Try to be as precise as possible. If necessary, split them into separate COPY instructions such as:

COPY ./Project/src/*.ts ./src
COPY ./Project/package.json .
Obviously, there are times when you will need to use COPY instructions that copy whole folders, as below:

COPY ./js/built /app/js
However, you may want to exclude files from that copy. You can use a .dockerignore file for that purpose. Simply add a .dockerignore file at the root of your build context that lists files and folders that should be excluded from the build like a .gitignore file.

Here is an example .dockerignore file:

# Ignore .git folder
.git
# Ignore Typescript files in any folder or subfolder
**/*.ts
Second, when using package managers like NPM, NuGet, apt, and so on, make sure you run them while building the image. It will avoid sending them as the context of the image, and it will allow the layer caching system to cache the result of running them. As long as the definition file doesn’t change, Docker will reuse its cache.

Image Layers #
    When creating an image, Docker reads each instruction in order and the resulting partial image is kept separate; it is cached and labeled with a unique ID. Such caching is very effective because it is used at different moments of an image life:
    In a future build, Docker will use the cached part instead of recreating it as long as it is possible.
    When pushing a new version of the image to a Registry, the common part is not pushed.
    When pulling an image from a registry, the common part you already have is not pulled.


# Use an image with the SDK for compilation
FROM openjdk:8-jdk-alpine AS builder
WORKDIR /out
# Get the source code inside the image 
COPY *.java .
# Compile source code
RUN javac Hello.java

# Create a lightweight image 
FROM openjdk:8-jre-alpine
# Copy compiled artifacts from previous image
COPY --from=builder /out/*.class .
CMD ["java", "Hello"]


When creating a container, you have the choice to set a restart mode. It tells Docker what to do when a container stops. A restart mode is set with the --restart switch.
When running server containers like we did earlier, we want them to always be up. It is very tempting to use the always restart mode. For instance:
>docker run -d -p 80 --restart always nginx

That’s probably not what you want. If you want your container to always be running except when you explicitly stop it, use the unless_stopped restart mode:
>docker run -d -p 80 --restart unless-stopped nginx

High availability Docker servers are monitored with tools that are up to the tasks such as collecting your logs and providing usage statistics. For simple needs or your development box however, you may use the following command:
>docker stats

Here are the commands you can run to remove the items that you don’t need:
>docker container prune -f
>docker volume prune -f
>docker image prune -f

If you want to remove all unused images, just use the following command:
>docker image prune --all

