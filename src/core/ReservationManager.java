package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serialize.CinemaList;
import serialize.ReservationList;

public class ReservationManager {
	/**
	 * 
	 */
	private String fileName = "reserv list.dat";
	private ReservationList reserv;
	private BufferedReader reader;

	private void read() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reserv list.dat"));) {
			reserv = (ReservationList) ois.readObject();
		}
		catch (IOException e) {
			reserv = new ReservationList();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ReservationManager(BufferedReader reader) {
		read();
		try {
			this.reader = reader;
		}
		catch (Exception e) {
			reserv = new ReservationList();
		}
	}

	public void add() {
		try {
			System.out.println("Введите номер фильма:");
			int idFilm = Integer.valueOf(reader.readLine());
			if (CinemaList.getFilmById(idFilm) == null) {
				System.out.println("Фильма с таким номером не существует.");
				return;
			}
			System.out.println("Введите ваше ФИО:");
			String fullName = reader.readLine();
			System.out.println("Введите количество билетов:");
			int count = Integer.valueOf(reader.readLine());
			int id = reserv.add(idFilm, fullName, count);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
				oos.writeObject(reserv);
			}
			System.out.println("Данные внесены успешно, ваш номер брони: " + id);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void cancel() {
		try {
			System.out.println("Введите номер брони: ");
			int id = Integer.valueOf(reader.readLine());
			reserv.cancel(id);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
				oos.writeObject(reserv);
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void show() {
		try {
			System.out.println("Введите номер брони: ");
			int id = Integer.valueOf(reader.readLine());
			reserv.show(id);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
