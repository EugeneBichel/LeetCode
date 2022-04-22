Services #
We’ve just learned that Pods are mortal and can die. However, if they’re managed via Deployments or DaemonSets, they get replaced when they fail. But replacements come with totally different IP addresses. This also happens when you perform scaling operations – scaling up adds new Pods with new IP addresses, whereas scaling down takes existing Pods away. Events like these cause a lot of IP churn.

The point I’m making is that Pods are unreliable, which poses a challenge. Assume you’ve got a microservices app with a bunch of Pods performing video rendering. How will this work if other parts of the app that need to use the rendering service cannot rely on the rendering Pods being there when they need them?

This is where Services come into play. Services provide reliable networking for a set of Pods.

Digging into a bit more detail, Services are fully fledged objects in the Kubernetes API – just like Pods and Deployments. They have a front end that consists of a stable DNS name, IP address, and port. On the back end, they load balance across a dynamic set of Pods. As Pods come and go, the Service observes this, automatically updates itself, and continues to provide that stable networking endpoint.

The same applies if you scale the number of Pods up or down. New Pods are seamlessly added to the Service and will receive traffic. Terminated Pods are seamlessly removed from the Service and will not receive traffic.

Connecting Pods to Services #
Services use labels and a label selector to know which set of Pods to load-balance traffic to. The Service has a label selector that is a list of all the labels a Pod must possess in order for it to receive traffic from the Service.

The figure below shows a Service configured to send traffic to all Pods on the cluster tagged with the following three labels:

    zone=prod
    env=be
    ver=1.3


The purpose of services is they provide reliable networking for a set of Pods.

