import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static void addTableHeader(PdfPTable table) {
        Stream.of("District Id", "District Name", "Province Id", "Province Name")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setPaddingBottom(5);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private static void addRows(PdfPTable table, String data1, String data2 ,String data3, String data4) {
        table.addCell(data1);
        table.addCell(data2);
        table.addCell(data3);
        table.addCell(data4);
    }

    public static void main(String[] args) throws IOException {
        Document document = new Document();
        String pdf = "Study.pdf";
        String district = "districts.txt";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdf));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLUE);
            Chunk chuck = new Chunk("The Table of Provinces and Districts", font);
            Paragraph paragraph = new Paragraph();
            paragraph.add(chuck);
            paragraph.setSpacingAfter(50);
            document.add(paragraph);
            Scanner scanner = new Scanner(new BufferedReader(new FileReader((district))));
            scanner.useDelimiter("[,\n]");
            PdfPTable table = new PdfPTable(4);
            addTableHeader(table);
            while (scanner.hasNext()) {
                String districtCode = String.valueOf(scanner.nextInt());
                String districtName = scanner.next();
                String provinceCode = String.valueOf(scanner.nextInt());
                String provinceName = scanner.next();
                System.out.println("District Code: " + districtCode + ", province Code: " + provinceCode + ", Province Name: " + provinceName + ", District Name: " + districtName);
                addRows(table, districtCode, districtName, provinceCode, provinceName);
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}