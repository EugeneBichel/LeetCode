## @Autowired 
    core annotation for this group; is used on dependencies to instruct Spring IoC to
    take care of injecting them. Can be used on fields, constructors, and setters. Use with
    @Qualifier from Spring to specify name of the bean to inject.
## @Inject
    equivalent annotation to @Autowired from javax.inject package. Use with
    @Qualifier from javax.inject to specify name of the bean to inject.
## @Resource
    equivalent annotation to @Autowired from javax.annotation package. Provides
    a name attribute to specify name of the bean to inject.
## @Required
    Spring annotation that marks a dependency as mandatory, used on setters.
## @Lazy
    dependency will be injected the first time it is used.