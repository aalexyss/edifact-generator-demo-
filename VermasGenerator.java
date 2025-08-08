/**
 * Simple EDIFACT VERMAS message generator
 * Sample use case: Verified Gross Mass (VGM) declaration for container shipments
 */

package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VerMasGenerator {

    public static void main(String[] args) {
        String containerNumber = "CONT1234567";
        double weight = 23456.0;

        String message = generateVerMas(containerNumber, weight);
        System.out.println(message);
    }

    public static String generateVerMas(String container, double weight) {
        StringBuilder sb = new StringBuilder();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        sb.append("UNH+MSG001+VERMAS:D:16A:UN:SMDG10'\n");
        sb.append("BGM+749+DOC123+5'\n");
        sb.append("DTM+137:" + today + ":102'\n");
        sb.append("NAD+CA++SOME SHIPPING CO'\n");
        sb.append("EQD+CN+" + container + "+22G1'\n");
        sb.append("MEA+AAE+VGM+KGM:" + (int) weight + "'\n");
        sb.append("UNT+6+MSG001'\n");

        return sb.toString();
    }
}
