import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class zad_5 extends Frame {
    private JFrame frame;
    private JPanel panel1;
    private ArrayList lista_pytan;
    private String[][] lista_odpowiedzi;
    private void program_5(){
        wyglad_okienka();
    }
    public void zad_5(){
        program_5();
    }
    private void wyglad_okienka(){
        lista_pytan = new ArrayList<>();
        lista_pytan.add("Ile to 2 + 2");
        lista_pytan.add("Jaki kolor ma niebo?");
        lista_pytan.add("Ile to calka z e^x?");
        frame = new JFrame("QUIZ");
        panel1 = new JPanel();
        JLabel napis_quiz = new JLabel("Quiz wiedzy ogolnej");
        napis_quiz.setFont(new Font("Source Code Pro", Font.BOLD, 20));

        lista_odpowiedzi = new String[][]{
                {"4", "6"},
                {"Niebieski", "Czerwony"},
                {"e^x", "Nie da się obliczyć"}};

        panel1.setLayout(new GridBagLayout()); // Ustawienie GridBagLayout dla panelu

        GridBagConstraints gbc = new GridBagConstraints();//tworzy obiekt
        //do określenia zachowania komponentów
        gbc.gridx = 0;//okresla połozenia na 0 wiersz
        gbc.gridy = 0;//okresla polozenie na 0 kolumne
        gbc.anchor = GridBagConstraints.NORTH;//komponent bedzie przyklejony od lewej jego obszaru siatki
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);//wewnetrzne marginesy wokół komponentu
        panel1.add(napis_quiz, gbc);

        for (int i = 0; i < lista_pytan.size(); i++) {
            JLabel pytanieLabel = new JLabel(lista_pytan.get(i).toString());

            gbc.gridx = 0; // Ustawiamy pytnie po lewej stronie
            gbc.gridy = i * 3 + 1; // Pozycja poniżej poprzedniego pytania, z odstępem 3 dla odpowiedzi
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridwidth = 1; // Odpowiedzi zostaną w jednej kolumnie

            panel1.add(pytanieLabel, gbc);


            for (int j = 0; j < 2; j++) {
                JButton button = new JButton(lista_odpowiedzi[i][j]);
                //group.add(button);
                gbc.gridx = 1; // Ustawiamy odpowiedzi po prawej stronie
                gbc.gridy = i * 3 + j + 1; // Pozycja odpowiedzi obok pytania
                panel1.add(button, gbc);

                button.setActionCommand("Odpowiedz " + (j + 1));
                button.addActionListener(e -> {
                    String action = e.getActionCommand();
                    System.out.println("Wybrano: " + action);
                    JLabel odpowiedz = new JLabel("Poprawna odpowiedz!");
                    gbc.gridx = 2;
                    gbc.gridy = 3;
                    gbc.anchor = GridBagConstraints.CENTER;
                    frame.revalidate();
                    frame.repaint();
                    panel1.add(odpowiedz,gbc);
                });
            }

            //JButton sprawdz = new JButton("Sprawdz odpowiedzi");
        }




        frame.add(panel1);
        //frame.setLayout(new GridLayout(1, 1)); // Ustawienie GridLayout na ramce
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); // Ramka na środku ekranu
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}
