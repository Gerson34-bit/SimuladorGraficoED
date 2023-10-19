import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class PilhaSeqGUI extends JDialog {

    private JPanel contentPane;
    private final JPanel contentPanel = new JPanel();
    private static PilhaSequencial pilha = new PilhaSequencial();;
    private JButton[] position = new JButton[8];
    private int cont = 0;

    public PilhaSeqGUI() {

    	this.setBounds(100, 100, 1000, 600);
        this.setLocation(250, 50);
        this.setTitle("Pilha Sequencial");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(Color.BLUE);

        contentPane = new JPanel();
        contentPane.setSize(800, 500);
        contentPane.setBackground(new Color(255, 165, 0));
        contentPane.setLayout(null);
        this.setVisible(true);
        this.setContentPane(contentPane);

        JLabel lblPilha = new JLabel("PILHA SEQUENCIAL");
        lblPilha.setForeground(Color.BLACK);
        lblPilha.setFont(new Font("Courier", Font.BOLD, 18));
        lblPilha.setBounds(188, 11, 197, 58);
        getContentPane().add(lblPilha);



       

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
        btnPush.setForeground(new Color(51, 51, 51));
        btnPush.setBackground(new Color(255, 255, 255));
        btnPush.setFont(new Font("Courier", Font.PLAIN, 16));
        btnPush.setBounds(115, 94, 89, 23);
        getContentPane().add(btnPush);

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
        btnPop.setForeground(new Color(51, 51, 51));
        btnPop.setFont(new Font("Courier", Font.PLAIN, 16));
        btnPop.setBackground(new Color(255, 255, 255));
        btnPop.setBounds(235, 94, 89, 23);
        getContentPane().add(btnPop);

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
        btnTop.setForeground(new Color(51, 51, 51));
        btnTop.setFont(new Font("Courier", Font.PLAIN, 16));
        btnTop.setBackground(new Color(255, 255, 255));
        btnTop.setBounds(355, 94, 89, 23);
        getContentPane().add(btnTop);

        // Posições da Pilha

        position[7] = new JButton("");
        position[7].setBackground(Color.WHITE);
        position[7].setBounds(164, 236, 233, 43);
        getContentPane().add(position[7]);

        position[6] = new JButton("");
        position[6].setBackground(Color.WHITE);
        position[6].setBounds(164, 279, 233, 43);
        getContentPane().add(position[6]);

        position[5] = new JButton("");
        position[5].setBackground(Color.WHITE);
        position[5].setBounds(164, 322, 233, 43);
        getContentPane().add(position[5]);

        position[4] = new JButton("");
        position[4].setBackground(Color.WHITE);
        position[4].setBounds(164, 365, 233, 43);
        getContentPane().add(position[4]);

        position[3] = new JButton("");
        position[3].setBackground(Color.WHITE);
        position[3].setBounds(164, 408, 233, 43);
        getContentPane().add(position[3]);

        position[2] = new JButton("");
        position[2].setBackground(Color.WHITE);
        position[2].setBounds(164, 451, 233, 43);
        getContentPane().add(position[2]);

        position[1] = new JButton("");
        position[1].setBackground(Color.WHITE);
        position[1].setBounds(164, 494, 233, 43);
        getContentPane().add(position[1]);

        position[0] = new JButton("");
        position[0].setBackground(Color.WHITE);
        position[0].setBounds(164, 537, 233, 43);
        getContentPane().add(position[0]);

        setModal(true);
        setBounds(400, 20, 586, 690);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
