/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import EJB.CategoriasFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Categorias;



@Named
@ViewScoped
public class AltaCategoriaController implements Serializable{
    
    @EJB
    private CategoriasFacadeLocal categoriaEJB;
    private Categorias categoria; 
    
    @PostConstruct
    public void init(){
        categoria = new Categorias();
    }
    
    public void registrar(){
    
        try{
            categoriaEJB.create(categoria);
        }catch(Exception e){
            System.out.println("ERROR: "+ e.getMessage());    
                  
        }
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }
    
}
