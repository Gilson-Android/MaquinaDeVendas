package br.com.ggc.maquinadevendas.objetos;
/**Classe base

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */

public class Base {

	protected String  descricao;
	// Vai receber o id do Resource
	protected int icone;
		
	public Base(int _icone, String _descricao){
		this.icone = _icone;
		this.descricao = _descricao;
	}
	
	public Base(){
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIcone() {
		return icone;
	}

	public void setIcone(int icone) {
		this.icone = icone;
	}
	
	
	
}
