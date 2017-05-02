package br.lucas.minhaArvore;

import java.util.ArrayList;
import java.util.List;

public class UniNodeImpl<T> implements UniNode<T> {
	
	private UniNode<T> pai;
	private List<UniNode<T>> filhos;
	private T conteudo;
	
	public UniNodeImpl(T t){
		this.conteudo = t;
	}

	@Override
	public boolean isLeaf() {
		return this.filhos == null;
	}

	@Override
	public T getConteudo() {
		return this.conteudo;
	}

//	@Override
//	public UniNode<T> getPai() {
//		return pai;
//	}

	@Override
	public List<UniNode<T>> getFilhos() {
		return filhos;
	}
	
	@Override
	public void setPai(UniNode<T> node) {
		this.pai = (UniNodeImpl<T>) node;
	}
	
	@Override
	public void addFilhos(UniNode<T> node) {
		if(this.filhos == null){
			this.filhos = new ArrayList<>();
		}
		this.filhos.add(node);
		//node.setPai(this);
	}

}
