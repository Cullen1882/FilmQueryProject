package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int fId;
	private String title;
	private String desc;
	private int relYear;
	private int langId;
	private int rentDur;
	private double rentRate;
	private int length;
	private double repCost;
	private String rating;
	private String specFeat;
	private List<Actor> cast;

	public Film() {

	}

	public Film(int id) {
		super();
		this.fId = id;
	}

	public Film(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return Objects.hash(desc, fId, langId, length, rating, relYear, rentDur, rentRate, repCost, specFeat, title);
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
		return Objects.equals(desc, other.desc) && fId == other.fId && langId == other.langId && length == other.length
				&& Objects.equals(rating, other.rating) && relYear == other.relYear && rentDur == other.rentDur
				&& Double.doubleToLongBits(rentRate) == Double.doubleToLongBits(other.rentRate)
				&& Double.doubleToLongBits(repCost) == Double.doubleToLongBits(other.repCost)
				&& Objects.equals(specFeat, other.specFeat) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", desc=" + desc + ", relYear=" + relYear + ", langId=" + langId
				+ ", rentDur=" + rentDur + ", rentRate=" + rentRate + ", length=" + length + ", repCost=" + repCost
				+ ", rating=" + rating + ", specFeat=" + specFeat + "]";
	}

}  