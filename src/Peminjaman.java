
import database.koneksi;
import datechooser.beans.DateChooserCombo;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deza Farras Tsany
 */
public class Peminjaman extends JFrame{
    String isiPesanBerhasil = "";
    String isiPesanGagal = "";
    String sTglPinjam = "";
    String sTglKembali = "";
    String[] KodePinjam;
    long temp2 = 0;
    
    // Date Chooser
    DateChooserCombo tglPinjam;
    DateChooserCombo tglKembali;
    
    // Tabel
    Vector<Object> rowName;
    Vector<Object> kodeP;
    Vector<Vector<Object>> dataMobil = null;
    
    JTable tblPinjam;
    JScrollPane SP;
    
    // Text Field
    JTextField txtPlatNo;
    JTextField txtMerkMobil;
    JTextField txtTipeMobil;
    JTextField txtWrnMobil;
    JTextField txtKode;
    JTextField txtNmDepan;
    JTextField txtNmBlkg;
    JTextField txtJnsID;
    JTextField txtNoId;
    JTextField txtTot;
    JTextField txtDeposit;
    
    JLabel lblKode;
    
    // Panel
    JPanel dtPeminjaman;
    
    public Peminjaman(){
//        setTitle("Data Peminjaman");
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        
        dataPeminjaman();
        KodePinjam();
        
        
//        setVisible(true);
    }
    
    private void dataPeminjaman(){
        // Membuat Panel
        JPanel panelTgl = new JPanel(new GridLayout(1,2,10,10));
        panelTgl.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelP = new JPanel(new BorderLayout(10, 10));
        panelP.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelTabel = new JPanel(new GridLayout(1,1));
        panelTabel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelDtPeminjaman = new JPanel(new GridLayout(7,4,10,10));
        panelDtPeminjaman.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBorder(new EmptyBorder(15, 50, 10, 50));
        JPanel panelKonsumen = new JPanel(new BorderLayout(10, 10));
        
        // Membuat Tabel
        rowName = new Vector<Object>();
        rowName.add("Plat Nomor");
        rowName.add("Merk Mobil");
        rowName.add("Tipe Mobil");
        rowName.add("Warna Mobil");
        rowName.add("Tahun Mobil");
        rowName.add("Kondisi Mobil");
        rowName.add("Harga Sewa");
        rowName.add("Biaya Denda");
        tblPinjam = new JTable(dataMobil, rowName);
        tblPinjam.setEnabled(false);
        SP = new JScrollPane(tblPinjam);
                
        // Label
        JLabel lblTglPinjam = new JLabel("Tanggal Peminjaman");
        JLabel lblTglKembali = new JLabel("Tanggal Selesai Peminjaman");
        JLabel lblKPinjam = new JLabel("Kode Peminjaman");
        lblKode = new JLabel();
        JLabel lblPlatNo = new JLabel("Plat Nomor");
        JLabel lblMerkMobil = new JLabel("Merek Mobil");
        JLabel lblTipeMobil = new JLabel("Tipe Mobil");
        JLabel lblWrnMobil = new JLabel("Warna Mobil");
        JLabel lblKonsumen = new JLabel("Kode Konsumen");
//        JLabel lblNmDepan = new JLabel("Nama Depam");
//        JLabel lblNmBlkg = new JLabel("Nama Belakang");
//        JLabel lblJnsID = new JLabel("Jenis Id");
//        JLabel lblNoId = new JLabel("Nomor Id");
        JLabel lblTot = new JLabel("Total");
        JLabel lblDeposit = new JLabel("Deposit");
        JLabel lblKosong = new JLabel("");       
        JLabel lblKosong1 = new JLabel(""); 
        JLabel lblKosong2 = new JLabel(""); 
        JLabel lblKosong3 = new JLabel(""); 
        JLabel lblKosong4 = new JLabel(""); 
        JLabel lblKosong5 = new JLabel(""); 
        JLabel lblKosong6 = new JLabel(""); 
        JLabel lblKosong7 = new JLabel(""); 
        JLabel lblKosong8 = new JLabel(""); 
        JLabel lblKosong9 = new JLabel(""); 
        
        //Membuat Text Field
        txtPlatNo = new JTextField();
        txtMerkMobil = new JTextField();
        txtTipeMobil = new JTextField();
        txtWrnMobil = new JTextField();
        txtKode = new JTextField();
//        txtNmDepan = new JTextField();
//        txtNmBlkg = new JTextField();
//        txtJnsID = new JTextField();
//        txtNoId = new JTextField();
        txtTot = new JTextField();
        txtDeposit = new JTextField();
        
        // kalender
        tglPinjam = new DateChooserCombo();
        tglKembali = new DateChooserCombo();
        
        // Button
        JButton btnCek = new JButton("Cek");
//        JButton btnCK = new JButton("Cek");
        JButton btnSmpn = new JButton("Simpan");
        
        // Panel Konsumen
        panelKonsumen.add(txtKode, BorderLayout.CENTER);
//        panelKonsumen.add(btnCK, BorderLayout.EAST);
        
        // Panel Tanggal
        panelTgl.add(lblTglPinjam);
        panelTgl.add(tglPinjam);
        panelTgl.add(lblTglKembali);
        panelTgl.add(tglKembali);
        
        panelP.add(panelTgl, BorderLayout.CENTER);
        panelP.add(btnCek, BorderLayout.EAST);
        
        // Panel Tabel
        panelTabel.add(SP);
        
        // Panet data
        panelDtPeminjaman.add(lblKPinjam);
        panelDtPeminjaman.add(lblKode);
        panelDtPeminjaman.add(lblKosong);
        panelDtPeminjaman.add(lblKosong1);
        panelDtPeminjaman.add(lblPlatNo);
        panelDtPeminjaman.add(txtPlatNo);
        panelDtPeminjaman.add(lblKonsumen);
        panelDtPeminjaman.add(panelKonsumen);
        panelDtPeminjaman.add(lblMerkMobil);
        panelDtPeminjaman.add(txtMerkMobil);
        panelDtPeminjaman.add(lblKosong2);
        panelDtPeminjaman.add(lblKosong3);
        panelDtPeminjaman.add(lblTipeMobil);
        panelDtPeminjaman.add(txtTipeMobil);
        panelDtPeminjaman.add(lblKosong4);
        panelDtPeminjaman.add(lblKosong5);
        panelDtPeminjaman.add(lblWrnMobil);
        panelDtPeminjaman.add(txtWrnMobil);
        panelDtPeminjaman.add(lblKosong6);
        panelDtPeminjaman.add(lblKosong7);
        panelDtPeminjaman.add(lblTot);
        panelDtPeminjaman.add(txtTot);
        panelDtPeminjaman.add(lblKosong8);
        panelDtPeminjaman.add(lblKosong9);
        panelDtPeminjaman.add(lblDeposit);
        panelDtPeminjaman.add(txtDeposit);
        
        // Panel Button
        panelButton.add(btnSmpn);
        
        // Membuat Tidak Bisa Huruf
        txtDeposit.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                        (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        // Fungsi Button
        btnCek.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if((tglPinjam == null) || (tglKembali == null)){
                    isiPesanGagal = "Lengkapi Tanggal";
                    Gagal();
                } else {
                    sTglPinjam = tglPinjam.getText();
                    sTglKembali = tglKembali.getText();
                    selectDatabaseCari();
                    tblPinjam.setModel(new DefaultTableModel(dataMobil, rowName));
                }
            }
        });
        
        btnSmpn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if((txtPlatNo.equals("")) || (txtKode.equals(""))){
                    isiPesanGagal = "Lengkapi Data";
                    Gagal();
                } else {
                    int tempDP = Integer.parseInt(txtDeposit.getText());
                    int tempTot = Integer.parseInt(txtTot.getText());
                    if(tempDP < 0){
                        isiPesanGagal = "Deposit yang di masukkan salah !!!";
                        Gagal();
                    } else if(tempDP > tempTot){
                        isiPesanGagal = "Uang yang dimasukan melebihi total !!!";
                        Gagal();
                    } else {
                        insertData();
                        bersih();
                        dataMobil = null;
                        tblPinjam.setModel(new DefaultTableModel(dataMobil, rowName));
                    }
                }
            }
        });
        
        //Fungsi mengambil data dari tabel
        tblPinjam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                try {
                    Date DtglPinjam = (Date) format.parse(tglPinjam.getText());
                    Date DtglKembali = (Date) format.parse(tglKembali.getText());
                    long pinjam = DtglPinjam.getTime();
                    long kembali = DtglKembali.getTime();
                    long temp = Math.abs(DtglKembali.getTime() - DtglPinjam.getTime());
                    temp2 = TimeUnit.MILLISECONDS.toDays(temp)/30;
                }
                catch (Exception a){
                    System.out.println(a);
                }         
                
                int row = tblPinjam.rowAtPoint(e.getPoint());

                String platNo = tblPinjam.getValueAt(row, 0).toString();
                String merkMobil = tblPinjam.getValueAt(row, 1).toString();
                String tipeMobil = tblPinjam.getValueAt(row, 2).toString();
                String wrnMobil = tblPinjam.getValueAt(row, 3).toString();
                int hrgSewa = Integer.parseInt(tblPinjam.getValueAt(row, 6).toString());

                txtPlatNo.setText(String.valueOf(platNo));
                txtMerkMobil.setText(String.valueOf(merkMobil));
                txtTipeMobil.setText(String.valueOf(tipeMobil));
                txtWrnMobil.setText(String.valueOf(wrnMobil));
                long total = (hrgSewa * (temp2+1));
                txtTot.setText(String.valueOf(total));
            }                    
        });
        
        // Deklarasi Panel
        dtPeminjaman = new JPanel();
        BoxLayout boxLayout = new BoxLayout(dtPeminjaman, BoxLayout.Y_AXIS);
        
        dtPeminjaman.setLayout(boxLayout);
        
        
        dtPeminjaman.add(panelP);
        dtPeminjaman.add(panelTabel);
        dtPeminjaman.add(panelDtPeminjaman);
        dtPeminjaman.add(panelButton);
//        add(dtPeminjaman);
    }
    
    // Kode Pinjam
    private void KodePinjam(){
        Date today = new Date();
        SimpleDateFormat format1=new SimpleDateFormat("yy");
        String time = format1.format(today);
        int temp = 0;
        String temp2 = "";
        try {
            // Memangil Database
            koneksi db = new koneksi();
            
            if(db.isConnected()){

            System.out.println("pinjam terhubung");
            }

            // Menghubungkan ke koneksi >> selectDataCari
            kodeP = db.kodePinjam();
            
            KodePinjam = new String[kodeP.size()];
            for (int i=0; i < kodeP.size(); i++){
                KodePinjam[i] = kodeP.get(i).toString();
                if(KodePinjam[i] == ""){
                    temp = 0;
                } else {
                    temp = Integer.parseInt(KodePinjam[i])+1;
                    temp2 = String.valueOf(temp);
                    int pnjg = temp2.length();
                    for (int a=0; a<4 - pnjg;a++){
                        temp2 = "0" + temp2;
                    }
                }
            }            
            
            if (temp == 0){
                lblKode.setText("Pinjam" + time + "0001");
            } else {
                lblKode.setText("Pinjam" + time + temp2);
            }
        } catch (Exception e) {
            System.out.println(e);
            isiPesanGagal = "KodePinjam";
            Gagal();
        }
    }
    
    private void bersih(){
        txtPlatNo.setText("");
        txtMerkMobil.setText("");
        txtTipeMobil.setText("");
        txtWrnMobil.setText("");
        txtKode.setText("");
        txtNmDepan.setText("");
        txtNmBlkg.setText("");
        txtJnsID.setText("");
        txtNoId.setText("");
        txtTot.setText("");
        txtDeposit.setText("");
        
    }
    
    private void Berhasil(){
        JOptionPane.showMessageDialog(null,isiPesanBerhasil,"Informasi Database",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void Gagal(){
        JOptionPane.showMessageDialog(null,isiPesanGagal,"Informasi Database",JOptionPane.ERROR_MESSAGE);
    }
    
    // DATABASE
    private void selectDatabaseCari(){
        try {
        // Memangil Database
        koneksi db = new koneksi();
        System.out.println(db.isConnected());
                
        // Menghubungkan ke koneksi >> selectDataCari
        dataMobil = db.selectDataMobilPinjam(sTglPinjam, sTglKembali);
        
        } catch (Exception e) {
            System.out.println(e);
            isiPesanGagal = "Data Tidak Berhasil di Temukan";
            Gagal();
        }
    }
    
    private void insertData(){
        try {
            // Memanggil Database
            koneksi db = new koneksi();
            System.out.println(db.isConnected());

            // Menghubungkan ke koneksi >> insertData
            db.insertDataPinjam(lblKode.getText(), txtPlatNo.getText(), txtKode.getText(), tglPinjam.getText(), 
                    tglKembali.getText(), Integer.valueOf(txtTot.getText()), Integer.valueOf(txtDeposit.getText()));

            isiPesanBerhasil = "Data Berhasil Disimpan";
        Berhasil();
        } catch (Exception e) {
            System.out.println(e);
            isiPesanGagal = "Data Tidak Berhasil Disimpan";
            Gagal();
        }  
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Peminjaman();
    }
    
}
