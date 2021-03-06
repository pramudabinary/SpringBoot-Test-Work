package lk.example.test.poi;

import lk.example.test.dto.CustomerDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/

public class CustomerExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private ArrayList<CustomerDTO> listUsers;

    public CustomerExcelExporter(ArrayList<CustomerDTO> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("customers");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(10);
        style.setFont(font);

        createCell(row, 0, "id", style);
        createCell(row, 1, "name", style);
        createCell(row, 2, "address", style);
        createCell(row, 3, "contact", style);
        createCell(row, 4, "salary", style);

        pieChartCreate();

    }

    private void pieChartCreate(){
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 20);

        XSSFChart chart = drawing.createChart(anchor);
        chart.setTitleText("Customers of TestProject");
        chart.setTitleOverlay(false);

        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(LegendPosition.LEFT);

        XDDFDataSource<String> customers = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                new CellRangeAddress(0, 0, 0, 6));

        XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                new CellRangeAddress(1, 1, 0, 6));

        XDDFChartData data = chart.createData(ChartTypes.PIE3D, null, null);

        data.setVaryColors(true);
        data.addSeries(customers,values);
        chart.plot(data);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(10);
        style.setFont(font);

        for (CustomerDTO dto : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, dto.getId(), style);
            createCell(row, columnCount++, dto.getName(), style);
            createCell(row, columnCount++, dto.getAddress(), style);
            createCell(row, columnCount++, dto.getContact(), style);
            createCell(row, columnCount++, dto.getSalary(), style);

        }

    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
