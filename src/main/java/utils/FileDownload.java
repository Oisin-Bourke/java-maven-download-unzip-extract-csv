package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownload {

    private static final String FILE_PATH = "src/main/resources/data.gz";

    /**
     * Use Non-blocking NIO API Channel for file download
     */
    public File fileDownload(String validUrl) {

        File gzipped;
        ReadableByteChannel readableByteChannel = null;
        FileOutputStream fileOutputStream = null;
        try {
            System.out.println("File downloading...");

            URL url = new URL(validUrl);
            readableByteChannel = Channels.newChannel(url.openStream());

            gzipped = new File(FILE_PATH);
            if(!gzipped.exists()){
                gzipped.createNewFile();
            }

            fileOutputStream = new FileOutputStream(gzipped);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            System.out.println("File downloaded.");
            return gzipped;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(1);
            }
            try {
                if (readableByteChannel != null) {
                    readableByteChannel.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(1);
            }
        }
        return null;
    }

}
