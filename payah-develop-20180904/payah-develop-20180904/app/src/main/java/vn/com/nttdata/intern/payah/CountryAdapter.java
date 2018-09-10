package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private int myLayout;
    private List<Country> arrayList;

    public CountryAdapter(Context context, int myLayout, List<Country> arrayList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);
        TextView tvVung = (TextView) convertView.findViewById(R.id.tvVung);
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imgHinh);
        tvVung.setText(arrayList.get(position).getCode());
        imgHinh.setImageResource(arrayList.get(position).getImage());
        return convertView;
    }
}
