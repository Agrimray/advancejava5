package advancejava5.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import advancejava5.model.Book;


@Component
public class BookServiceImpl implements BookService {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8081/books/";
	
	@Autowired
    public BookServiceImpl() {
        this.restTemplate = new RestTemplate();
        // Add JacksonHttpMessageConverter to RestTemplate's list of message converters
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
	
	public Book[] getBook() {
		// TODO Auto-generated method stub
		ResponseEntity<Book[]> bookArray=restTemplate.getForEntity(url,Book[].class);
		Book[] book = bookArray.getBody();
		return book;
	}

	
	public void addBook(Book book) {
		try {
	        System.out.println("inside service"+book.toString());
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(book);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Book> responseEntity = restTemplate.postForEntity(url, requestEntity, Book.class);
	        if (responseEntity.getStatusCode() == HttpStatus.OK) {
	            
	            Book responseBook = responseEntity.getBody();
	            //System.out.println("Book added successfully. Book ID: " + responseBook.getId());
	        } else {
	            
	            System.err.println("Failed to add book. Response status: " + responseEntity.getStatusCode());
	        }
	    } catch (JsonProcessingException e) {
	        System.err.println("Failed to convert book object to JSON: " + e.getMessage());
	    }
	}

	
	public void updateBook(Book book, int id) {
		restTemplate.put(url+id,book);
	}

	
	public void deleteBook(int id) {
		restTemplate.delete(url+id);

	}

}
