/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.buscapreco.service;

import com.api.buscapreco.data.ProdutosEntity; 
import com.api.buscapreco.data.ProdutosRepository; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service; 

@Service 
public class ProdutosService {
    
    @Autowired

    ProdutosRepository produtosRepository;

    public ProdutosEntity criarProduto(ProdutosEntity produto) {
       
        produtosRepository.save(produto);

        return produto;

    }
    
    public ProdutosEntity atualizarProduto(Integer produtoId, ProdutosEntity produtoRequest) { 

        ProdutosEntity produto = getProdutoId(produtoId);

        produto.setNomeProduto(produtoRequest.getNomeProduto());

        produto.setMarca(produtoRequest.getMarca());

        produto.setPreco(produtoRequest.getPreco());

        produto.setQuantidade(produtoRequest.getQuantidade());
        
        produto.setDataCompra(produtoRequest.getDataCompra());

        produtosRepository.save(produto);

        return produto;

    }
    
    public ProdutosEntity getProdutoId(Integer produtoId) { 

        return produtosRepository.findById(produtoId).orElse(null);

    }
    
    public List<ProdutosEntity> getProdutoNome(String nome) { 

        return produtosRepository.findByNomeProduto(nome);

    }

    public List<ProdutosEntity> listarTodosProdutos() {

        return produtosRepository.findAll();

    }

    public void deletarProduto(Integer produtoId) {

        ProdutosEntity produto = getProdutoId(produtoId);

        produtosRepository.deleteById(produto.getId());

    }
    
}
