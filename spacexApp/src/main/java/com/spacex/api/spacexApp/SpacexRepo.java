package com.spacex.api.spacexApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpacexRepo extends JpaRepository<SpacexEntity, Integer> {

	@Query(nativeQuery = true, value = "Select * from spacexdata where s_successfull = :successful and s_unmanned = :manned and s_launchyear >= :yearFrom and s_launchyear <= :yearTo")
	public List<SpacexEntity> findByFilter(@Param("yearFrom") int yearFrom, @Param("yearTo") int yearTo,
			@Param("successful") boolean successful, @Param("manned") boolean manned);

	@Query(nativeQuery = true,value = "Select * from spacexdata where s_successfull = true")
	public List<SpacexEntity> findAllSuccessful();
	
	@Query(nativeQuery = true,value = "Select * from spacexdata where s_unmanned = false")
	public List<SpacexEntity> findAllManned();
	
	@Query(nativeQuery = true,value = "Select * from spacexdata where s_mission = :name or s_rocketName = :name")
	public List<SpacexEntity> findAllBySearch(@Param("name") String name);
}
