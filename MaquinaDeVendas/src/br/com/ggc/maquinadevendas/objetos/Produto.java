package br.com.ggc.maquinadevendas.objetos;
/**Classe responsavel dos produtos

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */


public class Produto extends Base {

	private float valor_Produto;
	private int quantidade;
	private boolean selecionado;

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
	
	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	
	public Produto(int _icone,String _descricao,float _valor_Produto,int _quantidade ){
		this.icone = _icone;
		this.descricao = _descricao;
		this.valor_Produto = _valor_Produto;
		this.quantidade = _quantidade;
	}

}
