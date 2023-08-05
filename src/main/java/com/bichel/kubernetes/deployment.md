## Deployments
It is possible to run a stand-alone Pod on a Kubernetes cluster, but the preferred model is to deploy all Pods via higher-level controllers. The most common controller is the Deployment. It offers scalability, self-healing, and rolling updates. You define Deployments in YAML manifest files that specify things like which image to use and how many replicas to deploy.

Application code packaged as a container, running inside a Pod, managed by a Deployment controller.

Once everything is defined in the Deployment YAML file, you POST it to the API server as the desired state of the application and let Kubernetes implement it.

Most of the time you’ll deploy Pods indirectly via a higher-level controller. Examples of higher-level controllers include, Deployments, DaemonSets, and StatefulSets.

a Deployment is a higher-level Kubernetes object that wraps around a particular Pod and adds features such as scaling, zero-downtime updates, and versioned rollbacks.

Behind the scenes, Deployments, DaemonSets and StatefulSets implement a controller and a watch loop that is constantly observing the cluster making sure that current state matches the desired state.


