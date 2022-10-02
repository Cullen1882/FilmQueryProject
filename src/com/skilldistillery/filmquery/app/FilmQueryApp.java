package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
	}

	private void test() throws SQLException {
//    Actor actor =db.findActorById(2);
//    System.out.println(actor);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("*******************");
			System.out.println("***** WELCOME *****");
			System.out.println("******** TO *******");
			System.out.println("*** FILM QUERY ****");
			System.out.println("*******************");
			System.out.println(" ");
			System.out.println("Please choose from the following menu: ");
			System.out.println("Enter 1: Search for film by film ID");
			System.out.println("Enter 2: Search for film by keyword");
			System.out.println("Enter 3: Exit the Program");
			int userChoice = input.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("Please enter the film ID for the film you wish to search for: ");
				int userFilmId = input.nextInt();
				Film filmm = db.findFilmById(userFilmId);
				if (filmm != null) {
					System.out.println(filmm);
				}
				else{System.out.println("Please check the film ID and try again");
				}
				break;
			case 2:
				System.out.println("Please enter the keyword you wish to search by: ");
				String userKey = input.next();
				List<Film> films = db.findFilmByKeyword(userKey);
				if (films != null) {
					for (Film film : films) {
						System.out.println(film);
					}

				}else {
				System.out.println("Please choose another keyword to search by");
				}
				break;

			case 3:
				System.out.println("Thanks for using our program, Goodbye!");
				keepGoing = false;

			default:
				System.out.println("Please check your input and try again");
				break;
			}
		}
	}

}
