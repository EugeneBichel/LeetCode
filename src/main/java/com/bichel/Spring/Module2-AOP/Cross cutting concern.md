Spring Implements cross-cutting concerns with usage of Spring AOP module. Spring AOP uses AspectJ expression syntax for Pointcut expressions, which are matched against Join Point, code is altered with logic implemented in advices. In Spring AOP Joint Point is always method invocation.

Spring AOP uses Runtime Weaving, and for each type subject to aspects, to intercepts calls, spring creates one type of proxy:
     JDK Proxy – created for classes that implements interface
     CGLIB Proxy – created for class that are not implementing any interface

It is possible to force Spring to use CGLIB Proxy with usage of
@EnableAspectJAutoProxy(proxyTargetClass = true)


