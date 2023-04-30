package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entity.CombineUserOrder;
import com.app.Entity.UserOrder;
import com.app.Entity.Users;
import com.app.Repository.CombineOrderRepository;
import com.app.Repository.OrderRepository;
import com.app.Repository.UserDao;
import com.app.Repository.UserOrderRepository;
import com.app.custom_excs.CustomerHandlingException;
import com.app.dto.LoginRequest;

@Service
@Transactional

public class UserServiceImpl implements IUserService{
	@Autowired
	private UserDao userRepo;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private UserOrderRepository userOrderRepository;
	
	@Autowired
	private CombineOrderRepository combineOrderRepository;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@Override
	public Users registerOrEditUser(Users user) {
		try
		{
			//emailService.sendEmailForNewRegistration(user.getEmail());
			String encodedPass = this.passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPass);

		return userRepo.save(user);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return user;
	}

	@Override
	public Users findByEmail(String email) {

		return userRepo.findByEmail(email);
	}

	@Override
	public Users findById(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public Users edit(Users user, int userId) {
		user.setPassword(userRepo.findById(userId).get().getPassword());
		user.setId(userId);
		return userRepo.save(user);
	}

	@Override
	public String deleteUserById(Integer uid) {
		userRepo.deleteById(uid);
		return "Deleted User with ID: " + uid + " successfully!";
	}

	@Override
	public List<Users> getUserByName(String fname) {
		return userRepo.findByFirstName(fname);
	}

	@Override
	public Users getUserByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}

	@Override
	public int countUsers() {
		return (int) userRepo.count();
	}

	@Override
	public List<Users> fetchUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users findByEmailAndPassword(String email, String password) {
//		String encodedPass = this.passwordEncoder.encode(password);
//		System.out.println(encodedPass);
//		return userRepo.findByEmailAndPassword(email, encodedPass);
		Users user = userRepo.getUserByEmail(email);
		boolean userLoginPass = passwordEncoder.matches(password, user.getPassword());
		if(userLoginPass) 
			return user;
		return null;
	}



	@Override
	public Users disableUser(Users user, int id) {
		Users us = userRepo.findById(id).orElseThrow( () -> new CustomerHandlingException("User not found"));
		us.setStatus(user.getStatus());
		userRepo.save(us);
		return us;
	}
	@Override
	public Users enableUser(Users user, int id) {
		Users us = userRepo.findById(id).orElseThrow( () -> new CustomerHandlingException("User not found")); 
		us.setStatus(user.getStatus());
		userRepo.save(us);
		return us;
	}

	@Override
	public int findByNewEmailandPassword(LoginRequest request) {
		try {
			
			Users user = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
			
			System.out.println(user.getRole());
			if (user != null) {
				if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("CONSUMER")) {
					return 1;
				}

				else if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("FARMER")) {
					return 2;
				} else if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("ADMIN")) {
					return 3;
				} else if (user.getPassword().equals(request.getPassword()) && user.getRole().equals("DELIVERY_BOY")) {
					return 4;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 5;
		}
		return 0;
	}

	@Override
	public void saveOrder(UserOrder order) {
		orderRepository.save(order);
		
	}

	@Override
	public void editUserByStatus(Users user) {
		userRepo.editByEmail(user.getStatus(),user.getEmail());
		
	}

	@Override
	public UserOrder additems(UserOrder items, String email) {
		Users users = userRepo.findByEmail(email);
		System.out.println(users.getCity());
		try {
		
		UserOrder product = items;
		product.setOuser(users);
		product.setProductName(items.getProductName());
		product.setItemsPrice(items.getItemsPrice());
		product.setShippingPrice(items.getShippingPrice());
		product.setTaxPrice(items.getTaxPrice());
		product.setTotalPrice(items.getTotalPrice());
		
		
		return userOrderRepository.save(product);
		}
		catch(Exception e)
		{
			System.out.println("============================");
			System.out.println(e.getMessage());
			System.out.println("=============================");
		}
		return null;
	}

	@Override
	public List<CombineUserOrder> showConsumerOrder(int id) {
		return combineOrderRepository.findBycustomId(id);
	}
	
	public void updateUser(Users user) {
		String encodedPass = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPass);

		userRepo.save(user);
	}


	@Override
	public CombineUserOrder addCombineitems(CombineUserOrder order, String email) {
		Users users = userRepo.findByEmail(email);
		System.out.println(users.getCity());
		try {
		
		CombineUserOrder combineOrder = order;
		combineOrder.setCouser(users);
		combineOrder.setCity(order.getCity());
		combineOrder.setEmail(order.getEmail());
		combineOrder.setFirstName(order.getFirstName());
		combineOrder.setLastName(order.getLastName());
		combineOrder.setItemsPrice(order.getItemsPrice());
		combineOrder.setPhone(order.getPhone());
		combineOrder.setProductName(order.getProductName());
		combineOrder.setShippingPrice(order.getShippingPrice());
		combineOrder.setState(order.getState());
		combineOrder.setStatus(order.getStatus());
		combineOrder.setTaxPrice(order.getTaxPrice());
		combineOrder.setTotalPrice(order.getTotalPrice());
		
		return combineOrderRepository.save(combineOrder);
		}
		catch(Exception e)
		{
			System.out.println("============================");
			System.out.println(e.getMessage());
			System.out.println("=============================");
		}
		return null;
	}
}
