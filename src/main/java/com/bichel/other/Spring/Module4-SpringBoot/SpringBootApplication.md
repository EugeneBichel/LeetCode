@SpringBootApplication annotation is supposed to be used on top of the class and it was introduced for convenience. Usage of @SpringBootApplication annotation is equivalent to usage of following three annotations:
     @Configuration – allows additional bean registration
     @EnableAutoConfiguration – enables context auto-configuration
     @ComponentScan – turns on scanning for @Component annotated classes

Spring Boot is performing component scan, because @SpringBootApplication annotation is enabling component scanning with usage of @ComponentScan annotation.

By default, Spring Boot will search for @Component annotated classes within the same root package as @SpringBootApplication annotated class.

You can change this behavior by adding additional packages to scan with scanBasePackages or type-safe version of it scanBasePackageClasses within @SpringBootApplication annotation.    


