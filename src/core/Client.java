package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ReservationManager reserv = new ReservationManager(reader);
		CinemaManager cinema = new CinemaManager(reader);
		boolean run = true;
		while (run) {
			System.out.println("Выберите действие: \n"
					+ "1. Просмотреть список фильмов.\n"
					+ "2. Забронировать места.\n"
					+ "3. Отменить бронирование.\n"
					+ "4. Посмотреть информацию о бронировании.\n"
					+ "5. Выйти.");
			try {
				int select = Integer.valueOf(reader.readLine());
				switch (select) {
					case 1:
						cinema.show();
						break;
					case 2:
						reserv.add();
						break;
					case 3:
						reserv.cancel();
						break;
					case 4:
						reserv.show();
						break;
					case 5:
						run = false;
						break;
					default:
						throw new Exception();
				}
			}
			catch (Exception e) {
				System.out.println("Введены некорректные данные, попробуйте снова!");
			}
		}
	}

}
