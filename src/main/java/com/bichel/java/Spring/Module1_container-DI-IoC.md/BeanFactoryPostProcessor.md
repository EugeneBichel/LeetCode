BeanFactoryPostProcessor is an interface that contains single method postProcessBeanFactory, implementing it allows you to create logic that will modify Spring Bean Metadata before any Bean is created. 

BeanFactoryPostProcessor does not create any beans, however it can access and alter Metadata that is used later to create Beans.

BeanFactoryPostProcessor is invoked after Spring will read or discover Bean Definitions, but before any Spring Bean is created.

Because BeanFactoryPostProcessor is also a Spring Bean, but a special kind of Bean that should be invoked before other types of beans get created, Spring needs to have ability to create it before any other beans. This is why BeanFactoryPostProcessors needs to be registered from static method level.
    @Bean
    public static CustomBeanFactoryPostProcessor customerBeanFactoryPostProcessor() {
    return new CustomBeanFactoryPostProcessor();
    }

PropertySourcesPlaceholderConfigurer is a BeanFactoryPostProcessor that is used to resolve properties
placeholder in Spring Beans on fields annotated with @Value("${property_name}").

    @Value("${app.env}")
    private String appEnv;
    @Value("${app.envid}")
    private String appEnvId;



