package advancejava5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import advancejava5.model.Author;
import advancejava5.model.Book;

@Component
public class AuthorServiceImpl implements AuthorService{

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8081/author/";

	@Autowired
    public AuthorServiceImpl() {
        this.restTemplate = new RestTemplate();
        // Add JacksonHttpMessageConverter to RestTemplate's list of message converters
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
	
	public Author[] getAuthor() {
		ResponseEntity<Author[]> authorArray=restTemplate.getForEntity(url,Author[].class);
		Author[] author = authorArray.getBody();
		return author;
	}

}
