/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Deza Farras Tsany
 */
public class mainRentalMobil extends JFrame{
    // Class
    MOBIL mobil = new MOBIL();
    Customer pelanggan = new Customer();
    Peminjaman pinjam = new Peminjaman();
        
    // Panel
    JPanel panelAwal;
    JPanel panelCard;
    JPanel dtMobil;
    JPanel dtPelanggan;
    JPanel dtPinjam;
    
    public mainRentalMobil(){
        setTitle("Rental Mobil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        cardLayout();
                                
        setVisible(true);
    }
    
    private void cardLayout(){
        // Memanggil Fungsi      
        menuBar();
        tampilanAwal();
//        tampilanBukuBaru();
//        tampilanEdit();
//        tampilanMember();
//        tampilanEditMember();
//        tampilaPeminjaman();
        
        // Deklarasi Panel
        panelCard = new JPanel();
        dtMobil = new JPanel(new GridLayout(1,1));
        dtPelanggan = new JPanel(new GridLayout(1,1));
        dtPinjam = new JPanel(new GridLayout(1,1));
        
        dtMobil.add(mobil.panelMobil);
        dtPelanggan.add(pelanggan.panelCustomer);
        dtPinjam.add(pinjam.dtPeminjaman);
        
        // mobil.panelMobil pelanggan.panelPelanggan
        
        
        // Add Panel
//        dtMobil.add(pelanggan.panelPelanggan);
        
        // Set Layout
        panelCard.setLayout(new CardLayout());
        
        // Memasukan ke Dalam Panel
        panelCard.add(panelAwal, "Card1");
        panelCard.add(dtMobil, "Card2");
        panelCard.add(dtPelanggan, "Card3");
        panelCard.add(dtPinjam, "Card4");
//        panelCard.add(panelEditMember, "Card 5");
//        panelCard.add(panelPinjam, "Card 6");
        
        // Tampilkan Panel
        add(panelCard);
    }
    
    private void menuBar(){
        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // Membuat Menu
        JMenu menuFile = new JMenu("File");
        
        // Membuat menuItem
        // Unntuk File
        JMenuItem menuItemMobil = new JMenuItem("Mobil");
        JMenuItem menuItemPelanggan = new JMenuItem("Pelanggan");
        JMenuItem menuItemPinjam = new JMenuItem("Peminjaman");
        JMenuItem menuItemKembali = new JMenuItem("Pengembalian");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        
        // Add ke menuFile
        menuFile.add(menuItemMobil);
        menuFile.add(menuItemPelanggan);
        menuFile.add(menuItemPinjam);
        menuFile.add(menuItemKembali);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);
        
        // Add ke menuBar
        menuBar.add(menuFile);

        // mnemonic
        menuFile.setMnemonic(KeyEvent.VK_F);
        
        // accelator
        // file
        menuItemMobil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                InputEvent.CTRL_DOWN_MASK));

        menuItemPelanggan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                InputEvent.CTRL_DOWN_MASK));
        
        menuItemPinjam.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                InputEvent.CTRL_DOWN_MASK));

        menuItemKembali.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,
                InputEvent.CTRL_DOWN_MASK));

        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                InputEvent.CTRL_DOWN_MASK));
        
        // Memberi Perintah
        // File
        menuItemMobil.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panelCard.getLayout();
                cardLayout.show(panelCard, "Card2");
            }
        });
        
        menuItemPelanggan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panelCard.getLayout();
                cardLayout.show(panelCard, "Card3");
            }
        });
        
        menuItemPinjam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panelCard.getLayout();
                cardLayout.show(panelCard, "Card4");
            }
        });
        
        menuItemKembali.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panelCard.getLayout();
                cardLayout.show(panelCard, "Card ");
            }
        });
        
        menuItemExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });                    
        
               
        setJMenuBar(menuBar);
    }
    
    private void tampilanAwal(){
        // Deklarasi Panel
        panelAwal = new JPanel();
        
        // Set Layout
        panelAwal.setLayout(new BorderLayout());
        panelAwal.setBorder(new EmptyBorder(150, 250, 200, 200));
        
        // Image
        ImageIcon img = new ImageIcon("src/image/dmr.png");
        
        // Membuat label        
        JLabel lblImage = new JLabel(img);        
        
        // Memasukan ke Dalam Panel
        panelAwal.add(lblImage);
    }
    
    public static void main(String[] args) {
        new mainRentalMobil();
    }
}
