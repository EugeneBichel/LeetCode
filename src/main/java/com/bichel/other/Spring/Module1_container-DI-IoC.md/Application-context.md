Application Context is a central part of Spring application. It holds bean definitions and contains
registry of application components. It allows you to retrieve assembled and configured beans.
Application Context:
     Initiates Beans
     Configures Beans
     Assemblies Beans
     Manages Beans Lifecycle
     Is a Bean Factory
     Is a Resource Loader
     Has ability to push events to registered even listeners
     Exposes Environment which allows to resolve properties

Common Application Context types:
     AnnotationConfigApplicationContext
     AnnotationConfigWebApplicationContext
     ClassPathXmlApplicationContext
     FileSystemXmlApplicationContext
     XmlWebApplicationContext

 How are you going to create a new
instance of an ApplicationContext?
Spring Professional Exam Tutorial v5.0 - Dominik Cebula 2

Non-Web Applications:
     AnnotationConfigApplicationContext
     ClassPathXmlApplicationContext
     FileSystemXmlApplicationContext

Web Applications:
     Servlet 2 – web.xml, ContextLoaderListener, DispatcherServlet
     Servlet 3 – XmlWebApplicationContext
     Servlet 3 - AnnotationConfigWebApplicationContext

Spring Boot:
     SpringBootConsoleApplication – CommandLineRunner
     SpringBootWebApplication – Embedded Tomcat
