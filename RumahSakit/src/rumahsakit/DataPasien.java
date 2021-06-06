/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author X230
 */
public class DataPasien extends javax.swing.JFrame {
DefaultTableModel tabModel;
ResultSet RsProduk=null;
    /**
     * Creates new form DataPasien
     */
    public DataPasien() {
        initComponents();
        showData();
    }

        private void showData(){
        try{
            Object[] judul_kolom = {"id_pasien", "nik", "nama", "alamat", "telepon", "tglahir", "goldar", "gender"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelPasien.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from pasien ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("id_pasien"),
                    RsProduk.getString("nik"),
                    RsProduk.getString("nama"),
                    RsProduk.getString("alamat"),
                    RsProduk.getString("telepon"),
                    RsProduk.getString("tglahir"),
                    RsProduk.getString("goldar"), 
                    RsProduk.getString("gender") 
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
   
    //show data to form when click data on table
    //menampilkan data ke form saat data pada tabel di klik
    void tableToForm(){
        jTextFieldNIK.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),1)+"");
        jTextFieldNama.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),2)+"");
        jTextFieldAlamat.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),3)+"");
        jTextFieldTelepon.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),4)+"");
        jTextFieldTL.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),5)+"");
        jTextFieldDarah.setText(tabModel.getValueAt(TabelPasien.getSelectedRow(),6)+"");
        jComboBoxJK.setSelectedItem(tabModel.getValueAt(TabelPasien.getSelectedRow(),7)+"");
        
        buttonUpdate.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonSave.setEnabled(false);
    }
    
    //clear the form
    //membersihkan isian form 
    private void clearData(){
        
        jTextFieldNIK.setText("");
        jTextFieldNama.setText(""); 
        jTextFieldAlamat.setText("");
        jTextFieldTelepon.setText("");
        jTextFieldTL.setText("");
        jTextFieldDarah.setText("");
        jComboBoxJK.setSelectedIndex(0);
        
    } 
    
    //disable to fill in form
    //tidak membolehkan untuk mengisi form
    private void SetEditOff(){
        jTextFieldNIK.setEnabled(false);
        jTextFieldNama.setEnabled(false); 
        jTextFieldAlamat.setEnabled(false);
        jTextFieldTelepon.setEnabled(false);
        jTextFieldTL.setEnabled(false);
        jTextFieldDarah.setEnabled(false);
        jComboBoxJK.setEnabled(false);
    }
    
    //enable to fill in form
    //membolehkan untuk mengisi form
    private void seteditOn(){
        jTextFieldNIK.setEnabled(true);
        jTextFieldNama.setEnabled(true); 
        jTextFieldAlamat.setEnabled(true);
        jTextFieldTelepon.setEnabled(true);
        jTextFieldTL.setEnabled(true);
        jTextFieldDarah.setEnabled(true);
        jComboBoxJK.setEnabled(true);
    }
 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAlamat = new javax.swing.JTextField();
        jTextFieldTelepon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDarah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNIK = new javax.swing.JTextField();
        buttonNew = new java.awt.Button();
        buttonUpdate = new java.awt.Button();
        buttonDelete = new java.awt.Button();
        buttonSave = new java.awt.Button();
        jComboBoxJK = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1117, 630));
        setPreferredSize(new java.awt.Dimension(1117, 630));
        getContentPane().setLayout(null);

        TabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TabelPasien);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 50, 739, 510);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Data Pasien");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 194, 47);

        jTextFieldNama.setToolTipText("");
        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNama);
        jTextFieldNama.setBounds(140, 72, 161, 24);

        jLabel2.setText("Nama");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(43, 76, 70, 16);

        jLabel3.setText("Alamat");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(43, 118, 40, 16);

        jTextFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAlamatActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAlamat);
        jTextFieldAlamat.setBounds(140, 114, 161, 24);

        jTextFieldTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTeleponActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelepon);
        jTextFieldTelepon.setBounds(140, 156, 161, 24);

        jLabel4.setText("Telepon");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(43, 160, 45, 16);

        jLabel5.setText("Darah");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(43, 202, 34, 16);

        jTextFieldDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDarahActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldDarah);
        jTextFieldDarah.setBounds(140, 198, 161, 24);

        jLabel6.setText("Tanggal Lahir");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(43, 244, 77, 16);

        jTextFieldTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTLActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTL);
        jTextFieldTL.setBounds(140, 240, 161, 24);

        jLabel7.setText("NIK");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(43, 286, 80, 16);

        jLabel8.setText("Jenis Kelamin");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(43, 329, 80, 16);

        jTextFieldNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNIKActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNIK);
        jTextFieldNIK.setBounds(140, 282, 161, 24);

        buttonNew.setLabel("New");
        buttonNew.setName(""); // NOI18N
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        getContentPane().add(buttonNew);
        buttonNew.setBounds(43, 379, 41, 24);

        buttonUpdate.setLabel("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate);
        buttonUpdate.setBounds(94, 379, 56, 24);

        buttonDelete.setLabel("Delete");
        getContentPane().add(buttonDelete);
        buttonDelete.setBounds(160, 379, 52, 24);

        buttonSave.setLabel("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave);
        buttonSave.setBounds(222, 379, 57, 24);

        jComboBoxJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));
        jComboBoxJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJKActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxJK);
        jComboBoxJK.setBounds(141, 324, 160, 26);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Logo-PBO-kecil-bgt.png"))); // NOI18N
        jLabel10.setText("iconjan");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 20, 30, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Bg-PBO-coab.jpg"))); // NOI18N
        jLabel9.setText("buatbg");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1100, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

    private void jTextFieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAlamatActionPerformed

    private void jTextFieldTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTeleponActionPerformed

    private void jTextFieldDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDarahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDarahActionPerformed

    private void jTextFieldTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTLActionPerformed

    private void jTextFieldNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNIKActionPerformed

    //process for making new data
    //proses untuk membuat data data
    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        // TODO add your handling code here:
        clearData();
        buttonSave.setEnabled(true);
        buttonUpdate.setEnabled(false);
        buttonDelete.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_buttonNewActionPerformed

    //process for deleting data
    //proses untuk menghapus data
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();

        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextFieldNama.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM pasien WHERE nama='"+nama+"'");
            clearData();
            showData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    //process for updating data
    //proses untuk memperbaharui data
    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();
        String jk=jComboBoxJK.getSelectedItem().toString();
        String nik=jTextFieldNIK.getText();
        String alamat=jTextFieldAlamat.getText();
        String telepon=jTextFieldTelepon.getText();
        String tl=jTextFieldTL.getText();
        String darah=jTextFieldDarah.getText();        
        
        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh dikosongkan!");
            jTextFieldNama.requestFocus();
        }else if (nik.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NIK tidak boleh dikosongkan!");
            jTextFieldNIK.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh dikosongkan!");
            jTextFieldAlamat.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Telepon tidak boleh dikosongkan!");
            jTextFieldTelepon.requestFocus();
        }else if (tl.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Tanggal lahir tidak boleh dikosongkan!");
            jTextFieldTL.requestFocus();
        }else if (darah.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Darah tidak boleh dikosongkan!");
            jTextFieldDarah.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE pasien SET nik='"+nik+"', nama='"+nama+"' , alamat='"+alamat+"', telepon='"+telepon+"', tglahir='"+tl+"', goldar='"+darah+"', gender='"+jk+"' WHERE nama='"+nama+"'");
                clearData();
                showData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void jComboBoxJKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxJKActionPerformed

    //handling process when click data on pasien table
    //menangani proses saat tabel pasien di klik
    private void TabelPasienMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        seteditOn();
        tableToForm();
    }       
 
    //process for saving data
    //proses untuk menyimpan data
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();
        String jk=jComboBoxJK.getSelectedItem().toString();
        String nik=jTextFieldNIK.getText();
        String alamat=jTextFieldAlamat.getText();
        String telepon=jTextFieldTelepon.getText();
        String tl=jTextFieldTL.getText();
        String darah=jTextFieldDarah.getText();        
        
        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh dikosongkan!");
            jTextFieldNama.requestFocus();
        }else if (nik.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NIK tidak boleh dikosongkan!");
            jTextFieldNIK.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh dikosongkan!");
            jTextFieldAlamat.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Telepon tidak boleh dikosongkan!");
            jTextFieldTelepon.requestFocus();
        }else if (tl.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Tanggal lahir tidak boleh dikosongkan!");
            jTextFieldTL.requestFocus();
        }else if (darah.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Darah tidak boleh dikosongkan!");
            jTextFieldDarah.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("INSERT INTO pasien(nik, nama, alamat, telepon, tglahir, goldar, gender)"+
                    "VALUES('"+nik+"','"+nama+"','"+alamat+"','"+telepon+"','"+tl+"','"+darah+"','"+jk+"')");
                clearData();
                showData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPasien;
    private java.awt.Button buttonDelete;
    private java.awt.Button buttonNew;
    private java.awt.Button buttonSave;
    private java.awt.Button buttonUpdate;
    private javax.swing.JComboBox<String> jComboBoxJK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldDarah;
    private javax.swing.JTextField jTextFieldNIK;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTL;
    private javax.swing.JTextField jTextFieldTelepon;
    // End of variables declaration//GEN-END:variables
}
