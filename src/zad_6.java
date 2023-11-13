import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zad_6 extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField wprowadzana_waga;
    private JTextField wprowadzany_wzrost;
    private JLabel bmiLabel;

    public void zad_6(){
        SwingUtilities.invokeLater(this::wyglad_okienka);//inaczej wyglad_okienka()
    }
    private void wyglad_okienka() {
        JLabel napis_oblicz_BMI = new JLabel("Kalkulator BMI");
        JLabel napis_podaj_wage = new JLabel("Podaj wage w kg: ");
        JLabel napis_podaj_wzrost = new JLabel("Podaj wzrost w m: ");
        bmiLabel = new JLabel();


        JFrame frame = new JFrame();
        panel1 = new JPanel();//to jest mainPanel
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setLayout(new GridLayout(7,1,20,20));

        JButton przycisk_oblicz = new JButton("Oblicz");
        wprowadzana_waga = new JTextField();
        wprowadzany_wzrost = new JTextField();
        wprowadzana_waga.setPreferredSize(new Dimension(100, 20)); // Ustaw preferowany rozmiar dla wprowadzana_waga
        wprowadzany_wzrost.setPreferredSize(new Dimension(100, 20)); // Ustaw preferowany rozmiar dla wprowadzany_wzrost

        napis_oblicz_BMI.setFont(new Font("Source Code Pro", Font.BOLD,25));
        napis_podaj_wage.setFont(new Font("Source Code Pro", Font.BOLD,20));
        napis_podaj_wzrost.setFont(new Font("Source Code Pro", Font.BOLD,20));
        przycisk_oblicz.addActionListener(this);

        panel1.add(napis_oblicz_BMI);

        panel1.add(napis_podaj_wage);
        panel2.add(wprowadzana_waga);
        panel1.add(panel2);//musimy utworzyc te dwa panele aby rozmiary textfielda w GridLayout nie zwiekszały sie podczas manipulacją rozmiaru farme
        panel1.add(napis_podaj_wzrost);
        panel3.add(wprowadzany_wzrost);
        panel1.add(panel3);
        panel1.add(przycisk_oblicz);
        panel1.add(bmiLabel);

        frame.add(panel1);

        frame.setSize(450,350);
        //rame.setLayout(null);ta linjka sprawia że trzeba recznie ustawiac wszystkie elementy (niezalecane)
        frame.setLocationRelativeTo(null);//daje na stodek frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            panel1.remove(bmiLabel);
            // Twój kod, który może spowodować wyjątek NumberFormatException
            String text1 = wprowadzany_wzrost.getText();
            String text2 = wprowadzana_waga.getText();
            float floatwzrost = Float.parseFloat(text1);
            float floatwaga = Float.parseFloat(text2);
            float BMI = floatwaga/(floatwzrost*floatwzrost);
            bmiLabel = new JLabel("Wynik BMI: " + BMI);
            bmiLabel.setFont(new Font("Source Code Pro", Font.BOLD,20));
            panel1.add(bmiLabel);
            panel1.revalidate();//ponowne rozmieszczenie elementoww kontenerze
            //panel1.repaint();//od nowa pomalowanie elementu
        } catch (NumberFormatException exc) {
            // Obsługa wyjątku NumberFormatException
            System.out.println("Błąd: Nie można przekonwertować ciągu na liczbę zmiennoprzecinkową.");
            exc.printStackTrace();//wypisuje gdzie dokladnie wystapil blad
        }
    }
}
