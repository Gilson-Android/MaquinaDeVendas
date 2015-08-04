package br.com.ggc.maquinadevendas.adapter;
/**Classe responsavel por mostrar as categorias

 * @author Gilson Gonçalves de Carvalho

 * @version 0.00001

 */

import java.util.ArrayList;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.ggc.maquinadevendas.R;
import br.com.ggc.maquinadevendas.objetos.Base;
import br.com.ggc.maquinadevendas.objetos.Categoria;

public class AdapterCategoria extends PagerAdapter{
	
	private ArrayList<Categoria> lista;
	private Activity mActivity;
	private LayoutInflater inflater;
		
	public AdapterCategoria(Activity _activity, ArrayList<Categoria> _listaObjetos){
		this.mActivity = _activity;
		this.inflater = LayoutInflater.from(_activity);
		this.lista = _listaObjetos;
	}

	@Override
	public int getCount() {
		return lista.size();
	}
	
	@Override
	public Object instantiateItem(View collection, int position){
			
		inflater = (LayoutInflater) mActivity.getSystemService(mActivity.LAYOUT_INFLATER_SERVICE);
		
		View view = inflater.inflate(R.layout.adapter_categoria, null);
		
		TextView tv_Descricao = (TextView) view.findViewById(R.id.adapter_textView_principal);
		tv_Descricao.setText(lista.get(position).getDescricao().toUpperCase());
		
		ImageView iv_Icone = (ImageView) view.findViewById(R.id.adapter_imageView_foto);
		iv_Icone.setImageResource(lista.get(position).getIcone());
		((ViewPager) collection).addView(view, position);

		return(view);
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		// TODO Auto-generated method stub
		return (view == obj);
	}
	
	 @Override
     public void destroyItem(View container, int position, Object obj) {
          //((ViewPager) container).removeView((View) obj);
     }

}
