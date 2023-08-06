Kubernetes DNS
Briefly learn about the Kubernetes DNS.

As well as the various control plane and node components, every Kubernetes cluster has an internal DNS service that is vital to operations.

The cluster’s DNS service has a static IP address that is hard-coded into every Pod on the cluster, meaning all containers and Pods know how to find it. Every new service is automatically registered with the cluster’s DNS so that all components in the cluster can find every Service by name. Some other components that are registered with the cluster DNS are StatefulSets and the individual Pods that a StatefulSet manages.

Cluster DNS is based on CoreDNS.

