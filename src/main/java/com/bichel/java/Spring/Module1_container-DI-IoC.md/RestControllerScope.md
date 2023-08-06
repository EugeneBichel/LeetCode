So are Spring web controllers thread-safe or not?
The answer again is: it depends.

It depends on the scope of such a controller.

If you define a controller as the default singleton bean, it won’t be thread-safe. Changing the default scope to the session won’t make the controller safe either. However, the request scope will make the controller bean safe to work for concurrent web requests.

What about controllers with the prototype scope? You already know its thread safety depends on the scope of the bean which contains the prototype as a dependency. But we never inject controllers to other beans, right? They’re entry points to our application. So how does Spring behave when you define a controller as the prototype bean?

As you probably suppose, when you define a controller as the prototype, the Spring framework will create a new instance for each web request it serves. Unless you inject them to unsafe scoped beans, you can consider prototype scoped controllers as thread-safe.

