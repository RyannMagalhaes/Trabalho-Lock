package com.iftm.exemplelockotimista.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Conta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String conta;
    private String agencia;
    private Double saldo;
    @Version
    private int version;


    public boolean sacar( Double valor) {
        if (valor > this.saldo) {
            return false;

        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public boolean depositar( Double valor ) {
        if (valor <= 0) {
            return false;
        } else {
            this.saldo += valor;
            return true;
        }
    }

}
