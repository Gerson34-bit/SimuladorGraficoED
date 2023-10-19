public class LDE {
	
	private No cabeca;
	private int tamanho;
	
	public LDE() {
		cabeca = null;
		tamanho = 0;
	}
	
	/** Verifica se a lista esta vazia */
	public boolean vazia() {
	    if (tamanho == 0)
	        return true;
	    else
	        return false;
	}

	/** Obtem o tamanho da lista*/
	public int tamanho() {
	    return tamanho;
	}

	/** Obtem o i-esimo elemento de uma lista
	    Retorna o valor encontrado. */
	public int elemento (int pos) {
	    No aux = cabeca;
	    int cont = 1;

	    if (vazia()) {
	        return -1; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())) {
	        return -1; // Posicao invalida 
	    }

	    // Percorre a lista do 1o elemento ate pos 
	    while (cont < pos) {
	        // Modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getValor();
	}

	/** Retorna a posicao de um elemento pesquisado
	    Retorna 0 caso não seja encontrado */
	public int posicao (int dado) {
	    int cont = 1;
	    No aux;

	    /* Lista vazia */
	    if (vazia()) {
	        return -1;
	    }

	    /* Percorre a lista do inicio ao fim ate encontrar o elemento */
	    aux = cabeca;
		while (aux != null) {
	        /* Se encontrar o elemento, retorna sua posicao n */
	        if (aux.getValor() == dado) {
	            return cont;
	        }

	        /* Modifica "aux" para apontar para o proximo elemento da lista */
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	/** Insere no em lista vazia */
	private boolean insereInicioLista(int valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setValor(valor);
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    tamanho++;
	    return true;
	}

	/** Insere no no meio da lista */
	private boolean insereMeioLista(int pos, int dado) {
	    int cont = 1;

	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setValor(dado);

	    // Localiza a posicao onde sera inserido o novo no
	    No aux = cabeca;
	    while ((cont < pos-1) && (aux != null)) {
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // posicao invalida 
	    		return false;
	    }

	    // Insere novo elemento apos aux
	    novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);

	    tamanho++;
	    return true;
	}

	/** Insere no no fim da lista */
	private boolean insereFimLista(int dado) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setValor(dado);

	    // Procura o final da lista 
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.tamanho++;
	    return true;
	}

	/** Insere um elemento em uma determinada posicao
	    Retorna true se conseguir inserir e false caso contrario */
	public boolean insere(int pos, int dado) {
		if ((vazia()) && (pos != 1)) {
	        return false; // Lista vazia mas posicao invalida
	    }
	 	/* Inserção no inicio da lista (ou lista vazia) */
	    if (pos == 1) {
	        return insereInicioLista(dado);
	    }
	    /* inserção no fim da lista */
	    else if (pos == tamanho+1) {
	        return insereFimLista(dado);
		}
		/* inserção no meio da lista */
		else {
			return insereMeioLista(pos, dado);
		}
	}

	/** Remove elemento do inicio da lista */
	private int removeInicioLista() {
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int dado = p.getValor();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    tamanho--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos) {
		No atual = null, antecessor = null;
		int dado = -1;
		int cont = 1;

		/* Localiza o no que sera removido */
		atual = cabeca;
		while((cont < pos) && (atual != null)) {
			antecessor = atual;
			atual = atual.getProx();
			cont++;
		}

		if (atual == null) { /* posicao invalida */
		return -1;
		}

	    /* retira o elemento da lista */
	    dado = atual.getValor();
	    antecessor.setProx(atual.getProx());
	    tamanho--;

	    /* Sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p */
	    atual = null;
	    return dado;
	}

	/** Remove um elemento de uma determinada posicao
	    Retorna o valor a ser removido
	    -1 se a posicao for invalida ou a lista estiver vazia */
	public int remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    	return -1;
	    }

	    // Remocao do elemento da cabeca da lista 
	    if (pos == 1) {
	        return removeInicioLista();
	    }
	    // Remocao em outro lugar da lista
	    else {
	        return removeNaLista(pos);
	    }
	}	
}



