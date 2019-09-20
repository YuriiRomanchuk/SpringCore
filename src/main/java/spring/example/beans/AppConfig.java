package spring.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.example.logger.Event;

import java.text.DateFormat;
import java.util.Date;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Event event() {
        return new Event(new Date(), receiveDateFormat());
    }

    @Bean
    public DateFormat receiveDateFormat() {
        return DateFormat.getDateTimeInstance();
    }

}
