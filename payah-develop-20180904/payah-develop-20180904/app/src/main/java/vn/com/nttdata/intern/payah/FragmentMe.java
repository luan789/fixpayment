package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentMe extends Fragment {
    private TextView tvUserName, tvUserId, tvUserEmail, tvStringName, tvStringNumber, tvStringMail;
    SharedPreferences pren;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_me, container, false);
        tvUserName = (TextView) v.findViewById(R.id.tvUserName);
        tvUserId = (TextView) v.findViewById(R.id.tvUserId);
        tvUserEmail = (TextView) v.findViewById(R.id.tvUserEmail);
        tvStringName = (TextView) v.findViewById(R.id.tvStringName);
        tvStringNumber = (TextView) v.findViewById(R.id.tvStringNumber);
        tvStringMail = (TextView) v.findViewById(R.id.tvStringMail);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pren = this.getActivity().getSharedPreferences(SignUpActivity.PREFE_REGISTER, Context.MODE_PRIVATE);
        tvUserName.setText(pren.getString("Name", ""));
        tvUserId.setText(pren.getString("ID", ""));
        tvUserEmail.setText(pren.getString("Email", ""));
        tvStringName.setText(pren.getString("Name", ""));
        tvStringMail.setText(pren.getString("Adress", ""));
        tvStringNumber.setText(pren.getString("Phone", ""));
    }
}
