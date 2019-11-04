package com.akash.myfinance.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.akash.myfinance.R;

import java.util.ArrayList;

public class SearchListAdapter extends BaseAdapter {

    Context context;

    private TextView mSymbol ;

    private TextView mCompany;

    private ImageView rightArrowButton;

    private ArrayList<String> symbolName;

    private ArrayList<String> companyName;

    public SearchListAdapter(Context context, ArrayList<String> symbolName, ArrayList<String> companyName){
        this.context = context;
        this.symbolName = symbolName;
        this.companyName = companyName;
    }

    @Override
    public int getCount() {
        return symbolName.size();
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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.search_list_item,parent,false);
        }

        mSymbol = convertView.findViewById(R.id.symbol_text);
        mCompany = convertView.findViewById(R.id.name_text);
        rightArrowButton = convertView.findViewById(R.id.arrow_click);

        mSymbol.setText(symbolName.get(position));
        mCompany.setText(companyName.get(position));

        return convertView;
    }

}
