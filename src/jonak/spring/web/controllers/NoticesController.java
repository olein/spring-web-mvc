package jonak.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jonak.spring.web.dao.Notice;
import jonak.spring.web.service.NoticesService;

@Controller
public class NoticesController {

	private NoticesService noticesService;

	@Autowired
	public void setNoticesService(NoticesService noticesService) {
		this.noticesService = noticesService;
	}

	@RequestMapping("/test")
	public String showTest(Model model, @RequestParam("id") String id) {

		System.out.println("Id is : " + id);
		return "home";
	}

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		return "error";
	}

	@RequestMapping("/notices")
	public String showNotices(Model model) {
		List<Notice> notices = noticesService.getCurrent();
		model.addAttribute("notices", notices);
		System.out.println("From controller");
		return "notices";
	}

	@RequestMapping("/createnotice")
	public String createNotice(Model model) {
		model.addAttribute(new Notice());
		return "createnotice";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Notice notice, BindingResult result) {

		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createnotice";
		} else {
			noticesService.create(notice);
			System.out.println(notice);
		}
		return "noticecreated";

	}
}
