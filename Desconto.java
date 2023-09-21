import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desconto extends JFrame {
    private JTextField valorField;
    private JTextField percentagemField;
    private JButton calcularButton;
    private JLabel resultadoLabel;
    private JButton mudarLayoutButton; // Botão para mudar o layout
    private JPanel panel;

    private boolean useBorderLayout = true;

    public Desconto() {
        setTitle("Calculadora de Porcentagem");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Criar os componentes
        
        percentagemField = new JTextField(10);
        calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel("Resultado: ");
        mudarLayoutButton = new JButton("Mudar Layout");

        
        setLayout(new BorderLayout()); // Configurar o layout inicial como BorderLayout

        // Componentes do painel
        panel = new JPanel();
        panel.add(new JLabel("Valor: "));
        panel.add(valorField);
        panel.add(new JLabel("Porcentagem: "));
        panel.add(percentagemField);
        panel.add(calcularButton);

        // Funcão de calcular
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        // Botão para mudar o layout
        mudarLayoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mudarLayout();
            }
        });

        // Adicionar os componentes ao frame
        add(panel, BorderLayout.NORTH);
        add(resultadoLabel, BorderLayout.CENTER);
        add(mudarLayoutButton, BorderLayout.SOUTH);
    }
    
    // Metódo para Calcular o resultado
    private void calcularResultado() {
        try {
            double valor = Double.parseDouble(valorField.getText());
            double percentagem = Double.parseDouble(percentagemField.getText());
            double resultado = (valor * percentagem) / 100.0;
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Entradas inválidas");
        }
    }

    private void mudarLayout() {
        if (useBorderLayout) {
            // Mudar para GridLayout
            panel.setLayout(new GridLayout(3, 2)); // Exemplo de GridLayout
            useBorderLayout = false;
        } else {
            // Mudar de volta para BorderLayout
            panel.setLayout(new FlowLayout()); // Layout padrão do JPanel
            useBorderLayout = true;
        }
        validate(); // Atualizar o layout
    }

   
}
