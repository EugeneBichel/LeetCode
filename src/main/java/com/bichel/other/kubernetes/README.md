Kubernetes system #
By now, you probably understood that one of the critical aspects of a system based on Kubernetes is a high level of dynamism. Almost nothing is static. We define Deployments or StatefulSets, and Kubernetes distributes the Pods across the cluster. In most cases, those Pods are rarely sitting in one place for a long time. Rolling updates result in Pods being re-created and potentially moved to other nodes. Failure of any kind provokes the rescheduling of the affected resources. Many other events cause the Pods to move around. A Kubernetes cluster is like a beehive. It’s full of life, and it’s always in motion.

Dynamic nature of Kubernetes #
The dynamic nature of a Kubernetes cluster is not only due to our (human) actions or rescheduling caused by failures. Autoscaling is to be blamed as well. We should fully embrace Kubernetes’ dynamic nature and move towards autonomous and self-sufficient clusters capable of serving the needs of our applications without (much) human involvement. To accomplish that, we need to provide sufficient information that will allow Kubernetes’ to scale the applications as well as the nodes that constitute the cluster. In this chapter, we’ll focus on the former case. We’ll explore commonly used and basic ways to auto-scale Pods based on memory and CPU consumption. We’ll accomplish that using HorizontalPodAutoscaler.

HorizontalPodAutoscaler's only function is to automatically scale the number of Pods in a Deployment, a StatefulSet, or a few other types of resources. It accomplishes that by observing CPU and memory consumption of the Pods and acting when they reach pre-defined thresholds.
HorizontalPodAutoscaler is implemented as a Kubernetes API resource and a controller. The resource determines the behavior of the controller. The controller periodically adjusts the number of replicas in a StatefulSet or a Deployment to match the observed average CPU utilization to the target specified by a user.

Kubernetes is an application orchestrator. For the most part, it orchestrates containerized cloud-native microservices apps

An orchestrator is a system that deploys and manages applications. It can deploy your applications and dynamically respond to changes. For example, Kubernetes can:

Deploy your application
Scale it up and down dynamically according to demand
Self-heal it when things break
Perform zero-downtime rolling updates and rollbacks
And the best part about Kubernetes: it can do all of that without you having to supervise or get involved in decisions. Obviously, you have to set things up in the first place, but, once you’ve done that, you can sit back and let Kubernetes work its magic.

A cloud-native application is an application that is designed to meet modern business demands (auto-scaling, self-healing, rolling updates, etc.) and can run on Kubernetes.
I feel like it’s important to be clear that cloud-native apps are not applications that will only run on a public cloud. Yes, they absolutely can run on a public cloud, but they can run anywhere that you have Kubernetes – even your on-premises data center.

A microservices app is a business application that is built from lots of small specialized parts that communicate and form a meaningful application. For example, you might have an e-commerce app that comprises all of the following small specialized components:
    Web front-end
    Catalog service
    Shopping cart
    Authentication service
    Logging service
    Persistent store

At a high level, you might have a Kubernetes cluster with 10 nodes to run your production applications. Behind the scenes, each node is running Docker as its container runtime. This means that Docker is the low-level technology that starts and stops the containerized applications. Kubernetes is the higher-level technology that looks after the big picture decisions, such as deciding which nodes to run containers on, deciding when to scale up or down, and executing updates.
s can be seen in the figure above, Docker isn’t the only container runtime that Kubernetes supports. In fact, Kubernetes has a couple of features that abstract the container runtime (make it interchangeable):

The Container Runtime Interface (CRI) is an abstraction layer that standardizes the way third-party container runtimes interface with Kubernetes. It allows the container runtime code to exist outside of Kubernetes, but interfaces with it in a supported and standardized way.
Runtime Classes is a new feature that was introduced in Kubernetes 1.12 and promoted to beta in 1.14. It allows for different classes of runtimes. For example, the gVisor or Kata Containers runtimes might provide better workload isolation than the Docker and containerd runtimes.

The name Kubernetes (koo-ber-net-eez) comes from the Greek word meaning “Helmsman” – the person who steers a seafaring ship. This theme is reflected in the logo.

Kubernetes has emerged as the de-facto platform for deploying and managing cloud-native applications. In many ways, it’s like an operating system (OS) for the cloud. Consider this:
You install a traditional OS (Linux or Windows) on a server, and the OS abstracts the physical server’s resources and schedules processes etc.
You install Kubernetes on a cloud, and it abstracts the cloud’s resources and schedules the various microservices of cloud-native applications.

In the same way that Linux abstracts the hardware differences of different server platforms, Kubernetes abstracts the differences between different private and public clouds. Net result: as long as you’re running Kubernetes, it doesn’t matter if the underlying systems are on-premises in your own data center, edge clusters, or in the public cloud.
With this in mind, Kubernetes enables a true hybrid cloud, allowing you to seamlessly move and balance workloads across multiple different public and private cloud infrastructures. You can also migrate to and from different clouds, meaning you can choose a cloud today and not have to stick with that decision for the rest of your life.
A typical computer is a collection of CPU, memory, storage, and networking. But modern operating systems have done a great job abstracting most of that. For example, how many developers care which CPU core or exact memory address their application uses? Not many. We let the OS take care of things like that. And it’s a good thing; it’s made the world of application development a far friendlier place.

Kubernetes does a similar thing with cloud and data center resources. At a high level, a cloud or data center is a pool of compute, network, and storage. Kubernetes abstracts it. This means we don’t have to hard code which node or storage volume our applications run on, we don’t even have to care which cloud they run on – we let Kubernetes take care of that. Gone are the days of naming your servers, mapping storage volumes in a spreadsheet, and otherwise treating your infrastructure assets like pets. Systems like Kubernetes don’t care.
Gone are the days of taking your app and saying, “Run this part of the app on this exact node, with this IP, on this specific volume…”. In the cloud-native Kubernetes world, we just say “Hey Kubernetes, here’s an app. Please deploy it and make sure it keeps running”.

At the highest level, Kubernetes is two things:
    A cluster for running applications.
    An orchestrator of cloud-native microservices apps.

Kubernetes as a cluster #
Kubernetes is like any other cluster – a bunch of nodes and a control plane. The control plane exposes an API and records the state in a persistent store; it also has a scheduler for assigning work to nodes. Nodes are where application services run.
It can be useful to think of the control plane as the brains of the cluster and the nodes as the muscle. In this analogy, the control plane is the brain because it implements all of the important features, such as auto-scaling and zero-downtime rolling updates. The nodes are the muscle because they do the every-day hard work of executing application code.

Kubernetes as an orchestrator #
Orchestrator is just a fancy word for a system that takes care of deploying and managing applications.

How it works #
To make this happen, you start out with an app; you package it up and give it to the cluster (Kubernetes). The cluster is made up of one or more masters and a bunch of nodes.
The masters, sometimes called heads or head nodes, are in charge of the cluster. This means they make scheduling decisions, perform monitoring, implement changes, respond to events, and more. For these reasons, we often refer to the masters as the control plane.

The nodes are where application services run, and we sometimes call them the data plane. Each node has a reporting line back to the masters and constantly watches for new work assignments.

To run applications on a Kubernetes cluster, we follow this simple pattern:
    - Write the application as small independent microservices in our favorite languages.
    - Package each microservice in its own container.
    - Wrap each container in its own Pod.
    - Deploy Pods to the cluster via higher-level controllers, such as, Deployments, DaemonSets, StatefulSets, CronJobs etc.

We’re still near the beginning of the course, 
and you’re not expected to know what all of this means yet. 
However, at a high level, 
    - Deployments offer scalability and rolling updates; 
    - DaemonSets run one instance of a service on every node in the cluster; 
    - StatefulSets are for stateful application components, 
    - CronJobs are for short-lived tasks that need to run at set times. 
    There are more than these, but these will do for now.

Kubernetes likes to manage applications declaratively. This is a pattern where you describe how you want your application to look and feel in a set of YAML files. You POST these files to Kubernetes, then sit back while Kubernetes makes it all happen.
But it doesn’t stop there. Because the declarative pattern tells Kubernetes how an application should look, Kubernetes can watch it and make sure things don’t stray from what you asked for. If something isn’t as it should be, Kubernetes tries to fix it.

Kubernetes or Docker Swarm receive your orders and apply them. You create a cluster of servers (a single server is fine also), then you feed your Kubernetes or Docker Swarm with a file that states which containers you want, how to expose them to the outside world, and how many containers should be run for each image. Your orchestrator will make sure that happens.
Here is an example Kubernetes file:
    apiVersion: apps/v1beta1
    kind: Deployment
    spec:
      replicas: 2
      template:
        metadata:
          labels:
            app: core-server
        spec:
          containers:
          - image: learnbook/aspnetcore-server:1.1
            ports:
            - containerPort: 80
            env:
            - name: ASPNETCORE_ENVIRONMENT
              value: "Release"
    ---
    apiVersion: v1
    kind: Service
    spec:
      type: LoadBalancer
      ports:
      - port: 80
      selector:
        app: core-server

Although it looks complex, it’s not that hard. Sending it to the cluster by using the kubectl command makes sure that I get my application running as two containers exposed over the internet with a load balancer. Nice, isn’t it?
Better yet, need to upgrade or run more or fewer containers? Update the file stating your new needs, feed it to the orchestrator, and it will take care of things like rolling upgrades. Look at my modified file:
    apiVersion: apps/v1beta1
    kind: Deployment
    spec:
      replicas: 10
      template:
        metadata:
          labels:
            app: core-server
        spec:
          containers:
          - image: learnbook/aspnetcore-server:1.2
            ports:
            - containerPort: 80
            env:
            - name: ASPNETCORE_ENVIRONMENT
              value: "Release"
    ---
    apiVersion: v1
    kind: Service
    spec:
      type: LoadBalancer
      ports:
      - port: 80
      selector:
        app: core-servereturn 0;
    }

I only changed the replicas and image values in order to ask for 10 containers and have them run a more recent 1.2 image. I simply send it to the cluster, again using the kubectl command, and Kubernetes proceeds with the operations necessary to reach that state considering the existing state. It will:
Start 10 containers running the 1.2 image.
Wait for 2 containers to be ready.
Route the users to the 2 containers that are ready.
Stop and remove the previous two containers that run the 1.1 image.
As the 8 more containers become available, route users to them.
Load balance the incoming traffic to the 10 containers.


