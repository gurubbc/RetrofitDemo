package com.ofss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoService {
	
	@GET("10")
	Call<Todo> m1();
}
