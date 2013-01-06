package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import xls.XlsProcesador;

public class frmHappy extends JFrame {

    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel 2003", new String[]{"xls"});
    final JFileChooser fc = new JFileChooser();
    File file1;
    File file2;
    boolean flag1 = false;
    boolean flag2 = false;
    private JButton btnDoc1;
    private JButton btnDoc2;
    private JButton btnGenerar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField txtRuta1;
    private JTextField txtRuta2;

    private void habilitarBotonGenerar() {
        if ((this.flag1) && (this.flag2)) {
            this.btnGenerar.setEnabled(true);
        } else {
            this.btnGenerar.setEnabled(false);
        }
    }

    public frmHappy() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        initComponents();
        this.fc.addChoosableFileFilter(this.filter);
        this.fc.setAcceptAllFileFilterUsed(false);
        this.fc.setMultiSelectionEnabled(false);
        this.btnGenerar.setEnabled(false);
    }

    private void initComponents() {
        this.btnDoc1 = new JButton();
        this.btnDoc2 = new JButton();
        this.txtRuta1 = new JTextField();
        this.txtRuta2 = new JTextField();
        this.jSeparator1 = new JSeparator();
        this.jSeparator2 = new JSeparator();
        this.jLabel1 = new JLabel();
        this.btnGenerar = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("Happy Analisis");
        setResizable(false);

        this.btnDoc1.setIcon(new ImageIcon(getClass().getResource("/res/page_excel.png")));
        this.btnDoc1.setText("Archivo Semestral");
        this.btnDoc1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                frmHappy.this.btnDoc1ActionPerformed(evt);
            }
        });
        this.btnDoc2.setIcon(new ImageIcon(getClass().getResource("/res/page_excel.png")));
        this.btnDoc2.setText("Archivo Bimestral");
        this.btnDoc2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                frmHappy.this.btnDoc2ActionPerformed(evt);
            }
        });
        this.txtRuta1.setEditable(false);
        this.txtRuta1.setText("...");
        /*this.txtRuta1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                frmHappy.this.txtRuta1ActionPerformed(evt);
            }
        });*/
        this.txtRuta2.setEditable(false);
        this.txtRuta2.setText("...");

        this.jLabel1.setText("Selecciona archivos:");

        this.btnGenerar.setIcon(new ImageIcon(getClass().getResource("/res/wand.png")));
        this.btnGenerar.setText("Click para generar");
        this.btnGenerar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                frmHappy.this.btnGenerarActionPerformed(evt);
            }
        });
        this.jLabel2.setText("@ramayac");

        this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/res/emoticon_happy.png")));
        this.jLabel3.setText("Happy Analisis!!!");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnDoc2, -1, -1, 32767).addComponent(this.btnDoc1, -1, 208, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtRuta2, -1, 186, 32767).addComponent(this.txtRuta1, -1, 186, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1, -1, 98, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator2, -2, 302, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addContainerGap()))))).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING, -1, 420, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.btnGenerar, -1, 400, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(359, 32767).addComponent(this.jLabel2).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator2, -2, 10, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnDoc1, -2, 38, -2).addComponent(this.txtRuta1, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnDoc2, -2, 38, -2).addComponent(this.txtRuta2, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 10, -2).addGap(1, 1, 1).addComponent(this.btnGenerar, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addGap(5, 5, 5)));

        pack();
    }

    private void btnDoc1ActionPerformed(ActionEvent evt) {
        int returnVal = this.fc.showOpenDialog(this);

        if (returnVal == 0) {
            this.file1 = this.fc.getSelectedFile();

            this.txtRuta1.setText(this.file1.getPath());
            this.flag1 = true;
        } else {
            this.txtRuta1.setText("Error");
            this.file1 = null;
            this.flag1 = false;
        }
        habilitarBotonGenerar();
    }

    private void btnDoc2ActionPerformed(ActionEvent evt) {
        int returnVal = this.fc.showOpenDialog(this);

        if (returnVal == 0) {
            this.file2 = this.fc.getSelectedFile();

            this.txtRuta2.setText(this.file2.getPath());
            this.flag2 = true;
        } else {
            this.txtRuta2.setText("Error");
            this.file2 = null;
            this.flag2 = false;
        }
        habilitarBotonGenerar();
    }

    private void btnGenerarActionPerformed(ActionEvent evt) {
        try {
            XlsProcesador xls = new XlsProcesador();
            File f = xls.processDocuments(this.file1.getCanonicalPath(), this.file2.getCanonicalPath(), "resultado.xls");
            cleanAll();
            JOptionPane.showMessageDialog(this, "Listo!, archivo almacenado en:\n\"" + f.getCanonicalPath() + "\"");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio un Error!");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmHappy().setVisible(true);
            }
        });
    }

    private void cleanAll() {
        this.txtRuta1.setText("...");
        this.txtRuta2.setText("...");
        this.flag1 = false;
        this.flag2 = false;
        this.btnGenerar.setEnabled(false);
    }
}
