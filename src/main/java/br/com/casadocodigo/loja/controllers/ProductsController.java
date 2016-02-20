package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.controllers.validators.ProductValidator;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

/*	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProductValidator());
	}
*/	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView view = new ModelAndView("products/form");
		view.addObject("types", BookType.values());
		return view;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("products/list");
		view.addObject("products", productDAO.list());
		return view;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, name="saveProduct")
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes attributes) {
		if(bindingResult.hasErrors()){
			return form(product);
		}

		productDAO.save(product);
		attributes.addFlashAttribute("Produto adicionado.");
		
		return new ModelAndView("redirect:products");
	}

}
