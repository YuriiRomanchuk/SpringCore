package spring.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.logger.Event;
import spring.example.logger.EventLogger;

public class App {
    private static ConfigurableApplicationContext applicationContext;
    private Client client;
    private EventLogger eventLogger;
    private int eventsCount;
    private String message;

    public App(Client client, EventLogger eventLogger, int eventsCount, String message) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.eventsCount = eventsCount;
        this.message = message;
    }

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);
        app.logEvent();
        applicationContext.close();
    }

    private void logEvent() {
        for (int x = 1; x <= this.eventsCount; x++) {
            String currentMessage = this.message + x;
            String message = currentMessage.replaceAll(client.getId(), client.getFullName());
            Event event = applicationContext.getBean(Event.class);
            event.setMsg(message);
            eventLogger.logEvent(event);
        }
    }
}
