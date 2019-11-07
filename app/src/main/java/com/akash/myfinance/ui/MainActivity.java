package com.akash.myfinance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.akash.myfinance.R;
import com.akash.myfinance.listener.SearchApiCallBack;
import com.akash.myfinance.rest_services.api.ApiCall;
import com.akash.myfinance.rest_services.client.RetrofitClient;
import com.akash.myfinance.rest_services.model.search.SearchResponse;
import com.akash.myfinance.utility.FinanceConstants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RetrofitClient retrofitClient = new RetrofitClient();
    private ApiCall apiCall;
    private ArrayList<String> symbolArrayList = new ArrayList<String>();
    private ArrayList<String> companyNameArrayList = new ArrayList<String>();
    private ListView searchListView;
    private SearchListAdapter searchListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchListView = (ListView) findViewById(R.id.search_list_view);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setQueryHint("Find my Stock");
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("12345", "SearchOnQueryTextSubmit: " + query);
                retrofitClient.getSearchResults(FinanceConstants.SEARCH_FUNCTION
                        , query.trim(), FinanceConstants.API_FINANCE, new SearchApiCallBack() {
                            @Override
                            public void onResponseSucess(SearchResponse responseSuccess) {
                                if (symbolArrayList != null && companyNameArrayList != null) {
                                    symbolArrayList.clear();
                                    companyNameArrayList.clear();
                                }
                                for (int i = 0; i < responseSuccess.getBestMatchesResponse().size(); i++) {
                                    symbolArrayList.add(responseSuccess.getBestMatchesResponse().get(i).getSymbol());
                                    companyNameArrayList.add(responseSuccess.getBestMatchesResponse().get(i).getCompanyName());
                                }
                                searchListAdapter = new SearchListAdapter(getApplicationContext(),
                                        symbolArrayList, companyNameArrayList);
                                searchListView.setAdapter(searchListAdapter);
                                searchListAdapter.notifyDataSetChanged();
                                setListViewHeightBasedOnChildren(searchListView);
                                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Intent intent = new Intent(MainActivity.this, StockDetailsActivity.class);
                                        intent.putExtra("SymbolName", symbolArrayList.get(position));
                                        intent.putExtra("CompanyName", companyNameArrayList.get(position));
                                        Log.d("12345", "item " + symbolArrayList.get(position));
                                        startActivity(intent);
                                    }
                                });
                            }

                            @Override
                            public void onResponseFailure(String failureResponse) {

                            }
                        });

                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("12345", "SearchOnQueryTexchange " + s);

                return false;
            }
        });
        return true;

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
