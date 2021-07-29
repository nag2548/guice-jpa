package de.grabmair.guice.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "us_states", schema = "public")
public class UsStates implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id", unique = true, nullable = false)
	private short stateId;

	@Column(name = "state_name", length = 100)
	private String stateName;

	@Column(name = "state_abbr", length = 2)
	private String stateAbbr;

	@Column(name = "state_region", length = 50)
	private String stateRegion;

	public UsStates() {
	}

	public UsStates(String stateName, String stateAbbr, String stateRegion) {
		this.stateName = stateName;
		this.stateAbbr = stateAbbr;
		this.stateRegion = stateRegion;
	}

	public short getStateId() {
		return this.stateId;
	}

	public void setStateId(short stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbr() {
		return this.stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getStateRegion() {
		return this.stateRegion;
	}

	public void setStateRegion(String stateRegion) {
		this.stateRegion = stateRegion;
	}

	@Override
	public String toString() {
		return "UsStates [stateId=" + stateId + ", stateName=" + stateName + ", stateAbbr=" + stateAbbr
				+ ", stateRegion=" + stateRegion + "]";
	}
}
