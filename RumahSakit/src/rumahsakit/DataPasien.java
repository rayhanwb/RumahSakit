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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        TabelPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPasien);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Data Pasien");

        jTextFieldNama.setToolTipText("");
        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jTextFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAlamatActionPerformed(evt);
            }
        });

        jTextFieldTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTeleponActionPerformed(evt);
            }
        });

        jLabel4.setText("Telepon");

        jLabel5.setText("Darah");

        jTextFieldDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDarahActionPerformed(evt);
            }
        });

        jLabel6.setText("Tanggal Lahir");

        jTextFieldTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTLActionPerformed(evt);
            }
        });

        jLabel7.setText("NIK");

        jLabel8.setText("Jenis Kelamin");

        jTextFieldNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNIKActionPerformed(evt);
            }
        });

        buttonNew.setLabel("New");
        buttonNew.setName(""); // NOI18N
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        buttonUpdate.setLabel("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setLabel("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonSave.setLabel("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jComboBoxJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));
        jComboBoxJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBoxJK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(46, 46, 46))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(55, 55, 55)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7))
                                            .addGap(20, 20, 20)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTL, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldDarah, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDarah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxJK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldDarah;
    private javax.swing.JTextField jTextFieldNIK;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTL;
    private javax.swing.JTextField jTextFieldTelepon;
    // End of variables declaration//GEN-END:variables
}
