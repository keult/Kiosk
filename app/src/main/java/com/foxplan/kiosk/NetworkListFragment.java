package com.foxplan.kiosk;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NetworkListFragment extends Fragment{

    private WifiManager wifi;
    private List<ScanResult> avaiableNetworks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List networklist;
        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.recycle_view, container, false);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        wifi = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
        avaiableNetworks = wifi.getScanResults();

        networklist = new ArrayList(avaiableNetworks.size());

        for ( ScanResult networkItem : avaiableNetworks) {

            networklist.add(networkItem.SSID );
        }

        rv.setAdapter(new recycleview_adapter(networklist));

        return rv;
    }
}
