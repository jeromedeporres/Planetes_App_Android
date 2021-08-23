package fr.greta60.planeteappgreta60.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.greta60.planeteappgreta60.model.Planete;
import fr.greta60.planeteappgreta60.view.PlaneteView;

public class PlaneteAdapter extends ArrayAdapter<Planete> {
    public PlaneteAdapter(@NonNull Context context, List<Planete> planetes) {
        super(context, 0, planetes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // créer ou réutiliser un PlaneteView
        PlaneteView itemView = (PlaneteView) convertView;
        if (itemView == null)
            itemView = PlaneteView.create(parent); // <==(!!)
        // afficher les valeurs
        itemView.setItem(super.getItem(position));
        return itemView;
    }
}