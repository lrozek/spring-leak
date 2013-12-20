package pl.lrozek.spring.leak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan("pl.lrozek.spring.leak")
public class AppConfig {

}
