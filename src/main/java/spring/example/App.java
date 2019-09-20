package spring.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.enums.EventType;
import spring.example.logger.Event;
import spring.example.logger.EventLogger;

import java.util.Map;
import java.util.Properties;

public class App {
    private static ConfigurableApplicationContext applicationContext;
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> eventTypeLoggerMap;
    private Properties propertiesLogMessages;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> eventTypeLoggerMap, Properties propertiesLogMessages) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.eventTypeLoggerMap = eventTypeLoggerMap;
        this.propertiesLogMessages = propertiesLogMessages;
    }

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);
        app.logEvents();
        applicationContext.close();
    }

    public void logEvents() {
        for (Map.Entry<Object, Object> entry : propertiesLogMessages.entrySet()) {
            EventType currentEventType = EventType.valueOf((String) entry.getKey());

            EventLogger currentEventLogger = receiveEventLogger(currentEventType);
            Event event = receiveEvent((String) entry.getValue());
            currentEventLogger.logEvent(event);
        }
    }

    private Event receiveEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        Event event = applicationContext.getBean(Event.class);
        event.setMsg(msg);
        return event;
    }

    private EventLogger receiveEventLogger(EventType eventType) {
        EventLogger logger = eventTypeLoggerMap.get(eventType);
        if (logger == null) {
            logger = eventLogger;
        }
        return logger;
    }

}

