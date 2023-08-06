What is a pod in and what is its function?
    Multiple Docker containers which provide a service together.



### In the VMware world, the atomic unit of scheduling is the virtual machine (VM). 
### In the Docker world, it’s the container. 
### Well, in the Kubernetes world, it’s the Pod.

It’s true that Kubernetes runs containerized apps. However, you cannot run a container directly on a Kubernetes cluster – containers must always run inside of Pods.

The very first thing to understand is that the term Pod comes from a pod of whales – in the English language, we call a group of whales a pod of whales. As the Docker logo is a whale, it makes sense that we call a group of containers a Pod.

The simplest model is to run a single container per Pod. However, there are advanced use cases that run multiple containers inside a single Pod. These multi-container Pods are beyond the scope of what we’re discussing here, but powerful examples include:

Service meshes
Web containers supported by a helper container that pulls the latest content
Containers with a tightly coupled log scraper
The point is, a Kubernetes Pod is a construct for running one or more containers.

At the highest level, a Pod is a ring-fenced environment to run containers. The Pod itself doesn’t actually run anything, it’s just a sandbox for hosting containers. Keeping it high level, you ring-fence an area of the host OS, build a network stack, create a bunch of kernel namespaces, and run one or more containers in it. That’s a Pod.

If you’re running multiple containers in a Pod, they all share the same Pod environment. This includes things like the IPC namespace, shared memory, volumes, and network stack. As an example, this means that all containers in the same Pod will share the same IP address (the Pod’s IP).

f two containers in the same Pod need to talk to each other (container-to-container within the Pod), they can use ports on the Pod’s localhost interface.

Multi-container Pods are ideal when you have requirements for tightly coupled containers that may need to share memory and storage. However, if you don’t need to tightly couple your containers, you should put them in their own Pods and loosely couple them over the network. This keeps things clean by having each Pod dedicated to a single task. It also creates a lot of network traffic that is unencrypted. You should seriously consider using a service mesh to secure traffic between Pods and application services.

Pods are also the minimum unit of scaling in Kubernetes. If you need to scale your app, you add or remove Pods. You do not scale by adding more containers to an existing Pod. Multi-container Pods are only for situations where two different, but complementary, containers need to share resources.

Pods: atomic operations #
The deployment of a Pod is an atomic operation. This means that a Pod is only considered ready for service when all of its containers are up and running. There is never a situation where a partially deployed Pod will service requests. The entire Pod either comes up and is put into service, or it doesn’t, and it fails.

A single Pod can only be scheduled to a single node. This is also true of multi-container Pods – all containers in the same Pod will run on the same node.

Pod lifecycle #
Pods are mortal. They’re created, they live, and they die. If they die unexpectedly, you don’t bring them back to life. Instead, Kubernetes starts a new one in its place. However, even though the new Pod looks, smells, and feels like the old one, it isn’t. It’s a shiny new Pod with a shiny new ID and IP address.

This has implications on how you should design your applications. Don’t design them, so they are tightly coupled to a particular instance of a Pod. Instead, design them so that when Pods fail, a totally new one (with a new ID and IP address) can pop up somewhere else in the cluster and seamlessly take its place.


