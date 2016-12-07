
import database.koneksi;
import datechooser.beans.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Meidy
 */
public class Pengembalian extends JFrame{

    String isiPesanBerhasil = "";
    String isiPesanGagal = "";
    String sTglKembali = "";
    String[] KodeKembali;
    long temp = 0, temp2 = 0;
    
    // Date Chooser
    DateChooserCombo tglKembali;
    
    // Tabel
    Vector<Object> rowName;
    Vector<Object> kodeP;
    Vector<Vector<Object>> dataPinjam = null;
    
    JTable tblKembali;
    JScrollPane SP;
    
    // Text Field
    JTextField txtkodekembali;
    JTextField txtkodepinjam;
    JTextField txttglkembali;
    JTextField txtterlambat;
    JTextField txtdenda;
    JTextField txttotal;
    
    JLabel lblKode;
    
    // Panel
    JPanel dtPengembalian;
    public Pengembalian(){
        setTitle("Data Pengembalian");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        dataPengembalian();
        KodeKembali();
        
        
        setVisible(true);
    }
    
    private void dataPengembalian(){
        // Membuat Panel
        JPanel panelTgl = new JPanel(new GridLayout(1,2,10,10));
        panelTgl.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelP = new JPanel(new BorderLayout(10, 10));
        panelP.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelTabel = new JPanel(new GridLayout(1,1));
        panelTabel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelDtPengembalian = new JPanel(new GridLayout(7,4,10,10));
        panelDtPengembalian.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBorder(new EmptyBorder(15, 50, 10, 50));
        JPanel panelKonsumen = new JPanel(new BorderLayout(10, 10));
        
                
        // Label
        JLabel lblkodekembali = new JLabel("Kode Pengembalian");
        JLabel lblkodepinjam = new JLabel("Kode Peminjaman");
        JLabel lbltglkembali = new JLabel("Tanggal Kembali");
        JLabel lblterlambat = new JLabel("Terlambat (hari)");
        JLabel lbldenda = new JLabel("Denda (Rp)");
        JLabel lbltotal = new JLabel("Total (Rp)");
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
        txtkodekembali = new JTextField ();
        txtkodepinjam = new JTextField ();
        txttglkembali = new JTextField ();
        txtterlambat = new JTextField ();
        txtdenda = new JTextField ();
        txttotal = new JTextField ();
        
        tglKembali = new DateChooserCombo();
        
        // Button
        JButton btnCek = new JButton("Cek");
//        JButton btnCK = new JButton("Cek");
        JButton btnSmpn = new JButton("Simpan");
        
        // Panel Konsumen
        panelKonsumen.add(txtkodekembali, BorderLayout.CENTER);
//        panelKonsumen.add(btnCK, BorderLayout.EAST);
        
        // Panel Tanggal
        panelTgl.add(lbltglkembali);
        panelTgl.add(tglKembali);
        
        panelP.add(panelTgl, BorderLayout.CENTER);
        panelP.add(btnCek, BorderLayout.EAST);
        
        // Panel Tabel
        panelTabel.add(SP);
        
        // Panet data
        panelDtPengembalian.add(lblkodekembali);
        panelDtPengembalian.add(lblKode);
        panelDtPengembalian.add(lblKosong);
        panelDtPengembalian.add(lblKosong1);
        panelDtPengembalian.add(lblkodepinjam);
        panelDtPengembalian.add(txtkodepinjam);
        panelDtPengembalian.add(lbltglkembali);
        panelDtPengembalian.add(panelTgl);
        panelDtPengembalian.add(lblterlambat);
        panelDtPengembalian.add(txtterlambat);
        panelDtPengembalian.add(lblKosong2);
        panelDtPengembalian.add(lblKosong3);
        panelDtPengembalian.add(lbldenda);
        panelDtPengembalian.add(txtdenda);
        panelDtPengembalian.add(lblKosong4);
        panelDtPengembalian.add(lblKosong5);
        panelDtPengembalian.add(lblKosong8);
        panelDtPengembalian.add(lblKosong9);
        panelDtPengembalian.add(lbltotal);
        panelDtPengembalian.add(txttotal);
        
        // Panel Button
        panelButton.add(btnSmpn);
        panelButton.add(btnCek);

       //Fungsi mengambil data dari tabel
        tblKembali.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int row = tblKembali.rowAtPoint(e.getPoint());

                String kode = tblKembali.getValueAt(row, 0).toString();
                
                txtkodekembali.setText(String.valueOf(txtkodekembali));
                
            }                    
        });        
        
        // Membuat Tidak Bisa Huruf
        txtterlambat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                        (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
         txtdenda.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                        (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });  
         txttotal.addKeyListener(new KeyAdapter() {
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
                 if((txtkodepinjam == null) || (tglKembali == null)){
                    isiPesanGagal = "Lengkapi Tanggal";
                    Gagal();
                } else {
                    sTglKembali = tglKembali.getText();
                    selectDatabaseCari();
                }
            }
        });
        
        btnSmpn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((txtkodepinjam.equals("")) || (txttglkembali==null)){
                    isiPesanGagal = "Lengkapi Data";
                    Gagal();
                } else {
                    
                    } else {
                        insertDataKembali();
                        bersih();
                        dataPinjam = null;
                        tblMobil.setModel(new DefaultTableModel(dataPinjam, rowName));
                    }
                }
            }
        });

        // Deklarasi Panel
        dtPengembalian = new JPanel();
        BoxLayout boxLayout = new BoxLayout(dtPengembalian, BoxLayout.Y_AXIS);
        
        dtPengembalian.setLayout(boxLayout);
        
        
        dtPengembalian.add(panelP);
        dtPengembalian.add(panelTabel);
        dtPengembalian.add(panelDtPengembalian);
        dtPengembalian.add(panelButton);
        add(dtPengembalian);
    }
    
    // Kode Pinjam
    private void KodeKembali(){
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
            
            KodeKembali = new String[kodeP.size()];
            for (int i=0; i < kodeP.size(); i++){
                KodeKembali[i] = kodeP.get(i).toString();
                if(KodeKembali[i] == ""){
                    temp = 0;
                } else {
                    temp = Integer.parseInt(KodeKembali[i])+1;
                    temp2 = String.valueOf(temp);
                    int pnjg = temp2.length();
                    for (int a=0; a<4 - pnjg;a++){
                        temp2 = "0" + temp2;
                    }
                }
            }            
        } catch (Exception e) {
            System.out.println(e);
            isiPesanGagal = "KodePinjam";
            Gagal();
        }
    }
    
    private void bersih(){
        txtkodekembali.setText("");
        txtkodepinjam.setText("");
        txttglkembali.setText("");
        txtterlambat.setText("");
        txtdenda.setText("");
        txttotal.setText("");
        
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
        dataPinjam = db.selectDataMobilPinjam(sTglKembali);
        
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
            db.insertDataKembali(txtkodepinjam.getText(), txttglkembali.getText(), 
 Integer.valueOf(txtterlambat.getText()), Integer.valueOf(txtdenda.getText()),Integer.valueOf(txttotal.getText()));

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
        new Pengembalian();
    }
    
}

