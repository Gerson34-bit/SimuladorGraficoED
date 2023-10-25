import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.BorderLayout;


public class PilhaSeqGUI extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static PilhaSequencial pilha = new PilhaSequencial();;
    private JButton[] position = new JButton[8];
    private int cont = 0;

    public PilhaSeqGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

    	this.setBounds(100, 100, 1000, 600);
        this.setLocation(250, 50);
        this.setTitle("Pilha Sequencial");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(Color.BLUE);

        /*contentPanel = new JPanel();
        contentPanel.setSize(800, 500);
        contentPanel.setBackground(new Color(65, 65, 65));
        contentPanel.setLayout(null);
        this.setVisible(true);
        this.setContentPanel(contentPanel);
        */

        setBounds(300, 100, 950, 500);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBackground(new Color(65, 65, 65)); //Cor do Background
        contentPanel.setLayout(null);

        JLabel lblPilha = new JLabel("PILHA SEQUENCIAL");
        lblPilha.setForeground(Color.BLACK);
        lblPilha.setFont(new Font("Courier", Font.BOLD, 18));
        lblPilha.setBounds(30, 0, 700, 80);
        lblPilha.setVisible(true);
        contentPanel.add(lblPilha);



       

        JButton btnPush = new JButton("PUSH");
        btnPush.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Adicionando o botão Push

                if (!pilha.cheia()) {
                    JOptionPane input = new JOptionPane();
                    String conteudo = JOptionPane.showInputDialog("NOVO ELEMENTO:");
                    if (conteudo != null && (conteudo.length()) > 0) {
                        try {
                            position[cont].setText(conteudo);
                            position[cont].setFont(new Font("Courier", Font.BOLD, 18));
                            cont++;

                            // Empilhando o dado na pilha

                            int dado = Integer.parseInt(conteudo);
                            pilha.push(dado);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Digite um elemento valido", "ERRO",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A pilha esta cheia !", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnPush.setForeground(Color.WHITE);
        btnPush.setBackground(new Color(62, 66, 75));
        btnPush.setFont(new Font("Courier", Font.PLAIN, 16));
        btnPush.setBounds(30, 130, 115, 30);
        contentPanel.add(btnPush);

        JButton btnPop = new JButton("POP");
        btnPop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Adicionando botão pop

                if (!pilha.vazia()) {
                    String removido = position[cont - 1].getText();
                    try {
                        position[cont - 1].setText("");
                        cont--;
                        // Desempilhando o dado da pilha
                        pilha.pop();
                        JOptionPane.showMessageDialog(null, "Item desempilhado: " + removido, "POP!",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Último elemento desempilhado: " +
                                removido, "Pilha vazia!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A pilha está vazia !", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnPop.setForeground(Color.WHITE);
        btnPop.setFont(new Font("Courier", Font.PLAIN, 16));
        btnPop.setBackground(new Color(62, 66, 75));
        btnPop.setBounds(30, 180, 115, 30);
        contentPanel.add(btnPop);

        JButton btnTop = new JButton("TOP");
        btnTop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Adicionando o botão top

                if (!pilha.vazia()) {
                    int top = pilha.top();
                    JOptionPane.showMessageDialog(null, "Topo atual da pilha: " + top, "TOP!",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "A pilha está vazia", "NO TOP!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnTop.setForeground(Color.WHITE);
        btnTop.setFont(new Font("Courier", Font.PLAIN, 16));
        btnTop.setBackground(new Color(62, 66, 75));
        btnTop.setBounds(30, 230, 115, 30);
        contentPanel.add(btnTop);

        // Posições da Pilha

        position[7] = new JButton("");
        position[7].setBackground(Color.WHITE);
        position[7].setBounds(500, 50, 200, 50);
        contentPanel.add(position[7]);

        position[6] = new JButton("");
        position[6].setBackground(Color.WHITE);
        position[6].setBounds(500, 100, 200, 50);
        contentPanel.add(position[6]);

        position[5] = new JButton("");
        position[5].setBackground(Color.WHITE);
        position[5].setBounds(500, 150, 200, 50);
        contentPanel.add(position[5]);

        position[4] = new JButton("");
        position[4].setBackground(Color.WHITE);
        position[4].setBounds(500, 200, 200, 50);
        contentPanel.add(position[4]);

        position[3] = new JButton("");
        position[3].setBackground(Color.WHITE);
        position[3].setBounds(500, 250, 200, 50);
        contentPanel.add(position[3]);

        position[2] = new JButton("");
        position[2].setBackground(Color.WHITE);
        position[2].setBounds(500, 300, 200, 50);
        contentPanel.add(position[2]);

        position[1] = new JButton("");
        position[1].setBackground(Color.WHITE);
        position[1].setBounds(500, 350, 200, 50);
        contentPanel.add(position[1]);

        position[0] = new JButton("");
        position[0].setBackground(Color.WHITE);
        position[0].setBounds(500, 400, 200, 50);
        contentPanel.add(position[0]);

        //setModal(true);
        //setBounds(400, 20, 586, 690);
        //contentPanel.setLayout(new FlowLayout());
        //contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    }


    public static void main(String[] args) {
        try {
            PilhaSeqGUI dialog = new PilhaSeqGUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
