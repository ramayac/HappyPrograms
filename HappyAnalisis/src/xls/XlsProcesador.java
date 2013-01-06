package xls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class XlsProcesador {

    public File processDocuments(String filename1, String filename2, String fileres) {
        try {
            XlsDocument doc1 = new XlsDocument();
            XlsDocument doc2 = new XlsDocument();

            doc1.processAllSheetSemestral(filename1);
            doc2.processAllSheetBimestral(filename2);

            List hojas = generarReporte(doc1, doc2);
            return outPutXls(crearNuevoArchivoExcel(hojas), fileres);
        } catch (Exception ex) {
            Logger.getLogger(XlsProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private File outPutXls(Workbook wb, String fileres)
            throws IOException {
        File f = new File(fileres);
        FileOutputStream fileOut = new FileOutputStream(f);
        wb.write(fileOut);
        fileOut.close();
        return f;
    }

    private List<XlsSheet> generarReporte(XlsDocument doc1, XlsDocument doc2) {

        List<XlsSheet> hojas1 = doc1.getHojas();
        List<XlsSheet> hojas2 = doc2.getHojas();

        Map<String, List<IEstructuraMarcaVenta>> mapa = new HashMap<String, List<IEstructuraMarcaVenta>>();

        for (XlsSheet hoja1 : hojas1) {
            for (XlsSheet hoja2 : hojas2) {

                /*if (hoja1.getSheetName().equalsIgnoreCase("Clases")) {
                 break;
                 }*/

                if (hoja1.getSheetName().compareToIgnoreCase(hoja2.getSheetName()) == 0) {
                    List lista = new ArrayList();
                    lista.addAll(hoja1.getDatos());
                    lista.addAll(hoja2.getDatos());
                    mapa.put(hoja1.getSheetName(), lista);
                }
            }
        }


        for (Map.Entry<String, List<IEstructuraMarcaVenta>> sheetAgrupada : mapa.entrySet()) {
            String nombreSheet = sheetAgrupada.getKey();
            List<IEstructuraMarcaVenta> datosAgrupados = sheetAgrupada.getValue();

            if (nombreSheet.equalsIgnoreCase("Clases")) {
                
                List<IEstructuraMarcaVenta> datosClases = new ArrayList<IEstructuraMarcaVenta>(datosAgrupados.size());
                
                for (IEstructuraMarcaVenta fila1 : datosAgrupados) {
                    if (fila1 instanceof XlsDataSemestral) {

                        for (IEstructuraMarcaVenta fila2 : datosAgrupados) {
                            if (fila2 instanceof XlsDataBimestral) {

                                if (!fila2.isEmpty()) {
                                    
                                    int comp = fila1.get(0).compareTo(fila2.get(0));
                                    if (comp == 0) {
                                        XlsDataClases clase = new XlsDataClases();
                                        clase.setDatos(fila1.getDatos());
                                        clase.add(4, fila2.getDatos().get(1));
                                        clase.add(5, fila2.getDatos().get(2));
                                        clase.add(6, fila2.getDatos().get(3));

                                        fila1.setDatos(new ArrayList(0));
                                        fila1.setProcesado(true);
                                        
                                        fila2.setDatos(new ArrayList(0));
                                        fila2.setProcesado(true);
                                        
                                        datosClases.add(clase);
                                    }
                                }

                            }
                        }
                    }
                }
                
                mapa.put(nombreSheet, datosClases);
                
            } else {

                for (IEstructuraMarcaVenta fila1 : datosAgrupados) {
                    if (fila1 instanceof XlsDataSemestral) {

                        for (IEstructuraMarcaVenta fila2 : datosAgrupados) {
                            if (fila2 instanceof XlsDataBimestral) {

                                if (!fila2.isEmpty()) {

                                    /*int last = fila1.getMarca().compareTo(fila2.getMarca());
                                     int comp = last == 0 ? fila1.getEstructura().compareTo(fila2.getEstructura()) : last;*/

                                    int last = fila1.get(1).compareTo(fila2.get(1));
                                    int comp = last == 0 ? fila1.get(0).compareTo(fila2.get(0)) : last;

                                    if (comp == 0) {
                                        fila1.add(5, fila2.getDatos().get(2));
                                        fila1.add(6, fila2.getDatos().get(3));
                                        fila1.add(7, fila2.getDatos().get(4));

                                        fila1.setProcesado(true);

                                        fila2.setDatos(new ArrayList());
                                        fila2.setProcesado(true);
                                    }
                                }

                            }
                        }
                    }
                }
                
            }
        }

        for (Map.Entry<String, List<IEstructuraMarcaVenta>> sheetAgrupada : mapa.entrySet()) {
            List<IEstructuraMarcaVenta> datosAgrupados = sheetAgrupada.getValue();

            //Padding
            for (IEstructuraMarcaVenta fila : datosAgrupados) {
                if (!fila.isEmpty()) {
                    if (fila instanceof XlsDataSemestral) {

                        //Si la fila semestral no fue procesada, es porque no habia un "match" con bimestral
                        if (fila.isProcesado() == false) {
                            fila.add(5, "0.0");
                            fila.add(6, "0.0");
                            fila.add(7, "0.0");
                        }

                    } else if (fila instanceof XlsDataBimestral) {
                        fila.add(5, fila.getDatos().get(2));
                        fila.add(6, fila.getDatos().get(3));
                        fila.add(7, fila.getDatos().get(4));

                        fila.set(2, "0.0");
                        fila.set(3, "0.0");
                        fila.set(4, "0.0");
                    }
                }
            }
        }

        List<XlsSheet> hojas = new ArrayList<XlsSheet>();
        for (Map.Entry<String, List<IEstructuraMarcaVenta>> sheetAgrupada : mapa.entrySet()) {
            String nombre = sheetAgrupada.getKey();
            List<IEstructuraMarcaVenta> listaConVacios = sheetAgrupada.getValue();
            List<IEstructuraMarcaVenta> listaClean = new ArrayList<IEstructuraMarcaVenta>();

            for (IEstructuraMarcaVenta elemento : listaConVacios) {
                if (!elemento.isEmpty()) {
                    listaClean.add(elemento);
                }
            }

            XlsSheet nuevaHoja = new XlsSheet();
            nuevaHoja.setDatos(listaClean);
            nuevaHoja.setSheetName(nombre);

            hojas.add(nuevaHoja);
        }
        return hojas;
    }

    private Workbook crearNuevoArchivoExcel(List<XlsSheet> hojas) throws Exception {
        Workbook wb = new HSSFWorkbook();

        CellStyle styleERROR = wb.createCellStyle();
        styleERROR.setFillBackgroundColor(IndexedColors.RED.getIndex());

        for (XlsSheet hoja : hojas) {
            Sheet sheet = wb.createSheet(hoja.getSheetName());

            List datos = hoja.getDatos();
            
            if(hoja.getSheetName().equalsIgnoreCase("Clases")){
                Collections.sort(datos);
            } else {
                Comparator comparador = Collections.reverseOrder();
                Collections.sort(datos, comparador);
            }

            sheet.createRow(0);

            sheet.setColumnWidth(0, 9500);
            sheet.setColumnWidth(1, 9500);
            
            /*sheet.setColumnWidth(2, 2000);
             sheet.setColumnWidth(3, 2000);
             sheet.setColumnWidth(4, 200);
             sheet.setColumnWidth(5, 7590);
             sheet.setColumnWidth(6, 2970);
             sheet.setColumnWidth(7, 1980);
             sheet.setColumnWidth(8, 7590);
             sheet.setColumnWidth(9, 3630);*/
            
            sheet.createRow(1);
            sheet.createRow(2);
            sheet.createRow(3);
            sheet.createRow(4);
            sheet.createRow(5);
            sheet.createRow(6);
            sheet.createRow(7);
            sheet.createRow(8);
            sheet.createRow(9);

            int size = datos.size();

            for (int i = 0; i < size; i++) {
                //System.out.println();
                Row row = sheet.createRow(i + 9);

                IEstructuraMarcaVenta dato = (IEstructuraMarcaVenta) datos.get(i);
                if (!dato.isEmpty()) {

                    //List<String> lista = dato.getDatos();

                    int limite = 13;
                    if(hoja.getSheetName().equalsIgnoreCase("Clases")){
                        limite = 12;
                    }
                    
                    for (int j = 0; j <= limite; j++) {
                        String str = dato.get(j);

                        //System.out.print(" " + str);
                        Cell cell = row.createCell(j);

                        if (j > 1) {
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

                    }
                }
            }

            //Totales
            /*Row row = sheet.createRow(size+9);
             for (int i = 0; i < 13; i++) {
             Cell cell = row.createCell(i);
             cell.setCellValue("");
                
             if(i == 0){
             cell.setCellValue("Total:");
             }
                
             if (i >= 2 ) {
             char c = (char)(65+i);
             cell.setCellFormula("SUM(" + c + "10:" + c + (size+9) + ")");
             }
             }*/

        }

        return wb;
    }
}
