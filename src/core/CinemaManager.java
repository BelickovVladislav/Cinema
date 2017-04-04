package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serialize.CinemaList;

public class CinemaManager {
	/**
	 * 
	 */
	private String fileName = "cinema list.dat";
	private CinemaList cinema;
	private BufferedReader reader;

	private void read() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			cinema = (CinemaList) ois.readObject();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cinema = new CinemaList();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CinemaManager(BufferedReader reader) {
		read();
		try {
			this.reader = reader;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
	public void show() {
		try {
			cinema.show();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void add() {
		try {
			System.out.println("Введите название фильма:");
			String name = reader.readLine();
			System.out.println("Введите время начала сеанса:");
			String time = reader.readLine();
			System.out.println("Введите стоймость билета:");
			double price = Double.parseDouble(reader.readLine());
			cinema.add(name, time, price);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
				oos.writeObject(cinema);
			}
			System.out.println("Данные успешно добавлены!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
