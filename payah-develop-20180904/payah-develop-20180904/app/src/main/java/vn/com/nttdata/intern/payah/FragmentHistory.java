package vn.com.nttdata.intern.payah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentHistory extends Fragment {

    HistoryItemAdapter historyItemAdapter;
    ArrayList<HistoryItem> arrayList = new ArrayList<>();
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_history, container, false);
        listView = v.findViewById(R.id.list_view_history);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inputHistoryItem();
        historyItemAdapter = new HistoryItemAdapter(arrayList, getActivity());
        listView.setAdapter(historyItemAdapter);
    }

    private void inputHistoryItem() {
        for (int i = 0; i < 10; i++) {
            HistoryItem historyItem1 = new HistoryItem("16 May 2018", "12:12:12", "FFF-AAA-CCCCC", "50.00 MYR");
            arrayList.add(historyItem1);
        }
    }
}
