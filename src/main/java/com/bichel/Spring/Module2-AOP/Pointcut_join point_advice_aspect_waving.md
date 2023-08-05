## Join Point
Join Point in aspect oriented programming is a point in execution of a program in which behavior can be altered by AOP.
In Spring AOP Join Point is always method execution

Aspect Oriented Programming concept in general, distinguishes additional Join Points, some of them include:
     Method Execution / Invocation
     Constructor Execution / Invocation
     Reference / Assignment to Field
     Exception Handler
     Execution of Advice
     Execution of Static Initializer / Object Initializer

## Pointcut
Pointcut is a predicate used to match join point. Additional code, called Advice is executed in all parts of the program that are matching pointcut. Spring uses the AspectJ pointcut expression language by default.

    Example of Pointcut Expressions:
         execution - Match Method Execution
            execution(* com.spring.professional.exam.tutorial.module02.question02.bls.CurrencyService.getExchangeRate(..))
         within - Match Execution of given type or types inside package
            within(com.spring.professional.exam.tutorial.module02.question02.bls.*)
         @within – Match Execution of type annotated with annotation
            @within(com.spring.professional.exam.tutorial.module02.question02.annotations.Secured)
         @annotation – Match join points where the subject of the join point has the given annotation
            @annotation(com.spring.professional.exam.tutorial.module02.question02.annotations.InTransaction)

## Advice
Advice is additional behavior that will be inserted into the code, at each join point matched by pointcut.

## Aspect
Aspect brings together Pointcut and Advice. Usually it represents single behavior implemented by advice that will be added to all join points matched by pointcut.

## Weaving
Weaving is the process of applying aspects, which modifies code behavior at join points that have matching pointcuts and associated advices. During weaving aspects and application code is combined which enables execution of cross-cutting concerns.

Types of weaving:
 Compile Time Weaving – byte code is modified during the compilation, aspects are applied, code is modified at join points matching pointcuts by applying advices
 Load Time Weaving – byte code is modified when classes are loaded by class loaders, during class loading aspects are applied, code is modified at join points matching pointcuts by applying advices
 Runtime Weaving – used by Spring AOP, for each object/bean subject to aspects, proxy object is created (JDK Proxy or CGLIB Proxy), proxy objects are used instead of original object, at each join point matching pointcut, method invocation is changed to apply code from advice


