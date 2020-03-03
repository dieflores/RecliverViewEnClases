package com.desafiolatam.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.desafiolatam.recyclerviewexample.model.Animal;

import java.util.ArrayList;
import java.util.List;


// CUATRO : CREAR EL ADAPTER (CLICK DERECHO NEW JAVA CLASS APELLIDO ADAPTER) AQUI
// ES DONDE TENEMOS UNA CLASE DENTRO DE OTRA; VIEW HOLDER (CONTIENE LOS ELEMTOS QUE VAMOS A MOSTRAR)

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {  // HEREDAR DE RECYCLEVIEW  E IMPLEMENTAR METODOS, ONCREATE, ONBIND, GETITEM

    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList = new ArrayList<>();  // data set
    private Context mContext;
    private onItemClickListener listener;

    //Constructor

    public AnimalAdapter(List<Animal>
                                 animalList, Context mContext, onItemClickListener listener) {
        //  this.mLayoutInflater = mLayoutInflater;
        this.animalList = animalList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // para retornar view holder

        View view = mLayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_animal,
                        parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // vamos a crear un objeto
        Animal animal = animalList.get(position);

        holder.textView.setText(animal.getName());

        Glide.with(holder.imageView.getContext())  //implementacion de GLIDE
                .load(animal.getUrl())
                .into(holder.imageView);


    }

    @Override      // se asigna animalList.size();
    public int getItemCount() {
        return animalList.size();


    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // AQUI SE DEFINE LAS VISTAS O ATRIBUTOS QUE PERTENECEN AL ELEMENTO VIEW HOLDER
        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewListItem); // se declara variables locales y  Alt + enter (Create field imageView o Textview)
            textView = itemView.findViewById(R.id.textViewListItem); // SE ASOCIAN LOS ELEMENTOS A LA VISTA.
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(this, getNameByPosition(getAdapterPosition())
                    , getUrlByPosition(getAdapterPosition()));
        }
    }

    private String getNameByPosition(int position) {
        if (position != RecyclerView.NO_POSITION) {
            return animalList.get(position).getName();
        } else {
            return "no hay";
        }
    }

    private String getUrlByPosition(int position) {
        if (position != RecyclerView.NO_POSITION) {
            return animalList.get(position).getUrl();
        } else {
            return "no hay";
        }

    }
    public interface onItemClickListener {
        public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url);
    }
}
