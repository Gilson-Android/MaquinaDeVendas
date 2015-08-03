package br.com.ggc.maquinadevendas.objetos;

import android.R.bool;

public class Produto extends Base {

	private float valor_Produto;
	private int quantidade;

	public float getValor_Produto() {
		return valor_Produto;
	}

	public void setValor_Produto(float valor_Produto) {
		this.valor_Produto = valor_Produto;
	}
		
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void removerProduto() {
		this.quantidade --;
	}

	public Produto(int _icone,String _descricao,float _valor_Produto,int _quantidade ){
		this.icone = _icone;
		this.descricao = _descricao;
		this.valor_Produto = _valor_Produto;
		this.quantidade = _quantidade;
	}
}
