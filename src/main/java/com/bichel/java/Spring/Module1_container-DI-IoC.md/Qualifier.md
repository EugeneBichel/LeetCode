@Qualifier annotation gives you additional control on which bean will be injected, when multiple beans of the same type are found. By adding additional information on which bean you want to inject, @Qualifier resolves issues with NoUniqueBeanDefinitionException.

You can use @Qualifier in three ways:
 At injection point with bean name as value
 At injection and bean definition point
 Custom Qualifier Annotation Definition


