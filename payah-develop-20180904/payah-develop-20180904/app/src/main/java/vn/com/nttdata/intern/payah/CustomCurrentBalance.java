package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomCurrentBalance extends RelativeLayout {
    public CustomCurrentBalance(Context context) {
        super(context);
        init();
    }

    public CustomCurrentBalance(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCurrentBalance(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        inflate(getContext(), R.layout.layout_current_balance, this);
    }
}
