JDK Dynamic Proxy Limitations:
     Does not support self-invocation
     Class must implement interface
     Only method implementing the interface will be proxied

CGLIB Proxy Limitations:
     Does not support self-invocation
     Class for which proxy should be created cannot not be final
     Method which should be proxied cannot be final
     Only public/protected/package methods will be proxied, private methods are notproxied


Spring Bean Method needs to have following visibility level to be proxied:
     JDK Dynamic Proxy – public
     CGLIB Proxy – public/protected/package

On top of requirement above, for call to be proxied, it needs to come from outside, both JDK Dynamic Proxy and CGLIB proxy does not support self-invocation.


