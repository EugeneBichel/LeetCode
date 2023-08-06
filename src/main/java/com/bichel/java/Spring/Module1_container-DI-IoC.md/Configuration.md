Classes annotated with @Configuration contain bean definitions. There can be one or more in a Spring
application, and they can be combined with XML configuration files. These classes can be bootstrapped19
in many ways, depending on the chosen setup of the configuration. The DataSourceConfig class used in
the previous example is a typical Java Configuration class, which contains two bean definitions and some
properties that are injected from a property file using the PropertySource annotation.

The @Bean annotation is used to tell Spring that the result of the annotated method will be a bean that
has to be managed by it. The @Bean annotation together with the method are treated as a bean definition,
and the method name becomes the bean id

