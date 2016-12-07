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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meidy
 */
public class Customer extends JFrame{
    String jenisidentitas = "";
    int jnsidentitas;
    String isiPesanBerhasil = "";
    String isiPesanGagal = "";
    
    Vector<Object> rowName;
    Vector<Vector<Object>> dataCustomer = null;
    
    JTable tblCustomer;
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
    JPanel panelCustomer;
    
    public Customer (){
//        setTitle("Data Kendaraan");
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
        selectdbCustomer();   
        dataCustomer();
        
//        setVisible(true);
    }
    
    private void dataCustomer(){
        // Membuat Panel
        JPanel panelTabel = new JPanel(new GridLayout(1,1));
        panelTabel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelDtCustomer = new JPanel(new GridLayout(9,4,10,10));
        panelDtCustomer.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelButton = new JPanel(new GridLayout(1,2,50,50));
        panelButton.setBorder(new EmptyBorder(15, 50, 10, 50));
        JPanel paneljnsid = new JPanel(new GridLayout(1,2));
        JPanel panelRB = new JPanel(new GridLayout(1,2));
        JPanel panelRBStts = new JPanel(new GridLayout(1,2));
        
        // Membuat Tabel
        rowName = new Vector<Object>();
        rowName.add("No. Identitas");
        rowName.add("Jenis Identitas");
        rowName.add("Nama Depan");
        rowName.add("Nama Belakang");
        rowName.add("Tanggal Lahir");
        rowName.add("Alamat");
        rowName.add("No. Handphone");
        rowName.add("Email");
        tblCustomer = new JTable(dataCustomer, rowName);
        tblCustomer.setEnabled(false);
        SP = new JScrollPane(tblCustomer);
        
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
        JLabel lblKosong7 = new JLabel("");       
        JLabel lblKosong8 = new JLabel("");       
        
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
        panelDtCustomer.add(lblKode);
        panelDtCustomer.add(txtKode);
        panelDtCustomer.add(btnCari);
        panelDtCustomer.add(lblKosong);
        panelDtCustomer.add(lblNmDepan);
        panelDtCustomer.add(txtNmDepan);
        panelDtCustomer.add(lblNmBlkg);
        panelDtCustomer.add(txtNmBlkg);
        panelDtCustomer.add(lblJnsID);
        panelDtCustomer.add(txtJnsID);
        panelDtCustomer.add(lblNoId);
        panelDtCustomer.add(txtNoId);
        panelDtCustomer.add(lblJnsKlmin);
        panelDtCustomer.add(panelRB);
        panelDtCustomer.add(lblKosong1);
        panelDtCustomer.add(lblKosong2);
        panelDtCustomer.add(lblTmptLhr);
        panelDtCustomer.add(txtTmptLhr);
        panelDtCustomer.add(lblTgLhr);
        panelDtCustomer.add(tglLahir);
        panelDtCustomer.add(lblAlmt);
        panelDtCustomer.add(txtAlmt);
        panelDtCustomer.add(lblKosong3);
        panelDtCustomer.add(lblKosong4);
        panelDtCustomer.add(lblTlp);
        panelDtCustomer.add(txtTlp);
        panelDtCustomer.add(lblHp);
        panelDtCustomer.add(txtHp);
        panelDtCustomer.add(lblEmail);
        panelDtCustomer.add(txtEmail);
        panelDtCustomer.add(lblKosong5);
        panelDtCustomer.add(lblKosong6);
        panelDtCustomer.add(lblSts);
        panelDtCustomer.add(panelRBStts);

        
        //Panel Button
        panelButton.add(btnSmpn);
        panelButton.add(btnEdit);
        
       //Fungsi mengambil data dari tabel
        tblCustomer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int row = tblCustomer.rowAtPoint(e.getPoint());

                String kode = tblCustomer.getValueAt(row, 0).toString();
                
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
        
//        //Membuat Fungsi Button
//        bSimpan.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(rKTP.isSelected()){
//                    jenisidentitas="KTP";
//                } else if (rPaspor.isSelected()){
//                    jenisidentitas="Paspor";
//                }
//                
//                insertdbCustomer();
//                clearTextField();
//                selectdbCustomer();
//                tblCustomer.setModel(new DefaultTableModel(dataCustomer, rowName));
//            }
//        });
// 
//        bUbah.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(rKTP.isSelected()){
//                    jenisidentitas="KTP";
//                } else if (rPaspor.isSelected()){
//                    jenisidentitas="Paspor";
//                }
//
//                updatedbCustomer();
//                clearTextField();
//                selectdbCustomer();
//                tblCustomer.setModel(new DefaultTableModel(dataCustomer, rowName));
//            }
//        });
        
        // Deklarasi Panel
        panelCustomer = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelCustomer, BoxLayout.Y_AXIS);
        
        panelCustomer.setLayout(boxLayout);
        
        panelCustomer.add(panelTabel);
        panelCustomer.add(panelDtCustomer);
        panelCustomer.add(panelButton);
        
        add(panelCustomer);
    }

    
//    private void clearTextField(){
//        tnoid.setText("");
//        tnamadepan.setText("");
//        tnamabelakang.setText("");
//        ttgllahir.setText("");
//        talamat.setText("");
//        tnohp.setText("");
//        temail.setText("");
//        rKTP.setSelected(false);
//        rPaspor.setSelected(false);
//    }
//    
    private void Berhasil(){
        JOptionPane.showMessageDialog(null,isiPesanBerhasil,"Informasi Database",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void Gagal(){
        JOptionPane.showMessageDialog(null,isiPesanGagal,"Informasi Database",JOptionPane.ERROR_MESSAGE);
    }
//    
//    
//    //DATABASE
//    private void insertdbCustomer(){
//        try {
//        // Memanggil Database
//        koneksi db = new koneksi();
//        System.out.println(db.isConnected());
//       
//        // Menghubungkan ke koneksi >> insertData
//        db.insertDataCustomer(tnoid.getText(),jenisidentitas,tnamadepan.getText(), tnamabelakang.getText(), ttgllahir.getText(), 
//                talamat.getText(), tnohp.getText(), temail.getText());
//        
//        isiPesanBerhasil = "Data Berhasil Disimpan";
//        Berhasil();
//        } catch (Exception e) {
//            System.out.println(e);
//            isiPesanGagal = "Data Tidak Berhasil Disimpan";
//            Gagal();
//        }        
//    }
//
//    private void updatedbCustomer(){
//        try {
//        // Memanggil Database
//        koneksi db = new koneksi();
//        System.out.println(db.isConnected());
//        
//        // Menghubungkan ke koneksi >> updateData
//        db.updateDataCustomer (tnoid.getText(),jenisidentitas,tnamadepan.getText(), tnamabelakang.getText(), ttgllahir.getText(), 
//                talamat.getText(), tnohp.getText(), temail.getText());
//        
//        isiPesanBerhasil = "Data Berhasil Diperbaharui";
//        Berhasil();
//        } catch (Exception e) {
//            System.out.println(e);
//            isiPesanGagal = "Data Tidak Berhasil Diperbaharui";
//            Gagal();
//        }        
//    }    
//
    private void selectdbCustomer(){
        try {
        // Memanggil Database
        koneksi db = new koneksi();
        System.out.println(db.isConnected());
        
        // Menghubungkan ke koneksi >> selectData
        dataCustomer = db.selectDataCustomer();
        
        } catch (Exception e) {
            System.out.println(e);
            isiPesanGagal = "Data Tidak Berhasil Diambil";
            Gagal();
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Customer();
    }
    
}
