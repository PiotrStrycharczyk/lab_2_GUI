import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
public class zad_1 extends JFrame {
    private JButton button;
    private JTextField textfield;
    private JPanel panel;
    private Map<String, Color> kolory;

    public void zad_1(){
        SwingUtilities.invokeLater(() -> program_1()); {//obsluga przez jeden wątek - wątek EDTprogram_1();
        }
    }
    private void program_1(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);

        kolory = new HashMap<>();
        kolory.put("czerwony", Color.RED);
        kolory.put("zielony", Color.GREEN);
        kolory.put("niebieski", Color.BLUE);

        panel = new JPanel();
        panel.setLayout(null);

        textfield = new JTextField();//text area gdzie wpiszemy przyszly kolor
        JLabel label_z_tekstem = new JLabel("Wpisz kolor na jaki chcesz zmienic tlo:");
        button = new JButton("Button");
        oblsuga_buttona();//metoda obslugujaca buttona
        panel.setBackground(Color.orange);
        label_z_tekstem.setBounds(20, 20, 300, 20);
        textfield.setBounds(20, 60, 150, 20);
        button.setBounds(20, 100, 100, 30);

        panel.add(label_z_tekstem);//label z textem to tutaj wyswietla tekst
        panel.add(textfield);//textarea to tutaj wpisujemy
        panel.add(button);

        setLocationRelativeTo(null);
        add(panel);
        setVisible(true);
    }
    private void oblsuga_buttona(){
        button.addActionListener(e -> {//metoda obslugujaca klikniecie w button
            String wprowadzonytekst = textfield.getText();
            Color kolortla = kolory.get(wprowadzonytekst);
            if(kolortla != null){
                panel.setBackground(kolortla); // Ustaw kolor tła panelu na wprowadzony kolor
                System.out.println("Ustawiono kolor: " + kolortla);
            }
            else {
                System.out.println("Niepoprawny kolor: " + wprowadzonytekst);
            }
        });
    }
}

