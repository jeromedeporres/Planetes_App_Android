package fr.greta60.planeteappgreta60.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import fr.greta60.planeteappgreta60.R;
import fr.greta60.planeteappgreta60.model.Planete;

public class RecyclerPlaneteView extends RecyclerView.ViewHolder{
    // vues du layout item.xml
    private TextView tvNom;
    private TextView tvDistance;
    private ImageView ivImage;

    //création d'un objet de type viewholder et initialisation des variables d'instances
    public RecyclerPlaneteView(View view){
        super(view);
        findViews(view);
    }
    //initialisation des variables d'instances
    private void findViews(View view)
    {
        tvNom = view.findViewById(R.id.nomPlanete);
        tvDistance = view.findViewById(R.id.distancePlanete);
        ivImage = view.findViewById(R.id.imagePlanete);
    }
    public void setItem(final Planete planete)
    {
        tvNom.setText(planete.getNom());
        tvDistance.setText(planete.getDistance()+" Gm");
        ivImage.setImageResource(planete.getIdImage());
    }
}
