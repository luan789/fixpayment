package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FragmentTopupSubmit extends Fragment implements View.OnClickListener {
    TextView num1, num9, num8, num7, num6, num5, num4, num3, num2, num0;
    ImageView numBackspace;
    Button btnSubmitTopUp, btnBackTopupsubmit;
    TextView tvValueCurrent, tvTitleCurrent;
    InterfaceBtnBackTopupSubmit listener;
    public static final String RESULT_BALANCE = "result_balance";

    public void setOnclickBtnBackListenerS(InterfaceBtnBackTopupSubmit listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_topup_submit, container, false);
        findIdLayout(v);
        tvValueCurrent.setText("0.00");
        return v;
    }

    private void findIdLayout(View v) {
        num0 = v.findViewById(R.id.keyboard_num_0);
        numBackspace = v.findViewById(R.id.keyboard_num_backspace);
        num1 = v.findViewById(R.id.keyboard_num_1);
        num2 = v.findViewById(R.id.keyboard_num_2);
        num3 = v.findViewById(R.id.keyboard_num_3);
        num4 = v.findViewById(R.id.keyboard_num_4);
        num5 = v.findViewById(R.id.keyboard_num_5);
        num6 = v.findViewById(R.id.keyboard_num_6);
        num7 = v.findViewById(R.id.keyboard_num_7);
        num8 = v.findViewById(R.id.keyboard_num_8);
        num9 = v.findViewById(R.id.keyboard_num_9);
        btnBackTopupsubmit = v.findViewById(R.id.btn_back_topupsubmit);
        btnSubmitTopUp = v.findViewById(R.id.btn_submit_topup);
        tvTitleCurrent = v.findViewById(R.id.textview_current_title_topupsubmit);
        tvValueCurrent = v.findViewById(R.id.textview_current_value_topupsubmit);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setOnclickButton();
    }

    //set onclick button
    private void setOnclickButton() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        numBackspace.setOnClickListener(this);
        btnSubmitTopUp.setOnClickListener(this);
        btnBackTopupsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.keyboard_num_0:
                getTextKeyBoard(num0.getText().toString());
                break;
            case R.id.keyboard_num_1:
                getTextKeyBoard(num1.getText().toString());
                break;
            case R.id.keyboard_num_2:
                getTextKeyBoard(num2.getText().toString());
                break;
            case R.id.keyboard_num_3:
                getTextKeyBoard(num3.getText().toString());
                break;
            case R.id.keyboard_num_4:
                getTextKeyBoard(num4.getText().toString());
                break;
            case R.id.keyboard_num_5:
                getTextKeyBoard(num5.getText().toString());
                break;
            case R.id.keyboard_num_6:
                getTextKeyBoard(num6.getText().toString());
                break;
            case R.id.keyboard_num_7:
                getTextKeyBoard(num7.getText().toString());
                break;
            case R.id.keyboard_num_8:
                getTextKeyBoard(num8.getText().toString());
                break;
            case R.id.keyboard_num_9:
                getTextKeyBoard(num9.getText().toString());
                break;
            case R.id.btn_submit_topup:
                onClickSubmit();
                break;
            case R.id.keyboard_num_backspace:
                clickBackspace();
                break;
            case R.id.btn_back_topupsubmit:
                clickBtnBack();
                break;
        }
    }

    private void onClickSubmit() {
        if (listener != null) {
            SharedPreferences share = getActivity().getSharedPreferences(SignUpActivity.PREFE_REGISTER, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = share.edit();
            double result = Double.parseDouble(tvValueCurrent.getText().toString());
            if (result >= 10) {
                Log.d("TAG: BEFORE ADD", String.valueOf(result));
                result = result + Double.parseDouble(share.getString("Current", "0"));
                Log.d("TAG: AFTER ADD", String.valueOf(result));
                if (result > 99999) {
                    Toast.makeText(getContext(), "Current balance is limited", Toast.LENGTH_LONG).show();
                    return;
                }
                editor.putString("Current", String.format("%.2f",result));
                editor.apply();
                listener.onClickBtnSubmitTopsubmitListener(true);
            } else {
                Toast.makeText(getContext(), "Minimize 10.00", Toast.LENGTH_LONG).show();
                listener.onClickBtnSubmitTopsubmitListener(false);
            }
        }
    }

    private void clickBtnBack() {
        if (listener != null) {
            listener.onClickBtnBackTopsubmitListenr();
        }
    }

    private void getTextKeyBoard(String a) {
        int b = Integer.parseInt(a);
        if (tvValueCurrent.getText().length() < 5) {
            String value = tvValueCurrent.getText().toString();
            double result = Double.parseDouble(value);
            result = result * 10 + b * 0.01;
            tvValueCurrent.setText(String.format("%.2f", result));
        }
    }

    private void clickBackspace() {
        String value = tvValueCurrent.getText().toString();
        value = value.replace(".", "");
        value = value.substring(0, tvValueCurrent.getText().length() - 2);
        float r = Float.parseFloat(value);
        r = r / 100;
        tvValueCurrent.setText(String.format("%.2f", r));

        //int kq = r / 10;
//        if (value.length() == 4) {
//            value = value.substring(0, 4);
//        }

//        double result = Double.parseDouble(value);
//        result = result / 10;
//        DecimalFormat df = new DecimalFormat("##.##");
//        String txt = df.format(result);
//        tvValueCurrent.setText(txt);
    }

    public interface InterfaceBtnBackTopupSubmit {
        void onClickBtnBackTopsubmitListenr();

        void onClickBtnSubmitTopsubmitListener(Boolean bl);
    }

}
