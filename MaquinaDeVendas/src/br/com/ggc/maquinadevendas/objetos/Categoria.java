package br.com.ggc.maquinadevendas.objetos;
/**Classe responsavel por agrupar os produtos por categoria

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */

import java.util.ArrayList;

public class Categoria extends Base {
	ArrayList<Produto> listaProduto = new ArrayList<>();
	
	public Categoria(){
		listaProduto = new ArrayList<>();
	}

	public ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(ArrayList<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
}

