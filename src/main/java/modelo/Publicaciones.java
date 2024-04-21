/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "publicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicaciones.findAll", query = "SELECT p FROM Publicaciones p"),
    @NamedQuery(name = "Publicaciones.findByIdPublicacion", query = "SELECT p FROM Publicaciones p WHERE p.idPublicacion = :idPublicacion"),
    @NamedQuery(name = "Publicaciones.findByTitulo", query = "SELECT p FROM Publicaciones p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Publicaciones.findByCuerpo", query = "SELECT p FROM Publicaciones p WHERE p.cuerpo = :cuerpo"),
    @NamedQuery(name = "Publicaciones.findByComentarioProfesor", query = "SELECT p FROM Publicaciones p WHERE p.comentarioProfesor = :comentarioProfesor"),
    @NamedQuery(name = "Publicaciones.findByValoracion", query = "SELECT p FROM Publicaciones p WHERE p.valoracion = :valoracion"),
    @NamedQuery(name = "Publicaciones.findByFecha", query = "SELECT p FROM Publicaciones p WHERE p.fecha = :fecha")})
public class Publicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPublicacion")
    private Integer idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Cuerpo")
    private String cuerpo;
    @Size(max = 100)
    @Column(name = "ComentarioProfesor")
    private String comentarioProfesor;
    @Column(name = "Valoracion")
    private Character valoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @JoinColumn(name = "IdPersona", referencedColumnName = "IdPersona")
    @ManyToOne(optional = false)
    private Personas idPersona;

    public Publicaciones() {
    }

    public Publicaciones(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones(Integer idPublicacion, String titulo, String cuerpo, Date fecha) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getComentarioProfesor() {
        return comentarioProfesor;
    }

    public void setComentarioProfesor(String comentarioProfesor) {
        this.comentarioProfesor = comentarioProfesor;
    }

    public Character getValoracion() {
        return valoracion;
    }

    public void setValoracion(Character valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicaciones)) {
            return false;
        }
        Publicaciones other = (Publicaciones) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Publicaciones[ idPublicacion=" + idPublicacion + " ]";
    }
    
}
