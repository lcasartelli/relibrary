package it.unimib.relibrary.controllers;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unimib.relibrary.R;


public class NotificationsFragment extends REFragment {

    private static final String TITLE = "Notifiche";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static String getTitle() {
        return TITLE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notifications_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) this.getView().findViewById(R.id.notification_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] myDataset = new String[] {
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te",
            "Matteo ti ha aggiunto agli amici",
            "Maria è una pessima fotografa",
            "Aurora ha chiesto di uscire con te"
        };

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
