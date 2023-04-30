package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.Entity.CombineUserOrder;

import com.app.Repository.CombineOrderRepository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	private CombineOrderRepository combineOrderRepository;

	@Override
	public List<CombineUserOrder> showOrder() {

		return combineOrderRepository.findOrder();
	}

	@Override
	public CombineUserOrder fetchOrderById(CombineUserOrder combineUserOrder) {
	//	System.out.println(combineUserOrder.getCO_Id());
		return combineOrderRepository.getByOrderId(combineUserOrder.getCoid());
	}

	@Override
	public void editByOrderStatus(CombineUserOrder combineUserOrder) {
	//	System.out.println("orderid" + combineUserOrder.getCO_Id());

		combineOrderRepository.editByOrderStatus(combineUserOrder.getStatus(), combineUserOrder.getCoid());

	}

}
