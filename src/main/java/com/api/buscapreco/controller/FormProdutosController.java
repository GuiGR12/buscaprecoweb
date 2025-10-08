/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.buscapreco.controller;

import com.api.buscapreco.data.ProdutosEntity; 
import com.api.buscapreco.service.ProdutosService; 
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 


@Controller
public class FormProdutosController {
    
    @Autowired
            
        ProdutosService produtosService; 
            
    @GetMapping("/") 
        public String viewHomePage(Model model) {            
         
        return "BPindex"; 
        
        } 
        
    @GetMapping("/deletarProduto/{id}") 
        public String deletarProduto(@PathVariable(value = "id") Integer id) { 
        produtosService.deletarProduto(id); 
        return "redirect:/"; 
        } 

    @GetMapping("/criarProdutoForm") 
        public String criarProdutoForm(Model model) { 
        ProdutosEntity produto = new ProdutosEntity(); 
        model.addAttribute("produto", produto); 
        return "BPcadastro";
        }
        
    @PostMapping("/salvarProduto") 

        public String salvarProduto(@Valid @ModelAttribute("produto") ProdutosEntity produto, BindingResult result) { 

            if (result.hasErrors()) { 

            return "BPcadastro"; 

            }            

            produtosService.criarProduto(produto); 
            
            return "redirect:/listarProduto"; 

            }    
        
    @GetMapping("/atualizarProdutoForm/{id}") 

        public String atualizarProdutoForm(@PathVariable(value = "id") Integer id, Model model) { 

        ProdutosEntity produto = produtosService.getProdutoId(id); 

        model.addAttribute("produto", produto); 

        return "atualizar"; 
        
        }
        
    @GetMapping("/listarProduto") 
        public String listarProdutos(Model model) {            
            model.addAttribute("listarProdutos", produtosService.listarTodosProdutos());
        return "BPlista"; 
        
        }
     
}
