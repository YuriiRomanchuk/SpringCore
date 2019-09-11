package spring.example.logger;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(String message) {
        System.out.println(message);
    }
}
