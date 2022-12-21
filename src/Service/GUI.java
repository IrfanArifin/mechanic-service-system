package Service;

import javax.management.monitor.StringMonitor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class GUI {
    private JButton KIRIMButton;
    private JTextField textNama;
    private JComboBox comboBarang;
    private JComboBox comboLayanan;
    private JTextField textNomor;

    private JTable tableOutput;
    private DefaultTableModel tabel;
    private JPanel ROOT;
    private JTextField textHarga1;
    private JTextField textHarga2;

    public JPanel anu (){
        return this.ROOT;
    }

    public GUI() {
        tableBuilder();
        comboBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int harga1;
                if (comboBarang.getSelectedItem() == "Mesin cuci"){
                    harga1 = 100000;
                }else if (comboBarang.getSelectedItem() == "Kulkas") {
                    harga1 = 80000;
                }else if (comboBarang.getSelectedItem() == "AC") {
                    harga1 = 50000;
                }else {
                    harga1 = 0;
                }
                textHarga1.setText(String.valueOf(harga1));
            }
        });
        comboLayanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int harga2;
                if (comboLayanan.getSelectedItem() == "Service"){
                    harga2 = 4500000;
                } else if (comboLayanan.getSelectedItem() == "Cleaning") {
                    harga2 = 100000;
                } else if (comboLayanan.getSelectedItem() == "Cleaning and Service") {
                    harga2 = 500000;
                }else {
                    harga2 = 0;
                }
                textHarga2.setText(String.valueOf(harga2));
            }
        });
        KIRIMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getNama = textNama.getText();
                String getBarang = (String) comboBarang.getSelectedItem();
                String getLayanan= (String) comboLayanan.getSelectedItem();
                String getNomor = textNomor.getText();
                int Barang = Integer.parseInt(textHarga1.getText());
                int Layanan = Integer.parseInt(textHarga2.getText());
                int hargaTotal = Barang+Layanan;

                String result = "Data tersimpan!\nnama Pelanggan : "+getNama+" \nJenis Barang : "+getBarang+" \nPilihan Layanan : "+getLayanan+"\nNo.HP : "+getNomor+"\nHarga Total : "+hargaTotal+"\n\n";
                try{
                    FileWriter myWriter=new FileWriter("Mechanical Service.txt",true);
                    myWriter.write(result);
                    myWriter.close();
                    System.out.println("successfully wrote to the file.");

                }catch(IOException eju){
                    System.out.println("An error occurred");
                    eju.printStackTrace();
                }

                if (getNama.isBlank() ||getBarang.isBlank() ||getLayanan.isBlank() ||getNomor.isBlank()) {
                    JOptionPane.showMessageDialog(ROOT,
                            "Lengkapi data anda",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }



                Object[] isiTabel = {getNama, getBarang,getLayanan,getNomor,"Rp."+hargaTotal};
                tabel.addRow(isiTabel);
                JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
                clearField();

            }
        });
    }
    private void tableBuilder(){
        Object[] namaKolom = {"Nama Pelanggan", "Barang", "Layanan", "Nomor HP", "Harga"};
        Object[][] isiBaris = {};
        tabel = new DefaultTableModel(isiBaris, namaKolom);
        tableOutput.setModel(tabel);
    }

    private void clearField(){
        textNama.setText("");
        comboBarang.setSelectedIndex(0);
        comboLayanan.setSelectedIndex(0);
        textNomor.setText("");
    }
}
