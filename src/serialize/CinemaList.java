package serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CinemaList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7916758935022970050L;

	public static Film getFilmById(int id) {
		Film flm = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cinema list.dat"))) {
			CinemaList cinema = (CinemaList) ois.readObject();
			flm = cinema.getFilm(id);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flm;
	}

	private ArrayList<Film> list;

	public CinemaList() {
		list = new ArrayList<>();
	}

	public void add(String name, String time, double price) throws Exception {
		int id = 1;
		if (list.size() != 0)
			id = list.get(list.size() - 1).id + 1;
		list.add(new Film(id, name, time, price));
	}

	public void show() throws Exception {
		if (list.size() == 0)
			throw new Exception("В кинотеатре нет фильмов!");
		System.out.println("№\tНазвание фильма\tНачало сеанса\tСтойсмость");
		for (Film film : list)
			System.out.println(film.id + "\t" + film.name + "\t\t" + film.time + "\t\t" + film.price);

	}

	public Film getFilm(int id) {
		Film flm = null;
		for (Film film : list)
			if (film.id == id) {
				flm = film;
				break;
			}
		return flm;
	}

	public Film getLastFilm() {
		return list.get(list.size() - 1);
	}

	class Film implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2758251628435475960L;

		public Film(int id, String name, String time, double price) {
			this.id = id;
			this.name = name;
			this.time = time;
			this.price = price;
		}

		int id;
		String name, time;
		double price;

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getTime() {
			return time;
		}

		public double getPrice() {
			return price;
		}
	}

}
