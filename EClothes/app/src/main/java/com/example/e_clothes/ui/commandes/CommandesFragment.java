package com.example.e_clothes.ui.commandes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_clothes.R;
import com.example.e_clothes.adaptaters.CommandeAdaptater;
import com.example.e_clothes.entities.Article;
import com.example.e_clothes.entities.Commande;

import java.util.ArrayList;
import java.util.List;

public class CommandesFragment extends Fragment {

    View view;
    RecyclerView commandesList;
    List<Commande> commandes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_commande, container, false);
        commandesList = (RecyclerView) view.findViewById(R.id.commandes_list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            CommandeAdaptater commandeAdapter = new CommandeAdaptater(getContext(), commandes);
            commandesList.setLayoutManager(new LinearLayoutManager(getActivity()));
            commandesList.setAdapter(commandeAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        commandes = new ArrayList<>();
        commandes.add(new Commande(new Article("Robe rouge", "Rouge, Bleu, Vert, Noir", "$180", "X, XL, M, S", "une robe rouge courte d'un modele blablabla", R.drawable.dress1)));
        commandes.add(new Commande(new Article("Robe bleu", "Rouge, Bleu, Vert, Noir", "$280", "X, XL, M, S", "une robe rouge courte d'un modele blablabla", R.drawable.dress2)));
    }
}
