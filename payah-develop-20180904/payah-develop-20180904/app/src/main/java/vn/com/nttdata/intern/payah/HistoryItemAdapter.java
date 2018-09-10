package vn.com.nttdata.intern.payah;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HistoryItemAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    Context context;
    private List<HistoryItem> arrHistoryItem;

    public HistoryItemAdapter(List<HistoryItem> arrHistoryItem, Context context) {
        this.arrHistoryItem = arrHistoryItem;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrHistoryItem.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.layout_item_history, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvDate   =   convertView.findViewById(R.id.item_date_history);
            viewHolder.tvPrice  =   convertView.findViewById(R.id.item_price_history);
            viewHolder.tvTime   =   convertView.findViewById(R.id.item_time_history);
            viewHolder.tvId     =   convertView.findViewById(R.id.item_id_history);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        HistoryItem objectContact = arrHistoryItem.get(position);
        viewHolder.tvDate.setText(objectContact.getDateTra());
        viewHolder.tvPrice.setText(objectContact.getPirce());
        viewHolder.tvTime.setText(objectContact.getTimeTra());
        viewHolder.tvId.setText(objectContact.getIdTra());
        return convertView;
    }

    public static class ViewHolder {
        TextView tvDate;
        TextView tvTime;
        TextView tvId;
        TextView tvPrice;
    }
}
