package spring.example.logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        file.canWrite();
        writeMessageToFileLog("", false);
    }

    @Override
    public void logEvent(Event message) {
        writeMessageToFileLog(message.toString(), true);
    }

    private void writeMessageToFileLog(String message, Boolean append) {
        try {
            FileUtils.writeStringToFile(file, message + "\n", append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
