package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class ContentTopup extends ConstraintLayout {
    private Button btnTopup;
    OnTopupClicktener listener;

    public ContentTopup(Context context) {
        super(context);
        init();
        btnTopup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClickBtnTopup();
                }
            }
        });
    }

    public ContentTopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContentTopup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.activity_main_topup, this);
        btnTopup = findViewById(R.id.btn_topup_main_topup);

    }

    public void setOnClickButton(OnTopupClicktener listen){
        listener=listen;
    }

    public interface OnTopupClicktener{
        void onClickBtnTopup();
    }
}
