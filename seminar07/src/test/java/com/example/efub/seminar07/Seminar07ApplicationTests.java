package com.example.efub.seminar07;

import com.example.efub.seminar07.domain.User;
import com.example.efub.seminar07.domain.UserType;
import com.example.efub.seminar07.service.UserService;
import com.example.efub.seminar07.web.dto.UserController;
import com.example.efub.seminar07.web.dto.UserResponseDTO;
import com.example.efub.seminar07.web.dto.UserSaveRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserService userService;
	@Test
	public void 사용자를_가져온다() throws Exception{
		//given
		User entity=User.builder()
				.name("test_name")
				.type(UserType.NORMAL)
				.build();
		given(userService.findById(anyLong())).willReturn(new UserResponseDTO(entity));

		//fineById가 호출이 되면 UserResponseDTO를 반환
		mvc.perform(MockMvcRequestBuilders.get("/test/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("test_name"));
	}

	@Test
	public void 사용자없음_예외처리를한다() throws Exception{
		//given
		given(userService.findById(anyLong())).willThrow(new IllegalArgumentException());

		//then
		mvc.perform(MockMvcRequestBuilders.get("/test/1"))
				.andExpect(status().isNotFound());
	}

}
