package com.spacex.api.spacexApp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpacexDto {
	private String mission;
	private String rocketName;
	private int launchYear;
	private boolean isUnmanned;
	private boolean isSuccessful;
}
