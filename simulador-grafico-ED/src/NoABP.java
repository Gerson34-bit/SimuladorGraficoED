public class NoABP {

	private int conteudo;
	private NoABP esq;
	private NoABP dir;
	
	public NoABP() {
		esq = null;
		dir = null;
	}
	
	public int getConteudo() {
		return conteudo;
	}
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}
	
	public NoABP getEsq() {
		return esq;
	}
	public void setEsq(NoABP esq) {
		this.esq = esq;
	}
	
	public NoABP getDir() {
		return dir;
	}
	
	public void setDir(NoABP dir) {
		this.dir = dir;
	}
    
}
