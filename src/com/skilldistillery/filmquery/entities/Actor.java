package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actor {
	private int aId;
	private String firstName;
	private String lastName;
	private List<Film> disco;
	
	
	public Actor() {
		disco = new ArrayList<>();
	}
	
//	public Actor(int id) {
//		super();
//		this.aId = id;
//	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Film> getDisco() {
		return disco;
	}

	public void setDisco(List<Film> disco) {
		this.disco = disco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aId, disco, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return aId == other.aId && Objects.equals(disco, other.disco) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor: ").append(firstName).append(" ").append(lastName).append(" Actor ID: ")
				.append(aId).append("\n").append("Other Films with this Actor: ");
		for (Film film : disco) {
			builder.append("\n" + film.getTitle());
		}
		return builder.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
