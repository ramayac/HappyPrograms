package xls;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XlsDocument {

    public static final int STARTCOL = 9;
    private List<XlsSheet> _hojas = new ArrayList();

    public List<XlsSheet> getHojas() {
        return this._hojas;
    }

    public XlsSheet getHojas(String hojaName) {
        for (XlsSheet sheet : this._hojas) {
            if (sheet.getSheetName().equals(hojaName)) {
                return sheet;
            }
        }
        return null;
    }

    public int size() {
        return this._hojas.size();
    }

    public void processAllSheetSemestral(String filename) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        HSSFWorkbook wb = new HSSFWorkbook(in);
        int sheets = wb.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            HSSFSheet hoja = wb.getSheetAt(i);
            XlsSheet ts = new XlsSheet();

            List lst = procesarSemestral(hoja);
            ts.setDatos(lst);
            ts.setSheetName(hoja.getSheetName());

            this._hojas.add(ts);
        }
    }

    private String getCellContent(Cell cell) {
        switch (cell.getCellType()) {
            case 1:
                return cell.getStringCellValue();
            case 0:
                return new Double(cell.getNumericCellValue()).toString();
            case 2:
            case 3:
            case 4:
        }
        return "";
    }

    public void processAllSheetBimestral(String filename) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        HSSFWorkbook wb = new HSSFWorkbook(in);
        int sheets = wb.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            HSSFSheet hoja = wb.getSheetAt(i);
            XlsSheet ts = new XlsSheet();

            List lst = procesarBimestral(hoja);
            ts.setDatos(lst);
            ts.setSheetName(hoja.getSheetName());

            this._hojas.add(ts);
        }
    }

    private List<IEstructuraMarcaVenta> procesarSemestral(HSSFSheet sheet) {
        List lst = new ArrayList();
        for (Row row : sheet) {
            if (row.getRowNum() >= STARTCOL) {
                IEstructuraMarcaVenta data = getRowContentSemestral(row);
                lst.add(data);
            }
        }
        return lst;
    }

    private IEstructuraMarcaVenta getRowContentSemestral(Row row) {
        XlsDataSemestral data = new XlsDataSemestral();

        List celdas = new ArrayList();
        for (Cell cell : row) {
            if (cell.getColumnIndex() > data.MAXCOLRANGE) {
                break;
            }
            String str = getCellContent(cell);
            if ((str.equals(""))) {
                break;
            }
            celdas.add(str);
        }

        data.setDatos(celdas);
        return data;
    }

    private List<IEstructuraMarcaVenta> procesarBimestral(HSSFSheet sheet) {
        List lst = new ArrayList();
        for (Row row : sheet) {
            if (row.getRowNum() >= STARTCOL) {
                IEstructuraMarcaVenta data = getRowContentBimestral(row);
                lst.add(data);
            }
        }
        return lst;
    }

    private IEstructuraMarcaVenta getRowContentBimestral(Row row) {
        XlsDataBimestral data = new XlsDataBimestral();

        List celdas = new ArrayList();
        for (Cell cell : row) {
            if (cell.getColumnIndex() > data.MAXCOLRANGE) {
                break;
            }
            String str = getCellContent(cell);
            if ((str.equals(""))) {
                break;
            }
            celdas.add(str);
        }

        data.setDatos(celdas);
        return data;
    }

}
