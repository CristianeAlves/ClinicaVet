package br.com.crisdev.clinicavet.domain.veterinario;

import br.com.crisdev.clinicavet.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVeterinario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
