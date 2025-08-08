package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoparnGenerator {

    public static void main(String[] args) {
        String containerNumber = "CONT7654321";
        String portOfLoading = "DEHAM";
        String portOfDischarge = "NLRTM";

        String message = generateCoparn(containerNumber, portOfLoading, portOfDischarge);
        System.out.println(message);
    }

    public static String generateCoparn(String container, String pol, String pod) {
        StringBuilder sb = new StringBuilder();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        sb.append("UNH+MSG002+COPARN:D:95B:UN:SMDG21'\n");
        sb.append("BGM+45+COPARN001+9'\n");
        sb.append("DTM+137:" + today + ":102'\n");
        sb.append("NAD+CA+SHIPCO LOGISTICS'\n");
        sb.append("EQD+CN+" + container + "+22G1+2+5'\n");
        sb.append("LOC+9+" + pol + "'\n");
        sb.append("LOC+11+" + pod + "'\n");
        sb.append("MEA+AAE+G+KGM:22000'\n");
        sb.append("UNT+8+MSG002'\n");

        return sb.toString();
    }
}
