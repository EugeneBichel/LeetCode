### Is @Controller a stereotype? Is @RestController a stereotype?
    Yes, both @Controller and @RestController are stereotypes. The @Controller is actually a specialization of Spring's @Component stereotype annotation. This means that class annotated with @Controller will also be automatically be detected by Spring container as part of the container's component scanning process.

### What is the difference between @Controller and @RestController?  (answer)
    There are many differences between @Controller and @RestController as discussed in my earlier article (see the answer) but the most important one is that with @RestController you get the @ResponseBody annotation automatically, which means you don't need to separately annotate your handler methods with @ResponseBody annotation. This makes the development of RESTful web service easier using Spring. You can see here learn more about the difference between @RestController and @Controller annotations in Spring API.

### When do you need @ResponseBody annotation in Spring MVC? (answer)
    The @ResponseBody annotation can be put on a method to indicates that the return type should be written directly to the HTTP response body (and not placed in a Model, or interpreted as a view name).

    For example:

    @RequestMapping(path = "/hello", method = RequestMethod.PUT)
    @ResponseBody
    public String helloWorld() {
    return "Hello World";
    }

    Alternatively, you can also use @RestController annotation instead of @Controller annotation. This will remove the need for using @ResponseBody because as discussed in the previous answer, it comes automatically with @RestController annotation.

### What is the HTTP status return code for a successful DELETE statement? (answer)
    There is no strict rule with respect to what status code your REST API should return after a successful DELETE i.e it can return 200 Ok or 204 No Content. In general, if the DELETE operation is successful and the response body is empty return 204. If the DELETE request is successful and the response body is NOT empty, return 200

### Where do you need @EnableWebMVC? (answer)
    The @EnableWebMvc annotation is required to enable Spring MVC when Java configuration is used to configure Spring MVC instead of XML. It is equivalent to <mvc: annotation-driven>  in XML configuration.

    It enables support for @Controller-annotated classes that use @RequestMapping to map incoming requests to handler methods not already familiar with Spring's support for Java configuration

### When do you need @ResponseStatus annotation in Spring MVC? (answer)
    A good questions for 3 to 5 years experienced spring developers. The @ResponseStatus annotation is required during error handling in Spring MVC and REST. Normally when an error or exception is thrown at the server-side, web server returns a blanket HTTP status code 500 - Internal server error.

    This may work for a human user but not for REST clients. You need to send them a proper status code like 404 if the resource is not found. That's where you can use @ResponseStatus annotation, which allows you to send custom HTTP status code along with proper error message in case of Exception.

    In order to use it, you can create custom exceptions and annotated them using @ResponseStatus annotation and proper HTTP status code and reason.

    When such exceptions are thrown from controller's handler methods and not handled anywhere else, then appropriate HTTP response with the proper HTTP status code, which you have set is sent to the client.

    For example, if you are writing a RESTful Web Service for a library which provides book information then you can use @ResponseStatus to create Exception which returns HTTP response code 404 when a book is not found instead of Internal Server Error (500), as shown below:

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Book")  // 404
    public class BookNotFoundException extends RuntimeException {
        // ...
    }

    If this Exception is thrown from any handler method then HTTP error code 404 with reason "No such Book" will be returned to the client.

### Do you need Spring MVC in your classpath for developing RESTful Web Service? (answer)
    This question is often asked Java programmers with 1 to 2 years of experience in Spring. The short answer is Yes, you need Spring MVC in your Java application's classpath to develop RESTful web services using the Spring framework. It's actually Spring MVC which provides all useful annotations e.g. @RestController, @ResponseCode, @ResponseBody, @RequestBody, and @PathVariable, hence you must spring-mvc.jar or appropriate Maven entry in your pom.xml


