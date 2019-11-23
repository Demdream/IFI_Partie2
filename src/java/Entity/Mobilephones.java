/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author PSDT0769
 */
@Entity
@Table(name = "mobilephones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobilephones.findAll", query = "SELECT m FROM Mobilephones m")
    , @NamedQuery(name = "Mobilephones.findById", query = "SELECT m FROM Mobilephones m WHERE m.id = :id")
    , @NamedQuery(name = "Mobilephones.findByReference", query = "SELECT m FROM Mobilephones m WHERE m.reference = :reference")
    , @NamedQuery(name = "Mobilephones.findByNom", query = "SELECT m FROM Mobilephones m WHERE m.nom = :nom")
    , @NamedQuery(name = "Mobilephones.findByPrix", query = "SELECT m FROM Mobilephones m WHERE m.prix = :prix")
    , @NamedQuery(name = "Mobilephones.findByLastUpdate", query = "SELECT m FROM Mobilephones m WHERE m.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Mobilephones.findByQuantity", query = "SELECT m FROM Mobilephones m WHERE m.quantity = :quantity")})
public class Mobilephones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private BigDecimal prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "quantity")
    private Short quantity;

    public Mobilephones() {
    }

    public Mobilephones(Integer id) {
        this.id = id;
    }

    public Mobilephones(Integer id, String reference, String nom, BigDecimal prix, Date lastUpdate) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobilephones)) {
            return false;
        }
        Mobilephones other = (Mobilephones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Mobilephones[ id=" + id + " ]";
    }
    
}
