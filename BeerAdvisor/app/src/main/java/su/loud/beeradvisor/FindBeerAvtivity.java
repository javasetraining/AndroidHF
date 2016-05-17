package su.loud.beeradvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class FindBeerAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }

    public void onClickFindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.colors);
        String beerType = String.valueOf(color.getSelectedItem());
        brands.setText(beerType);
    }
}
