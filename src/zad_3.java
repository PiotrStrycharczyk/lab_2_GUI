import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JPanel;
import java.awt.Dimension;
public class zad_3 extends JFrame implements ActionListener{//klasa implementuje interfejs Acti
    // onListener, czyli klasa dostarcza implementacje wszystkich metod zawartych w tym
    // interfejsie

    private JFrame frame;
    private JPanel panel_listy_zakupow_i_usuwania_itemu;
    private JPanel panel_wpisania_i_dodania_itemu;
    private JTextField textField;
    private ArrayList<String> lista_zakupow = new ArrayList<>();
    private JLabel napis_lista_zakupow;
    private JLabel wymienione_zakupy;
    private Border border;
    public void zad_3(){
        SwingUtilities.invokeLater(this::wyglad_okienka);//inaczej wyglad_okienk()
    }
    private void wyglad_okienka(){
        Dimension preferredSize = new Dimension(300,500);
        Dimension preferredSizeNapisuListaZakupow = new Dimension(250,20);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Ustawienie BoxLayout w kierunku pionowym
        frame = new JFrame();
        wymienione_zakupy = new JLabel();
        JPanel panel_napis_lzakupow = new JPanel();
        panel_wpisania_i_dodania_itemu = new JPanel();
        panel_listy_zakupow_i_usuwania_itemu = new JPanel();
        panel_listy_zakupow_i_usuwania_itemu.setPreferredSize(preferredSize);
        border = BorderFactory.createLineBorder(Color.BLACK);//obwolutka

        textField = new JTextField(15);
        JLabel napis_dodaj_produkty= new JLabel("Podaj jakie zakupy dodac: ");
        napis_dodaj_produkty.setFont(new Font("Avenir", Font.BOLD, 15));

        JButton przycisk_dodania_itemu = new JButton("Dodaj");


        napis_lista_zakupow = new JLabel("Lista zakupow:");
        napis_lista_zakupow.setPreferredSize(preferredSizeNapisuListaZakupow);
        napis_lista_zakupow.setFont(new Font("Avenir", Font.BOLD, 15));


        panel_wpisania_i_dodania_itemu.add(napis_dodaj_produkty);
        panel_wpisania_i_dodania_itemu.add(textField);
        panel_wpisania_i_dodania_itemu.add(przycisk_dodania_itemu);//napis textfield i button dodaj

        panel_listy_zakupow_i_usuwania_itemu.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_napis_lzakupow.add(napis_lista_zakupow);

        panel_listy_zakupow_i_usuwania_itemu.add(wymienione_zakupy);
        przycisk_dodania_itemu.addActionListener(this);//obsluga zdarzenia dla przycisku

        frame.setSize(300,700);

        //mainPanel.add(panel_dodania_produktow);
        mainPanel.add(panel_wpisania_i_dodania_itemu);
        mainPanel.add(panel_napis_lzakupow);
        mainPanel.add(panel_listy_zakupow_i_usuwania_itemu);

        frame.add(mainPanel);


        //frame.setLayout(null);ta linjka sprawia że trzeba recznie ustawiac wszystkie elementy (niezalecane)
        //frame.setLayout(null);
        frame.setLocationRelativeTo(null);//daje na stodek frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override//te moetody nie muszą być na wątku EDT, bo są wywolywane z konstruktora...
    public void actionPerformed(ActionEvent e) {
        String item = textField.getText();
        System.out.println("Dodano: "+item);
        if(!item.isEmpty()) {
            lista_zakupow.add(item);
            textField.setText("");

            // Przygotuj tekst i przycisk "Usuń" dla listy zakupów
            refreshListPanel();
        }
        else System.out.println("Blad - nie wprowadzono itemu");
    }

    private void refreshListPanel() {
        panel_listy_zakupow_i_usuwania_itemu.removeAll();
        panel_listy_zakupow_i_usuwania_itemu.setLayout(new BoxLayout(panel_listy_zakupow_i_usuwania_itemu, BoxLayout.Y_AXIS));
        //panel_listy_zakupow_i_usuwania_itemu.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (String zakup : lista_zakupow) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));


            JLabel itemLabel = new JLabel("- " + zakup);
            itemLabel.setFont(new Font("Futura", Font.BOLD, 15));

            JButton usunButton = new JButton("Usuń");
            usunButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lista_zakupow.remove(zakup);
                    System.out.println("Usunieto:"+ zakup);
                    refreshListPanel();
                }
            });

            itemPanel.add(itemLabel);
            itemPanel.setBorder(border);
            itemPanel.add(usunButton);

            panel_listy_zakupow_i_usuwania_itemu.add(itemPanel);
        }
        frame.revalidate();
        frame.repaint();
    }
}

