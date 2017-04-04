package serialize;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5126387576192450656L;
	private ArrayList<Reservation> list;

	public ReservationList() {
		list = new ArrayList<>();
	}

	public void show(int id) throws Exception {
		boolean find = false;
		for (Reservation reserv : list) {
			if (reserv.id == id) {
				System.out.println("ФИО:" + reserv.fullName + "\n"
						+ "Фильм: " + CinemaList.getFilmById(reserv.id_film).name + "\n"
						+ "Количество билетов: " + reserv.count + "\n"
						+ "Стоймость: " + CinemaList.getFilmById(reserv.id_film).price * reserv.count);
				find = true;
			}
		}
		if (!find)
			throw new Exception("Бронь с таким номером не найдена!");
	}

	public int add(int id_film, String fullName, int count) {
		int id = 1;
		if (list.size() != 0)
			id = list.get(list.size() - 1).id + 1;
		list.add(new Reservation(id, id_film, fullName, count));
		return list.get(list.size() - 1).id;
	}

	public void cancel(int id) {
		for (Reservation reserv : list)
			if (reserv.id == id) {
				list.remove(reserv);
				System.out.println("Отмена бронирования произошла успешно!");
				return;
			}
		System.out.println("Бронь с таким номером не найдена!");

	}

	private class Reservation implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5841951020211910239L;
		int id, id_film;
		String fullName;
		int count;

		public Reservation(int id, int id_film, String fullName, int count) {
			this.id = id;
			this.id_film = id_film;
			this.fullName = fullName;
			this.count = count;
		}

	}

}
