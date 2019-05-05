package Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.onlineclothingshopping.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private EditText regisusername, regispassword;
    private Button btnregister;
//    private Context mcontext;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View view=inflater.inflate(R.layout.fragment_register,container,false);
        
        regisusername=view.findViewById(R.id.etregisuser);
        regispassword=view.findViewById(R.id.etregispassword);
        btnregister=view.findViewById(R.id.btnregister);


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        
        
        return view;
    }

  public void Register(){
    SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("User",Context.MODE_PRIVATE);

      SharedPreferences.Editor editor = sharedPreferences.edit();

      editor.putString("username", regisusername.getText().toString());
      editor.putString("password", regispassword.getText().toString());

      editor.commit();

      Toast.makeText(this.getActivity(), "Registered", Toast.LENGTH_SHORT).show();

    }

}
