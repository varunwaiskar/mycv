package com.varun.trash;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		
		DemoEnum d = DemoEnum.JobServe;
		
		switch(d) {
			case JobServe :
				System.out.println("ok");
				break;
			default :
				System.out.println("default reached");
		}
		
	}
	
	
		
}
