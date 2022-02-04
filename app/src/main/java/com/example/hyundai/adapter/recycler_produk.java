package com.example.hyundai.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.Product;
import com.example.hyundai.activity.MainActivity;
import com.example.hyundai.update_product;
import com.example.hyundai.update_user;

import java.util.List;

public class recycler_produk extends RecyclerView.Adapter<recycler_produk.MyViewHolder> {

    private List<Product> itemProduk;
    Context context;
    DatabaseHelper mDatabaseHelper;
    /*static String nama_user = "nama user";
    static String npk_user = "npk user";*/


    public recycler_produk(Context ct, List<Product> item) {
        this.context = ct;
        this.itemProduk = item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_produk, parent, false);
        return new MyViewHolder(view).linkAdapter(this);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Product barang = itemProduk.get(position);
        holder.text1.setText(barang.getPart_name());
        holder.text2.setText(barang.getSku());

    }

    @Override
    public int getItemCount() {
        return itemProduk.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageButton edit, delete;
        private recycler_produk adapter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.part_name);
            text2 = itemView.findViewById(R.id.sku);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.hapus);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.itemProduk.remove(getAdapterPosition());
                    mDatabaseHelper.DeleteProduct(adapter.itemProduk.get(getAdapterPosition()).getSku());
                    adapter.notifyDataSetChanged();
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, update_product.class);
                    context.startActivity(intent);
                }
            });
        }

        public MyViewHolder linkAdapter(recycler_produk adapter) {
            this.adapter = adapter;
            return this;
        }
    }
}
