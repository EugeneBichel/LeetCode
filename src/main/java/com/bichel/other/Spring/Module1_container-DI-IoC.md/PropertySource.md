PropertySource is Spring Abstraction on Environment Key-Value pairs, which can come from:
     JVM Properties
     System Environmental Variables
     JNDI Properties
     Servlet Parameters
     Properties File Located on Filesystem
     Properties File Located on Classpath

You read properties with usage of @PropertySource or @PropertySources annotation:
    @PropertySources({
        @PropertySource("file:${app-home}/app-db.properties"),
        @PropertySource("classpath:/app-defaults.properties")
    })

You access properties with usage of @Value annotation:
    @Value("${db.host}")
    private String dbHost;


