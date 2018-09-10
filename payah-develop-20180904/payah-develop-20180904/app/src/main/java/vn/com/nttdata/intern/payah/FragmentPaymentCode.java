package vn.com.nttdata.intern.payah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragmentPaymentCode extends Fragment {
    FrameLayout scanQ;
    InterfaceClickScanQrCodeListener listener;
    private Button btnBack;

    public void setOnClickScanQr(InterfaceClickScanQrCodeListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_payment_code, container, false);
        scanQ = v.findViewById(R.id.scan_qr_code);
        btnBack=v.findViewById(R.id.btn_scanqr_back);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scanQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClickScanQrListener();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClickBackQrListener();
                }
            }
        });
    }

    public interface InterfaceClickScanQrCodeListener {
        void onClickScanQrListener();
        void onClickBackQrListener();
    }
}
