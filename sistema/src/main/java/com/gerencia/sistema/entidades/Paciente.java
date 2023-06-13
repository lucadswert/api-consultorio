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

@Entity(name = "pacientes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CPF;
	private String email;
	private String telefone;
	//Acho q tem q dividir o endereço em (logradouro, número, complemento, bairro, cidade, UF e CEP)
	// Apenas Número e Complemento não são obrigatórios
	private String endereco;

	private boolean ativo = true;
}
