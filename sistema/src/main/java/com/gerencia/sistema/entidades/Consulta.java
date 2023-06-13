package com.gerencia.sistema.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "consultas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "medico_id")
	private Medico medico;
	@ManyToOne
    @JoinColumn(name = "paciente_id")
	private Paciente paciente;
	private String dataHora;

}
