package spring.example.logger;

import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cacheSize == cache.size()) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }

    public List<Event> getCache() {
        return cache;
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
