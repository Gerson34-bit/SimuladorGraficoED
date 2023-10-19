public class PilhaSequencial {
    public int topo;
    public int dados[];
    public int tamanho = 8;

    public PilhaSequencial() {
        dados = new int[tamanho];
        topo = -1;
    }

    public boolean vazia() {
        if (topo == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cheia() {
        if (topo == (tamanho - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public int getTamanho() {
        return (topo + 1);
    }

    public int top() {
        return dados[topo];
    }

    public boolean push(int valor) {
        if (cheia()) {
            return false;
        }
        topo++;
        dados[topo] = valor;
        return true;
    }

    public int pop() {
        if (vazia()) {
            return 0;
        }
        topo--;
        return dados[topo];
    }
}
