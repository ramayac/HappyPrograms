/*     */ package gui;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ import xls.xlsProcesador;
/*     */ 
/*     */ public class frmHappy extends JFrame
/*     */ {
/*  30 */   FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel 2003", new String[] { "xls" });
/*  31 */   final JFileChooser fc = new JFileChooser();
/*     */   File file1;
/*     */   File file2;
/*  34 */   boolean flag1 = false;
/*  35 */   boolean flag2 = false;
/*     */   private JButton btnDoc1;
/*     */   private JButton btnDoc2;
/*     */   private JButton btnGenerar;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JSeparator jSeparator1;
/*     */   private JSeparator jSeparator2;
/*     */   private JTextField txtRuta1;
/*     */   private JTextField txtRuta2;
/*     */ 
/*     */   private void habilitarBotonGenerar()
/*     */   {
/*  38 */     if ((this.flag1) && (this.flag2))
/*  39 */       this.btnGenerar.setEnabled(true);
/*     */     else
/*  41 */       this.btnGenerar.setEnabled(false);
/*     */   }
/*     */ 
/*     */   public frmHappy()
/*     */   {
/*     */     try
/*     */     {
/*  49 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/*     */ 
/*  55 */     initComponents();
/*  56 */     this.fc.addChoosableFileFilter(this.filter);
/*  57 */     this.fc.setAcceptAllFileFilterUsed(false);
/*  58 */     this.fc.setMultiSelectionEnabled(false);
/*  59 */     this.btnGenerar.setEnabled(false);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  73 */     this.btnDoc1 = new JButton();
/*  74 */     this.btnDoc2 = new JButton();
/*  75 */     this.txtRuta1 = new JTextField();
/*  76 */     this.txtRuta2 = new JTextField();
/*  77 */     this.jSeparator1 = new JSeparator();
/*  78 */     this.jSeparator2 = new JSeparator();
/*  79 */     this.jLabel1 = new JLabel();
/*  80 */     this.btnGenerar = new JButton();
/*  81 */     this.jLabel2 = new JLabel();
/*  82 */     this.jLabel3 = new JLabel();
/*     */ 
/*  84 */     setDefaultCloseOperation(3);
/*  85 */     setTitle("Happy Monday Report");
/*  86 */     setResizable(false);
/*     */ 
/*  88 */     this.btnDoc1.setIcon(new ImageIcon(getClass().getResource("/res/page_excel.png")));
/*  89 */     this.btnDoc1.setText("Archivo de Fecha más reciente");
/*  90 */     this.btnDoc1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  92 */         frmHappy.this.btnDoc1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  96 */     this.btnDoc2.setIcon(new ImageIcon(getClass().getResource("/res/page_excel.png")));
/*  97 */     this.btnDoc2.setText("Archivo de Fecha menor");
/*  98 */     this.btnDoc2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 100 */         frmHappy.this.btnDoc2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 104 */     this.txtRuta1.setEditable(false);
/* 105 */     this.txtRuta1.setText("...");
/* 106 */     this.txtRuta1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 108 */         frmHappy.this.txtRuta1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 112 */     this.txtRuta2.setEditable(false);
/* 113 */     this.txtRuta2.setText("...");
/*     */ 
/* 115 */     this.jLabel1.setText("Selecciona archivos:");
/*     */ 
/* 117 */     this.btnGenerar.setIcon(new ImageIcon(getClass().getResource("/res/wand.png")));
/* 118 */     this.btnGenerar.setText("Click para generar");
/* 119 */     this.btnGenerar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 121 */         frmHappy.this.btnGenerarActionPerformed(evt);
/*     */       }
/*     */     });
/* 125 */     this.jLabel2.setText("@ramayac");
/*     */ 
/* 127 */     this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/res/emoticon_happy.png")));
/* 128 */     this.jLabel3.setText("Happy Monday Report!!!");
/*     */ 
/* 130 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 131 */     getContentPane().setLayout(layout);
/* 132 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnDoc2, -1, -1, 32767).addComponent(this.btnDoc1, -1, 208, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtRuta2, -1, 186, 32767).addComponent(this.txtRuta1, -1, 186, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1, -1, 98, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator2, -2, 302, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addContainerGap()))))).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING, -1, 420, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.btnGenerar, -1, 400, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(359, 32767).addComponent(this.jLabel2).addContainerGap()));
/*     */ 
/* 164 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator2, -2, 10, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnDoc1, -2, 38, -2).addComponent(this.txtRuta1, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnDoc2, -2, 38, -2).addComponent(this.txtRuta2, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 10, -2).addGap(1, 1, 1).addComponent(this.btnGenerar, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addGap(5, 5, 5)));
/*     */ 
/* 191 */     pack();
/*     */   }
/*     */ 
/*     */   private void txtRuta1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void btnDoc1ActionPerformed(ActionEvent evt)
/*     */   {
/* 200 */     int returnVal = this.fc.showOpenDialog(this);
/*     */ 
/* 202 */     if (returnVal == 0) {
/* 203 */       this.file1 = this.fc.getSelectedFile();
/*     */ 
/* 205 */       this.txtRuta1.setText(this.file1.getPath());
/* 206 */       this.flag1 = true;
/*     */     }
/*     */     else {
/* 209 */       this.txtRuta1.setText("Error");
/* 210 */       this.file1 = null;
/* 211 */       this.flag1 = false;
/*     */     }
/* 213 */     habilitarBotonGenerar();
/*     */   }
/*     */ 
/*     */   private void btnDoc2ActionPerformed(ActionEvent evt) {
/* 217 */     int returnVal = this.fc.showOpenDialog(this);
/*     */ 
/* 219 */     if (returnVal == 0) {
/* 220 */       this.file2 = this.fc.getSelectedFile();
/*     */ 
/* 222 */       this.txtRuta2.setText(this.file2.getPath());
/* 223 */       this.flag2 = true;
/*     */     }
/*     */     else {
/* 226 */       this.txtRuta2.setText("Error");
/* 227 */       this.file2 = null;
/* 228 */       this.flag2 = false;
/*     */     }
/* 230 */     habilitarBotonGenerar();
/*     */   }
/*     */ 
/*     */   private void btnGenerarActionPerformed(ActionEvent evt) {
/*     */     try {
/* 235 */       xlsProcesador xls = new xlsProcesador();
/* 236 */       File f = xls.processDocuments(this.file1.getCanonicalPath(), this.file2.getCanonicalPath(), "resultado.xls");
/* 237 */       cleanAll();
/* 238 */       JOptionPane.showMessageDialog(this, "Listo!, archivo almacenado en:\n\"" + f.getCanonicalPath() + "\"");
/*     */     } catch (Exception ex) {
/* 240 */       JOptionPane.showMessageDialog(this, "Ocurrio un Error!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 248 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 250 */         new frmHappy().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void cleanAll()
/*     */   {
/* 268 */     this.txtRuta1.setText("...");
/* 269 */     this.txtRuta2.setText("...");
/* 270 */     this.flag1 = false;
/* 271 */     this.flag2 = false;
/* 272 */     this.btnGenerar.setEnabled(false);
/*     */   }
/*     */ }

/* Location:           C:\Users\ramayac\Desktop\HappyIndex\HappyMonday.jar
 * Qualified Name:     gui.frmHappy
 * JD-Core Version:    0.6.0
 */