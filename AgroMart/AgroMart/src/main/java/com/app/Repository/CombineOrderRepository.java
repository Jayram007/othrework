package com.app.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.CombineUserOrder;
@Repository
public interface CombineOrderRepository extends JpaRepository<CombineUserOrder, Integer> {
	@Query(value = "select * from combine_user_order where id=:id", nativeQuery = true)
	public List<CombineUserOrder> findBycustomId(@Param("id") int id);

	@Query(value = "select * from combine_user_order", nativeQuery = true)
	public List<CombineUserOrder> findOrder();

	@Query(value = "select * from combine_user_order where coid=:id", nativeQuery = true)
	public CombineUserOrder getByOrderId(@Param("id") int id);

	@Transactional
	@Modifying
	@Query("update CombineUserOrder c set c.status=:status where c.coid=:id")
	public void editByOrderStatus(@Param("status") String status, @Param("id") int id);

}
