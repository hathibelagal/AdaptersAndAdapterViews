package io.github.hathibelagal.adapterviewssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class CustomAdapterWithoutViewHolder extends AppCompatActivity {

    static class Cheese {
        String name;
        String description;

        public Cheese(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    static class ViewHolder{
        TextView cheeseName;
        TextView cheeseDescription;
    }

    Cheese[] cheeses = {
            new Cheese("Parmesan", "Hard, granular cheese"),
            new Cheese("Ricotta", "Italian whey cheese"),
            new Cheese("Fontina", "Italian cow's milk cheese"),
            new Cheese("Mozzarella", "Southern Italian buffalo milk cheese"),
            new Cheese("Cheddar", "Firm, cow's milk cheese"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);

        cheeseGrid.setNumColumns(2);

        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);

        ArrayAdapter<Cheese> cheeseAdapter = new ArrayAdapter<Cheese>(this, 0, cheeses) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                Cheese currentCheese = cheeses[position];

                // Inflate only once
                if(convertView == null) {
                    convertView = getLayoutInflater()
                            .inflate(R.layout.custom_item, null, false);
                }

                TextView cheeseName = (TextView)convertView.findViewById(R.id.cheese_name);
                TextView cheeseDescription = (TextView)convertView.findViewById(R.id.cheese_description);

                cheeseName.setText(currentCheese.name);
                cheeseDescription.setText(currentCheese.description);

                return convertView;
            }
        };

        cheeseGrid.setAdapter(cheeseAdapter);
    }
}
