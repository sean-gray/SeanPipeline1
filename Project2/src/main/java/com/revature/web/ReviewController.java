package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Review;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Movies;
import com.revature.service.ReviewService;
import com.revature.service.UserService;

@RestController(value = "reviewController")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	private static ReviewService reviewService;
	@Autowired
	public void setReviewService(ReviewService reviewService) {
		ReviewController.reviewService = reviewService;
	}
	@Autowired
	public UserService userService;
	
	
	private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
	public ReviewController() {
		super();
	}
	@RequestMapping(value = { "/getreviews" })
	public List<Review> getReviews() {
		List<Review> reviewlist = reviewService.randomReview();
		return reviewlist;
		
	}
	///movies?moviename=the+lion+king&movieyear=2019
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Movies getMovies(@RequestParam String moviename,@RequestParam String movieyear){
        String movie = "http://www.omdbapi.com/?apikey=9bc46875&t="+moviename+"&y="+movieyear;
        System.out.println(moviename);
        Movies newmovie=  restTemplate.getForObject(movie, Movies.class);
        return newmovie;

    }
	@RequestMapping(value = "/savereviews", method = RequestMethod.POST)
	public void saveReview(@RequestBody String r) {
		System.out.println("savfe reviews got called");
		System.out.println(r);
		//Object rparse = JSON.parse(r);
		try {
			System.out.println("testing");
			Review robj = new ObjectMapper().readValue(r, Review.class);
			System.out.println(robj.getRevdesc());
			reviewService.insertReview(robj);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/reviewsbyuser", method = RequestMethod.GET)
    public List<Review> reviewsByUser(@RequestParam String username){
		int userid = userService.findUseridByUsername(username);
		System.out.println("User id is currently: " + userid);
        List<Review> reviewlist = reviewService.reviewsByUserid(userid);
        return reviewlist;

    }
	@RequestMapping(value = "/reviewsbymovie", method = RequestMethod.GET)
    public List<Review> reviewsByMovie(@RequestParam String imdbid){
        List<Review> reviewlist = reviewService.reviewsByMovieid(imdbid);
        return reviewlist;

    }
	@RequestMapping(value = "/reviewsbyone", method = RequestMethod.GET)
    public List<Review> reviewsByOne(@RequestParam int revid){
        List<Review> reviewlist = reviewService.reviewsByOne(revid);
        return reviewlist;

    }
	
}
