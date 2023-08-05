Spring Boot allows you to configure following aspects of logging:
     Logging Levels
     Logging Pattern
     Logging Colors
     Logging Output – console, file
     Logging Rotation
     Logging Groups
     Logging System used
         Logback – default
         log4j2
         JDK (Java Util Logging)
     Logging System specific configuration:
         Logback – logback-spring.xml
         log4j2 - log4j2-spring.xml
         JDK (Java Util Logging) - logging.properties

Logging Levels can be set via application.properties:
    logging.level.root=WARN
    app.service.a.level=ALL
    app.service.b.level=FINEST
    app.service.c.level=FINER

You can also use ––debug or ––trace argument when launching spring boot application:
$ java -jar myapp.jar ––debug
It is also possible to specify debug=true or trace=true in
application.properties.
    
Spring Boot by default logs only to console. You can change this behavior via application.properties or by using logging system specific configuration.
If you want to change this behavior via application.properties, you need to set one of following property:
     logging.file
     logging.path
    

