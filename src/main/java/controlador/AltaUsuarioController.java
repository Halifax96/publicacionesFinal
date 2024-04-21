/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.PersonasFacadeLocal;
import EJB.RolesFacadeLocal;
import EJB.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Personas;
import modelo.Roles;
import modelo.Usuarios;

@Named
@ViewScoped
public class AltaUsuarioController implements Serializable{

    private Usuarios usuario;
    private Personas persona;
    private Roles rol;
    private List<Roles> listaRoles;//Roles que se deben cargar en el formulario
    
    @EJB 
    private UsuariosFacadeLocal usuariosEJB;
    @EJB
    private RolesFacadeLocal rolesEJB;
    @EJB
    private PersonasFacadeLocal personasEJB;
    
    @PostConstruct
     public void init(){
         usuario = new Usuarios();
         persona = new Personas();
         rol = new Roles();
     }
     
    public void insertarUsuario(){
            
       try{
            usuario.setIdPersona(persona);
            for(Roles r : listaRoles){
                   if(r.getIdRol()==rol.getIdRol()){
                       usuario.setIdRol(r);
                   }
            }
            usuariosEJB.create(usuario);
       }catch(Exception e){
            System.out.println("Error al insertar usuario\n" + e.getMessage());
       }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario.getUser());
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public List<Roles> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Roles> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public UsuariosFacadeLocal getUsuariosEJB() {
        return usuariosEJB;
    }

    public void setUsuariosEJB(UsuariosFacadeLocal usuariosEJB) {
        this.usuariosEJB = usuariosEJB;
    }

    public RolesFacadeLocal getRolesEJB() {
        return rolesEJB;
    }

    public void setRolesEJB(RolesFacadeLocal rolesEJB) {
        this.rolesEJB = rolesEJB;
    }

    public PersonasFacadeLocal getPersonasEJB() {
        return personasEJB;
    }

    public void setPersonasEJB(PersonasFacadeLocal personasEJB) {
        this.personasEJB = personasEJB;
    }
    
    

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
     
  

}

