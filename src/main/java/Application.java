import utils.*;
import java.io.File;
import java.math.BigDecimal;

public class Application {

    private static final String URL = "https://s3.amazonaws.com/swrve-public/full_stack_programming_test/test_data.csv.gz";

    public static void main(String[]args) {

        //File download
        File gzippedFile = new FileDownload().fileDownload(URL);

        if(gzippedFile != null){

            //Decompress GZIP file
            new FileUnzip().decompressGZIP(gzippedFile);

            //Parse CSV file and extract data
            new CSVParser().parseCSV();

            //Print captured data
            System.out.println(DataCapture.getUserCount());
            System.out.println(DataCapture.getDeviceResolutionCount());
            System.out.println(new BigDecimal(DataCapture.getTotalSpend()).movePointLeft(2));
            System.out.println(DataCapture.getFirstUserId());
        }

    }

}
