/*    */ package xls;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.apache.poi.ss.usermodel.Cell;
/*    */ import org.apache.poi.ss.usermodel.Row;
/*    */ 
/*    */ public class xlsDocument
/*    */ {
/*    */   public static final int STARTCOL = 8;
/* 16 */   private List<xlsSheet> _hojas = new ArrayList();
/*    */ 
/*    */   public List<xlsSheet> getHojas() {
/* 19 */     return this._hojas;
/*    */   }
/*    */ 
/*    */   public xlsSheet getHojas(String hojaName) {
/* 23 */     for (xlsSheet sheet : this._hojas) {
/* 24 */       if (sheet.getSheetName().equals(hojaName)) {
/* 25 */         return sheet;
/*    */       }
/*    */     }
/* 28 */     return null;
/*    */   }
/*    */ 
/*    */   public int size() {
/* 32 */     return this._hojas.size();
/*    */   }
/*    */ 
/*    */   public void processAllSheet(String filename) throws Exception {
/* 36 */     FileInputStream in = new FileInputStream(filename);
/* 37 */     HSSFWorkbook wb = new HSSFWorkbook(in);
/* 38 */     int sheets = wb.getNumberOfSheets();
/*    */ 
/* 40 */     for (int i = 0; i < sheets; i++) {
/* 41 */       HSSFSheet hoja = wb.getSheetAt(i);
/* 42 */       xlsSheet ts = new xlsSheet();
/*    */ 
/* 44 */       List lst = procesar(hoja);
/* 45 */       ts.setDatos(lst);
/* 46 */       ts.setSheetName(hoja.getSheetName());
/*    */ 
/* 48 */       this._hojas.add(ts);
/*    */     }
/*    */   }
/*    */ 
/*    */   private List<xlsData> procesar(HSSFSheet sheet1) {
/* 53 */     List lst = new ArrayList();
/* 54 */     for (Row row : sheet1) {
/* 55 */       if (row.getRowNum() >= 8) {
/* 56 */         xlsData data = getRowContent(row);
/* 57 */         lst.add(data);
/*    */       }
/*    */     }
/* 60 */     return lst;
/*    */   }
/*    */ 
/*    */   private xlsData getRowContent(Row row) {
/* 64 */     xlsData data = new xlsData();
/*    */ 
/* 66 */     List celdas = new ArrayList();
/* 67 */     for (Cell cell : row) {
/* 68 */       if (cell.getColumnIndex() > xlsData.MAXCOLRANGE)
/*    */         break;
/* 70 */       String str = getCellContent(cell);
/* 71 */       if ((str.equals("")) || (str.equalsIgnoreCase("total"))) {
/*    */         break;
/*    */       }
/* 74 */       celdas.add(str);
/*    */     }
/*    */ 
/* 78 */     data.setDatos(celdas);
/* 79 */     return data;
/*    */   }
/*    */ 
/*    */   private String getCellContent(Cell cell) {
/* 83 */     switch (cell.getCellType()) {
/*    */     case 1:
/* 85 */       return cell.getStringCellValue();
/*    */     case 0:
/* 87 */       return new Double(cell.getNumericCellValue()).toString();
/*    */     case 2:
/*    */     case 3:
/*    */     case 4:
/*    */     }
/* 92 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\ramayac\Desktop\HappyIndex\HappyMonday.jar
 * Qualified Name:     xls.xlsDocument
 * JD-Core Version:    0.6.0
 */