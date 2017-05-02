package br.lucas.minhaArvore;

public class UniArvoreImpl<T> implements UniArvore<T> {
	
	class UniNode {
		
	}
	
	private T raiz;
	
	public UniArvoreImpl(T noRaiz){
		this.raiz = noRaiz;
	}
	
	public T getRaiz() {
		return raiz;
	}

}
