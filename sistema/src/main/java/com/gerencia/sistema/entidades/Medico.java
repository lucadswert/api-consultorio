package com.gerencia.sistema.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	//Acho q tem q dividir o endereço em (logradouro, número, complemento, bairro, cidade, UF e CEP)
	// Apenas Número e Complemento não são obrigatórios
	private String endereco;
	private String CREA;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	private boolean ativo = true;

}
