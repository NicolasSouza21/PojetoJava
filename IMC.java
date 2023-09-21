import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Criação dos componentes da interface

class Principal extends JFrame {
    private JTextField fieldPeso;
    private JTextField fieldAltura;
    private JButton calcular;
    private JLabel peso;
    private JLabel lblAltura;
    private JLabel lblResultado;

    // Configurações

    public Principal() {
        setConfig();
    }

    // Layout

    private void setConfig() {
        this.setTitle("Calculadora de IMC");
        this.setSize(355, 150);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(2); // Fecha a janela ao clicar no "X"
        this.getContentPane().setBackground(Color.lightGray); // Define a cor de fundo da janela

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Criação dos componentes
        fieldPeso = new JTextField(10);
        fieldAltura = new JTextField(10);
        calcular = new JButton("Calcular");
        peso = new JLabel("Peso(Kg):");
        lblAltura = new JLabel("Altura(m):");
        lblResultado = new JLabel("Resultado:");

        // Adiciona um ouvinte de ação ao botão "Calcular"
        calcular.addActionListener(new EventoCalculaIMC());

        // Adiciona os componentes ao painel de entrada
        inputPanel.add(peso);
        inputPanel.add(fieldPeso);
        inputPanel.add(lblAltura);
        inputPanel.add(fieldAltura);

        // Adiciona o painel de entrada, o botão "Calcular" e o rótulo de resultado ao JFrame
        this.add(inputPanel);
        this.add(calcular);
        this.add(lblResultado);
    }

    // Calculadora

    class EventoCalculaIMC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double peso = Double.parseDouble(fieldPeso.getText());
                double altura = Double.parseDouble(fieldAltura.getText());

                double imc = peso / Math.pow(altura, 2);

                DecimalFormat df = new DecimalFormat("#0.0");

                String resultado = "Resultado: " + df.format(imc);

                // Determina a categoria do IMC e adiciona ao resultado
                if (imc < 18.5) {
                    resultado += " Abaixo do peso";
                } else if (imc < 24.9) {
                    resultado += " Peso ideal";
                } else if (imc < 29.9) {
                    resultado += " Levemente acima do peso";
                } else if (imc < 34.9) {
                    resultado += " Primeiro grau de obesidade";
                } else if (imc < 39.9) {
                    resultado += " Segundo grau de obesidade";
                } else
                    resultado += " Obesidade mórbida";

                // Atualiza o rótulo de resultado com o valor calculado
                lblResultado.setText(resultado);
            } catch (ArithmeticException ar) {
                // Manipula erros de exceção aritmética
                JOptionPane.showMessageDialog(null, "Erro aritmético, causa: " + ar.getMessage());
            } catch (Exception ex) {
                // Manipula outros erros e exceções
                JOptionPane.showMessageDialog(null, "Erro, causa: " + ex.getMessage() + ", Utilize o formato '0.00'");
            }
        }
    }
}
