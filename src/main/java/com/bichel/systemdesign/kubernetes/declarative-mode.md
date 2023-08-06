The declarative model and the concept of desired state are at the very heart of Kubernetes.

In Kubernetes, the declarative model works like this:

Declare the desired state of an application (microservice) in a manifest file
POST it to the API server
Kubernetes stores it in the cluster store as the application’s desired state
Kubernetes implements the desired state on the cluster
Kubernetes implements watch loops to make sure the current state of the application doesn’t vary from the desired state

Manifest files are written in simple YAML, and they tell Kubernetes how you want an application to look. This is called the desired state. It includes things such as; which image to use, how many replicas to run, which network ports to listen on, and how to perform updates.

Once you’ve created the manifest, you POST it to the API server. The most common way of doing this is with the kubectl command-line utility. This sends the manifest to the control plane as an HTTP POST, usually on port 443.

Once the request is authenticated and authorized, Kubernetes inspects the manifest, identifies which controller to send it to (e.g., the Deployments controller), and records the config in the cluster store as part of the cluster’s overall desired state. Once this is done, the work gets scheduled on the cluster. This includes the hard work of pulling images, starting containers, building networks, and starting the application’s processes.

Finally, Kubernetes utilizes background reconciliation loops that constantly monitor the state of the cluster. If the current state of the cluster varies from the desired state, Kubernetes will perform whatever tasks are necessary to reconcile the issue.

But the declarative story doesn’t end there – things go wrong, and things change. When they do, the current state of the cluster no longer matches the desired state. As soon as this happens, Kubernetes kicks into action and attempts to bring the two back into harmony.

Declarative example #
Assume you have an app with a desired state that includes 10 replicas of a web front-end Pod. If a node that was running two replicas fails, the current state will be reduced to 8 replicas, but the desired state will still be 10. This will be observed by a reconciliation loop, and Kubernetes will schedule two new replicas to bring the total back up to 10.

The same thing will happen if you intentionally scale the desired number of replicas up or down. You could even change the image you want to use. For example, if the app is currently using v2.00 of an image, and you update the desired state to use v2.01, Kubernetes will notice the difference and go through the process of updating all replicas so that they are using the new version specified in the new desired state.

To be clear, instead of writing a long list of commands to go through the process of updating every replica to the new version, you simply tell Kubernetes you want the new version, and Kubernetes does the hard work for you.

Despite how simple this might seem, it’s extremely powerful and at the very heart of how Kubernetes operates. You give Kubernetes a declarative manifest that describes how you want an application to look. This forms the basis of the application’s desired state. The Kubernetes control plane records it, implements it, and runs background reconciliation loops that constantly check that what is running is what you’ve asked for. When the current state matches the desired state, the world is a happy place. When it doesn’t, Kubernetes gets busy fixing it.


