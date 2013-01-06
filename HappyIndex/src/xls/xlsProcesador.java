package xls;

import dto.Consolidado;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class xlsProcesador {

    public File processDocuments(String filename1, String fileres) {
        try {
            xlsDocument doc1 = new xlsDocument();
            doc1.processAllSheet(filename1);

            List hojas = generarReporte(doc1);
            return outPutXls(crearNuevoArchivoExcel(hojas), fileres);
        } catch (Exception ex) {
            Logger.getLogger(xlsProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private File outPutXls(Workbook wb, String fileres) throws IOException {
        File f = new File(fileres);
        FileOutputStream fileOut = new FileOutputStream(f);
        wb.write(fileOut);
        fileOut.close();
        return f;
    }

    private List<xlsSheet> generarReporte(xlsDocument doc1) {
        List hojas = new ArrayList();

        //por Hojas
        for (xlsSheet hoja1 : doc1.getHojas()) {
            Map<String, Consolidado> mapa = new HashMap<String, Consolidado>();

            xlsSheet nuevaHoja = new xlsSheet();

            for (xlsData fila : hoja1.getSem1()) {
                if (fila.getDatos().isEmpty()) {
                    break;
                }

                String llave = fila.getPais() + fila.getMarca();
                if (mapa.containsKey(llave)) {
                    break;
                } else {
                    Consolidado con = new Consolidado(fila.getPais(), fila.getMarca());
                    con.SetSem1(fila.getIMU(), fila.getGM(), fila.getRotacion(), fila.getMarkDown());
                    mapa.put(llave, con);
                }
            }

            for (xlsData fila : hoja1.getSem2()) {
                if (fila.getDatos().isEmpty()) {
                    break;
                }

                String llave = fila.getPais() + fila.getMarca();
                if (mapa.containsKey(llave)) {
                    Consolidado con = mapa.get(llave);
                    con.SetSem2(fila.getIMU(), fila.getGM(), fila.getRotacion(), fila.getMarkDown());
                    mapa.put(llave, con);
                } else {
                    Consolidado con = new Consolidado(fila.getPais(), fila.getMarca());
                    con.SetSem2(fila.getIMU(), fila.getGM(), fila.getRotacion(), fila.getMarkDown());
                    mapa.put(llave, con);
                }
            }

            for (xlsData fila : hoja1.getProy()) {
                if (fila.getDatos().isEmpty()) {
                    break;
                }

                String llave = fila.getPais() + fila.getMarca();
                if (mapa.containsKey(llave)) {
                    Consolidado con = mapa.get(llave);
                    con.SetProy(fila.getIMU(), fila.getGM(), fila.getRotacion(), fila.getMarkDown());
                    mapa.put(llave, con);
                } else {
                    Consolidado con = new Consolidado(fila.getPais(), fila.getMarca());
                    con.SetProy(fila.getIMU(), fila.getGM(), fila.getRotacion(), fila.getMarkDown());
                    mapa.put(llave, con);
                }
            }

            List<Consolidado> nuevosDatos = new ArrayList<Consolidado>();
            nuevosDatos.addAll(mapa.values());

            nuevaHoja.setCons(nuevosDatos);
            nuevaHoja.setSheetName(hoja1.getSheetName());

            hojas.add(nuevaHoja);
        }

        return hojas;
    }

    private Workbook crearNuevoArchivoExcel(List<xlsSheet> hojas) throws Exception {
        Workbook wb = new HSSFWorkbook();

        CellStyle styleERROR = wb.createCellStyle();
        styleERROR.setFillBackgroundColor(IndexedColors.RED.getIndex());

        for (xlsSheet hoja : hojas) {
            Sheet sheet = wb.createSheet(hoja.getSheetName());

            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 10000);
            
            sheet.setColumnWidth(2, 2000);
            sheet.setColumnWidth(3, 2000);
            sheet.setColumnWidth(4, 2000);
            sheet.setColumnWidth(5, 2000);
            
            sheet.setColumnWidth(6, 2000);
            sheet.setColumnWidth(7, 2000);
            sheet.setColumnWidth(8, 2000);
            sheet.setColumnWidth(9, 2000);
            
            sheet.setColumnWidth(10, 2000);
            sheet.setColumnWidth(11, 2000);
            sheet.setColumnWidth(12, 2000);
            sheet.setColumnWidth(13, 2000);

            sheet.createRow(0);
            sheet.createRow(1);
            sheet.createRow(2);

            List<Consolidado> datos = hoja.getCons();
            int size = datos.size();

            for (int i = 0; i < size; i++) {
                Row row = sheet.createRow(i + 3);
                Consolidado dato = datos.get(i);
                
                row.createCell(0).setCellValue(dato.getPais());
                row.createCell(1).setCellValue(dato.getMarca());
                
                row.createCell(2).setCellValue(dato.getIMU1());
                row.createCell(3).setCellValue(dato.getGM1());
                row.createCell(4).setCellValue(dato.getRotacion1());
                row.createCell(5).setCellValue(dato.getMarkDown1());
                
                row.createCell(6).setCellValue(dato.getIMU2());
                row.createCell(7).setCellValue(dato.getGM2());
                row.createCell(8).setCellValue(dato.getRotacion2());
                row.createCell(9).setCellValue(dato.getMarkDown2());
                
                row.createCell(10).setCellValue(dato.getIMU3());
                row.createCell(11).setCellValue(dato.getGM3());
                row.createCell(12).setCellValue(dato.getRotacion3());
                row.createCell(13).setCellValue(dato.getMarkDown3());
                
                /*for (int j = 0; j < datos.size(); j++) {
                    String str = (String) .get(j);
                    
                    if (j > 9) {
                        try {
                            double d = Double.parseDouble(str);
                            cell.setCellValue(d);
                            cell.setCellType(0);
                        } catch (Exception ex) {
                            cell.setCellValue(-9999.9899999999998D);
                            cell.setCellStyle(styleERROR);
                            cell.setCellType(5);
                        }
                    } else {
                        if (str.contains(".0")) {
                            cell.setCellValue(str.replace(".0", ""));
                        } else {
                            cell.setCellValue(str);
                        }
                        cell.setCellType(1);
                    }

                }*/

            }

            /*Row row = sheet.createRow(size + 5);
            for (int i = 0; i < xlsData.MAXCOLRANGE; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue("");
            if (i == 10) {
            cell.setCellFormula("SUM(K7:K" + (size + 5) + ")");
            }
            if (i == 11) {
            cell.setCellFormula("SUM(L7:L" + (size + 5) + ")");
            }
            }*/
        }

        return wb;
    }
}