/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.koneksi;
import datechooser.beans.DateChooserCombo;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
/**
 *
 * @author Deza Farras Tsany
 */
public class clsPelanggan extends JFrame{
    // Tabel
    Vector<Object> rowName;
    Vector<Vector<Object>> dataPelanggan = null;
    
    JTable tblPelanggan;
    JScrollPane SP;
    
    // Text Field
    JTextField txtKode;
    JTextField txtNmDepan;
    JTextField txtNmBlkg;
    JTextField txtJnsID;
    JTextField txtNoId;
    JTextField txtJnsKlmin;
    JTextField txtTmptLhr;
    JTextField txtTgLhr;
    JTextField txtAlmt;
    JTextField txtTlp;
    JTextField txtHp;
    JTextField txtEmail;
    JTextField txtSts;
    JTextField txtKosong;
    
    // Kalender
    DateChooserCombo tglLahir;
    
    // Radio Button
    JRadioButton rdLaki, rdPerempuan, rbBlm, rbMenikah;
    ButtonGroup bgGender, bgStts;
    
    // Panel
    JPanel panelPelanggan;
    
    public clsPelanggan(){
        viewPelanggan();
    }
    
    private void viewPelanggan(){
        // Membuat Panel
        JPanel panelTabel = new JPanel(new GridLayout(1,1));
        panelTabel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelDtPelanggan = new JPanel(new GridLayout(9,4,10,10));
        panelDtPelanggan.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelButton = new JPanel(new GridLayout(1,2,50,50));
        panelButton.setBorder(new EmptyBorder(15, 50, 10, 50));
        JPanel panelRB = new JPanel(new GridLayout(1,2));
        JPanel panelRBStts = new JPanel(new GridLayout(1,2));
        
        // Membuat Tabel
        rowName = new Vector<Object>();
        rowName.add("Kode Konsumen");
        rowName.add("Nama Depan");
        rowName.add("Nama Belakang");
        rowName.add("Jenis Id");
        rowName.add("Nomor Identitas");
        rowName.add("Jenis Kelamin");
        rowName.add("Tanggal Lahir");
        rowName.add("Nomor Telepon");
        tblPelanggan = new JTable(dataPelanggan, rowName);
        tblPelanggan.setEnabled(false);
        SP = new JScrollPane(tblPelanggan);
        
        //Membuat Label
        JLabel lblKode = new JLabel("Kode Konsumen");
        JLabel lblNmDepan = new JLabel("Nama Depam");
        JLabel lblNmBlkg = new JLabel("Nama Belakang");
        JLabel lblJnsID = new JLabel("Jenis Id");
        JLabel lblNoId = new JLabel("Nomor Id");
        JLabel lblJnsKlmin = new JLabel("Jenis Kelamin");
        JLabel lblTmptLhr = new JLabel("Tempat Lahir");
        JLabel lblTgLhr = new JLabel("Tanggal Lahir");
        JLabel lblAlmt = new JLabel("Alamat");
        JLabel lblTlp = new JLabel("Nomor Telepon");
        JLabel lblHp = new JLabel("Nomor Hp");
        JLabel lblEmail = new JLabel("E-mail");
        JLabel lblSts = new JLabel("Status Pernikahan");
        JLabel lblKosong = new JLabel("");       
        JLabel lblKosong1 = new JLabel("");       
        JLabel lblKosong2 = new JLabel("");       
        JLabel lblKosong3 = new JLabel("");       
        JLabel lblKosong4 = new JLabel("");       
        JLabel lblKosong5 = new JLabel("");       
        JLabel lblKosong6 = new JLabel("");       
        
        //Membuat Text Field
        txtKode = new JTextField();
        txtNmDepan = new JTextField();
        txtNmBlkg = new JTextField();
        txtJnsID = new JTextField();
        txtNoId = new JTextField();
        txtJnsKlmin = new JTextField();
        txtTmptLhr = new JTextField();
        txtTgLhr = new JTextField();
        txtAlmt = new JTextField();
        txtTlp = new JTextField();
        txtHp = new JTextField();
        txtEmail = new JTextField();
        txtSts = new JTextField();
        txtKosong = new JTextField();
        
        // Membuat Radio Button
        rdLaki = new JRadioButton("Laki - Laki");
        rdPerempuan = new JRadioButton("Perempuan");
        bgGender = new ButtonGroup();
        bgGender.add(rdLaki);
        bgGender.add(rdPerempuan);
        
        rbBlm = new JRadioButton("Belum Menikah");
        rbMenikah = new JRadioButton("Menikah");
        bgStts = new ButtonGroup();
        bgStts.add(rbBlm);
        bgStts.add(rbMenikah);
        
        // kalender
        tglLahir = new DateChooserCombo();
      
        //Membuat Button
        JButton btnCari = new JButton("Cari");
        JButton btnSmpn = new JButton("Simpan");
        JButton btnEdit = new JButton("Edit");
        
        //Set Panel
        //Panel Tabel
        panelTabel.add(SP);
        
        //Panel RB
        panelRB.add(rdLaki);
        panelRB.add(rdPerempuan);
        
        panelRBStts.add(rbBlm);
        panelRBStts.add(rbMenikah);
        
        //Panel Data Pelanggan
        panelDtPelanggan.add(lblKode);
        panelDtPelanggan.add(txtKode);
        panelDtPelanggan.add(btnCari);
        panelDtPelanggan.add(lblKosong);
        panelDtPelanggan.add(lblNmDepan);
        panelDtPelanggan.add(txtNmDepan);
        panelDtPelanggan.add(lblNmBlkg);
        panelDtPelanggan.add(txtNmBlkg);
        panelDtPelanggan.add(lblJnsID);
        panelDtPelanggan.add(txtJnsID);
        panelDtPelanggan.add(lblNoId);
        panelDtPelanggan.add(txtNoId);
        panelDtPelanggan.add(lblJnsKlmin);
        panelDtPelanggan.add(panelRB);
        panelDtPelanggan.add(lblKosong1);
        panelDtPelanggan.add(lblKosong2);
        panelDtPelanggan.add(lblTmptLhr);
        panelDtPelanggan.add(txtTmptLhr);
        panelDtPelanggan.add(lblTgLhr);
        panelDtPelanggan.add(tglLahir);
        panelDtPelanggan.add(lblAlmt);
        panelDtPelanggan.add(txtAlmt);
        panelDtPelanggan.add(lblKosong3);
        panelDtPelanggan.add(lblKosong4);
        panelDtPelanggan.add(lblTlp);
        panelDtPelanggan.add(txtTlp);
        panelDtPelanggan.add(lblHp);
        panelDtPelanggan.add(txtHp);
        panelDtPelanggan.add(lblEmail);
        panelDtPelanggan.add(txtEmail);
        panelDtPelanggan.add(lblKosong5);
        panelDtPelanggan.add(lblKosong6);
        panelDtPelanggan.add(lblSts);
        panelDtPelanggan.add(panelRBStts);
        
        //Panel Button
        panelButton.add(btnSmpn);
        panelButton.add(btnEdit);
        
        //Fungsi mengambil data dari tabel
        tblPelanggan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int row = tblPelanggan.rowAtPoint(e.getPoint());

                String kode = tblPelanggan.getValueAt(row, 0).toString();
                
                txtKode.setText(String.valueOf(kode));
                
            }                    
        });
        
        // Membuat Tidak Bisa Huruf
        txtTlp.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                        (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        txtHp.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });        
        
//        //Fungsi Combo box
//        cbStsMobil.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                statusMobil = (String)cbStsMobil.getSelectedItem();
//            }
//        });
//        
//        // Fungsi Button
//        btnSmpn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(rdBaru.isSelected()){
//                    kondisMobil="Baru";
//                } else if (rdBekas.isSelected()){
//                    kondisMobil="Bekas";
//                }
//                
//                if(statusMobil.equals("Terjual")){
//                    sttsMobil = 1;
//                } else {
//                    sttsMobil = 0;
//                }
//                
//                insertDatabase();
//                bersihkanTextfield();
//                selectDatabase();
//                tblMobil.setModel(new DefaultTableModel(dataMobil, rowName));
//            }
//        });
//        
//        btnEdit.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(rdBaru.isSelected()){
//                    kondisMobil="Baru";
//                } else if (rdBekas.isSelected()){
//                    kondisMobil="Bekas";
//                }
//                
//                if(statusMobil.equals("Terjual")){
//                    sttsMobil = 1;
//                } else {
//                    sttsMobil = 0;
//                }
//                
//                updateDatabase();
//                bersihkanTextfield();
//                selectDatabase();
//                tblMobil.setModel(new DefaultTableModel(dataMobil, rowName));
//            }
//        });
        
        // Deklarasi Panel
        panelPelanggan = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelPelanggan, BoxLayout.Y_AXIS);
        
        panelPelanggan.setLayout(boxLayout);
        
        panelPelanggan.add(panelTabel);
        panelPelanggan.add(panelDtPelanggan);
        panelPelanggan.add(panelButton);
        
//        add(panelMobil);
    }
    
    public static void main(String[] args) {
        new clsPelanggan();
    }
}
    
    
