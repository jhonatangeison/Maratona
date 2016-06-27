package br.com.heiderlopes.persistenciaandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.heiderlopes.persistenciaandroid.R;
import br.com.heiderlopes.persistenciaandroid.model.Academia;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class MaratonaAdapter extends BaseAdapter {

    private Context context;
    private List<Academia> academias;
    private LayoutInflater layoutInflater;

    public MaratonaAdapter(Context context, List<Academia> academias) {
        this.context = context;
        this.academias = academias;
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @Override
    public int getCount() {
        return academias.size();
    }

    @Override
    public Object getItem(int i) {
        return academias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return academias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AcademiaViewHolder holder;

        if(view == null) {
            holder = new AcademiaViewHolder();
            view = layoutInflater.inflate(R.layout.item_academia, viewGroup, false);
            holder.tvNome = (TextView) view.findViewById(R.id.tvNome);
         /*   holder.tvPeso = (TextView) view.findViewById(R.id.tvPeso);
            holder.tvIMC = (TextView) view.findViewById(R.id.tvIMC);
            holder.tvIdade = (TextView) view.findViewById(R.id.tvIdade);
            holder.tvModal = (TextView) view.findViewById(R.id.tvModal);
            holder.tvValor = (TextView) view.findViewById(R.id.tvValor);
            holder.tvDia = (TextView) view.findViewById(R.id.tvDias);*/

            view.setTag(holder);
        } else {
            holder = (AcademiaViewHolder) view.getTag();
        }
        holder.tvNome.setText(academias.get(i).getTITULO());
      /*  holder.tvPeso.setText(academias.get(i).getPeso());
        holder.tvIMC.setText(academias.get(i).getImc());
        holder.tvIdade.setText(academias.get(i).getIdade());
        holder.tvModal.setText(academias.get(i).getModal());
        holder.tvValor.setText(academias.get(i).getValor());
        holder.tvDia.setText(academias.get(i).getDias());*/

        return view;
    }

    private class AcademiaViewHolder {
        protected TextView tvNome;
        protected TextView tvPeso;
        protected TextView tvIMC;
        protected TextView tvIdade;
        protected TextView tvModal;
        protected TextView tvValor;
        protected TextView tvDia;
    }
}
