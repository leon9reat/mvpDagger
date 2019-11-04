package com.medialink.mvpmemorize.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Film{

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("species")
	private List<String> species;

	@SerializedName("director")
	private String director;

	@SerializedName("description")
	private String description;

	@SerializedName("producer")
	private String producer;

	@SerializedName("vehicles")
	private List<String> vehicles;

	@SerializedName("locations")
	private List<String> locations;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("rt_score")
	private String rtScore;

	@SerializedName("people")
	private List<String> people;

	@SerializedName("url")
	private String url;

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setSpecies(List<String> species){
		this.species = species;
	}

	public List<String> getSpecies(){
		return species;
	}

	public void setDirector(String director){
		this.director = director;
	}

	public String getDirector(){
		return director;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setProducer(String producer){
		this.producer = producer;
	}

	public String getProducer(){
		return producer;
	}

	public void setVehicles(List<String> vehicles){
		this.vehicles = vehicles;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public void setLocations(List<String> locations){
		this.locations = locations;
	}

	public List<String> getLocations(){
		return locations;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setRtScore(String rtScore){
		this.rtScore = rtScore;
	}

	public String getRtScore(){
		return rtScore;
	}

	public void setPeople(List<String> people){
		this.people = people;
	}

	public List<String> getPeople(){
		return people;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}