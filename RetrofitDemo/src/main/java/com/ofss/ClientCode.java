package com.ofss;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientCode {

	public static void main(String[] args) throws IOException {
		// We are going to call REST API programmatically
		// We will convert the JSON into Java object of Todo type
		
		Retrofit retrofit=new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/todos/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
				
		// REturns me an implementation of TodoService interfacce
		TodoService todoService=  retrofit.create(TodoService.class);
				
		// Call m1() which you left as unimplemented in the interface
		Call<Todo> call=todoService.m1();
		
		// Let's invoke the execute() method that will actually fire the REST API
		
		Response<Todo>  response=call.execute();
		
		if (response.isSuccessful())
		{
			System.out.println("Successful");
			Todo todoObj=response.body();
			// you can deal this just like a normal regular Java object
			
			System.out.println("Title found is "+todoObj.title);
		
			
		}
		else
		{
			System.out.println("Failure");
			System.out.println(response.code());
			
		}
	}

}
