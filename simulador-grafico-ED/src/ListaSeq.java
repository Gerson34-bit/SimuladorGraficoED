

public class ListaSeq{
    private int dados[];
    private int nElementos;

    public ListaSeq(){
        nElementos = 0;
        dados = new int[10];
    }
    
    /** Verifica se a Lista está vazia */
    public boolean vazia(){
        if(nElementos == 0){
            return true;
        }
        else{
            return false;
        }
    }
    /**Verifica se a Lista está cheia */

    public boolean cheia(){
        if(nElementos == 10){
            return true;
        }
        else{
            return false;
        }
    }
    /**Obtém o numero de elementos da lista*/

    public int nElementos(){
        return nElementos;
    }
    
    //obtem a posição de um elemento da lista com base no valor
    public int posicao(int valor){
        for(int i = 0; i < nElementos; i++){
            if(dados[i] == valor){
                return(i + 1);
            }
        }
        //se o elemento não for encontrado
        return -1;
    }
    
    //obtem um elemento da lista com base na posição
    public int elemento(int posicao){
        if(posicao > 10 || posicao < 1){
            return -1;
        }
        else{
            return dados[posicao-1];
        }
    }
    
    
    public boolean insere(int posicao, int valor){
        if(cheia() || posicao > (nElementos+1) || posicao < 1){
            return false;
        }
        else{
            for(int i = nElementos; i >= posicao; i--){
                dados[i] = dados[i-1];
            }
            dados[posicao-1] = valor;
            nElementos++;
            return true;
        }
    }
    public int remove(int posicao){
        int aux;
        if(posicao > nElementos || posicao < 1){
            return -1;
        }
        else{
          aux  = dados[posicao-1];
            for(int i = (posicao - 1); i < nElementos - 1; i++){
                dados[i] = dados[i+1];
            }
            nElementos--;
            return aux;
        }
    }

}