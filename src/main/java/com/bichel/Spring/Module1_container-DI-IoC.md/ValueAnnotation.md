To inject scalar/literal values into Spring Beans, you need to use @Value annotation.

@Value annotation has one field value that accepts:
 Simple value
 Property reference
 SpEL String

@Value annotation can be used on top of:
 Field
 Constructor Parameter
 Method – all fields will have injected the same value
 Method parameter – Injection will not be performed automatically if @Value is not present
on method level or if @Autowired is not present at method level
 Annotation type

Inside @Value you can specify:
 Simple value - @Value("John"), @Value("true")
 Reference a property - @Value("${app.department.id}")
 Perform SpEL inline computation - @Value("#{'Wall Street'.toUpperCase()}"),
@Value("#{5000 * 0.9}"),
@Value("#{'${app.department.id}'.toUpperCase()}")
 Inject values into array, list, set, map

@Value is used for:
 Setting simple values of Spring Bean Fields, Method Parameters Constructor Parameters
 Injecting property/environment values into Spring Bean Fields, Method Parameters, Constructor Parameters
 Injecting results of SpEL expressions into Spring Bean Fields, Method Parameters, Constructor Parameters
 Injecting values from other Spring Beans into Spring Bean Fields, Method Parameters, Constructor Parameters
 Injecting values into collections (arrays, lists, sets, maps) from literals, property/environment values, other Spring Beans
 Setting default values of Spring Bean Fields, Method Parameters, Constructor Parameters when referenced value is missing


