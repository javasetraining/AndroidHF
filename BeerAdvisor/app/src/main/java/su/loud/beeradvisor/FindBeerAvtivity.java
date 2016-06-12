package su.loud.beeradvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerAvtivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }

    public void onClickFindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.colors);
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> brandlist = expert.getBrands(beerType);
        StringBuilder sb = new StringBuilder();
        for (String brand: brandlist) {
            sb.append(brand).append('\n');
        }
        brands.setText(sb);
    }

}
