package com.dsc.android.bcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewData> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        //createMockList();
        apicall();
        setUpRecyclerView();
    }

   /* private void createMockList(){
        RecyclerViewData data;
        data = new RecyclerViewData("https://bit.ly/2NT7svr", "Bijin","xyz@gmail.com");
        mockDataList.add(data);
        data = new RecyclerViewData("https://bit.ly/2NT7svr", "Biji","abc@gmail.com");
        mockDataList.add(data);
        data = new RecyclerViewData("https://bit.ly/2NT7svr", "Biju","lmn@gmail.com");
        mockDataList.add(data);
        data = new RecyclerViewData("https://bit.ly/2NT7svr", "Chotu","pqr@gmail.com");
        mockDataList.add(data);
        data = new RecyclerViewData("https://bit.ly/2NT7svr", "Hero","123@gmail.com");
        mockDataList.add(data);
    }*/

    private void setUpRecyclerView(){
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewDataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();

    }

    private void apicall(){
        ApiService apiService = AppClient.getInstance().createService(ApiService.class);
        Call<UserWrapper> call =apiService.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.i("Response",response.body().toString());
                        userList .addAll(response.body().getRecyclerViewData());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {
                Toast.makeText(RecyclerViewActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
