

function cadastro(){
    
    const txtProduto = document.getElementById("txtProduto").value
    const txtMarca = document.getElementById("txtMarca").value
    const txtPreco = document.getElementById("txtPreco").value
    const txtQuantidade = document.getElementById("txtQuantidade").value
    const txtData = document.getElementById("txtData").value   
        
    if (txtProduto == "" || txtMarca == "" || txtPreco == ""|| txtQuantidade == "" || txtData == ""){
        
        alert('Preencha os campos corretamente!');
        
    } else {
            
        alert('Produto cadastrado com sucesso!');
       
           }
    }