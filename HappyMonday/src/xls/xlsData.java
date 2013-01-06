/*    */ package xls;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class xlsData
/*    */ {
/*    */   public static final int COLTIENDA = 0;
/*    */   public static final int COLSKU = 7;
/*    */   public static final int COLVENTUNITS = 10;
/*    */   public static final int COLVENTINVEN = 11;
/* 12 */   public static int MAXCOLRANGE = 13;
/*    */ 
/* 14 */   private List<String> _datos = new ArrayList(MAXCOLRANGE);
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 18 */     if ((obj instanceof xlsData)) {
/* 19 */       xlsData foo = (xlsData)obj;
/*    */ 
/* 21 */       return (getTienda().equals(foo.getTienda())) && (getSku().equals(foo.getSku()));
/*    */     }
/*    */ 
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 31 */     String hash = getTienda() + getSku();
/* 32 */     return hash.hashCode();
/*    */   }
/*    */ 
/*    */   public String getSku() {
/*    */     try {
/* 37 */       return (String)this._datos.get(7);
/*    */     } catch (IndexOutOfBoundsException iobe) {
/*    */     }
/* 40 */     return "";
/*    */   }
/*    */ 
/*    */   public String getTienda()
/*    */   {
/*    */     try {
/* 46 */       return (String)this._datos.get(0);
/*    */     } catch (IndexOutOfBoundsException iobe) {
/*    */     }
/* 49 */     return "";
/*    */   }
/*    */ 
/*    */   public String getVentasInventarios()
/*    */   {
/* 54 */     return (String)this._datos.get(11);
/*    */   }
/*    */ 
/*    */   public String getVentasUnidades() {
/* 58 */     return (String)this._datos.get(10);
/*    */   }
/*    */ 
/*    */   public String setVentasUnidades(String str) {
/* 62 */     return (String)this._datos.set(10, str);
/*    */   }
/*    */ 
/*    */   public Double getVentasInventariosInt() {
/*    */     try {
/* 67 */       return Double.valueOf(Double.parseDouble((String)this._datos.get(11))); } catch (NumberFormatException nfe) {
/*    */     }
/* 69 */     return Double.valueOf(-999999999.99000001D);
/*    */   }
/*    */ 
/*    */   public Double getVentasUnidadesInt()
/*    */   {
/*    */     try {
/* 75 */       return Double.valueOf(Double.parseDouble((String)this._datos.get(10))); } catch (NumberFormatException nfe) {
/*    */     }
/* 77 */     return Double.valueOf(-999999999.99000001D);
/*    */   }
/*    */ 
/*    */   public List<String> getDatos()
/*    */   {
/* 82 */     return this._datos;
/*    */   }
/*    */ 
/*    */   public void setDatos(List<String> _datos) {
/* 86 */     this._datos = _datos;
/*    */   }
/*    */ }

/* Location:           C:\Users\ramayac\Desktop\HappyIndex\HappyMonday.jar
 * Qualified Name:     xls.xlsData
 * JD-Core Version:    0.6.0
 */