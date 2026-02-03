package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cars.AddCarActivity;
import com.example.cars.R;


public class MenuFragment extends Fragment {

   View view;

   Button btaddcar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_menu, container, false);

         btaddcar =view.findViewById(R.id.btaddcar);

         btaddcar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(getActivity(), AddCarActivity.class);
                 startActivity(i);
             }
         });


        return view;


    }


}