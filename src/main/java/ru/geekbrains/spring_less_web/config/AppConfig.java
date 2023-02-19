package ru.geekbrains.spring_less_web.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("secrets.properties")
public class AppConfig {
}
