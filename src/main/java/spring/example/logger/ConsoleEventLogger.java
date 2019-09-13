package spring.example.logger;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event message) {
        System.out.println(message);
    }
}
