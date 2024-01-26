package com.spacex.api.spacexApp;

import java.util.List;

public interface SpacexService {
	public List<SpacexDto> getAll();

	public List<SpacexDto> getFiltered(int yearFrom, int yearTo, boolean successful, boolean manned);
	
	public List<SpacexDto> getSearchByName(String name);
	
	public List<SpacexDto> getCategory1();
	
	public List<SpacexDto> getCategory2();
}
