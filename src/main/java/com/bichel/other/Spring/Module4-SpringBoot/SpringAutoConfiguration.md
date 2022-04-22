You can customize Spring Auto Configuration by creating your own autoconfiguration module with Auto Configuration Class.

To do that, you need to create java jar module which will contain METAINF/spring.factories file that contains org.springframework.boot.autoconfigure.EnableAutoConfiguration entry, which points to your Auto Configuration Class.

Auto Configuration Class is a class annotated with @Configuration annotation, usually used together with @ConditionalOnClass annotation. Additionally you can use @PropertySource annotation with @EnableConfigurationProperties and @ConfigurationProperties annotations to introduce custom properties for your auto-configuration module.

Inside Auto Configuration Class you should have @Bean annotated methods, which
will provide configured beans when @ConditionalOnClass is met.


@Conditional annotations are used together with Auto Configuration Classes,
to indicate under which conditions, specific @Configuration class should
apply.
    @Configuration
    @ConditionalOnProperty(name = "file.store", havingValue = "network")
    public class NetworkFileStoreAutoConfiguration {
        @Bean
        public FileStore networkFileStore() {
            return new NetworkFileStore();
        }
    }

