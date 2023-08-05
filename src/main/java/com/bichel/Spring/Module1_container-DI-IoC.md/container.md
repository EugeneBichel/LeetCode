Container is an execution environment which provides additional technical services for
your code to use. Usually containers use IoC technique, that allows you to focus on
creating business aspect of the code, while technical aspects like communication details
(HTTP, REST, SOAP) are provided by execution environment.

Spring provides a container for beans. It manages lifecycle of the beans and also provides
additional services through usage of Application Context.

Spring Container Lifecycle:
1. Application is started.
2. Spring container is created.
3. Containers reads configuration.
4. Beans definitions are created from configuration.
5. BeanFactoryPostProcessors are processing bean definitions.
6. Instances of Spring Beans are created.
7. Spring Beans are configured and assembled – resolve property values and inject
dependencies.
8. BeanPostProcessors are called.
9. Application Runs.
10. Application gets shutdown.
11. Spring Context is closed.
12. Destruction callbacks are invoked.


