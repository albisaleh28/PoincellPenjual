package com.example.poincellpenjual.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poincellpenjual.R;
import com.example.poincellpenjual.models.Konsumen;

import java.util.ArrayList;

public class KonsumenListAdapter extends RecyclerView.Adapter<KonsumenListAdapter.ListViewHolder> {


    private final ArrayList<Konsumen> listKonsumen;


    public KonsumenListAdapter(ArrayList<Konsumen> list) {
        this.listKonsumen = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_konsumen, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Konsumen konsumen = listKonsumen.get(position);

        holder.tvName.setText(konsumen.getNama_konsumen());
        holder.tvEmail.setText(konsumen.getAlamat_konsumen());
        holder.tvPoin.setText("Total Poin :" +konsumen.getPoin_konsumen());
    }

    @Override
    public int getItemCount() {
        return listKonsumen.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvPoin;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_nama_konsumen);
            tvEmail = itemView.findViewById(R.id.tv_email_konsumen);
            tvPoin = itemView.findViewById(R.id.tv_totalpoin_konsumen);
        }
    }
}
