import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class JanelaPrincipal extends JFrame {

    private JPanel contentPane;
    
    private JButton botaoLS;
    private JButton botaoLSE;
    private JButton botaoLDE;
    private JButton botaoPilha;
    private JButton botaoFila;
    private JButton botaoABP;
   

    public JanelaPrincipal() {
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(65, 65, 65));
		this.setBounds(100, 100, 1000, 600);
		this.setLocation(250, 50);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 65, 65));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);

		this.setContentPane(contentPane);
        this.setVisible(true);

        JLabel lblMenu = new JLabel("Simulador Gráfico das Estruturas de Dados");
        lblMenu.setForeground(new Color(0, 0, 0));
        lblMenu.setFont(new Font("Courier", Font.BOLD, 25));
        lblMenu.setBounds(30, 0, 700, 80);
        lblMenu.setVisible(true);
        contentPane.add(lblMenu);

        //Abre a janela da Lista Sequencial
        botaoLS = new JButton("LISTA SEQUENCIAL");
        botaoLS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaSeqGUI le = new ListaSeqGUI();
                le.setVisible(true);
            }
        });
        botaoLS.setForeground(Color.WHITE);
        botaoLS.setBackground(new Color(62, 66, 75));
        botaoLS.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoLS.setBounds(375, 150, 250, 30);
        contentPane.add(botaoLS);

        //Abre a janela da Lista Sequencial Encadeada
        botaoLSE = new JButton("LISTA ENCADEADA");
		botaoLSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                new LSE_GUI();
			}
		});
        botaoLSE.setForeground(Color.WHITE);
        botaoLSE.setBackground(new Color(62, 66, 75));
        botaoLSE.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoLSE.setBounds(375, 190, 250, 30);
        contentPane.add(botaoLSE);
        
        //Abre a janela da Lista Duplamente Encadeada
        botaoLDE = new JButton("LISTA D. ENCADEADA");
        botaoLDE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LDE_GUI le = new LDE_GUI();
                le.setVisible(true);
            }
        });
        botaoLDE.setForeground(Color.WHITE);
        botaoLDE.setBackground(new Color(62, 66, 75));
        botaoLDE.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoLDE.setBounds(375, 230, 250, 30);
        contentPane.add(botaoLDE);

        //Abre a janela da Pilha
        botaoPilha = new JButton("PILHA");
        botaoPilha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PilhaSeqGUI p = new PilhaSeqGUI();
                p.setVisible(true);
            }
        });
        botaoPilha.setForeground(Color.WHITE);
        botaoPilha.setBackground(new Color(62, 66, 75));
        botaoPilha.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoPilha.setBounds(375, 270, 250, 30);
        contentPane.add(botaoPilha);

        //Abre a janela da Fila
        botaoFila = new JButton("FILA");
        botaoFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FilaGUI p = new FilaGUI();
                p.setVisible(true);
            }
        });
        botaoFila.setForeground(Color.WHITE);
        botaoFila.setBackground(new Color(62, 66, 75));
        botaoFila.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoFila.setBounds(375, 310, 250, 30);
        contentPane.add(botaoFila);
        
      //Abre a janela da Pilha
        botaoABP = new JButton("ABP");
        botaoABP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ABP_GUI p = new ABP_GUI();
                p.setVisible(true);
            }
        });
        botaoABP.setForeground(Color.WHITE);
        botaoABP.setBackground(new Color(62, 66, 75));
        botaoABP.setFont(new Font("Courier", Font.PLAIN, 16));
        botaoABP.setBounds(375, 350, 250, 30);
        contentPane.add(botaoABP);

        
       
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
