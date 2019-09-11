package spring.example;

public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "Boris Jonson");
        app.consoleEventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user id 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        consoleEventLogger.LogEvent(message);
    }


}
