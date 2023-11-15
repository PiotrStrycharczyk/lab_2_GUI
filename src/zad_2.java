import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class zad_2 extends JFrame {
    private JTextArea miejsce_na_tekst;
    private JFileChooser fileChooser;
    private JButton button_nowy;
    private JButton button_otworz;
    private JButton button_zapisz;
    private JButton button_zamknij;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemNowy;
    private JMenuItem menuItemOtworz;
    private JMenuItem menuItemZapisz;
    private JMenuItem menuItemZamknij;

    private void init_zad_2() {
        wyglad_okienka();
        obslugow_przyciskow();
        addMenu(); // Add the menu bar
    }

    private void addMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        menuItemNowy = new JMenuItem("Nowy");
        menuItemOtworz = new JMenuItem("Otwórz");
        menuItemZapisz = new JMenuItem("Zapisz");
        menuItemZamknij = new JMenuItem("Zamknij");

        menuItemNowy.addActionListener(e -> obsluga_button_nowy());
        menuItemOtworz.addActionListener(e -> obsluga_button_otworz());
        menuItemZapisz.addActionListener(e -> obsluga_button_zapisz());
        menuItemZamknij.addActionListener(e -> obsluga_button_zamknij());

        menu.add(menuItemNowy);
        menu.add(menuItemOtworz);
        menu.add(menuItemZapisz);
        menu.add(menuItemZamknij);
        menuBar.add(menu);

        setJMenuBar(menuBar); // Set the menu bar to the frame
    }
    public void zad_2(){
        SwingUtilities.invokeLater(() -> init_zad_2());
    }
    private void wyglad_okienka() {
        JPanel panel1 = new JPanel();
        JLabel napis_notatnik = new JLabel("aplikacja notatnika");
        JLabel napis_menu = new JLabel("Menu:");
        JLabel napis_nowy = new JLabel("1. Utwórz nowy plik");
        JLabel napis_otworz = new JLabel("2. Otwórz plik");
        JLabel napis_zapisz = new JLabel("3. Zapisz plik");
        JLabel napis_zamknij = new JLabel("4. Zamknij plik");
        JLabel napis_miejsce_na_tekst = new JLabel("Miejsce na wprowadzenie tekstu:");
        napis_miejsce_na_tekst.setFont(new Font("Source Code Pro", Font.BOLD, 15));

        button_nowy = new JButton("Nowy");
        button_otworz = new JButton("Otworz");
        button_zapisz = new JButton("Zapisz");
        button_zamknij = new JButton("Zamknij");
        napis_notatnik.setFont(new Font("Source Code Pro", Font.BOLD, 25));

        miejsce_na_tekst = new JTextArea(10,30);

        panel1.setLayout(new GridBagLayout()); // Ustawienie GridBagLayout dla panelu

        GridBagConstraints gbc = new GridBagConstraints();//tworzy obiekt
        //do określenia zachowania komponentów
        gbc.gridx = 0;//okresla połozenia na 0 wiersz
        gbc.gridy = 0;//okresla polozenie na 0 kolumne
        gbc.anchor = GridBagConstraints.CENTER;//komponent bedzie przyklejony od lewej jego obszaru siatki
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);//wewnetrzne marginesy wokół komponentu
        panel1.add(napis_notatnik, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;//napis menu pojdzie do nowego wiersza
        gbc.gridwidth = 1;//tylko jeden wiersz
        //panel1.add(napis_menu, gbc);
        panel1.add(napis_miejsce_na_tekst, gbc);

        gbc.gridy++;
        //panel1.add(napis_nowy, gbc);

        gbc.gridx++;//button_nowy pojdzie do drugiej kolumnie w tym samym wierszu
        //panel1.add(button_nowy, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        //panel1.add(napis_otworz, gbc);

        gbc.gridx++;
        //panel1.add(button_otworz, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
       // panel1.add(napis_zapisz, gbc);

        gbc.gridx++;
        //panel1.add(button_zapisz, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
       // panel1.add(napis_zamknij, gbc);

        gbc.gridx++;
       // panel1.add(button_zamknij, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel1.add(miejsce_na_tekst, gbc);//dodanie textArea



        napis_menu.setFont(new Font("Source Code Pro", Font.BOLD, 15));

        setLayout(new GridLayout(1, 1)); // Ustawienie GridLayout na ramce
        setSize(400, 600);
        setLocationRelativeTo(null); // Ramka na środku ekranu
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(panel1);
    }

    private void obsluga_button_nowy(){
        miejsce_na_tekst.setText("");
    }
    private void obsluga_button_otworz() {
        fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();//pobiera wybrany przez użytkownika plik
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                StringBuilder text = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                miejsce_na_tekst.setText(text.toString());
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void obsluga_button_zapisz(){
        fileChooser = new JFileChooser();//nowy obiekt ktory pozwala uzytkownikowi wybrac plik do zapisania
        int returnValue = fileChooser.showSaveDialog(null);//reprezentuje reakcje uzytkownika na wybor pliku

        if (returnValue == JFileChooser.APPROVE_OPTION) {//sprawdza czy ktos kliknal zapisz w oknie ktore wyskoczylo
            File selectedFile = fileChooser.getSelectedFile();//pobiera wybrany przez użytkowanika plik
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));//obiekt ktory pozwala na zapis tekstu do pliku
                writer.write(miejsce_na_tekst.getText());//zapisuje z text area tekst jaki wprowadzono do pliku o wybranego pliku
                writer.close();//koczy operacja zapisu do pliku
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void obsluga_button_zamknij(){
        dispose();
    }

    private void obslugow_przyciskow(){
        button_nowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obsluga_button_nowy();
            }
        });

        button_otworz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obsluga_button_otworz();
            }
        });

        button_zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obsluga_button_zapisz();
            }
        });

        button_zamknij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obsluga_button_zamknij();
            }
        });
    }

}

