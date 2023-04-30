package com.app.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.Entity.CropInfo;

public interface CropInfoRepository extends JpaRepository<CropInfo, Integer> {
	@Query("select c from CropInfo c where c.cropId= :id")
	public CropInfo findByCustomId(@Param("id") Integer id);

	@Query(value = "select * from crop_info c where c.id= :id", nativeQuery = true)
	public List<CropInfo> fetchByCropId(@Param("id") int id);

	

	@Transactional
	@Modifying
	@Query("Delete from CropInfo c where c.cropId=:id")
	public void deleteProduct(@Param("id") Integer id);
}
