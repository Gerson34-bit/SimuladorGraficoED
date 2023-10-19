import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class LSE_GUI extends JDialog {
    

 
	private static final long serialVersionUID = -2410283143543094655L;
	private LSE lista = new LSE();
    private JButton[] pBtn = new JButton[10];
	private JPanel contentPane;
	private JLabel[] setas = new JLabel[9];


	public static void main(String[] args){
        try{
            LSE_GUI dialog = new LSE_GUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    
public LSE_GUI(){
       
    	
    	this.setBounds(100, 100, 1000, 600);
        this.setLocation(250,50);
        this.setTitle("Lista Sequencial");
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setBackground(new Color(255, 200, 100));
    
        contentPane = new JPanel();
        contentPane .setSize(800,500);
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(null);
        this.setVisible(true);
        this.setContentPane(contentPane);

     
        
        JButton btnInserir = new JButton("Inserir");
        btnInserir.setFont(new Font("Courrier", Font.BOLD, 18));
        btnInserir.setForeground(Color.BLACK);
        btnInserir.setBackground(Color.WHITE);
        btnInserir.setBounds(75,75,120,50);
        btnInserir.setBorder(null);
        contentPane.add(btnInserir);
     

        JButton btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("Courrier", Font.BOLD, 18));
        btnRemover.setForeground(Color.BLACK);
        btnRemover.setBackground(Color.WHITE);
        btnRemover.setBounds(75,150,120,50);
        btnRemover.setBorder(null);
        contentPane.add(btnRemover);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Courrier", Font.BOLD, 18));
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setBounds(75,225,120,50);
        btnBuscar.setBorder(null);
        contentPane.add(btnBuscar);
    
     
    
    
        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String conteudo = JOptionPane.showInputDialog("Novo Elemento");
                String indice = JOptionPane.showInputDialog("Posição do novo elemento");
                int tamanho = lista.tamanho();
                 if(conteudo!=null && indice!= null){
                     try{
                        int posicao = Integer.parseInt(indice);
                        int valor = Integer.parseInt(conteudo);
                        if(lista.insere(posicao,valor)){
                            for(int i = tamanho; i >= posicao; i--){
                                String p = pBtn[i-1].getText();
                                pBtn[i].setText(p);
                            }
                            pBtn[posicao-1].setText(""+valor);
                            
                        }
                        else if(pBtn[9].isShowing()){
                            JOptionPane.showMessageDialog(null,"Operação Inválida","ERRO",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            dispose();
                        }
                    }catch(Exception ex) {}
               }
                

            }

        });

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!lista.vazia()) {
                        String conteudo = JOptionPane.showInputDialog("Remover elemento na posição:");
                        int posicao = Integer.parseInt(conteudo);
                        int tamanho = lista.tamanho();

                        if (tamanho == 1 && posicao == 1) {
                            // Se há apenas um elemento na lista e a posição a ser removida é 1
                            lista.remove(posicao);
                            pBtn[0].setText("");  // Limpa o texto do único botão
                            JOptionPane.showMessageDialog(null, "Elemento removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } else if (posicao >= 1 && posicao <= tamanho) {
                            lista.remove(posicao);
                            
                            // Atualiza a interface gráfica após a remoção do elemento
                            for (int i = posicao - 1; i < tamanho - 1; i++) {
                                String r = pBtn[i + 1].getText();
                                pBtn[i].setText(r);
                                pBtn[i + 1].setText("");  // Limpa o texto do próximo botão
                            }

                            // Limpa o texto do último botão após a remoção
                            pBtn[tamanho - 1].setText("");
                            
                            JOptionPane.showMessageDialog(null, "Elemento removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Posição inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "A Lista Sequencial está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    // Captura e trata qualquer exceção que possa ocorrer durante o processo.
                }
            }
        });
      






        
        
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!lista.vazia()){
                    String conteudo = JOptionPane.showInputDialog("Buscar elemento:");
                        int elBuscado = Integer.parseInt(conteudo);
                        int res = lista.posicao(elBuscado);
                    if(res != -1){
                        JOptionPane.showMessageDialog(null,"Elemento está na posição: "+ res,"Resultado",JOptionPane.INFORMATION_MESSAGE );
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Elemento não encontrado. ","Atenção",JOptionPane.WARNING_MESSAGE );
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"A Lista está vazia!!!","Erro", JOptionPane.ERROR_MESSAGE);
                }


            }
        });


        pBtn[0] = new JButton("");
        pBtn[0].setBackground(Color.WHITE);
        pBtn[0].setBounds(123,300,73,72);
        contentPane.add(pBtn[0]);
        
        pBtn[1] = new JButton("");
        pBtn[1].setBackground(Color.WHITE);
        pBtn[1].setBounds(192 + 80,300,73,72);
        contentPane.add(pBtn[1]);
        
        pBtn[2] = new JButton("");
        pBtn[2].setBackground(Color.WHITE);
        pBtn[2].setBounds(263 + 160,300,73,72);
        contentPane.add(pBtn[2]);
        
        pBtn[3] = new JButton("");
        pBtn[3].setBackground(Color.WHITE);
        pBtn[3].setBounds(336 + 240,300,73,72);
        contentPane.add(pBtn[3]);
        
        pBtn[4] = new JButton("");
        pBtn[4].setBackground(Color.WHITE);
        pBtn[4].setBounds(409 + 320,300,73,72);
        contentPane.add(pBtn[4]);
        
        pBtn[5] = new JButton("");
        pBtn[5].setBackground(Color.WHITE);
        pBtn[5].setBounds(482 + 400,300,73,72);
        contentPane.add(pBtn[5]);
        
        pBtn[6] = new JButton("");
        pBtn[6].setBackground(Color.WHITE);
        pBtn[6].setBounds(555 + 480,300,73,72);
        contentPane.add(pBtn[6]);
        
        pBtn[7] = new JButton("");
        pBtn[7].setBackground(Color.WHITE);
        pBtn[7].setBounds(628 + 560,300,73,72);
        contentPane.add(pBtn[7]);
        
        pBtn[8] = new JButton("");
        pBtn[8].setBackground(Color.WHITE);
        pBtn[8].setBounds(701 + 640,300,73,72);
        contentPane.add(pBtn[8]);
        
        pBtn[9] = new JButton("");
        pBtn[9].setBackground(Color.WHITE);
        pBtn[9].setBounds(774 + 720,300,73,72);
        contentPane.add(pBtn[9]);
        
        configurarSetas(); 
      
    }

    private void configurarSetas() {
        for (int i = 0; i < 9; i++) {
            setas[i] = new JLabel("→");  // Usamos "→" como a representação da seta
            setas[i].setBounds(220 + i * 153, 300, 73, 72);
            setas[i].setFont(new Font("Courier", Font.BOLD, 40));
            setas[i].setForeground(Color.GREEN);
            contentPane.add(setas[i]);
        }
        contentPane.repaint();
    }

}


