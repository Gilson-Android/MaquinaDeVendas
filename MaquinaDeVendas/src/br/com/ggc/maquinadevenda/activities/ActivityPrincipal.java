package br.com.ggc.maquinadevenda.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import br.com.ggc.maquinadevendas.R;
import br.com.ggc.maquinadevendas.adapter.AdapterCategoria;
import br.com.ggc.maquinadevendas.adapter.AdapterProduto;
import br.com.ggc.maquinadevendas.objetos.*;

public class ActivityPrincipal extends Activity {

	ViewPager viewPager_CategoriaProduto;
	GridView gridView_Produto;
	ArrayList<Categoria> listaCategoria;
	ImageButton button_Voltar,button_Avancar;
	ImageButton button_25_centavos,button_50_centavos,button_1_Real,button_2_Reais,button_5_Reais,button_10_Reais;
	Button button_Confirmar,button_Cancelar;
	TextView textView_Saldo;
	EstoqueDinheiro estoqueDinheiro = new EstoqueDinheiro();
	ArrayList<Produto> listaProduto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_principal);
		
		button_Confirmar = (Button) findViewById(R.id.Activiy_Principal_bt_confirmar);
		button_Cancelar = (Button) findViewById(R.id.Activiy_Principal_bt_cancelar);
		button_Voltar = (ImageButton) findViewById(R.id.Activiy_Principal_bt_voltar);
		button_Avancar = (ImageButton) findViewById(R.id.Activiy_Principal_bt_avancar);
		button_25_centavos = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_25_centavos);
		button_50_centavos = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_50_centavos);
		button_1_Real = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_1_real);
		button_2_Reais = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_2_reais);
		button_5_Reais = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_5_reais);
		button_10_Reais = (ImageButton) findViewById(R.id.Activiy_Principal_bt_somar_10_reais);
		textView_Saldo = (TextView) findViewById(R.id.Activiy_Principal_tv_credito);
		viewPager_CategoriaProduto = (ViewPager) findViewById(R.id.Activiy_Principal_vp_categoria);
		gridView_Produto = (GridView) findViewById(R.id.Activiy_Principal_gv_produto);
		listaCategoria = new ArrayList<>();
		
		
		carregarMostruario();
		
		carregarEventos();
		
		atualizarSaldoTela();
		
		carregarEstoqueDinheiro();
		
		AdapterCategoria adaptercategoria = new AdapterCategoria(this, listaCategoria);
		
		viewPager_CategoriaProduto.setAdapter(adaptercategoria);
		
		AdapterProduto adapterProduto = new AdapterProduto(ActivityPrincipal.this, listaCategoria.get(0).getListaProduto());	
		gridView_Produto.setAdapter(adapterProduto);
		
		button_Voltar.setEnabled(false);
	}
	
	//Metodo que possivelmente tera origem de um xml,json ou sqllite
	//Também existe a possibilidade da maquina ter uma rotina fisica que faz o scaneamento dos produtos existentes
	public void carregarMostruario(){
		Categoria categoria = new Categoria();
		categoria.setDescricao("Todas Categorias");
		listaCategoria.add(categoria);
		
		categoria = new Categoria();
		categoria.setDescricao("Refrigerante");
		categoria.setIcone(R.drawable.ic_refrigerante);
		categoria.getListaProduto().add(new Produto(R.drawable.ic_coca_cola, "Coca Cola", 4.00F,1));
		categoria.getListaProduto().add(new Produto(0, "Coca-Cola Light", 4.00F,0));
		categoria.getListaProduto().add(new Produto(0, "Coca Zero", 4.00F,1));
		categoria.getListaProduto().add(new Produto(0, "Fanta", 3.50F,1));
		categoria.getListaProduto().add(new Produto(0, "Sprite", 3.00F,0));
		categoria.getListaProduto().add(new Produto(0, "Kuat", 3.50F,1));
		categoria.getListaProduto().add(new Produto(0, "Pepsi-Cola", 3.50F,0));
		categoria.getListaProduto().add(new Produto(0, "Schweppes", 4.00F,1));
		listaCategoria.add(categoria);
		
		categoria = new Categoria();
		categoria.setDescricao("Agua");
		categoria.setIcone(R.drawable.ic_agua);
		categoria.getListaProduto().add(new Produto(0, "Ana Rosa", 1.00F,1));
		categoria.getListaProduto().add(new Produto(0, "Timbu", 1.50F,1));
		categoria.getListaProduto().add(new Produto(0, "Frescale", 4.00F,0));
		categoria.getListaProduto().add(new Produto(0, "CRYSTAL", 3.50F,0));
		categoria.getListaProduto().add(new Produto(0, "Sprite", 3.00F,1));
		listaCategoria.add(categoria);
		
		categoria = new Categoria();
		categoria.setDescricao("Chocolate");
		categoria.setIcone(R.drawable.ic_chocolate);
		categoria.getListaProduto().add(new Produto(0, "Arcor", 3.00F,1));
		categoria.getListaProduto().add(new Produto(0, "Cacau Show", 4.50F,0));
		categoria.getListaProduto().add(new Produto(0, "Ferrero", 4.00F,1));
		listaCategoria.add(categoria);
		
		listaProduto = new ArrayList<>();
		for (Categoria item : listaCategoria) {
			for (Produto produtos : item.getListaProduto()) {
				listaCategoria.get(0).getListaProduto().add(produtos);
			}
		}
	}
	
	private void carregarEventos(){
		
		viewPager_CategoriaProduto.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageSelected(int _position) {
				// TODO Auto-generated method stub
				AdapterProduto	adapterProduto = new AdapterProduto(ActivityPrincipal.this, listaCategoria.get(_position).getListaProduto());
				
				gridView_Produto.setAdapter(adapterProduto);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				//Toast.makeText(ActivityPrincipal.this, "arg0:" + arg0 + " - arg1:" + arg1 + " - arg2:" + arg2, Toast.LENGTH_LONG).show();
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		button_Voltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (viewPager_CategoriaProduto.getCurrentItem() > 0 ) {
					viewPager_CategoriaProduto.setCurrentItem(viewPager_CategoriaProduto.getCurrentItem() - 1);
				}
				if (viewPager_CategoriaProduto.getCurrentItem() == listaCategoria.size()-1) {
					button_Avancar.setEnabled(false);
				}else {
					button_Avancar.setEnabled(true);
				}
				if (viewPager_CategoriaProduto.getCurrentItem() == 0) {
					button_Voltar.setEnabled(false);
				}else {
					button_Voltar.setEnabled(true);
				}
			}
		});
		
		button_Avancar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (viewPager_CategoriaProduto.getCurrentItem() < listaCategoria.size()-1) {
					viewPager_CategoriaProduto.setCurrentItem(viewPager_CategoriaProduto.getCurrentItem() + 1);
				}
				if (viewPager_CategoriaProduto.getCurrentItem() == listaCategoria.size()-1) {
					button_Avancar.setEnabled(false);
					
				}else {
					button_Avancar.setEnabled(true);
				}
				if (viewPager_CategoriaProduto.getCurrentItem() == 0) {
					button_Voltar.setEnabled(false);
				}else {
					button_Voltar.setEnabled(true);
				}				
			}
		});
		
		button_25_centavos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addMoeda_25_Centavos();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
				
			}
		});
		
		button_50_centavos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addMoeda_50_Centavos();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
			}
		});
		
		button_1_Real.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addMoeda_1_Real();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
			}
		});
		
		button_2_Reais.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addCedula_2_Reais();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
			}
		});
		
		button_5_Reais.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addCedula_5_Reais();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
			}
		});
		
		button_10_Reais.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				estoqueDinheiro.addCedula_10_Reais();
				atualizarSaldoTela();
				button_Cancelar.setEnabled(true);
			}
		});
		
		button_Confirmar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				button_Confirmar.setEnabled(false);
				button_Cancelar.setEnabled(false);
				//Subtrai o valor do produto selecionado do valor de saldo
				estoqueDinheiro.getSaldo().removerValor(listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(estoqueDinheiro.getSaldo().getProdutoSelecionado()).getValor_Produto());
				
				//Remove uma unidade do estoque
				listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(estoqueDinheiro.getSaldo().getProdutoSelecionado()).removerProduto();
				
				//Recarrega o Adapter com quantidade de produto atualizada
				AdapterProduto adapterProduto = new AdapterProduto(ActivityPrincipal.this, listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto());	
				gridView_Produto.setAdapter(adapterProduto);
				
				//Devolve o troco de acordo com as cedulas e moedas disponiveis
				Toast.makeText(ActivityPrincipal.this, estoqueDinheiro.liberarProduto(listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(estoqueDinheiro.getSaldo().getProdutoSelecionado())), Toast.LENGTH_LONG).show();
				String msg = estoqueDinheiro.liberarTroco();
				if (msg.length() > 0) {
					Toast.makeText(ActivityPrincipal.this, msg, Toast.LENGTH_LONG).show();
				}
				Toast.makeText(ActivityPrincipal.this, "Obrigado pela preferência", Toast.LENGTH_LONG).show();
				atualizarSaldoTela();
			}
		});
		
		button_Cancelar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				button_Confirmar.setEnabled(false);
				button_Cancelar.setEnabled(false);
				Toast.makeText(ActivityPrincipal.this, estoqueDinheiro.liberarTroco(), Toast.LENGTH_LONG).show();
				atualizarSaldoTela();
			}
		});
		
		gridView_Produto.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				// TODO Auto-generated method stub
				if (listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(position).getQuantidade() == 0) {
					Toast.makeText(ActivityPrincipal.this, "Produto esgotado", Toast.LENGTH_LONG).show();
				}else if(estoqueDinheiro.getSaldo().getAtual() == 0 ) {
					Toast.makeText(ActivityPrincipal.this, "Por favor, Insira : "+ String.format("R$ %10.2f",listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(position).getValor_Produto() - estoqueDinheiro.getSaldo().getAtual()), Toast.LENGTH_LONG).show();
				}else if(estoqueDinheiro.getSaldo().getAtual() < listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(position).getValor_Produto() ) {
					Toast.makeText(ActivityPrincipal.this, "Seu saldo é insuficiente para o produto selecionado. \nPor favor, Insira mais: "+ String.format("R$ %10.2f",listaCategoria.get(viewPager_CategoriaProduto.getCurrentItem()).getListaProduto().get(position).getValor_Produto() - estoqueDinheiro.getSaldo().getAtual()), Toast.LENGTH_LONG).show();
				}else {
					estoqueDinheiro.getSaldo().setProdutoSelecionado(position);
					button_Confirmar.setEnabled(true);
					button_Cancelar.setEnabled(true);
				}
			}
		});
	}

	private void carregarEstoqueDinheiro(){
		estoqueDinheiro.setMoeda_1_Real(50);
		estoqueDinheiro.setMoeda_25_Centavos(50);
		estoqueDinheiro.setMoeda_50_Centavos(50);
		estoqueDinheiro.setCedula_2_Reais(30);
		estoqueDinheiro.setCedula_5_Reais(30);
		estoqueDinheiro.setCedula_10_Reais(30);
		
	}
	
	private void atualizarSaldoTela(){
		textView_Saldo.setText(String.format("Saldo disponível R$ %10.2f",estoqueDinheiro.getSaldo().getAtual()));
	}
}
