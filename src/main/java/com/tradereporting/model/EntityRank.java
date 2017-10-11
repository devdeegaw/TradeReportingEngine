package com.tradereporting.model;

import java.util.Objects;

public class EntityRank {
	private int rank;
    private  String entity;
    private  String date;
    
   public EntityRank(int rank, String entity,String date){
    	this.rank =rank;
    	this.entity =entity;
    	this.date =date;
    }
    
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
    public String toString() {
		
		return "EntityRank [" + this.entity + ", " + this.rank  + ", " + this.date + "]";
    }
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		final EntityRank other = (EntityRank) o;
		return other.getRank() == this.getRank() && other.getEntity().equals(this.getEntity())
				&& other.getDate().equals(this.getDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, entity, date);
	}

}
