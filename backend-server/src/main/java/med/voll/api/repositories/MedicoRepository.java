package med.voll.api.repositories;

import med.voll.api.entidades.Especialidade;
import med.voll.api.entidades.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
        SELECT m
        FROM medicos m
        LEFT JOIN consultas c ON m.id = c.medico.id AND c.data = :data AND c.motivoCancelamento IS NULL
        WHERE m.ativo = 1
        AND m.especialidade = :especialidade
        AND c.medico.id IS NULL
        ORDER BY FUNCTION('RAND')
    """)
    List<Medico> escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo
            from medicos m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}