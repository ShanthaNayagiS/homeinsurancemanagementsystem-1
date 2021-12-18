package com.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.insurance.exception.AgentNotFoundException;
import com.insurance.model.Agent;
import com.insurance.repository.AgentRepository;
import com.insurance.service.AgentService;

@SpringBootTest
public class AgentTest {
	@InjectMocks
	private AgentService agentService;
	@Mock
	private AgentRepository agentRepository;

	@Test
	public void createAgentTest() {
		Agent agent = new Agent();
		agent.setAgentId(1);
		agent.setAgentName("Dipali");
		agent.setAddress("pune");
		agent.setAgentPinCode(123456);
		agent.setEmail("dipali@gmail.com");
		agent.setMobileNo("1234567890");

		Mockito.when(agentRepository.save(agent)).thenReturn(agent);

		assertEquals(agent, agentService.createAgent(agent));

	}

	@Test
	public void getAllAgentTest() throws AgentNotFoundException {
		Agent agent1 = new Agent();
		agent1.setAgentId(1);
		agent1.setAgentName("Dipali");
		agent1.setAddress("pune");
		agent1.setAgentPinCode(123456);
		agent1.setEmail("dipali@gmail.com");
		agent1.setMobileNo("1234567890");

		Agent agent2 = new Agent();
		agent2.setAgentId(2);
		agent2.setAgentName("Sharvari");
		agent2.setAddress("pune");
		agent2.setAgentPinCode(123456);
		agent2.setEmail("sharvari@gmail.com");
		agent2.setMobileNo("1234567899");

		List<Agent> list = new ArrayList<Agent>();
		list.add(agent1);
		list.add(agent2);

		Mockito.when(agentRepository.findAll()).thenReturn(list);

		assertEquals(list, agentService.getAllAgent());
	}

	@Test
	public void updateAgentTest() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(1);
		agent.setAgentName("Dipali");
		agent.setAddress("pune");
		agent.setAgentPinCode(123456);
		agent.setEmail("dipali@gmail.com");
		agent.setMobileNo("1234567890");

		Mockito.when(agentRepository.save(agent)).thenReturn(agent);

		Mockito.when(agentRepository.existsById(1)).thenReturn(true);
		agent.setAgentName("Samuel Eto");

		Agent testAgent = agentService.updateAgent(agent);

		assertEquals(agent.getAgentName(), testAgent.getAgentName());
	}

	@Test
	public void getAgentByIdPositiveTest() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(1);
		agent.setAgentName("Dipali");
		agent.setAddress("pune");
		agent.setAgentPinCode(123456);
		agent.setEmail("dipali@gmail.com");
		agent.setMobileNo("1234567890");

		Mockito.when(agentRepository.existsById(1)).thenReturn(true);
		Mockito.when(agentRepository.findById(1)).thenReturn(Optional.of(agent));

		assertEquals(Optional.of(agent), agentService.getAgentById(1));

	}

//	@Test
//	public void getAgentByIdNegativeTest()throws AgentNotFoundException {
//		Agent agent = new Agent();
//		agent.setAgentId(1);
//		agent.setAgentName("Dipali");
//		agent.setAddress("pune");
//		agent.setAgentPinCode(123456);
//		agent.setEmail("dipali@gmail.com");
//		agent.setMobileNo("1234567890");
//
//		Executable ex = () -> {
//			agentService.getAgentById(1);
//		};
//
//		verify(agentRepository, never()).findById(1);
//		Assertions.assertThrows(AgentNotFoundException.class, ex);
//
//	}

	@Test
	public void deleteAgentByIdPositiveTest() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(1);
		agent.setAgentName("Dipali");
		agent.setAddress("pune");
		agent.setAgentPinCode(123456);
		agent.setEmail("dipali@gmail.com");
		agent.setMobileNo("1234567890");

		Mockito.when(agentRepository.save(agent)).thenReturn(agent);
		Mockito.when(agentRepository.existsById(1)).thenReturn(true);

		agentService.deleteAgentById(1);

		verify(agentRepository, Mockito.atLeastOnce()).deleteById(1);

	}

//	@Test
//	public void deleteAgentByIdNegativetiveTest() throws AgentNotFoundException {
//		Agent agent = new Agent();
//		agent.setAgentId(1);
//		agent.setAgentName("Dipali");
//		agent.setAddress("pune");
//		agent.setAgentPinCode(123456);
//		agent.setEmail("dipali@gmail.com");
//		agent.setMobileNo("1234567890");
//
//		Mockito.when(agentRepository.existsById(2)).thenReturn(false);
//		Executable ex = () -> {
//			agentService.deleteAgentById(2);
//		};
//
//		verify(agentRepository, never()).deleteById(1);
//		Assertions.assertThrows(AgentNotFoundException.class, ex);
//	}

}
