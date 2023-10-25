
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class FilaGUI extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static Fila fila = new Fila();
    private JButton posicoes[] = new JButton[10];
    private JButton frenteButton[] = new JButton[10];
    private JButton fimButton[] = new JButton[10];
    private int oldFrente = 0;
    private int oldFim = 0;

    public static void main(String[] args) {
        try {
            FilaGUI dialog = new FilaGUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FilaGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        setBounds(300, 100, 950, 500);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBackground(new Color(65, 65, 65)); //Cor do Background
        contentPanel.setLayout(null);

        JLabel lblFila = new JLabel("Queue");
        lblFila.setForeground(new Color(0, 0, 0));
        lblFila.setFont(new Font("Courier", Font.BOLD, 25));
        lblFila.setBounds(30, 0, 700, 80);
        lblFila.setVisible(true);
        contentPanel.add(lblFila);

        JButton botaoFilaInserir = new JButton("Inserir");
        botaoFilaInserir.setBackground(new Color(62, 66, 75));
        botaoFilaInserir.setForeground(Color.WHITE);
        botaoFilaInserir.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaInserir.setBounds(30, 130, 115, 30);
        contentPanel.add(botaoFilaInserir);


        botaoFilaInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.isFull()) {
                    JOptionPane input = new JOptionPane();
                    String conteudo = input.showInputDialog("Novo Elemento:");
                    if (conteudo != null && (conteudo.length()) > 0) {
                        try {
                            
                            int valor = Integer.parseInt(conteudo);

                            int fim = fila.getFim();
                            posicoes[fim].setText(conteudo);
                            posicoes[fim].setFont(new Font("Segoe UI", Font.PLAIN, 18));

                            fila.enQueue(valor);
                            
                            
                            if(oldFim != fim){
                                fimButton[oldFim].setVisible(false);
                            }

                            fimButton[fim].setVisible(true);

                            oldFim = fim;
                            

                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Digite um elemento válido", "Erro",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fila cheia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoFilaRemover = new JButton("Remover");
        botaoFilaRemover.setForeground(Color.WHITE);
        botaoFilaRemover.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaRemover.setBackground(new Color(62, 66, 75));
        botaoFilaRemover.setBounds(30, 180, 115, 30);
        contentPanel.add(botaoFilaRemover);

        botaoFilaRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.isEmpty()) {
                    int frente = fila.getFrente();
                    String removido = posicoes[frente].getText();
                    try {
            
                        posicoes[frente].setText("");
                        frente = (frente) % 10;
                        fila.deQueue();

                        frenteButton[frente+1].setVisible(true);
                        
                        
                        if(oldFrente != frente){
                            frenteButton[oldFrente+1].setVisible(false);
                        }else if(oldFrente == 0){
                            frenteButton[0].setVisible(false);
                        }

                        frenteButton[frente+1].setVisible(true);

                        oldFrente = frente;

                        JOptionPane.showMessageDialog(null, "Elemento removido: " + removido, "Removido",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Último elemento removido: " +
                                removido, "Vazia!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fila vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoFilaBuscar = new JButton("Buscar");
        botaoFilaBuscar.setBackground(new Color(62, 66, 75));
        botaoFilaBuscar.setForeground(Color.WHITE);
        botaoFilaBuscar.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaBuscar.setBounds(30, 230, 115, 30);
        contentPanel.add(botaoFilaBuscar);

        botaoFilaBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.isEmpty()) {
                    int frente = fila.getFrente();
                    String buscar = posicoes[frente].getText();
                    frente = (frente + 1) % 10;
                    fila.peek();
                    JOptionPane.showMessageDialog(null, "Primeiro elemento da fila: " + buscar, "Busca",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Fila vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Posições do botão do array

        posicoes[0] = new JButton("");
        posicoes[0].setBackground(Color.WHITE);
        posicoes[0].setBounds(200, 170, 70, 70);
        contentPanel.add(posicoes[0]);

        posicoes[1] = new JButton("");
        posicoes[1].setBackground(Color.WHITE);
        posicoes[1].setBounds(270, 170, 70, 70);
        contentPanel.add(posicoes[1]);

        posicoes[2] = new JButton("");
        posicoes[2].setBackground(Color.WHITE);
        posicoes[2].setBounds(340, 170, 70, 70);
        contentPanel.add(posicoes[2]);

        posicoes[3] = new JButton("");
        posicoes[3].setBackground(Color.WHITE);
        posicoes[3].setBounds(410, 170, 70, 70);
        contentPanel.add(posicoes[3]);

        posicoes[4] = new JButton("");
        posicoes[4].setBackground(Color.WHITE);
        posicoes[4].setBounds(480, 170, 70, 70);
        contentPanel.add(posicoes[4]);

        posicoes[5] = new JButton("");
        posicoes[5].setBackground(Color.WHITE);
        posicoes[5].setBounds(550, 170, 70, 70);
        contentPanel.add(posicoes[5]);

        posicoes[6] = new JButton("");
        posicoes[6].setBackground(Color.WHITE);
        posicoes[6].setBounds(620, 170, 70, 70);
        contentPanel.add(posicoes[6]);

        posicoes[7] = new JButton("");
        posicoes[7].setBackground(Color.WHITE);
        posicoes[7].setBounds(690, 170, 70, 70);
        contentPanel.add(posicoes[7]);

        posicoes[8] = new JButton("");
        posicoes[8].setBackground(Color.WHITE);
        posicoes[8].setBounds(760, 170, 70, 70);
        contentPanel.add(posicoes[8]);

        posicoes[9] = new JButton("");
        posicoes[9].setBackground(Color.WHITE);
        posicoes[9].setBounds(830, 170, 70, 70);
        contentPanel.add(posicoes[9]);

        //Posições do botão da frente

        frenteButton[0] = new JButton("Frente");
        frenteButton[0].setBackground(Color.GREEN);
        frenteButton[0].setBounds(200, 100, 70, 70);
        contentPanel.add(frenteButton[0]);
        frenteButton[0].setVisible(true);

        frenteButton[1] = new JButton("Frente");
        frenteButton[1].setBackground(Color.GREEN);
        frenteButton[1].setBounds(270, 100, 70, 70);
        contentPanel.add(frenteButton[1]);
        frenteButton[1].setVisible(false);
        
        frenteButton[2] = new JButton("Frente");
        frenteButton[2].setBackground(Color.GREEN);
        frenteButton[2].setBounds(340, 100, 70, 70);
        contentPanel.add(frenteButton[2]);
        frenteButton[2].setVisible(false);

        frenteButton[3] = new JButton("Frente");
        frenteButton[3].setBackground(Color.GREEN);
        frenteButton[3].setBounds(410, 100, 70, 70);
        contentPanel.add(frenteButton[3]);
        frenteButton[3].setVisible(false);

        frenteButton[4] = new JButton("Frente");
        frenteButton[4].setBackground(Color.GREEN);
        frenteButton[4].setBounds(480, 100, 70, 70);
        contentPanel.add(frenteButton[4]);
        frenteButton[4].setVisible(false);

        frenteButton[5] = new JButton("Frente");
        frenteButton[5].setBackground(Color.GREEN);
        frenteButton[5].setBounds(550, 100, 70, 70);
        contentPanel.add(frenteButton[5]);
        frenteButton[5].setVisible(false);

        frenteButton[6] = new JButton("Frente");
        frenteButton[6].setBackground(Color.GREEN);
        frenteButton[6].setBounds(620, 100, 70, 70);
        contentPanel.add(frenteButton[6]);
        frenteButton[6].setVisible(false);

        frenteButton[7] = new JButton("Frente");
        frenteButton[7].setBackground(Color.GREEN);
        frenteButton[7].setBounds(690, 100, 70, 70);
        contentPanel.add(frenteButton[7]);
        frenteButton[7].setVisible(false);

        frenteButton[8] = new JButton("Frente");
        frenteButton[8].setBackground(Color.GREEN);
        frenteButton[8].setBounds(760, 100, 70, 70);
        contentPanel.add(frenteButton[8]);
        frenteButton[8].setVisible(false);

        frenteButton[9] = new JButton("Frente");
        frenteButton[9].setBackground(Color.GREEN);
        frenteButton[9].setBounds(830, 100, 70, 70);
        contentPanel.add(frenteButton[9]);
        frenteButton[9].setVisible(false);

        //Posições do botão do fim
        
        fimButton[0] = new JButton("Fim");
        fimButton[0].setBackground(Color.RED);
        fimButton[0].setBounds(200, 240, 70, 70);
        contentPanel.add(fimButton[0]);
        fimButton[0].setVisible(true);

        fimButton[1] = new JButton("Fim");
        fimButton[1].setBackground(Color.RED);
        fimButton[1].setBounds(270, 240, 70, 70);
        contentPanel.add(fimButton[1]);
        fimButton[1].setVisible(false);

        fimButton[2] = new JButton("Fim");
        fimButton[2].setBackground(Color.RED);
        fimButton[2].setBounds(340, 240, 70, 70);
        contentPanel.add(fimButton[2]);
        fimButton[2].setVisible(false);

        fimButton[3] = new JButton("Fim");
        fimButton[3].setBackground(Color.RED);
        fimButton[3].setBounds(410, 240, 70, 70);
        contentPanel.add(fimButton[3]);
        fimButton[3].setVisible(false);

        fimButton[4] = new JButton("Fim");
        fimButton[4].setBackground(Color.RED);
        fimButton[4].setBounds(480, 240, 70, 70);
        contentPanel.add(fimButton[4]);
        fimButton[4].setVisible(false);

        fimButton[5] = new JButton("Fim");
        fimButton[5].setBackground(Color.RED);
        fimButton[5].setBounds(550, 240, 70, 70);
        contentPanel.add(fimButton[5]);
        fimButton[5].setVisible(false);

        fimButton[6] = new JButton("Fim");
        fimButton[6].setBackground(Color.RED);
        fimButton[6].setBounds(620, 240, 70, 70);
        contentPanel.add(fimButton[6]);
        fimButton[6].setVisible(false);

        fimButton[7] = new JButton("Fim");
        fimButton[7].setBackground(Color.RED);
        fimButton[7].setBounds(690, 240, 70, 70);
        contentPanel.add(fimButton[7]);
        fimButton[7].setVisible(false);

        fimButton[8] = new JButton("Fim");
        fimButton[8].setBackground(Color.RED);
        fimButton[8].setBounds(760, 240, 70, 70);
        contentPanel.add(fimButton[8]);
        fimButton[8].setVisible(false);

        fimButton[9] = new JButton("Fim");
        fimButton[9].setBackground(Color.RED);
        fimButton[9].setBounds(830, 240, 70, 70);
        contentPanel.add(fimButton[9]);
        fimButton[9].setVisible(false);
    }

    
}