package com.example.model;

public class sentence 
{
	public String cx;
	public Sens [] sens;
	public sentence()
	{
		cx = "";
	}
	public void setSens(int sensLenth)
	{
		sens = new Sens[sensLenth];
		for(int i = 0; i < sensLenth; i++)
		{
			sens[i] = new Sens();
		}
	}
	
}
