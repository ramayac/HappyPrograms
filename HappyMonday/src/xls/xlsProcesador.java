/*     */ package xls;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.IndexedColors;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ 
/*     */ public class xlsProcesador
/*     */ {
/*     */   public File processDocuments(String filename1, String filename2, String fileres)
/*     */   {
/*     */     try
/*     */     {
/*  26 */       xlsDocument doc1 = new xlsDocument();
/*  27 */       xlsDocument doc2 = new xlsDocument();
/*     */ 
/*  29 */       doc1.processAllSheet(filename1);
/*  30 */       doc2.processAllSheet(filename2);
/*     */ 
/*  32 */       List hojas = generarReporte(doc1, doc2);
/*  33 */       return outPutXls(crearNuevoArchivoExcel(hojas), fileres);
/*     */     }
/*     */     catch (Exception ex) {
/*  36 */       Logger.getLogger(xlsProcesador.class.getName()).log(Level.SEVERE, null, ex);
/*  37 */     }return null;
/*     */   }
/*     */ 
/*     */   private File outPutXls(Workbook wb, String fileres)
/*     */     throws IOException
/*     */   {
/*  43 */     File f = new File(fileres);
/*  44 */     FileOutputStream fileOut = new FileOutputStream(f);
/*  45 */     wb.write(fileOut);
/*  46 */     fileOut.close();
/*  47 */     return f;
/*     */   }
/*     */ 
/*     */   private List<xlsSheet> generarReporte(xlsDocument doc1, xlsDocument doc2) {
/*  51 */     List hojas = new ArrayList();
/*     */ 
/*  53 */     for (xlsSheet hoja1 : doc1.getHojas())
/*     */     {
/*  55 */       xlsSheet nuevaHoja = new xlsSheet();
/*  56 */       List nuevosDatos = new ArrayList();
/*  57 */       xlsSheet hoja2 = doc2.getHojas(hoja1.getSheetName());
/*  58 */       if (hoja2 != null)
/*     */       {
/*  62 */         for (xlsData fila1 : hoja1.getDatos()) {
/*  63 */           if (fila1.getDatos().isEmpty())
/*     */           {
/*     */             break;
/*     */           }
/*  67 */           for (int i = 0; i < hoja2.getDatos().size(); i++) {
/*  68 */             xlsData fila2 = (xlsData)hoja2.getDatos().get(i);
/*     */ 
/*  70 */             if (fila2.getDatos().isEmpty())
/*     */             {
/*     */               break;
/*     */             }
/*     */ 
/*  78 */             if (fila1.equals(fila2)) {
/*  79 */               Double unidades = Double.valueOf(fila1.getVentasUnidadesInt().doubleValue() - fila2.getVentasUnidadesInt().doubleValue());
/*  80 */               fila1.setVentasUnidades(unidades.toString());
/*  81 */               nuevosDatos.add(fila1);
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  87 */         List aux = hoja1.getDatos();
/*  88 */         aux.removeAll(nuevosDatos);
/*     */ 
/*  90 */         nuevosDatos.addAll(aux);
/*     */ 
/*  92 */         nuevaHoja.setDatos(nuevosDatos);
/*  93 */         nuevaHoja.setSheetName(hoja1.getSheetName());
/*     */ 
/*  95 */         hojas.add(nuevaHoja);
/*     */       }
/*     */     }
/*     */ 
/*  99 */     return hojas;
/*     */   }
/*     */ 
/*     */   private Workbook crearNuevoArchivoExcel(List<xlsSheet> hojas) throws Exception {
/* 103 */     Workbook wb = new HSSFWorkbook();
/*     */ 
/* 107 */     CellStyle styleERROR = wb.createCellStyle();
/* 108 */     styleERROR.setFillBackgroundColor(IndexedColors.RED.getIndex());
/*     */ 
/* 111 */     for (xlsSheet hoja : hojas) {
/* 112 */       Sheet sheet = wb.createSheet(hoja.getSheetName());
/*     */ 
/* 114 */       List datos = hoja.getDatos();
/* 115 */       sheet.createRow(0);
/*     */ 
/* 118 */       sheet.setColumnWidth(0, 7326);
/* 119 */       sheet.setColumnWidth(1, 9570);
/* 120 */       sheet.setColumnWidth(2, 1980);
/* 121 */       sheet.setColumnWidth(3, 6270);
/*     */ 
/* 123 */       sheet.setColumnWidth(4, 990);
/* 124 */       sheet.setColumnWidth(5, 7590);
/* 125 */       sheet.setColumnWidth(6, 2970);
/* 126 */       sheet.setColumnWidth(7, 1980);
/*     */ 
/* 128 */       sheet.setColumnWidth(8, 7590);
/* 129 */       sheet.setColumnWidth(9, 3630);
/*     */ 
/* 134 */       sheet.createRow(1);
/* 135 */       sheet.createRow(2);
/* 136 */       sheet.createRow(3);
/* 137 */       sheet.createRow(4);
/* 138 */       sheet.createRow(5);
/*     */ 
/* 140 */       int size = datos.size();
/*     */ 
/* 142 */       for (int i = 0; i < size; i++) {
/* 143 */         Row row = sheet.createRow(i + 6);
/*     */ 
/* 145 */         xlsData dato = (xlsData)datos.get(i);
/* 146 */         List lista = dato.getDatos();
/*     */ 
/* 150 */         for (int j = 0; j < lista.size(); j++)
/*     */         {
/* 153 */           String str = (String)lista.get(j);
/* 154 */           Cell cell = row.createCell(j);
/*     */ 
/* 156 */           if (j > 9) {
/*     */             try {
/* 158 */               double d = Double.parseDouble(str);
/* 159 */               cell.setCellValue(d);
/* 160 */               cell.setCellType(0);
/*     */             } catch (Exception ex) {
/* 162 */               cell.setCellValue(-9999.9899999999998D);
/* 163 */               cell.setCellStyle(styleERROR);
/* 164 */               cell.setCellType(5);
/*     */             }
/*     */           } else {
/* 167 */             if (str.contains(".0"))
/* 168 */               cell.setCellValue(str.replace(".0", ""));
/*     */             else {
/* 170 */               cell.setCellValue(str);
/*     */             }
/* 172 */             cell.setCellType(1);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 179 */       Row row = sheet.createRow(size + 5);
/* 180 */       for (int i = 0; i < xlsData.MAXCOLRANGE; i++) {
/* 181 */         Cell cell = row.createCell(i);
/* 182 */         cell.setCellValue("");
/* 183 */         if (i == 10) {
/* 184 */           cell.setCellFormula("SUM(K7:K" + (size + 5) + ")");
/*     */         }
/* 186 */         if (i == 11) {
/* 187 */           cell.setCellFormula("SUM(L7:L" + (size + 5) + ")");
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 192 */     return wb;
/*     */   }
/*     */ }

/* Location:           C:\Users\ramayac\Desktop\HappyIndex\HappyMonday.jar
 * Qualified Name:     xls.xlsProcesador
 * JD-Core Version:    0.6.0
 */