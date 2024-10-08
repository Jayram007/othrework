package com.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.CombineUserOrder;
import com.app.Entity.CropInfo;
import com.app.Entity.Product;
import com.app.Entity.UserOrder;
import com.app.Entity.Users;
import com.app.Repository.UserDao;
import com.app.service.CropInformServiceImpl;
import com.app.service.ProductServiceImpl;
import com.app.service.UserServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private CropInformServiceImpl cropInformServiceImpl;

	@Autowired
	private UserDao userRepo;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/showProducts")
	public List<Product> getUserDetails() {
		return productServiceImpl.allProducts();

	}
	
	@GetMapping("/showCropInfo")
	public List<CropInfo> getCropInfo() {
		return cropInformServiceImpl.showCropInfo();
	}
	
	@PostMapping("/profile/{email}")
	public Users consumerProfile(@Valid @PathVariable String email) {
		return userRepo.findByEmail(email);
	}
	
	@PostMapping("/saveOrder/{email}")
	public String saveOrder(@Valid @RequestBody UserOrder order, @PathVariable String email) {
		userServiceImpl.additems(order, email);
		return "Order Saved";
	}
	
	@PostMapping("/saveCombineOrder/{email}")
	public String saveCombineOrder(@Valid @RequestBody CombineUserOrder order, @PathVariable String email) {
		userServiceImpl.addCombineitems(order, email);
		return "Order Saved";
	}
	
	@GetMapping("/organicProduct")
	public List<Product> organicProduct() {
		return productServiceImpl.findByOrganicProducts();
	}

	@GetMapping("/nonOrganicProduct")
	public List<Product> nonOrganicProduct() {
		return productServiceImpl.findByNonOrganicProducts();
	}

	@GetMapping("/showConsumerOrder/{id}")
	public List<CombineUserOrder> showOrder(@PathVariable int id) {
		return userServiceImpl.showConsumerOrder(id);
	}
}
