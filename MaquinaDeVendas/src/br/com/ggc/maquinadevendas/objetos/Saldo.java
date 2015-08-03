package br.com.ggc.maquinadevendas.objetos;

public class Saldo {
	
	float atual = 0;
	int produtoSelecionado;
	
	public float getAtual() {
		return atual;
	}

	public void addValor(float _valor){
		atual += _valor;
	}
	
	public void removerValor(float _valor){
		atual -= _valor;
	}

	public int getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(int produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
