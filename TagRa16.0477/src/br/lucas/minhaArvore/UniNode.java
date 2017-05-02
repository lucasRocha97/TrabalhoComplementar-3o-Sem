package br.lucas.minhaArvore;

import java.util.List;

public interface UniNode<T> {
	
	public boolean isLeaf();
	
	public T getConteudo();
	
	//public UniNode<T> getPai();
	
	public void setPai(UniNode<T> node);
	
	public List<UniNode<T>> getFilhos();
	
	public void addFilhos(UniNode<T> node);
	
}
