package com.jai.mainapp;

import java.io.FileInputStream;

import java.io.ObjectInputStream;

import com.jai.bean.Student;

public class Deserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Deserialization");
			String filename="student.ser";
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			Student student=(Student)ois.readObject();
			
			System.out.println("Student Information is");
			System.out.println("id is :"+student.getSid());
			System.out.println("name is :"+student.getName());
			System.out.println("address is :"+student.getSaddress());
			ois.close();
			
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
