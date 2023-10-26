public class ABP {
	private NoABP raiz;
	
	public ABP(){
		raiz = null;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/**Buscar recursivamente a partir da raiz.
	    Retorna o endereço se o elemento for
	    encontrado, caso contrário retorna NULL*/
	private NoABP busca(NoABP T, int valor) {
		if (T == null)
			return null;  // Arvore Vazia

		if(T.getConteudo() == valor)
			return T; 	// Elem. encontrado na raiz
		
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
	    else
			return busca(T.getDir(), valor);
	}
	
	/**Buscar um elemento na ABP
    		Retorna o endereço se o elemento for
    		encontrado, caso contrário retorna NULL*/
	public NoABP busca(int valor) {          
		//if (raiz != null) 
			return busca(raiz, valor);
		
		//return null;
	}
	public NoABP getRaiz() {
		return raiz;
	}
	/**Insere um nó em uma árvore ABP
	    Retorna 1 se a inserção for com sucesso.
	    Caso contrário retorna 0*/
	public int insere(int valor) {

		NoABP novoNo = new NoABP();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);

		String seq = "";
		int pos;

		// Quando a arvore estiver vazia, o novoNó será a raiz da arv
		if (raiz == null){ 
	 		raiz = novoNo;
			return 8;
		}

	    // Procura a posicao correta pra inserir o novo no
	    NoABP aux = raiz;
	    NoABP p = null;
	    while (aux != null) {
	    	p = aux;
			if (valor < aux.getConteudo()) {
				aux = aux.getEsq();
				seq += "0";
			} else {
				aux = aux.getDir();
				seq += "1";
			}
		}

		pos = posicoes(seq);

		if(pos == -1) {
			return pos;
		} else {
			// Encontrou um nó folha para inserir
			if (valor < p.getConteudo()) {
				p.setEsq(novoNo);
			} else {
				p.setDir(novoNo);
			}
		}
		
		return pos;
	}

	private int posicoes(String seq) {
		int posicao = 0;

		if(seq.equals("0")) { posicao = 4; } 
		else if (seq.equals("00")) { posicao = 2; }
		else if (seq.equals("000")) { posicao = 1; }
		else if (seq.equals("001")) { posicao = 3; }
		else if (seq.equals("01")) { posicao = 6; }
		else if (seq.equals("010")) { posicao = 5; }
		else if (seq.equals("011")) { posicao = 7; }
		else if (seq.equals("1")) { posicao = 12; }
		else if (seq.equals("10")) { posicao = 10; }
		else if (seq.equals("100")) { posicao = 9; }
		else if (seq.equals("101")) { posicao = 11; }
		else if (seq.equals("11")) { posicao = 14; }
		else if (seq.equals("110")) { posicao = 13; }
		else if (seq.equals("111")) { posicao = 15; }
		else { posicao = -1; }
		
		return posicao;
	}

	public void limparABP(int indice) {
		NoABP aux = raiz;
		int i = 0;
		while (i < indice) {			
			if(aux == null) {
				break;
			} else {
				aux = raiz;
				if(aux == null) {
					break;
				} else {
					// Se o valor procurado for menor que raiz,
					// continue pesquisando na sub-arv da esq.
					if (aux.getEsq() != null){
						aux = aux.getEsq();
					}
					// Caso contratio, pesquise na sub-arv 
					// da direita
					else if (aux.getDir() != null) {
						aux = aux.getDir();
					} else if (aux.getEsq() == null && aux.getDir() == null) {
						aux = null;
					}
				}
			}

			i++;
		}

		raiz = null;
	}

	public void limparABP() {
		raiz = null;
	}

	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private String exibePreOrdem(NoABP T) {
		String preOrdem = "";

		if (T == null)
			return "";
	
		// Imprime a raiz
		preOrdem += T.getConteudo();
		
		// Caminha recursivamente na sub-arv da esq (pre-ordem)
		if (T.getEsq() != null)
			preOrdem = preOrdem + " " + exibePreOrdem(T.getEsq());
	
		// Caminha recursivamente na sub-arv da dir (pre-ordem)
	 	if (T.getDir() != null)
		 	preOrdem = preOrdem + " " + exibePreOrdem(T.getDir());

		return preOrdem;
	}

	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public String exibePreOrdem() {
		if (raiz == null)
			return "Árvore vazia";
		else
			return exibePreOrdem(raiz);
	}	
	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private String exibeInOrdem(NoABP T) {
		String inOrdem = "";
		if (T == null)
			return "";

		if (T.getEsq() != null)
			inOrdem = inOrdem + " " + exibeInOrdem(T.getEsq());
	
		inOrdem = inOrdem + " " + T.getConteudo();
	
	 	if (T.getDir() != null)
		 	inOrdem = inOrdem + " " + exibeInOrdem(T.getDir());

			return inOrdem;
	}

	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public String exibeInOrdem() {
		if (raiz == null)
			return "Arvore vazia";
		else
			return exibeInOrdem(raiz);
	}	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private String exibePosOrdem(NoABP T) {
		String posOrdem = "";

		if (T == null)
			return "";

		if (T.getEsq() != null)
			posOrdem = posOrdem + " " + exibePosOrdem(T.getEsq());
	
	 	if (T.getDir() != null)
			posOrdem = posOrdem + " " + exibePosOrdem(T.getDir());

		posOrdem = posOrdem + " " + T.getConteudo();

		return posOrdem;
	}
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public String exibePosOrdem() {
		if (raiz == null)
			return "Arvore vazia";
		else
			return exibePosOrdem(raiz);
	}
	
	private Integer sucessor(NoABP T) {
		if(T.getEsq() != null) {
			return sucessor(T.getEsq());
		}
	    
		return T.getConteudo();
	}
	private NoABP remove(NoABP T, int valor) {
		 
		if(T == null) 
			return T;
	 	
		if(valor < T.getConteudo()) {
			T.setEsq(remove(T.getEsq(), valor));
		} else if(valor > T.getConteudo()) {
			T.setDir(remove(T.getDir(), valor));
		} else {
			// Caso 1: Nó é uma folha (não tem filhos)
			if(T.getEsq() == null && T.getDir() == null) {
				return null;
			} else if(T.getEsq() == null) {
				// Caso 2: Nó só tem o filho da esquerda
	            return T.getDir();
	        } else if(T.getDir() == null) {
	        	// Caso 3: Nó só tem o filho da direita
	            return T.getEsq();
	        } else {
	        	// Caso 3: Nó tem 2 filhos
	        	// Procura o sucessor (valor mais próximo na sub-arv da direita
	        	Integer minValue = sucessor(T.getDir());
	        	T.setConteudo(minValue);
	        	T.setDir(remove(T.getDir(), minValue));
	        }
		}
		
		return T;
	}
	 
	/** Remove o nó com um dado valor e retorna a nova raiz */
	public void remove(Integer valor) {
   	    remove(raiz, valor);
    }
}
