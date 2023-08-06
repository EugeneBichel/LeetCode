Advantages of Java Config over XML Config:
     Compile-Time Feedback due to Type-checking
     Refactoring Tools for Java without special support/plugins work out of the box with Java Config (special support needed for XML Config)

Advantages of Java Config over Annotation Based Config:
     Separation of concerns – beans configuration is separated from beans implementation
     Technology agnostic – beans may not depend on concrete IoC/DI implementation – makes it
    easier to switch technology
     Ability to integrate Spring with external libraries
     More centralized location of bean list

Limitations of Java Config:
     Configuration class cannot be final
     Configuration class methods cannot be final
     All Beans have to be listed, for big applications, it might be a challenge compared to Component Scanning


