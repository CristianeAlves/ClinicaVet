package br.com.crisdev.clinicavet.domain.veterinario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    Page<Veterinario> findAllByAtivoTrue(Pageable paginacao);
}
