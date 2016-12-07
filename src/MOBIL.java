
import database.koneksi;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

public class MOBIL extends JFrame{
    // Variable
    static String tempPlatNo = "";
    String kondisMobil = "";
    String statusMobil = "";
    
    String isiPesan = "";
    String isiPesanError = "";
    
    int sttsMobil;
    
    // Tabel
    Vector<Object> rowName;
    Vector<Vector<Object>> dataMobil = null;
    
    JTable tblMobil;
    JScrollPane SP;
    
    // Text Field
    JTextField txtPlatNo;
    JTextField txtMerkMobil;
    JTextField txtTipeMobil;
    JTextField txtWrnMobil;
    JTextField txtThnMobil;
    JTextField txtHrgSewa;
    JTextField txtBDenda;
    JTextField txtStsMobil;
    
    // Combo Box
    JComboBox cbStsMobil;
    
    // Radio Button
    JRadioButton rdBaru, rdBekas;
    ButtonGroup bgKondisi;
    
    JPanel panelMobil;
    
    public MOBIL(){
//        setTitle("Data Kendaraan");
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        
        selectDatabase();
        
        dataMobil();
        
//        setVisible(true);
    }
    
    private void dataMobil(){
        // Membuat Panel
        JPanel panelTabel = new JPanel(new GridLayout(1,1));
        panelTabel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JPanel panelDtMobil = new JPanel(new GridLayout(5,4,10,10));
        panelDtMobil.setBorder(new EmptyBorder(5, 10, 5, 10));
        JPanel panelButton = new JPanel(new GridLayout(1,2,50,50));
        panelButton.setBorder(new EmptyBorder(15, 50, 10, 50));
        JPanel panelRB = new JPanel(new GridLayout(1,2));
        
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
        tblMobil = new JTable(dataMobil, rowName);
        tblMobil.setEnabled(false);
        SP = new JScrollPane(tblMobil);
        
        //Membuat Label
        JLabel lblPlatNo = new JLabel("Plat Nomor");
        JLabel lblMerkMobil = new JLabel("Merek Mobil");
        JLabel lblTipeMobil = new JLabel("Tipe Mobil");
        JLabel lblWrnMobil = new JLabel("Warna Mobil");
        JLabel lblThnMobil = new JLabel("Tahun Mobil");
        JLabel lblKondisiMobil = new JLabel("Kondisi Mobil");
        JLabel lblHrgSewa = new JLabel("Harga Sewa");
        JLabel lblBDenda = new JLabel("Biaya Denda");
        JLabel lblStsMobil = new JLabel("Status Mobil");
        
        //Membuat Text Field
        txtPlatNo = new JTextField();
        txtMerkMobil = new JTextField();
        txtTipeMobil = new JTextField();
        txtWrnMobil = new JTextField();
        txtThnMobil = new JTextField();
        txtHrgSewa = new JTextField();
        txtBDenda = new JTextField();
        
        
        // Membuat Radio Button
        rdBaru = new JRadioButton("Baru");
        rdBekas = new JRadioButton("Bekas");
        bgKondisi = new ButtonGroup();
        bgKondisi.add(rdBaru);
        bgKondisi.add(rdBekas);
        
        //Membuat Combo Box
        String rasa[] = {"- Status Mobil -","Terjual"};
        cbStsMobil = new JComboBox(rasa);
        
        //Membuat Button
        JButton btnSmpn = new JButton("Simpan");
        JButton btnEdit = new JButton("Edit");
        
        //Set Panel
        //Panel Tabel
        panelTabel.add(SP);
        
        //Panel RB
        panelRB.add(rdBaru);
        panelRB.add(rdBekas);
        
        //Panel Data Mobil
        panelDtMobil.add(lblPlatNo);
        panelDtMobil.add(txtPlatNo);
        panelDtMobil.add(lblMerkMobil);
        panelDtMobil.add(txtMerkMobil);
        panelDtMobil.add(lblTipeMobil);
        panelDtMobil.add(txtTipeMobil);
        panelDtMobil.add(lblWrnMobil);
        panelDtMobil.add(txtWrnMobil);
        panelDtMobil.add(lblThnMobil);
        panelDtMobil.add(txtThnMobil);
        panelDtMobil.add(lblKondisiMobil);
        panelDtMobil.add(panelRB);
        panelDtMobil.add(lblHrgSewa);
        panelDtMobil.add(txtHrgSewa);
        panelDtMobil.add(lblBDenda);
        panelDtMobil.add(txtBDenda);
        panelDtMobil.add(lblStsMobil);
        panelDtMobil.add(cbStsMobil);
        
        //Panel Button
        panelButton.add(btnSmpn);
        panelButton.add(btnEdit);
        
        //Fungsi mengambil data dari tabel
        tblMobil.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int row = tblMobil.rowAtPoint(e.getPoint());

                String platNo = tblMobil.getValueAt(row, 0).toString();
                tempPlatNo = tblMobil.getValueAt(row, 0).toString();
                String merkMobil = tblMobil.getValueAt(row, 1).toString();
                String tipeMobil = tblMobil.getValueAt(row, 2).toString();
                String wrnMobil = tblMobil.getValueAt(row, 3).toString();
                String thnMobil = tblMobil.getValueAt(row, 4).toString();
                String kondisiMobil = tblMobil.getValueAt(row, 5).toString();
                String hrgSewa = tblMobil.getValueAt(row, 6).toString();
                String hrgDenda = tblMobil.getValueAt(row, 7).toString();

                txtPlatNo.setText(String.valueOf(platNo));
                txtMerkMobil.setText(String.valueOf(merkMobil));
                txtTipeMobil.setText(String.valueOf(tipeMobil));
                txtWrnMobil.setText(String.valueOf(wrnMobil));
                txtThnMobil.setText(String.valueOf(thnMobil));
                txtHrgSewa.setText(String.valueOf(hrgSewa));
                txtBDenda.setText(String.valueOf(hrgDenda));
                if(kondisiMobil.equals("Baru")){
                    rdBaru.setSelected(true);
                } else {
                    rdBekas.setSelected(true);
                }
            }                    
        });
        
        //MembaCa Text field
        txtThnMobil.setDocument(new PlainDocument(){
            
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if(str != null && (getLength() + str.length() <= 4)){
                    super.insertString(offs, str, a);
                }
            }
        });
        
        // Membuat Tidak Bisa Huruf
        txtThnMobil.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || 
                        (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        txtHrgSewa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });        
        
        txtBDenda.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char karakter = e.getKeyChar();
                if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        //Fungsi Combo box
        cbStsMobil.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                statusMobil = (String)cbStsMobil.getSelectedItem();
            }
        });
        
        // Fungsi Button
        btnSmpn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((txtPlatNo.equals(""))||(txtMerkMobil.equals("")) || (txtTipeMobil.equals("")) || (txtWrnMobil.equals("")) || (txtThnMobil.equals(""))
                        || (txtHrgSewa.equals(""))|| (txtBDenda.equals(""))){
                    isiPesanError = "Lengkapi Data";
                    pesanError();
                } else {
                    if(rdBaru.isSelected()){
                        kondisMobil="Baru";
                    } else if (rdBekas.isSelected()){
                        kondisMobil="Bekas";
                    }

                    if(statusMobil.equals("Terjual")){
                        sttsMobil = 1;
                    } else {
                        sttsMobil = 0;
                    }

                    insertDatabase();
                    bersihkanTextfield();
                    selectDatabase();
                    tblMobil.setModel(new DefaultTableModel(dataMobil, rowName));
                }
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdBaru.isSelected()){
                    kondisMobil="Baru";
                } else if (rdBekas.isSelected()){
                    kondisMobil="Bekas";
                }
                
                if(statusMobil.equals("Terjual")){
                    sttsMobil = 1;
                } else {
                    sttsMobil = 0;
                }
                
                updateDatabase();
                bersihkanTextfield();
                selectDatabase();
                tblMobil.setModel(new DefaultTableModel(dataMobil, rowName));
            }
        });
        
        // Deklarasi Panel
        panelMobil = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelMobil, BoxLayout.Y_AXIS);
        
        panelMobil.setLayout(boxLayout);
        
        panelMobil.add(panelTabel);
        panelMobil.add(panelDtMobil);
        panelMobil.add(panelButton);
        
//        add(panelMobil);
    }
    
    private void bersihkanTextfield(){
        txtPlatNo.setText("");
        txtMerkMobil.setText("");
        txtTipeMobil.setText("");
        txtWrnMobil.setText("");
        txtThnMobil.setText("");
        txtHrgSewa.setText("");
        txtBDenda.setText("");
        bgKondisi.clearSelection();
        cbStsMobil.setSelectedItem("- Status Mobil -");
    }
    
    // Membuat Message Box
    private void pesanBerhasil(){
        JOptionPane.showMessageDialog(null,isiPesan,"Informasi Database",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void pesanError(){
        JOptionPane.showMessageDialog(null,isiPesanError,"Informasi Database",JOptionPane.ERROR_MESSAGE);
    }
    
    // Query untuk DATABASE
    private void insertDatabase(){
        try {
        // Memangil Database
        koneksi db = new koneksi();
        System.out.println(db.isConnected());
       
        // Menghubungkan ke koneksi >> insertData
        db.insertDataMobil(txtPlatNo.getText(), txtMerkMobil.getText(), txtTipeMobil.getText(), txtWrnMobil.getText(), 
                Integer.valueOf(txtThnMobil.getText()), kondisMobil, Integer.valueOf(txtHrgSewa.getText()),
                Integer.valueOf(txtBDenda.getText()), sttsMobil);
        
        isiPesan = "Data Berhasil di Simpan";
        pesanBerhasil();
        } catch (Exception e) {
            System.out.println(e);
            isiPesanError = "Data Tidak Berhasil di Simpan";
            pesanError();
        }        
    }
    
    private void updateDatabase(){
        try {
        // Memangil Database
        koneksi db = new koneksi();
        System.out.println(db.isConnected());
        
        // Menghubungkan ke koneksi >> updateData
        db.updateDataMobil(txtPlatNo.getText(), txtMerkMobil.getText(), txtTipeMobil.getText(), txtWrnMobil.getText(), 
                Integer.valueOf(txtThnMobil.getText()), kondisMobil, Integer.valueOf(txtHrgSewa.getText()),
                Integer.valueOf(txtBDenda.getText()), sttsMobil, tempPlatNo);
        
        isiPesan = "Data Berhasil di Perbaharui";
        pesanBerhasil();
        } catch (Exception e) {
            System.out.println(e);
            isiPesanError = "Data Tidak Berhasil di Perbaharui";
            pesanError();
        }        
    }
    
    private void selectDatabase(){
        try {
        // Memangil Database
        koneksi db = new koneksi();
        System.out.println(db.isConnected());
        
        // Menghubungkan ke koneksi >> selectData
        dataMobil = db.selectDataMobil();
        
        } catch (Exception e) {
            System.out.println(e);
            isiPesanError = "Data Tidak Berhasil di Ambil";
            pesanError();
        }
    }
    
    public static void main(String[] args) {
        new MOBIL();
    }
}