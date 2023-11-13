import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
public class zad_4 extends Frame {
    private JComboBox combo_jednostki_wejsciowe;
    private JComboBox combo_jednostki_wyjsciowe;
    private JPanel panel_1;
    private JTextField wprowadzane_dane;
    private JFrame frame;
    JLabel zapisanie_wynikow;
    public void zad_4(){
        SwingUtilities.invokeLater(this::wyglad_okienka);//inaczej wyglad_okienk()
    }
    private void wyglad_okienka() {
        JLabel napis_konwerter = new JLabel("Konwerter jednostek");
        JLabel napis_co_przeliczyc = new JLabel("Wybierz co chcesz przeliczyc");
        String[] wszystkie_opcje = {"centymetry", "metry", "gramy", "kilogramy", "cm3", "m3"};
        combo_jednostki_wejsciowe = new JComboBox(wszystkie_opcje);
        combo_jednostki_wyjsciowe = new JComboBox(wszystkie_opcje);
        JButton button_oblicz = new JButton("Oblicz");
        wprowadzane_dane = new JTextField(20);
        zapisanie_wynikow = new JLabel();

        napis_konwerter.setFont(new Font("Source Code Pro", Font.BOLD, 25));
        napis_co_przeliczyc.setFont(new Font("Source Code Pro", Font.BOLD, 20));

        JPanel main_panel = new JPanel();
        panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
        frame = new JFrame();
        main_panel.add(napis_konwerter);
        main_panel.add(napis_co_przeliczyc);

        panel_2.add(combo_jednostki_wejsciowe);
        panel_2.add(combo_jednostki_wyjsciowe);
        panel_2.add(wprowadzane_dane);
        main_panel.add(panel_2);
        panel_1.add(button_oblicz);
        panel_1.add(zapisanie_wynikow);
        main_panel.add(panel_1);

        main_panel.setLayout(new GridLayout(7, 2, 20, 20));

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(main_panel);
        frame.setVisible(true);
        button_oblicz.addActionListener(e -> przeliczJednostki());//wyrazenie lambda
    }
    private void przeliczJednostki() {
        panel_1.remove(zapisanie_wynikow);
        zapisanie_wynikow = new JLabel();//do zmiany
        String jednostkaWejsciowa = (String) combo_jednostki_wejsciowe.getSelectedItem();
        String jednostkaWyjsciowa = (String) combo_jednostki_wyjsciowe.getSelectedItem();
        zapisanie_wynikow.setFont(new Font("Source Code Pro", Font.BOLD, 20));

        double wartoscWejsciowa;
        double wynik = -1;//zwraca -1 jak nie wejdzie do żadnego if-a

        try {
            wartoscWejsciowa = Double.parseDouble(wprowadzane_dane.getText());
        } catch (NumberFormatException ex) {
            zapisanie_wynikow.setText("Błędna wartość wejściowa!");
            panel_1.add(zapisanie_wynikow);
            frame.repaint();
            frame.revalidate();
            return;
        }

        if(jednostkaWejsciowa != null && jednostkaWyjsciowa != null) {
            if (jednostkaWejsciowa.equals("centymetry") && jednostkaWyjsciowa.equals("metry")) {
                wynik = wartoscWejsciowa / 100;
            }
            else if(jednostkaWyjsciowa.equals("centymetry") && jednostkaWejsciowa.equals("metry")){
                wynik = wartoscWejsciowa * 100;
            }
            else if(jednostkaWejsciowa.equals("gramy") && jednostkaWyjsciowa.equals("kilogramy")){
                wynik = wartoscWejsciowa/1000;
            } else if (jednostkaWyjsciowa.equals("gramy") && jednostkaWejsciowa.equals("kilogramy")) {
                wynik = wartoscWejsciowa*1000;
            } else if (jednostkaWejsciowa.equals("cm3") && jednostkaWyjsciowa.equals("m3")) {
                wynik = wartoscWejsciowa/1000000;
            } else if (jednostkaWyjsciowa.equals("cm3") && jednostkaWejsciowa.equals("m3")) {
                wynik = wartoscWejsciowa*1000000;
            }
            if (wynik != -1) {
                zapisanie_wynikow.setText("Wynik: " + wynik);
                panel_1.add(zapisanie_wynikow);
                frame.repaint();
                frame.revalidate();
            } else {
                zapisanie_wynikow.setText("Niepoprawne jednostki!");
                panel_1.add(zapisanie_wynikow);
                frame.repaint();
                frame.revalidate();
            }
        }
    }
}

