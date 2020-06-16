package com.example.e_clothes.ui.panier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_clothes.R;
import com.example.e_clothes.adaptaters.PanierAdaptater;
import com.example.e_clothes.entities.Article;
import com.example.e_clothes.entities.Panier;

import java.util.ArrayList;
import java.util.List;

public class PanierFragment extends Fragment {

    View view;
    private RecyclerView panierList;
    private List<Panier> panierData;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_panier, container, false);

        panierList = (RecyclerView) view.findViewById(R.id.panier_list);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            PanierAdaptater panierAdapter = new PanierAdaptater(getContext(), panierData);
            panierList.setLayoutManager(new LinearLayoutManager(getActivity()));
            panierList.setAdapter(panierAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        panierData = new ArrayList<>();

        panierData.add(new Panier(new Article("Robe rouge", "Rouge, Bleu, Vert, Noir", "$180", "X, XL, M, S", "une robe rouge courte d'un modele blablabla", R.drawable.dress1)));
        panierData.add(new Panier(new Article("Robe bleu", "Rouge, Bleu, Vert, Noir", "$380", "X, XL, M, S", "une robe rouge courte d'un modele blablabla", R.drawable.dress2)));
        panierData.add(new Panier(new Article("Robe pagne", "Rouge, Bleu, Vert, Noir", "$280", "X, XL, M, S", "une robe rouge courte d'un modele blablabla", R.drawable.dress3)));

    }
}
