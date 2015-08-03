package br.com.ggc.maquinadevendas.objetos;

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
