import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorDolarParaReal extends JFrame {
    private JTextField valorDolarField;
    private JTextField taxaCambioField;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public ConversorDolarParaReal() {
        setTitle("Calculadora de Dólar para Real");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Crie um painel principal com BoxLayout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Painel de entrada - BoxLayout vertical
        JPanel entradaPanel = new JPanel();
        entradaPanel.setLayout(new BoxLayout(entradaPanel, BoxLayout.Y_AXIS));
        JLabel labelValorDolar = new JLabel("Valor em Dólar:");
        valorDolarField = new JTextField(10);
        JLabel labelTaxaCambio = new JLabel("Taxa de Câmbio Atual (1 dólar = X reais):");
        taxaCambioField = new JTextField(10);
        entradaPanel.add(labelValorDolar);
        entradaPanel.add(valorDolarField);
        entradaPanel.add(labelTaxaCambio);
        entradaPanel.add(taxaCambioField);

        // Botão "Calcular"
        calcularButton = new JButton("Calcular");

        // Painel de resultado
        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinhe à esquerda

        // Adicione componentes ao painel principal
        mainPanel.add(entradaPanel);
        mainPanel.add(calcularButton);
        mainPanel.add(resultadoLabel);

        // Adicione o painel principal ao frame
        add(mainPanel);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularConversao();
            }
        });
    }

    private void calcularConversao() {
        try {
            double valorDolar = Double.parseDouble(valorDolarField.getText());
            double taxaCambio = Double.parseDouble(taxaCambioField.getText());
            double valorReal = valorDolar * taxaCambio;
            resultadoLabel.setText("Resultado em Reais: " + valorReal);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Entradas inválidas");
        }
    }

   
}
        
    
