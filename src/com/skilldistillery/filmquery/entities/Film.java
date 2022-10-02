package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int fId;
	private String title;
	private String desc;
	private int relYear;
	private int langId;
	private String lang;
	private int rentDur;
	private double rentRate;
	private int length;
	private double repCost;
	private String rating;
	private String specFeat;
	private List<Actor> cast;

	public Film() {
		cast = new ArrayList<>();
	}

//	public Film(int id) {
//		super();
//		this.fId = id;
//	}
//
//	public Film(String title) {
//		super();
//		this.title = title;
//	}

	public int getId() {
		return fId;
	}

	public void setId(int id) {
		this.fId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRelYear() {
		return relYear;
	}

	public void setRelYear(int relYear) {
		this.relYear = relYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getRentDur() {
		return rentDur;
	}

	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return repCost;
	}

	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecFeat() {
		return specFeat;
	}

	public void setSpecFeat(String specFeat) {
		this.specFeat = specFeat;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cast, desc, fId, lang, langId, length, rating, relYear, rentDur, rentRate, repCost,
				specFeat, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(desc, other.desc) && fId == other.fId
				&& Objects.equals(lang, other.lang) && langId == other.langId && length == other.length
				&& Objects.equals(rating, other.rating) && relYear == other.relYear && rentDur == other.rentDur
				&& Double.doubleToLongBits(rentRate) == Double.doubleToLongBits(other.rentRate)
				&& Double.doubleToLongBits(repCost) == Double.doubleToLongBits(other.repCost)
				&& Objects.equals(specFeat, other.specFeat) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film Title: ").append(title).append("\n").append("Description: ").append(desc).append("\n").append("Year Released: ").append(relYear)
				.append("\n").append("Language: ").append(lang).append("\n").append("Rating: ").append(rating).append("\n").append("Cast: \n");
		for (Actor actor : cast) {
			builder.append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
			
			
		}
		
		return builder.toString();
	}

	

}