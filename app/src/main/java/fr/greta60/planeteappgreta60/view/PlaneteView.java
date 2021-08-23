package fr.greta60.planeteappgreta60.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fr.greta60.planeteappgreta60.R;
import fr.greta60.planeteappgreta60.model.Planete;

public class PlaneteView extends RelativeLayout {
    // vues du layout item.xml
    private TextView tvNom;
    private TextView tvDistance;
    private ImageView ivImage;

    public PlaneteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        findViews();
    }

    public static PlaneteView create(ViewGroup parent){
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        PlaneteView itemView = (PlaneteView) li.inflate(R.layout.item, parent, false);
        itemView.findViews();
        return itemView;
    }

    private void findViews()
    {
        tvNom = findViewById(R.id.nomPlanete);
        tvDistance = findViewById(R.id.distancePlanete);
        ivImage = findViewById(R.id.imagePlanete);
    }
    public void setItem(final Planete planete)
    {
        tvNom.setText(planete.getNom());
        tvDistance.setText(planete.getDistance()+" Gm");
        ivImage.setImageResource(planete.getIdImage());
    }
}



