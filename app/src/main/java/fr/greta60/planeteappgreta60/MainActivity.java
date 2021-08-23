package fr.greta60.planeteappgreta60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.greta60.planeteappgreta60.adapter.PlaneteAdapter;
import fr.greta60.planeteappgreta60.model.Planete;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        String[] nomsTab = resources.getStringArray(R.array.noms);
        int[] distancesTab = resources.getIntArray(R.array.distances);

        //créer un tableau des ressources images
        int[] idImages = new int[]{
                R.drawable.mercury,
                R.drawable.venus,
                R.drawable.earth,
                R.drawable.mars,
                R.drawable.jupiter,
                R.drawable.saturn,
                R.drawable.uranus,
                R.drawable.neptune,
                R.drawable.pluto
        };
        //créer la liste des planètes
        ArrayList<Planete> list = new ArrayList<>();
        for (int i = 0; i < nomsTab.length ; i++){
            Planete p = new Planete(nomsTab[i], distancesTab[i], idImages[i]);
            list.add(p);
        }
        //créer arrayAdapter
//        ArrayAdapter adapter = new ArrayAdapter(this,
//                                    android.R.layout.simple_list_item_1,
//                                    android.R.id.text1,
//                                    list
//        );

//        ArrayAdapter adapter = new ArrayAdapter(this,
//                R.layout.item1,
//                R.id.planete_nom,
//                list
//        );

        // créer PlaneteAdapter
        PlaneteAdapter adapter = new PlaneteAdapter(this, list);

        //associer adaptateur à ListView
        ListView lv = findViewById(android.R.id.list);
        lv.setAdapter(adapter);
    }
}
