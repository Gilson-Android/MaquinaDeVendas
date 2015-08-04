package br.com.ggc.maquinadevendas.adapter;
/**Classe responsavel por mostrar os produtos por categoria

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */
import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.ggc.maquinadevendas.R;
import br.com.ggc.maquinadevendas.objetos.Produto;
import br.com.ggc.maquinadevendas.suporte.Constantes;

public class AdapterProduto extends BaseAdapter {
	
	private List<Produto> lista;
	private LayoutInflater inflater;
	private ViewHolder Holder;
	private Activity mActivity;
	
	static class ViewHolder{
		private TextView tv_Titulo;
		private TextView tv_Valor;
		private ImageView iv_Icone;
	}
	
	public AdapterProduto(Activity _activity, List<Produto> _lista){
		this.mActivity = _activity;
		this.inflater = LayoutInflater.from(_activity);
		this.lista = _lista;
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		try{
			if(convertView == null){
				convertView = inflater.inflate(R.layout.adapter_produto, null);
				Holder = new ViewHolder();
				Holder.tv_Titulo = (TextView) convertView.findViewById(R.id.adapter_produto_textView_titulo);
				Holder.tv_Valor = (TextView) convertView.findViewById(R.id.adapter_produto_textView_valor);
				Holder.iv_Icone = (ImageView) convertView.findViewById(R.id.adapter_produto_imageView_foto);
				convertView.setTag(Holder);
			} else{
				Holder = (ViewHolder) convertView.getTag();
			}

			Holder.tv_Titulo.setText(lista.get(position).getDescricao());
			Holder.tv_Valor.setText(String.format("R$ %10.2f", lista.get(position).getValor_Produto()));			
			
			if (lista.get(position).getQuantidade() > 0) {
				Holder.iv_Icone.setImageResource(lista.get(position).getIcone());
			}else {
				Holder.iv_Icone.setImageResource(R.drawable.ic_esgotado);
			}		
			//Holder.tv_Titulo.setOnClickListener(onClickListener);
			
		} catch(Exception e){
			Log.e(Constantes.TAG, "AdapterProduto(): " + e.toString());
		}
		return convertView;
	}
	
	OnClickListener onClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Toast.makeText(mActivity, "Produto:" v.get, duration)
		}
	};

}
