package com.desafiolatam.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.desafiolatam.recyclerviewexample.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.onItemClickListener {

    //

    private RecyclerView recyclerView;  // objeto declkarado arriba e instanciado abajo
    private AnimalAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);   // elemento recicler view instanciado (primero fue creado en el XML de activity_main)

        mAdapter = new AnimalAdapter(initializeAnimals(), this, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Animal> initializeAnimals() {

        Animal animal1 = new Animal("https://images.unsplash.com/photo-1500479694472-551d1fb6258d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "FOX");
        Animal animal2 = new Animal("https://images.unsplash.com/photo-1521651201144-634f700b36ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "ELEPHANT");
        Animal animal3 = new Animal("https://images.unsplash.com/photo-1489084917528-a57e68a79a1e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "GATITO");
        Animal animal4 = new Animal("https://images.unsplash.com/photo-1460999158988-6f0380f81f4d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "HERMOSOS");

        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        return animalList;


    }


    private void instanceDetailFragment(String name, String url) {
        DetailFragment detailFragment = DetailFragment.newInstance(name, url);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, detailFragment, "DetailFragment")
                .commit();
    }


    @Override
    public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url) {
      //  Toast.makeText(this, nameAnimal, Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal, url);

    }
}





