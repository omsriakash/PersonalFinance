package com.akash.myfinance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.akash.myfinance.R;
import com.akash.myfinance.listener.StockDetailsAPICallBack;
import com.akash.myfinance.rest_services.client.RetrofitClient;
import com.akash.myfinance.rest_services.model.stock_details.StockDetailsResponse;
import com.akash.myfinance.utility.FinanceConstants;

import org.w3c.dom.Text;

public class StockDetailsActivity extends AppCompatActivity {

    private TextView mSymbolNameTextView;

    private TextView mCompanyNameTextView;

    private TextView mStockPrice;

    private TextView mChangeNumber;

    private TextView mChangePercentNumber;

    private String mSymbolName;

    private String mCompanyName;

    private RetrofitClient retrofitClient = new RetrofitClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_details);

        mSymbolNameTextView = findViewById(R.id.symbol_name);
        mCompanyNameTextView = findViewById(R.id.company_name);
        mStockPrice = findViewById(R.id.stock_price);
        mChangeNumber = findViewById(R.id.change_number);
        mChangePercentNumber = findViewById(R.id.change_percent_number);

        final Intent intent = getIntent();
        mSymbolName = intent.getStringExtra("SymbolName");
        mCompanyName = intent.getStringExtra("CompanyName");

        mSymbolNameTextView.setText(mSymbolName);
        mCompanyNameTextView.setText(mCompanyName);
        callGetStockDetailsAPI(FinanceConstants.STOCK_DETAILS_FUNCTION,mSymbolName.trim(),
                FinanceConstants.API_FINANCE);

    }

    public void callGetStockDetailsAPI(String function, String symbol, String apiKey){
        retrofitClient.getStockDetails(function, symbol, apiKey, new StockDetailsAPICallBack() {
            @Override
            public void onResponseSucess(StockDetailsResponse responseSuccess) {
                mStockPrice.setText( responseSuccess.getGlobalQuote().getPrice());
                mChangeNumber.setText(String.valueOf(responseSuccess.getGlobalQuote().getChangeNumber()) );
                mChangePercentNumber.setText("(" +responseSuccess.getGlobalQuote().getChangePercentageNumber()+")");

                if (responseSuccess.getGlobalQuote().getChangeNumber() <= 0){
                    mChangeNumber.setTextColor(getResources().getColor(R.color.red));
                    mChangePercentNumber.setTextColor(getResources().getColor(R.color.red));
                } else {
                    mChangeNumber.setTextColor(getResources().getColor(R.color.green));
                    mChangePercentNumber.setTextColor(getResources().getColor(R.color.green));
                }
            }

            @Override
            public void onResponseFailure(String failureResponse) {

            }
        });
    }
}
