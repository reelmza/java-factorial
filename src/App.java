import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            FactorialCalculator factorial = new FactorialCalculator();
            factorial.setVisible(true);
        });
    }
}
