Spring Boot uses autoconfiguration to detect dependencies on the class path, based on detected dependencies, spring beans are configured to allow integration with technologies, like JPA, Data Sources, Embedded Databases, Template Rendering engines etc.

Spring Boot searches for META-INF/spring.factories on classpath that should contain entry org.springframework.boot.autoconfigure.EnableAutoConfiguration that lists all autoconfiguration classes provided by the autoconfiguration module.

Autoconfiguration class is using @ConditionalOn... annotations to specify under which conditions, certain Autoconfiguration should be applied.

Spring Boot provides starter modules, which are empty jars with set of dependencies specified with correct dependencies versions to allow easy start with the library.

Starter module may provide only set of dependencies, or set of dependencies with autoconfiguration code.



