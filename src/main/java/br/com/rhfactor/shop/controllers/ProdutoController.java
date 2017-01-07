package br.com.rhfactor.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rhfactor.shop.beans.Produto;
import br.com.rhfactor.shop.daos.ProdutoDAO;

@Controller
public class ProdutoController {

	@Autowired // Injeção de dependência
	private ProdutoDAO produtoDao;
	
	@RequestMapping(value="/produto",method=RequestMethod.GET)
	public String formulario(){
		return "produto/form";
	}
	
	@RequestMapping(value="/produto",method=RequestMethod.POST)
	public String salvar( Produto produto ){
		this.produtoDao.salvar(produto);
		return "redirect:produtos";
	}
	
	@RequestMapping(value="/produtos",method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("/produto/listar");
		modelAndView.addObject("produtos",this.produtoDao.listar());
		return modelAndView;
	}

}
