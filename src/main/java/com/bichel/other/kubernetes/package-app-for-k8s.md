For an application to run on a Kubernetes cluster, it needs to tick a few boxes. These include:

    - Being packaged as a container
    - Being wrapped in a Pod
    - Being deployed via a declarative manifest file

It goes like this: you write an application service in a language of your choice. You build it into a container image and store it in a registry. At this point, the application service is containerized.

Next, you define a Kubernetes Pod to run the containerized application. At the kind of high level we’re at, a Pod is just a wrapper that allows a container to run on a Kubernetes cluster. Once you’ve defined the Pod, you’re ready to deploy it on the cluster.

Application code packaged as a container, running inside a Pod, managed by a Deployment controller.
