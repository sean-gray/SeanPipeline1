package com.revature.projectmain;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import com.revature.model.Movies;
import com.revature.model.Review;
import com.revature.model.User;
import com.revature.service.ReviewService;
import com.revature.service.UserService;
import com.revature.web.ReviewController;
/*
 * This tells Spring where to look for the mock application context. In this case,
 * we are using a dummy context we created.
 */
//@ContextConfiguration(locations="classpath:testContext.xml")
/*
 * This denotes that our application context is a Web Application Context.
 */
@WebAppConfiguration
/*
 * When using JUnit, you can specify a test runner. This test runner is a class
 * that defines how your tests will be run. Spring has its own JUnit test runner,
 * which is called the SpringJUnit4ClassRunner. We can use the @RunWith annotation
 * to denote that we want the tests in this class to be run using a specific test
 * runner.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class Project2ApplicationTests {
	@Autowired
	RestTemplate restTemplate;
	@Mock
	private static ReviewService reviewService;
	@Mock
	private static UserService userService;
	@InjectMocks
	private ReviewController reviewController;
	/*
	 * Spring Mock MVC already has built-in support for mocking Spring controllers.
	 * We need only create a mock controller by using the MockMvc class.
	 */
	private MockMvc mockMvc;
	private Review review;
	private Movies movies;
	private User user;
	private List<Review> Review;
	private List<User> User;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		//Now let's build our mock controller:
		mockMvc = MockMvcBuilders.standaloneSetup(reviewController).build();
		Review = new ArrayList<>();
		review = new Review(1, 0, "Same Owner", 0, "Some Land");
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
	}
	@Before
	public void setUp2() {
		MockitoAnnotations.initMocks(this);
		//Now let's build our mock controller:
		mockMvc = MockMvcBuilders.standaloneSetup(reviewController).build();
		User = new ArrayList<>();
		user = new User();
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
//		review.add(new Review(1,0, "Scooby Doo",0, "Brown with Spots"));
	}
	@Test
	public void testGetAllReviews() {
		Mockito.when(reviewService.randomReview()).thenReturn(Review);
		//Now let's actually test the controller:
		try {
			/*
			 * We are manually constructing a request and specifying what should happen
			 * when such a request is made.
			 */
			mockMvc.perform(get("/review/all").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllUsers() {
		Mockito.when(userService.findAll()).thenReturn(User);
		//Now let's actually test the controller:
		try {
			/*
			 * We are manually constructing a request and specifying what should happen
			 * when such a request is made.
			 */
			mockMvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllReviews2() {
		Mockito.when(reviewService.randomReview()).thenReturn(Review);
		//Now let's actually test the controller:
		try {
			/*
			 * We are manually constructing a request and specifying what should happen
			 * when such a request is made.
			 */
			mockMvc.perform(get("/review/all").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
			Assert.assertNotNull(Project2ApplicationTests.reviewService.randomReview());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllUsers2() {
		Mockito.when(userService.findAll()).thenReturn(User);
		//Now let's actually test the controller:
		try {
			/*
			 * We are manually constructing a request and specifying what should happen
			 * when such a request is made.
			 */
			mockMvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
			Assert.assertNotNull(Project2ApplicationTests.userService.findAll());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}