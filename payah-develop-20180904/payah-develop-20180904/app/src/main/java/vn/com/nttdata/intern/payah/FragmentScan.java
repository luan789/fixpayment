package vn.com.nttdata.intern.payah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentScan extends Fragment {

    private ImageView imageScan;
    private InterfaceClickImageScan listener;

    public void setOnClickImageScanListener(InterfaceClickImageScan listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_scan, container, false);
        imageScan = v.findViewById(R.id.imgScan);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClickScanListener();
                }
            }
        });
    }

    public interface InterfaceClickImageScan {
        void onClickScanListener();
    }
}
