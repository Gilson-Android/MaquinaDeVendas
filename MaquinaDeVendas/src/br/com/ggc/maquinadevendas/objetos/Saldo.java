package br.com.ggc.maquinadevendas.objetos;
/**Classe responsavel por saldo disponivel para compra

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */

public class Saldo {
	
	float atual = 0;
	int produtoSelecionado = -1;
	
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
