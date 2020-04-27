//package com.revature.io;
//
//import com.revature.beans.Human;
//
//public class SerialDemo {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		IO io = new IO();
//		String a = "banana";
//		io.writeOutputStreamContents("I like to eat a " + a + " in the afternoon. \n ");
//		
//		//Reading from a file.
//		System.out.println(io.readInputStreamContents());
//		
//		Human h1 = new Human("Matt", 88, 9);
//		Human h2 = new Human("JP", 231, 4);
//		Human h3 = new Human("Tina", 32, 566);
//		
//		IOWithCollections.humanList.add(h1);
//		IOWithCollections.humanList.add(h2);
//		IOWithCollections.humanList.add(h3);
//		
//		IOWithCollections.writeHumanFile();
//		IOWithCollections.readHumanFile();
//		System.out.println(IOWithCollections.humanList.toString());
//		
//
//	}
//
//}
