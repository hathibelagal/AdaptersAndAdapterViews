package io.github.hathibelagal.adapterviewssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewWithBasicAdapter extends AppCompatActivity {

    String[] cheeses = {"Parmesan", "Ricotta", "Fontina", "Mozzarella", "Cheddar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView cheeseList = new ListView(this);
        setContentView(cheeseList);

        ArrayAdapter<String> cheeseAdapter = new ArrayAdapter<String>(this,
                R.layout.item,
                R.id.cheese_name,
                cheeses);

        cheeseList.setAdapter(cheeseAdapter);

    }
}
