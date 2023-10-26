import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABP_GUI extends JDialog {

    private JPanel contentPanel = new JPanel();
    private ABP abp = new ABP();

    private int indice;
    private int valor;

    private JLabel elementos[] = new JLabel[15];
    private JLabel linhas[] = new JLabel[15];

    public ABP_GUI() {
    	
    	 try {
             for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (Exception e) {
         }
    	 
        paintCabecalho();
        infoPanel();

        indice = 0;

        this.setModal(true);
		this.setBounds(0, 0, 1000, 600);
		this.setLocation(250, 50);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void paintCabecalho() {
    	  contentPanel.setBackground(new Color(65, 65, 65)); //Cor do Background
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
        contentPanel.setBounds(0, 0, 1000, 600);
        contentPanel.setVisible(true);

   
        
        JLabel l_icon = new JLabel();
        l_icon.setForeground(new Color(34, 38, 45));
		l_icon.setFont(new Font("Courier", Font.BOLD, 25));
        l_icon.setBounds(870, 462, 100, 80);
        l_icon.setVisible(true);
        this.getContentPane().add(l_icon);
        
        JLabel titulo = new JLabel("ÁRVORE BINÁRIA DE PESQUISA");
        titulo.setForeground(new Color(34, 38, 45));
		titulo.setFont(new Font("Courier", Font.BOLD, 25));
        titulo.setBounds(30, 0, 700, 80);
        titulo.setVisible(true);
        this.getContentPane().add(titulo);

     

        JButton b_limpar = new JButton("Limpar Arvore");
        
        b_limpar.setBounds(880, 30, 120, 30);
        b_limpar.setBackground(new Color(62, 66, 75));
        b_limpar.setAlignmentX(CENTER_ALIGNMENT);
        b_limpar.setAlignmentY(CENTER_ALIGNMENT);
        b_limpar.setFocusable(false);
        b_limpar.setVisible(true);
        this.getContentPane().add(b_limpar);
        b_limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpar();
                atualizaInfoPanel();
            }
        });
        
       
       
    }

    private void infoPanel() {
        JLabel info_text =  new JLabel();
        info_text.setText("<html> <p>pre-ordem: </p> <p>in-ordem: </p> <p>pos-ordem: </p> </html>");
        info_text.setBounds(50, 452, 130, 90);
        info_text.setForeground(new Color(34, 38, 45));
        info_text.setFont(new Font("Courier", Font.PLAIN, 18));
        this.getContentPane().add(info_text);
        
        JLabel info = new JLabel();
        info.setBounds(30, 452, 380, 90);
        info.setBackground(Color.LIGHT_GRAY);
        info.setOpaque(true);
        this.getContentPane().add(info);

        paintOp();
    }

    private void atualizaInfoPanel() {
        JLabel infos = new JLabel("");
        
            contentPanel.add(infos);
            infos.setText("<html> <p>" + abp.exibePreOrdem() + "</p> <p>" + abp.exibeInOrdem() + "</p> <p>" + abp.exibePosOrdem() + "</p> </html>");
            infos.setBounds(155, 452, 240, 90);
            infos.setForeground(new Color(34, 38, 45));
            infos.setFont(new Font("Courier", Font.BOLD, 18));
            infos.setHorizontalAlignment(SwingConstants.RIGHT);
            infos.setOpaque(true);
            infos.setBackground(Color.LIGHT_GRAY);
            infos.setVisible(true);
    }


    private void paintOp() {

        // INSERIR
        JButton b_inserir = new JButton("Inserir");
        b_inserir.setForeground(Color.WHITE);
        b_inserir.setBackground(new Color(62, 66, 75));
        b_inserir.setBounds(440, 460, 120, 30);
        b_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        b_inserir.setFocusable(false);
        this.getContentPane().add(b_inserir);
        
        JLabel l_inserir = new JLabel();
        l_inserir.setBounds(460, 500, 160, 35);
        l_inserir.setBorder(BorderFactory.createLoweredBevelBorder());
        l_inserir.setOpaque(false);
        this.getContentPane().add(l_inserir);
        
        JLabel t_inserir = new JLabel("<html> <p>Elemento: </p> </html>");
        t_inserir.setBounds(470, 500, 140, 35);
        t_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        t_inserir.setForeground(new Color(34, 38, 45));
        t_inserir.setHorizontalAlignment(SwingConstants.LEADING);
        t_inserir.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_inserir);
        
        JTextArea i_elemento = new JTextArea();
        i_elemento.setBounds(580, 509, 30, 18);
        i_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(i_elemento);

        b_inserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i_txtValor = i_elemento.getText();
                try {
                    resetColors();
                    valor = Integer.parseInt(i_txtValor);
                    if(i_txtValor.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    } else if(abp.busca(valor) == null) {
                        inserir(valor);
                    } else if(abp.busca(valor) != null) {
                        JOptionPane.showMessageDialog(null, "Valor " + i_txtValor + " já inserido na árvore", "[ERRO] INSERÇÃO INVÁLIDA", JOptionPane.WARNING_MESSAGE);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Digite um elemento válido", "[ERRO] ELEMENTO INVÁLIDO", JOptionPane.WARNING_MESSAGE);
                }
                i_elemento.setText("");
                atualizaInfoPanel();
            }
        });
        
        // BUSCAR
        JButton b_buscar = new JButton("Buscar");
        b_buscar.setForeground(Color.WHITE);
        b_buscar.setBackground(new Color(62, 66, 75));
        b_buscar.setBounds(650, 460, 120, 30);
        b_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        b_buscar.setFocusable(false);
        this.getContentPane().add(b_buscar);
        
        JLabel l_buscar = new JLabel();
        l_buscar.setBounds(670, 500, 160, 35);
        l_buscar.setBorder(BorderFactory.createLoweredBevelBorder());
        l_buscar.setOpaque(false);
        this.getContentPane().add(l_buscar);
        
        JLabel t_buscar = new JLabel("<html> <p>Elemento: </p> </html>");
        t_buscar.setBounds(680, 500, 140, 35);
        t_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        t_buscar.setForeground(new Color(34, 38, 45));
        t_buscar.setHorizontalAlignment(SwingConstants.LEADING);
        t_buscar.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_buscar);
        
        JTextArea b_elemento = new JTextArea();
        b_elemento.setBounds(790, 509, 30, 18);
        b_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(b_elemento);
        
        b_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String b_txtElem = b_elemento.getText();
                try {
                    resetColors();
                    if(b_txtElem.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!b_txtElem.equals("")) {
                        valor = Integer.parseInt(b_txtElem);
                        buscar(b_txtElem, valor);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "ERRO", "", JOptionPane.WARNING_MESSAGE);
                }
                b_elemento.setText("");
            }
        });
        
     // REMOVER
        JButton b_remover = new JButton("Remover");
        b_remover.setForeground(Color.WHITE);
        b_remover.setBackground(new Color(62, 66, 75));
        b_remover.setBounds(850, 460, 120, 30);
        b_remover.setFont(new Font("Courier", Font.BOLD, 18));
        b_remover.setFocusable(false);
        this.getContentPane().add(b_remover);

        JLabel l_remover = new JLabel();
        l_remover.setBounds(870, 500, 160, 35);
        l_remover.setBorder(BorderFactory.createLoweredBevelBorder());
        l_remover.setOpaque(false);
        this.getContentPane().add(l_remover);

        JLabel t_remover = new JLabel("<html> <p>Elemento: </p> </html>");
        t_remover.setBounds(880, 500, 140, 35);
        t_remover.setFont(new Font("Courier", Font.PLAIN, 18));
        t_remover.setForeground(new Color(34, 38, 45));
        t_remover.setHorizontalAlignment(SwingConstants.LEADING);
        t_remover.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_remover);

        JTextArea r_elemento = new JTextArea();
        r_elemento.setBounds(990, 509, 30, 18);
        r_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(r_elemento);
        
        b_remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r_txtElem = r_elemento.getText();
                try {
                    resetColors();
                    if(r_txtElem.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int valorRemover = Integer.parseInt(r_txtElem);
                        remover(valorRemover);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Digite um elemento válido", "[ERRO] ELEMENTO INVÁLIDO", JOptionPane.WARNING_MESSAGE);
                }
                r_elemento.setText("");
                atualizaInfoPanel();
            }
        });
        
    }
    
    private void remover(int valor) {
        NoABP noRemover = abp.busca(valor);

        if (noRemover != null) {
            abp.remove(valor);
            removerVisual(noRemover); // Adicione esta linha
            atualizaInfoPanel();
            JOptionPane.showMessageDialog(null, "Elemento removido: " + valor, "Remoção Concluída", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Elemento não encontrado na árvore", "[ERRO] ELEMENTO INEXISTENTE", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void removerVisual(NoABP no) {
        if (no != null) {
            removerVisual(no.getEsq());
            removerVisual(no.getDir());

            for (int i = 0; i < indice; i++) {
                if (elementos[i].getText().equals(String.valueOf(no.getConteudo()))) {
                    contentPanel.remove(elementos[i]);
                    removeElementoArray(i);
                    break;
                }
            }
            for (int i = 0; i < indice; i++) {
                if (linhas[i] != null && linhas[i].isVisible()) {
                    contentPanel.remove(linhas[i]);
                }
            }
            this.getContentPane().repaint();
            this.contentPanel.revalidate();
          //  contentPanel.repaint();
            }
    }
    
    private void removeElementoArray(int index) {
        for (int i = index; i < indice - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[indice - 1] = null;
        indice--;
    }
    
    private void inserir(int valor) {
        int pos;

        pos = abp.insere(valor);

        if(pos == -1) {
            JOptionPane.showMessageDialog(null, "Não é possível adicionar o elemento " + valor, "[ERRO] PROFUNDIDADE MÁXIMA ATINGIDA", JOptionPane.WARNING_MESSAGE);
        } else if (pos == 8) {
            paintElem(pos, valor);
        } else {
            paintLinha(pos);
            paintElem(pos, valor);
        }

        indice++;
    }
    
    private void buscar(String texto, int valor) {
        if(abp.vazia()) {
            JOptionPane.showMessageDialog(null, "Não há elementos na árvore", "[ERRO] ÁRVORE VAZIA", JOptionPane.WARNING_MESSAGE);
        } else {
            NoABP aux = abp.busca(valor);

            if(aux == null) {
                JOptionPane.showMessageDialog(null, "Elemento não inserido na árvore", "[ERRO] ELEMENTO INEXISTENTE", JOptionPane.WARNING_MESSAGE);
            } else {
                for(int i = 0; i < indice; i++) {
                    elementos[i].setBackground(Color.GREEN);
                    if(elementos[i].getText().equals(texto)) {
                        break;
                    }
                    if(i == 0) {
                        elementos[0].setBackground(Color.LIGHT_GRAY);
                    } else {
                        elementos[i].setBackground(Color.WHITE);
                    }
                }
            }

        }
    }

    private void resetColors() {
        for(int i = 0; i < indice; i++) {
            if(i == 0) {
                elementos[0].setBackground(Color.LIGHT_GRAY);
            } else {
                elementos[i].setBackground(Color.WHITE);
            }
        }
    }

    private void paintElem(int pos, int valor) {
        int x = 0, y = 0;

        if(pos == 8) { x = 450; y = 70;  }
        if(pos == 4) { x = 220; y = 180; }
        if(pos == 12) { x = 680; y = 180; }
        if(pos == 2) { x = 105; y = 280; }
        if(pos == 6) { x = 335; y = 280; }
        if(pos == 10) { x = 565; y = 280; }
        if(pos == 14) { x = 795; y = 280; }
        if(pos == 1) { x = 30;  y = 370; }
        if(pos == 3) { x = 150; y = 370; }
        if(pos == 5) { x = 270; y = 370; }
        if(pos == 7) { x = 390; y = 370; }
        if(pos == 9) { x = 510; y = 370; }
        if(pos == 11) { x = 630; y = 370; }
        if(pos == 13) { x = 750; y = 370; }
        if(pos == 15) { x = 870; y = 370; }
        
        JLabel elem =  new JLabel("" + valor);
        elementos[indice] = elem;
        contentPanel.add(elementos[indice]);
        elementos[indice].setBounds(x, y, 80, 60);
        elementos[indice].setFont(new Font("Courier", Font.BOLD, 25));
        elementos[indice].setForeground(new Color(34, 38, 45));
        elementos[indice].setBackground(Color.WHITE);
        elementos[0].setBackground(Color.LIGHT_GRAY);
        elementos[indice].setBorder(BorderFactory.createLineBorder(new Color(34, 38, 45)));
        elementos[indice].setHorizontalAlignment(SwingConstants.CENTER);
        elementos[indice].setOpaque(true);
        elementos[indice].setVisible(true);
    }
    
    private void paintLinha(int pos) {
        int x = 0, y = 0;
        int w = 0, h = 0;
        String path = "";
        
        if(pos == 4) { x = 260; y = 130; path = "imagens/Line1_esq.png"; w = 231; h = 51; }
        if(pos == 2) { x = 145; y = 240; path = "imagens/Line2_esq.png"; w = 116; h = 41; } 
        if(pos == 10) { x = 605; y = 240; path = "imagens/Line2_esq.png"; w = 116; h = 41; } 
        if(pos == 1) { x = 70; y = 340; path = "imagens/Line4_esq.png"; w = 76; h = 31; } 
        if(pos == 5) { x = 310; y = 340; path = "imagens/Line5_esq.png"; w = 66; h = 31; } 
        if(pos == 9) { x = 550; y = 340; path = "imagens/Line6_esq.png"; w = 56; h = 31; } 
        if(pos == 13) { x = 790; y = 340; path = "imagens/Line7_esq.png"; w = 47; h = 31; }
        if(pos == 12) { x = 490; y = 130; path = "imagens/Line1_dir.png"; w = 231; h = 51; }
        if(pos == 6) { x = 260; y = 240; path = "imagens/Line2_dir.png"; w = 116; h = 41; } 
        if(pos == 14) { x = 720; y = 240; path = "imagens/Line2_dir.png"; w = 116; h = 41; } 
        if(pos == 3) { x = 145; y = 340; path = "imagens/Line4_dir.png"; w = 47; h = 31; } 
        if(pos == 7) { x = 375; y = 340; path = "imagens/Line5_dir.png"; w = 56; h = 31; } 
        if(pos == 11) { x = 605; y = 340; path = "imagens/Line6_dir.png"; w = 66; h = 31; } 
        if(pos == 15) { x = 835; y = 340; path = "imagens/Line7_dir.png"; w = 76; h = 31; }
        
        ImageIcon icon_linha = new ImageIcon(path);
        JLabel l_linha = new JLabel();
        linhas[indice-1] = l_linha;
        contentPanel.add(linhas[indice-1]);
        linhas[indice-1].setIcon(icon_linha);
        linhas[indice-1].setBounds(x, y, w, h);
        linhas[indice-1].setVisible(true);
    }

    private void limpar() {
        if(indice == 0) {
            this.getContentPane().repaint();
        } else if (indice == 1) {
            elementos[0].setVisible(false);
            contentPanel.remove(elementos[0]);
            indice--;
            limpar();
        } else {
            int i = indice;
            for(indice = i; indice > 1; indice--) {
                elementos[indice-1].setVisible(false);
                linhas[indice-2].setVisible(false);
                contentPanel.remove(elementos[indice-1]);
            }
            limpar();
        }
        
        abp.limparABP();
        indice = 0;
    }
    
    
    
    public static void main(String[] args) {
        try {
			ABP_GUI ABP = new ABP_GUI();
			ABP.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ABP.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
