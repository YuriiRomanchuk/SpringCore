package spring.example.logger;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> eventLoggers;

    public CombinedEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    @Override
    public void logEvent(Event message) {

        eventLoggers.forEach(l -> l.logEvent(message));

    }
}
