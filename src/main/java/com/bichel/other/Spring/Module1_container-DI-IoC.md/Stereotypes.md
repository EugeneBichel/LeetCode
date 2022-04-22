Stereotypes are annotations applied to classes to describe role which will be performed by this class. Spring discrovered classes annotated by stereotypes and creates bean definitions based on those types.

Stereotypes annotations are used to mark classes according to their purpose:
– @Component: template for any Spring-managed component(bean).
– @Repository: template for a component used to provide data access, specialization of the
@Component annotation for the the Dao layer.
– @Service: template for a component that provides service execution, specialization of the
@Component annotation for the Service layer.
– @Controller: template for a web component, specialization of the @Component annotation for
the Web layer.
– @Cofiguration: configuration class containing bean definitions (methods annotated with @Bean).
