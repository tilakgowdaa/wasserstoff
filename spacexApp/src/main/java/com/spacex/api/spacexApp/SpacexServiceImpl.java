package com.spacex.api.spacexApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpacexServiceImpl implements SpacexService {

	@Autowired
	private SpacexRepo repo;

	@Override
	public List<SpacexDto> getAll() {
		List<SpacexEntity> entity = repo.findAll();
		List<SpacexDto> dto = new ArrayList<SpacexDto>();
		for (SpacexEntity entities : entity) {
			SpacexDto spacexDto = new SpacexDto();
			BeanUtils.copyProperties(entities, spacexDto);
			dto.add(spacexDto);
		}
		return dto;
	}

	@Override
	public List<SpacexDto> getFiltered(int yearFrom, int yearTo, boolean successful, boolean manned) {
		List<SpacexEntity> entity = repo.findByFilter(yearFrom, yearTo, successful, manned);
		List<SpacexDto> dto = new ArrayList<SpacexDto>();
		for (SpacexEntity entities : entity) {
			SpacexDto spacexDto = new SpacexDto();
			BeanUtils.copyProperties(entities, spacexDto);
			dto.add(spacexDto);
		}
		return dto;
	}

	@Override
	public List<SpacexDto> getSearchByName(String name) {
		List<SpacexEntity> entity = repo.findAllBySearch(name);
		List<SpacexDto> dto = new ArrayList<SpacexDto>();
		for (SpacexEntity entities : entity) {
			SpacexDto spacexDto = new SpacexDto();
			BeanUtils.copyProperties(entities, spacexDto);
			dto.add(spacexDto);
		}
		return dto;
	}

	@Override
	public List<SpacexDto> getCategory1() {
		List<SpacexEntity> entity = repo.findAllSuccessful();
		List<SpacexDto> dto = new ArrayList<SpacexDto>();
		for (SpacexEntity entities : entity) {
			SpacexDto spacexDto = new SpacexDto();
			BeanUtils.copyProperties(entities, spacexDto);
			dto.add(spacexDto);
		}
		return dto;
	}

	@Override
	public List<SpacexDto> getCategory2() {
		List<SpacexEntity> entity = repo.findAllManned();
		List<SpacexDto> dto = new ArrayList<SpacexDto>();
		for (SpacexEntity entities : entity) {
			SpacexDto spacexDto = new SpacexDto();
			BeanUtils.copyProperties(entities, spacexDto);
			dto.add(spacexDto);
		}
		return dto;
	}

}
