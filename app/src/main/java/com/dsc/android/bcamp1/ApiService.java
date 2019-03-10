package com.dsc.android.bcamp1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v2/5c84deb63300000815f2ba59")
    Call<UserWrapper> getUserList();
}
