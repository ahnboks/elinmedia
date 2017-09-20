package com.ahn.springboot;

import com.ahn.springboot.domain.WideAdmin;
import com.ahn.springboot.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log
public class SpringbootApplicationTests {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private WideAdminRepository wideAdminRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
	public void insertAdmin() {
		WideAdmin wideAdminAdmin = new WideAdmin();
		wideAdminAdmin.setWide_admin_email("ahnboks@naver.com");
		wideAdminAdmin.setWide_admin_name("엘린미디어");
		wideAdminAdmin.setWide_admin_password(passwordEncoder.encode("1234"));
		wideAdminAdmin.setWide_admin_contractFinishDate(new Date());
		wideAdminAdmin.setWide_admin_contractStatusCode("CY");
		wideAdminAdmin.setWide_admin_roleCode("MA");

		wideAdminRepository.save(wideAdminAdmin);
	}

	@Test
    @WithMockUser(roles = "MA", username = "ahnboks@naver.com",password = "1234")
	public void selectadmin() throws Exception{
        this.mockMvc.perform(get("/admin/main"))
                .andExpect(status().isOk()).andDo(print());
	}





}
