/*    */ package xls;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class xlsSheet
/*    */ {
/*  8 */   private String _sheetName = "";
/*  9 */   private List<xlsData> _datos = new ArrayList();
/*    */ 
/*    */   public String getSheetName() {
/* 12 */     return this._sheetName;
/*    */   }
/*    */ 
/*    */   public void setSheetName(String _sheetName) {
/* 16 */     this._sheetName = _sheetName;
/*    */   }
/*    */ 
/*    */   public List<xlsData> getDatos() {
/* 20 */     return this._datos;
/*    */   }
/*    */ 
/*    */   public void setDatos(List<xlsData> _datos) {
/* 24 */     this._datos = _datos;
/*    */   }
/*    */ 
/*    */   public int size() {
/* 28 */     return this._datos.size();
/*    */   }
/*    */ }

/* Location:           C:\Users\ramayac\Desktop\HappyIndex\HappyMonday.jar
 * Qualified Name:     xls.xlsSheet
 * JD-Core Version:    0.6.0
 */