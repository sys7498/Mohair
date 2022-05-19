package com.example.mohartest1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile_main extends Fragment {
    int selected_number_hairstyle;
    int selected_number_facetype;
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_main, container, false);
        ImageView ProfileImg = view.findViewById(R.id.profile_img);
        TextView NameTextView = view.findViewById(R.id.profile_name);

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        selected_number_hairstyle = bundle.getInt("hairstylenumber");
        selected_number_facetype = bundle.getInt("facetypenumber");

        ProfileImg.setImageDrawable(getResources().getDrawable(DrawableToInt.FaceTypeWithHair[selected_number_facetype][selected_number_hairstyle]));
        NameTextView.setText(name);
        return view;
    }
}