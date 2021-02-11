package com.jai.mainapp;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.jai.bean.Student;

public class Serialization {

	public static void main(String[] args) {
		try {
		System.out.println("performing Serialization");
		
		String filename="student.ser";
		FileOutputStream fos=new FileOutputStream(filename);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		Student student=new Student();
		student.setSid(10);
		student.setName("sachin");
		student.setSaddress("mumbai");
		
		oos.writeObject(student);
		
		System.out.println("Serialization completed and stored in the file called"+filename);
		oos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
