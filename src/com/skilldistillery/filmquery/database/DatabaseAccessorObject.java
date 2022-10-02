package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		String user = "student";
		String pass = "student";
		try{
			Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			film = new Film();

			film.setId(rs.getInt("id"));
			film.setTitle(rs.getString("title"));
			film.setDesc(rs.getString("description"));
			film.setRelYear(rs.getInt("release_year"));
			film.setLangId(rs.getInt("language_id"));
			film.setLang(rs.getString("name"));
			film.setRentDur(rs.getInt("rental_duration"));
			film.setRentRate(rs.getDouble("rental_rate"));
			film.setLength(rs.getInt("length"));
			film.setRepCost(rs.getDouble("replacement_cost"));
			film.setRating(rs.getString("rating"));
			film.setSpecFeat(rs.getString("special_features"));
			film.setCast(findActorsByFilmId(filmId));
//			
		}
		rs.close();
		stmt.close();
		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
//		List<Film> film = new ArrayList<>();

		String user = "student";
		String pass = "student";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE actor.id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				actor = new Actor();

				actor.setaId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actor.setDisco(findFilmsByActorId(actorId));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> filmCast = new ArrayList<>();
		
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name, film.title FROM actor JOIN film_actor ON actor_id = actor.id JOIN film ON film_id = film.id WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();

				actor.setaId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				filmCast.add(actor);

			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return filmCast;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> filmList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SSELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id JOIN actor ON actor.id = film_actor.actor_id JOIN language ON film.language_id = language.id  WHERE actor.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();

				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDesc(rs.getString("description"));
				film.setRelYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setLang(rs.getString("name"));
				film.setRentDur(rs.getInt("rental_duration"));
				film.setRentRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setRepCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecFeat(rs.getString("special_features"));
				filmList.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

	@Override
	public List<Film> findFilmByKeyword(String key) {
		List<Film> keyFilms = new ArrayList<>();
		
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + key + "%");
			stmt.setString(2, "%" + key + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();

				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDesc(rs.getString("description"));
				film.setRelYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setLang(rs.getString("name"));
				film.setRentDur(rs.getInt("rental_duration"));
				film.setRentRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setRepCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecFeat(rs.getString("special_features"));
				film.setCast(findActorsByFilmId(rs.getInt("id")));
				keyFilms.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keyFilms;
	}
}