Spring Boot is “opinionated” framework because it comes with general idea on how application should be organized, provides default configurations and modules setups for technology related aspect of application. (embedded databases, mvc view resolvers, template rendering engines, ...)

In comparison with Spring Framework, Spring Boot provides starters and autoconfigurations which intelligently fits default configuration based on defined dependencies.

Main advantage on how Spring Boot approaches “opinionated” style, is that you can always override
default configuration if it does not fit your use case. “Opinionated” has following advantages:
     Simplifies application setup
     Maximizes productivity, by allowing you to focus on business code instead of setup of technology
    related code
     Allows you to write configuration only in case when defaults are not a good fit for your case
     Allows easy integration with technology modules (Embedded Databases, Containers ...)
     Minimizes amount of setup code

The main disadvantage of “opinionated” framework is that, if your application does not fall into most use cases supported by framework, you will have to override most of default setup, configurations and project organization, which might harm your productivity


