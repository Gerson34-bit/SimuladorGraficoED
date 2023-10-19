import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JPanel contentPane;
    
    private JButton botaoLS;
    private JButton botaoLSE;
    private JButton botaoLDE;
   

    public JanelaPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(255, 255, 255));
		this.setBounds(100, 100, 1000, 600);
		this.setLocation(250, 50);

		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);

		this.setContentPane(contentPane);
        this.setVisible(true);


        botaoLS = new JButton("LISTA SEQUENCIAL");
        botaoLS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaSeqGUI le = new ListaSeqGUI();
                le.setVisible(true);
            }
        });
        addButton(botaoLS, 375, 140);

        botaoLSE = new JButton("LISTA ENCADEADA");
		botaoLSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                new LSE_GUI();
			}
		});
        addButton(botaoLSE, 375, 190);
        
        botaoLDE = new JButton("LISTA D. ENCADEADA");
        botaoLDE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LDE_GUI le = new LDE_GUI();
                le.setVisible(true);
            }
        });
        addButton(botaoLDE, 375, 240);
        
       
    }
    
    private void addButton(JButton button, int x, int y) {
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBounds(x, y, 250, 30);
        button.setFont(new Font("Courier", Font.PLAIN, 18));
        button.setFocusable(false);
        contentPane.add(button);
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }

}
