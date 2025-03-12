package com.ofss;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ClientCode {

	public static void main(String[] args) throws IOException {
		Retrofit retrofit=new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/todos/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		TodoService todoService=retrofit.create(TodoService.class);
		Call<Todo> call=todoService.m1();
		Response<Todo> response=call.execute();
		if (response.isSuccessful())
		{
			System.out.println(response.body());
			Todo todoObject=(Todo)response.body();
			System.out.println(todoObject);
			System.out.println(todoObject.getUserId());
			todoObject.getId();
			System.out.println(todoObject.getId()+ " and "+ todoObject.getTitle()+ " and "+todoObject.isCompleted());
			
		}
		else
		{
			int httpErrorCode=response.code();
			Todo todo=response.body();
			System.out.println(httpErrorCode+" and "+todo);
		}
		
	}

}
