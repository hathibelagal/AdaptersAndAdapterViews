package io.github.hathibelagal.adapterviewssample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewWithBasicAdapterAndEventHandling extends AppCompatActivity {

    String[] cheeses = {"Parmesan", "Ricotta", "Fontina", "Mozzarella", "Cheddar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);

        cheeseGrid.setNumColumns(2);

        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);

        ArrayAdapter<String> cheeseAdapter = new ArrayAdapter<String>(this,
                R.layout.item,
                R.id.cheese_name,
                cheeses);

        cheeseGrid.setAdapter(cheeseAdapter);

        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {
                String message = "You clicked on " + cheeses[position];
                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }
}
