public class No {
    private int valor;
    private No prox;
    
    public No() {
    	setValor(0);
        setProx(null);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
