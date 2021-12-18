package com.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.insurance.exception.UserNotFoundException;
import com.insurance.model.UserEntry;
import com.insurance.repository.UserRepository;
import com.insurance.service.UserService;

@SpringBootTest
public class UserEntryTest {
	@InjectMocks
	private UserService userService;
	@Mock
	private UserRepository userRepository;

	@Test
	public void createUserTest() throws UserNotFoundException {
		UserEntry userEntry = new UserEntry();
		userEntry.setUserId(1);
		userEntry.setUserName("Sanket");
		// userEntry.setUserDob("2000-12-09");
		userEntry.setUserEmail("sanket@gmail.com");
		userEntry.setUserPhone("1234567890");
		userEntry.setUserOccupation("IT");
		userEntry.setUserAnnualIncome(100000);
		userEntry.setUserAddress("Pune");
		userEntry.setUserPinCode(12345);
		Mockito.when(userRepository.save(userEntry)).thenReturn(userEntry);

		assertEquals(userEntry, userService.createUser(userEntry));
	}

	@Test
	public void getAllUserTest() throws UserNotFoundException {
		UserEntry userEntry = new UserEntry();
		userEntry.setUserId(1);
		userEntry.setUserName("Sanket");
		// userEntry.setUserDob("2000-12-09");
		userEntry.setUserEmail("sanket@gmail.com");
		userEntry.setUserPhone("1234567890");
		userEntry.setUserOccupation("IT");
		userEntry.setUserAnnualIncome(100000);
		userEntry.setUserAddress("Pune");
		userEntry.setUserPinCode(12345);

		UserEntry userEntry1 = new UserEntry();
		userEntry1.setUserId(1);
		userEntry1.setUserName("Sanket");
		// userEntry.setUserDob("2000-12-09");
		userEntry1.setUserEmail("sanket@gmail.com");
		userEntry1.setUserPhone("1234567890");
		userEntry1.setUserOccupation("IT");
		userEntry1.setUserAnnualIncome(100000);
		userEntry1.setUserAddress("Pune");
		userEntry1.setUserPinCode(12345);

		List<UserEntry> list = new ArrayList<UserEntry>();
		list.add(userEntry);
		list.add(userEntry1);

		Mockito.when(userRepository.findAll()).thenReturn(list);

		assertEquals(list, userService.getAllUser());
	}

	@Test
	public void deleteUserDetailsByIdTest() throws UserNotFoundException {
		UserEntry userEntry = new UserEntry();
		userEntry.setUserId(1);
		userEntry.setUserName("Sanket");
		// userEntry.setUserDob("2000-12-09");
		userEntry.setUserEmail("sanket@gmail.com");
		userEntry.setUserPhone("1234567890");
		userEntry.setUserOccupation("IT");
		userEntry.setUserAnnualIncome(100000);
		userEntry.setUserAddress("Pune");
		userEntry.setUserPinCode(12345);

		Mockito.when(userRepository.save(userEntry)).thenReturn(userEntry);
		Mockito.when(userRepository.existsById(1)).thenReturn(true);

		userService.deleteUserDetailsById(1);

		verify(userRepository, Mockito.atLeastOnce()).deleteById(1);
	}
}