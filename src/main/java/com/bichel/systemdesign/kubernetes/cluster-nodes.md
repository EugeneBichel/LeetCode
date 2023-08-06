Nodes #
Nodes are the workers of a Kubernetes cluster. At a high level, they do three things:

Watch the API Server for new work assignments.
Execute new work assignments.
Report back to the control plane (via the API server).
As we can see from the figure below, they’re a bit simpler than masters.

## Three major components of a node.
### Kubelet (communication with master)
### Container runtime (runtime for docker containers)
### Kube-proxy (networking)


Kubelet #
The kubelet is the star of the show on every node. It’s the main Kubernetes agent, and it runs on every node in the cluster. In fact, it’s common to use the terms node and kubelet interchangeably.

When you join a new node to a cluster, the process installs the kubelet onto the node. The kubelet is then responsible for registering the node with the cluster. Registration effectively pools the node’s CPU, memory, and storage into the wider cluster pool.

One of the main jobs of the kubelet is to watch the API server for new work assignments. Any time it sees one, it executes the task and maintains a reporting channel back to the control plane.

If a kubelet can’t run a particular task, it reports back to the master and lets the control plane decide what actions to take. For example, if a kubelet cannot execute a task, it is not responsible for finding another node to run it on. It simply reports back to the control plane, and the control plane decides what to do.

Container runtime #
The kubelet needs a container runtime to perform container-related tasks – things like pulling images and starting and stopping containers.

In the early days, Kubernetes had native support for a few container runtimes, such as Docker. More recently, it has moved to a plugin model called the Container Runtime Interface (CRI). At a high level, the CRI masks the internal machinery of Kubernetes and exposes a clean documented interface for third-party container runtimes to plug into.

There are many container runtimes available for Kubernetes. One popular example is cri-containerd. This is a community-based, open-source project, porting the CNCF containerd runtime to the CRI interface. It has a lot of support and is replacing Docker as the most popular container runtime used in Kubernetes.

Kube-proxy #
The last piece of the node puzzle is the kube-proxy. This runs on every node in the cluster and is responsible for local cluster networking. For example, it makes sure each node gets its own unique IP address and implements local IPTABLES or IPVS rules to handle routing and load-balancing of traffic on the Pod network.
