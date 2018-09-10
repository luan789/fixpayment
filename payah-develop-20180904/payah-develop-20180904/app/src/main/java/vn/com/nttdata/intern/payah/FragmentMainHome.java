package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentMainHome extends Fragment {
    private TextView textViewCurrentValue;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_home, container, false);
        textViewCurrentValue=view.findViewById(R.id.textview_current_value_topup_home);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences share = getActivity().getSharedPreferences(SignUpActivity.PREFE_REGISTER, Context.MODE_PRIVATE);
        textViewCurrentValue.setText(share.getString("Current","0"));
    }
}
