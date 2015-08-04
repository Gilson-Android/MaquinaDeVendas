package br.com.ggc.maquinadevendas.objetos;

/**
 * Classe responsavel por gerenciar a entrada e saida de cedulas e moedas na
 * maquina
 * 
 * @author Gilson Gonçalves de Carvalho
 * 
 * @version 0.00001
 */

public class EstoqueDinheiro {
	private int moeda_25_Centavos;
	private int moeda_50_Centavos;
	private int moeda_1_Real;
	private int cedula_2_Reais;
	private int cedula_5_Reais;
	private int cedula_10_Reais;
	private Saldo saldo = new Saldo();

	public int getMoeda_25_Centavos() {
		return moeda_25_Centavos;
	}

	public void setMoeda_25_Centavos(int moeda_25_Centavos) {
		this.moeda_25_Centavos = moeda_25_Centavos;
	}

	public void addMoeda_25_Centavos() {
		this.saldo.addValor(0.25f);
		this.moeda_25_Centavos++;
	}

	public void removerMoeda_25_Centavos() {
		this.saldo.removerValor(0.25f);
		this.moeda_25_Centavos--;
	}

	public int getMoeda_50_Centavos() {
		return moeda_50_Centavos;
	}

	public void setMoeda_50_Centavos(int moeda_50_Centavos) {
		this.moeda_50_Centavos = moeda_50_Centavos;
	}

	public void addMoeda_50_Centavos() {
		this.saldo.addValor(0.50f);
		this.moeda_50_Centavos++;
	}

	public void removerMoeda_50_Centavos() {
		this.saldo.removerValor(0.50f);
		this.moeda_50_Centavos--;
	}

	public int getMoeda_1_Real() {
		return moeda_1_Real;
	}

	public void setMoeda_1_Real(int moeda_1_Real) {
		this.moeda_1_Real = moeda_1_Real;
	}

	public void addMoeda_1_Real() {
		this.saldo.addValor(1.0f);
		this.moeda_1_Real++;
	}

	public void removerMoeda_1_Real() {
		this.saldo.removerValor(1.0f);
		this.moeda_1_Real--;
	}

	public int getCedula_2_Reais() {
		return cedula_2_Reais;
	}

	public void setCedula_2_Reais(int cedula_2_Reais) {
		this.cedula_2_Reais = cedula_2_Reais;
	}

	public void addCedula_2_Reais() {
		this.saldo.addValor(2.0f);
		this.cedula_2_Reais++;
	}

	public void removerCedula_2_Reais() {
		this.saldo.removerValor(2.0f);
		this.cedula_2_Reais--;
	}

	public int getCedula_5_Reais() {
		return cedula_5_Reais;
	}

	public void setCedula_5_Reais(int cedula_5_Reais) {
		this.cedula_5_Reais = cedula_5_Reais;
	}

	public void addCedula_5_Reais() {
		this.saldo.addValor(5.0f);
		this.cedula_5_Reais++;
	}

	public void removerCedula_5_Reais() {
		this.saldo.removerValor(5.0f);
		this.cedula_5_Reais--;
	}

	public int getCedula_10_Reais() {
		return cedula_10_Reais;
	}

	public void setCedula_10_Reais(int cedula_10_Reais) {
		this.cedula_10_Reais = cedula_10_Reais;
	}

	public void addCedula_10_Reais() {
		this.saldo.addValor(10.0f);
		this.cedula_10_Reais++;
	}

	public void removerCedula_10_Reais() {
		this.saldo.removerValor(10.0f);
		this.cedula_10_Reais--;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public String liberarProduto(Produto _produto) {
		StringBuilder produtoLiberado = new StringBuilder();
		produtoLiberado.append("Produto liberado: " + _produto.getDescricao()
				+ "\n");
		produtoLiberado.append("Valor de compra: "
				+ String.format("R$ %10.2f", _produto.getValor_Produto())
				+ "\n");
		return produtoLiberado.toString();
	}

	// Esse metodo tem como objetivo acionar a libeção fisica de dinheiro da
	// maquina
	// Enviando sinal a um relé
	public String liberarTroco() {
		StringBuilder notasLiberadas = new StringBuilder();
		float total = saldo.getAtual();
		while (saldo.getAtual() >= 10 && cedula_10_Reais > 0) {
			removerCedula_10_Reais();
			notasLiberadas.append("Cedula de 10 reais liberada \n");
		}
		while (saldo.getAtual() >= 5 && cedula_5_Reais > 0) {
			removerCedula_5_Reais();
			notasLiberadas.append("Cedula de 5 reais liberada \n");
		}
		while (saldo.getAtual() >= 2 && cedula_2_Reais > 0) {
			removerCedula_2_Reais();
			notasLiberadas.append("Cedula de 2 reais liberada \n");
		}
		while (saldo.getAtual() >= 1 && moeda_1_Real > 0) {
			removerMoeda_1_Real();
			notasLiberadas.append("Moeda de 1 real liberada \n");
		}
		while (saldo.getAtual() >= 0.5 && moeda_50_Centavos > 0) {
			removerMoeda_50_Centavos();
			notasLiberadas.append("Moeda de 50 centavos liberada \n");
		}
		while (saldo.getAtual() >= 0.25 && moeda_25_Centavos > 0) {
			removerMoeda_25_Centavos();
			notasLiberadas.append("Moeda de 25 centavos liberada \n");
		}
		if (notasLiberadas.toString().length() > 0) {
			notasLiberadas.append("Total----------");
			notasLiberadas.append(String.format("R$ %10.2f", total));
		}

		return notasLiberadas.toString();
	}

}
