package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao", "metier", "ext"})
public class AppConfig {
    // Spring will automatically discover and register our @Component classes
}
