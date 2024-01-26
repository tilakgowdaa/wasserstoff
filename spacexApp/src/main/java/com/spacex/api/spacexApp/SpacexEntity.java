package com.spacex.api.spacexApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spacexdata")
@Data
@NoArgsConstructor
public class SpacexEntity {
	@Id
	@Column(name = "s_id")
	private int id;
	@Column(name = "s_mission")
	private String mission;
	@Column(name = "s_rocketname")
	private String rocketName;
	@Column(name = "s_launchyear")
	private int launchYear;
	@Column(name = "s_unmanned")
	private boolean isUnmanned;
	@Column(name = "s_successfull")
	private boolean isSuccessful;
}
