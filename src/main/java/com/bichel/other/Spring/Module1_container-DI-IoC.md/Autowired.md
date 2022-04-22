@Autowired is an annotation that is processed by AutowiredAnnotationBeanPostProcessor, which can be put onto class constructor, field, setter method or config method. Using this annotation enables automatic Spring Dependency Resolution that is primary based on types.

@Autowired has a property required which can be used to tell Spring if dependency is required or optional. By default dependency is required. If @Autowired with required dependency is used on top
of constructor or method that contains multiple arguments, then all arguments are considered required dependency unless argument is of type Optional, is marked as @Nullable, or is marked as
@Autowired(required = false).

If @Autowired is used on top of Collection or Map then Spring will inject all beans matching the type into Collection and key-value pairs as BeanName-Bean into Map. Order of elements depends on
usage of @Order, @Priority annotations and implementation of Ordered interface.

@Autowired uses following steps when resolving dependency:
1. Match exactly by type, if only one found, finish.
2. If multiple beans of same type found, check if any contains  @Primary annotation, if yes, inject
@Primary bean and finish.
3. If no exactly one match exists, check if @Qualifier exists for field, if yes use @Qualifier to
find matching bean.
4. If still no exactly one bean found, narrow the search by using bean name.
5. If still no exactly one bean found, throw exception (NoSuchBeanDefinitionException,
NoUniqueBeanDefinitionException, …).

### Autowired with field
@Autowired with field injection is used like this:
     Autowired fields can have any visibility level
     Injection is happening after Bean is created but before any init method (@PostConstruct,
    InitializingBean, @Bean(initMethod)) is called
     By default field is required, however you can use Optional @Nullable or @Autowired(required = false) to indicate that field is not required.

### Autowired with constructor
@Autowired can be used with constructor like this:
Constructor can have any access modifier (public, protected, private, package-private).

If there is only one constructor in class, there is no need to use @Autowired on top of it, Spring will use this default constructor anyway and will inject dependencies into it.

If class defines multiple constructor, then you are obligated to use @Autowired to tell Spring which constructor should be used to create Spring Bean. If you will have a class with multiple constructor
without any of constructor marked as @Autowired then Spring will throw NoSuchMethodException.

By default all arguments in constructor are required, however you can use Optional, @Nullable or @Autowired(required = false) to indicate that parameter is not required.

Injection of dependency into private field can be done with @Autowired annotation:
    @Autowired
    private ReportWriter reportWriter
Injection of property into private field can be done with @Value annotation:
    @Value("${report.global.name}")
    private String reportGlobalName;



Private Field cannot be accessed from outside of the class, to resolve this when writing Unit Test you can
use following solutions:
     Use SpringRunner with ContextConfiguration and @MockBean
     Use ReflectionTestUtils to modify private fields
     Use MockitoJUnitRunner to inject mocks
     Use @TestPropertySource to inject test properties into private fields


