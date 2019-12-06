package utils;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import java.io.*;

public class FileUnzip {

    private final static String FILE_OUTPUT_PATH = "src/main/resources/data.csv";

    public void decompressGZIP(File zipped)  {
        System.out.println("Decompressing file...");

        File unzipped = new File(FILE_OUTPUT_PATH);

        if(!unzipped.exists()){
            try {
                unzipped.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try (GzipCompressorInputStream inputStream = new GzipCompressorInputStream(new FileInputStream(zipped))) {
            try {
                IOUtils.copy(inputStream, new FileOutputStream(unzipped));
                System.out.println("File decompressed.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.println( "Error: " + e.getMessage());
            System.exit(1);
        }
    }

}



