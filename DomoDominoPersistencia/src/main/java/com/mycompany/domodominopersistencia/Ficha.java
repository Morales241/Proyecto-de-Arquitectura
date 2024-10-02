package com.mycompany.domodominopersistencia;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ficha")
public class Ficha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "lado1", nullable = false)
    private Integer lado1;
    
    @Column(name = "lado2", nullable = false)
    private Integer lado2;

    public Ficha() {
    }

    public Ficha(Integer lado1, Integer lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    
    public Ficha(Long id, Integer lado1, Integer lado2) {
        this.id = id;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLado1() {
        return lado1;
    }

    public void setLado1(Integer lado1) {
        this.lado1 = lado1;
    }

    public Integer getLado2() {
        return lado2;
    }

    public void setLado2(Integer lado2) {
        this.lado2 = lado2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.lado1);
        hash = 13 * hash + Objects.hashCode(this.lado2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.lado1, other.lado1)) {
            return false;
        }
        return Objects.equals(this.lado2, other.lado2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ficha{");
        sb.append("id=").append(id);
        sb.append(", lado1=").append(lado1);
        sb.append(", lado2=").append(lado2);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
