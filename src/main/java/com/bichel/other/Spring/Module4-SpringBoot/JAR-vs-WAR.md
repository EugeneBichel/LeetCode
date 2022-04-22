WAR (Web Application Archive) is a file that represents web module. WAR cannot be executed
in standalone mode, it needs to be deployed to Application Server like Tomcat or WildFly.
Embedded container is used to execute executables jars. Embedded container is packed as
dependency in executable jar and will be responsible for executing only single application.
WAR approach on the other hand uses Application Server which might be used to execute
multiple applications at the same time.

WAR file has following structure:
 Assembly root:
     JSP Pages, static HTML pages
     META-INF/
         MANIFEST.MF
     WEB-INF/
         web.xml (not required for Servlet 3+)
         lib/
         classes/
         tags/


Spring Boot Executable JAR has following structure:
 Assembly root:
     BOOT-INF/
         classes/
         lib/
             . . .
             tomcat-embed-core-9.0.17.jar
             . . .
     META-INF/
         MANIFEST.MF
     org.springframework.boot.loader
         . . .
         JarLauncher.class
         . . .

To create WAR file with Spring Boot, you need to:
     Specify WAR packaging method:
        <packaging>war</packaging>
     Specify required dependencies:
            <dependencies>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                    <scope>provided</scope>
                </dependency>
            </dependencies>
     Use WAR plugin (explicit specification of this plugin is optional):
        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.2.3</version>
                </plugin>
            </plugins>
        </build>


To create Executable JAR file with embedded container in Spring Boot, you need to:
 Specify required dependencies:
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

 Use Spring Boot Maven plugin:
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
