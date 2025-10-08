/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.buscapreco.controller;

import com.api.buscapreco.data.ProdutosEntity; 
import com.api.buscapreco.service.ProdutosService; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController

@RequestMapping("/produto")
public class ProdutosController {
        
    @Autowired 

        ProdutosService produtosService; 
    
    @GetMapping("/listar") 

        public ResponseEntity<List> getAllProdutos() { 

        List<ProdutosEntity> produtos = produtosService.listarTodosProdutos(); 

        return new ResponseEntity<>(produtos, HttpStatus.OK); 

        }
    
    @GetMapping("/pesquisar/{id}") 

        public ResponseEntity<ProdutosEntity> getProdutoById(@PathVariable Integer id) { 

        ProdutosEntity produto = produtosService.getProdutoId(id); 

        return new ResponseEntity<>(produto, HttpStatus.OK); 

        } 
        
    @PostMapping("/adicionar") 

        public ResponseEntity<ProdutosEntity> addProduto(@RequestBody ProdutosEntity produto) { 

        var novoProduto = produtosService.criarProduto(produto); 

        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED); 

        } 
        
    @PutMapping("/atualizar/{id}") 

        public ResponseEntity<ProdutosEntity> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutosEntity produto) { 

        var produtoAtualizado = produtosService.atualizarProduto(id, produto); 

        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK); 

        }
        
     @DeleteMapping("/deletar/{id}") 

        public ResponseEntity deletarProduto(@PathVariable Integer id) { 

        produtosService.deletarProduto(id); 

        return new ResponseEntity<>(HttpStatus.OK); 

        }    
    
}
