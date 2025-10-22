/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.buscapreco.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Integer> {
    
    List<ProdutosEntity> findByNomeProduto(String nomeProduto); 

    List<ProdutosEntity> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
    
}
