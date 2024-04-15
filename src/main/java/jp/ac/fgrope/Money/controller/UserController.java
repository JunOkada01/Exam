package jp.ac.fgrope.Money.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.fgrope.Money.model.UserBook;
import jp.ac.fgrope.Money.service.UserBookService;

@Controller
public class UserController {
	@Autowired
	private UserBookService UserBookService;
 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list",this.UserBookService.getUserList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
 
	@GetMapping("/add/")
	public ModelAndView add(UserBook UserBook, ModelAndView model) {
		model.addObject("Userbook", UserBook);
		model.setViewName("form");
		return model;
	}
	
 
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull UserBook UserBook, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.UserBookService.save(UserBook);
			redirectAttributes.addFlashAttribute("exception", "");
 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
	
		
	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, UserBook UserBook, ModelAndView model) {
		model.addObject("detaillist", this.UserBookService.get(id));
		model.setViewName("detail");
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, UserBook UserBook, ModelAndView model) {
		this.UserBookService.delete(id);
		model.setViewName("delete");
		return model;
	}
}