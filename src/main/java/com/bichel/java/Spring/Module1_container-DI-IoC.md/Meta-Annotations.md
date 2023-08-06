Meta-Annotations are annotations that can be used to create new annotations.

@RestController annotation is using @Controller and @ResponseBody to define its behavior. 

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
    @AliasFor(annotation = Controller.class)
    String value() default "";
}