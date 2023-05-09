package advancejava5.Controller;


import javax.persistence.Index;

//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import advancejava5.model.Book;
import advancejava5.service.BookService;
import advancejava5.service.LoginService;


@Controller
public class HomeController {
	
	public static String username1;

	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home()
	{
		return "index";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model)
	{
		
		//System.out.println(username+password);
		
		String uname = loginService.validateUser(username, password);
		username1=uname;
		System.out.println("userinside"+username1);
		if (uname == null) {
			return "index";
		} else {
			System.out.println(uname);
			Book[] book = bookService.getBook();
			for(Book b : book) {
				System.out.println(b.toString());
				System.out.println("AUthor is " + b.getAuthorName());			
			}
			//System.out.println(book);
			model.addAttribute("name", uname);
			model.addAttribute("bookList",book);
			return "libraryPage";
		}
		
	}
	@RequestMapping( value = "/logout")
	public String logout() {
		return "index";
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Model model,@RequestParam("bookCode") int bookCode) {
		bookService.deleteBook(bookCode);
		System.out.println("delete inside"+username1);
		model.addAttribute("name",username1);
		Book[] book=bookService.getBook();
		model.addAttribute("bookList",book);
		return "libraryPage";
	}
	
	
	@RequestMapping(path = "/showAddBook", method = RequestMethod.GET)
	public String addbook(Model model)
	{
		model.addAttribute("name",username1);
		return "addBook";
	}
	
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addBook(@RequestParam(value="bookId") int bookId,@RequestParam(value="bookName") String bookName
				,Model model,@RequestParam(value="authorName") String authorName,@RequestParam("date") String date) {
		//model.addAttribute("name",username1);
		Book book=new Book(bookId,bookName,authorName,date);
		System.out.println(book.getAuthorName());
		System.out.println("inside addbook"+book.toString());
		bookService.addBook(book);
		model.addAttribute("name",username1);
		Book[] b=bookService.getBook();
		model.addAttribute("bookList",b);
		//redirectAttributes.addAttribute("uname", username1);
		//return "redirect:/login";
		return "libraryPage";
	}
	
	@RequestMapping(path = "/showupdateBook", method = RequestMethod.GET)
	public String updatebook(@RequestParam(value="id") int bookId,Model model)
	{
		model.addAttribute("name",username1);
		model.addAttribute("bookId",bookId);
		return "updateBook";
	}
	
	@RequestMapping(value="/updateBook",method=RequestMethod.POST)
	public String updateBook(@RequestParam(value="bookId") int bookId,@RequestParam(value="bookName") String bookName
				,Model model,@RequestParam(value="authorName") String authorName,@RequestParam("date") String date) {
		Book book=new Book(bookId,bookName,authorName,date);
		bookService.updateBook(book, bookId);
		model.addAttribute("name",username1);
		Book[] b=bookService.getBook();
		model.addAttribute("bookList",b);
		//redirectAttributes.addAttribute("uname", username1);
		//return "redirect:/login";
		return "libraryPage";
	}
}
