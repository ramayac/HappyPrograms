package xls;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class xlsDocument {

    private List<xlsSheet> _hojas = new ArrayList<xlsSheet>();

    public List<xlsSheet> getHojas() {
        return this._hojas;
    }

    public xlsSheet getHojas(String hojaName) {
        for (xlsSheet sheet : this._hojas) {
            if (sheet.getSheetName().equals(hojaName)) {
                return sheet;
            }
        }
        return null;
    }

    public int size() {
        return this._hojas.size();
    }

    public void processAllSheet(String filename) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        HSSFWorkbook wb = new HSSFWorkbook(in);
        int sheets = wb.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            HSSFSheet hoja = wb.getSheetAt(i);
            xlsSheet ts = new xlsSheet();

            List<xlsData> sem1 = new ArrayList<xlsData>();
            sem1.addAll(procesar(hoja, 0, 5));
            List<xlsData> sem2 = new ArrayList<xlsData>();
            sem2.addAll(procesar(hoja, 8, 13));
            List<xlsData> proy = new ArrayList<xlsData>();
            proy.addAll(procesar(hoja, 16, 21));

            ts.setSem1(sem1);
            ts.setSem2(sem2);
            ts.setProy(proy);
            ts.setSheetName(hoja.getSheetName());

            this._hojas.add(ts);
        }
    }

    private List<xlsData> procesar(HSSFSheet sheet1, int coli, int colf) {
        List<xlsData> lst = new ArrayList<xlsData>();
        for (Row row : sheet1) {
            if (row.getRowNum() >= 3) {
                xlsData data = getRowContent(row, coli, colf);
                lst.add(data);
            }
        }
        return lst;
    }

    private xlsData getRowContent(Row row, int coli, int colf) {
        xlsData data = new xlsData();

        List celdas = new ArrayList();
        for (Cell cell : row) {
            if (cell.getColumnIndex() < coli) {
                continue;
            }
            if (cell.getColumnIndex() > colf) {
                continue;
            }
            String str = getCellContent(cell);
            if ((str.equals("")) || (str.equalsIgnoreCase("total"))) {
                break;
            }
            celdas.add(str);
        }

        data.setDatos(celdas);
        return data;
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
}
