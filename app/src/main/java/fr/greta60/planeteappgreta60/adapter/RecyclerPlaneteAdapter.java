package fr.greta60.planeteappgreta60.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.greta60.planeteappgreta60.R;
import fr.greta60.planeteappgreta60.model.Planete;
import fr.greta60.planeteappgreta60.view.RecyclerPlaneteView;

/**
 * une classe de type RecyclerView.Adapter<RecyclerPlaneteView> */

public class RecyclerPlaneteAdapter extends RecyclerView.Adapter<RecyclerPlaneteView> {

    //variable pour stocker la liste des planetes
    private List<Planete> list;

    //pour stocker la position d'élément cliqué
    private int clickedPosition = RecyclerView.NO_POSITION;

    //écouter pour créer le menu contextuel
    private View.OnCreateContextMenuListener menuListener;

    //constructeur pour initialiser la liste des planetes => list
    public RecyclerPlaneteAdapter(@NonNull List<Planete> planetes) {
        super();
        list = planetes;
    }

    @NonNull
    @Override
    public RecyclerPlaneteView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        //Création d'objet de type View
        View view = li.inflate(R.layout.recycler_item, parent, false);
        //création d'un objet de type RecyclerView.ViewHolder
        // => objet contenant la vue
        return new RecyclerPlaneteView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPlaneteView holder, final int position) {
        Planete p = list.get(position);
        holder.setItem(p);

        //ajouter un écouteur d'évènement sur chaque élément de la liste
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedPosition(position);
            }
        });
        //holder.itemView.setOnClickListener((view)->setClickedPosition(position));//expression Lambda
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setClickedPosition(position);
                return false;
            }
        });
        holder.itemView.setBackgroundColor(getClickedPosition() == position ? Color.YELLOW : Color.TRANSPARENT);
        //ajout d'un écouteur d'événement de type "createContextMenu" sur chaque élement de la liste
        holder.itemView.setOnCreateContextMenuListener(menuListener);
    }

    @Override
    public int getItemCount() { //nombre d'éléments de la liste
        return list.size();
    }

    public int getClickedPosition() {
        return clickedPosition;
    }

    public void setClickedPosition(int clickedPosition) {
        notifyItemChanged(this.clickedPosition);
        this.clickedPosition = clickedPosition;
        notifyItemChanged(clickedPosition);
    }

    public View.OnCreateContextMenuListener getMenuListener() {
        return menuListener;
    }

    public void setMenuListener(View.OnCreateContextMenuListener menuListener) {
        this.menuListener = menuListener;
    }

    public void addPlanete(Planete planete) {
        list.add(planete);
        //envoi de notification d'ajout d'un élèment avec la position d'element qui vient etre ajouter
        notifyItemInserted(list.size()-1);
    }

    public void removePlanete(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}