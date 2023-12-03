package br.com.crisdev.clinicavet.domain.veterinario;

import br.com.crisdev.clinicavet.domain.endereco.Endereco;

public record DadosDetalhamentoVeterinario(
        Long id,
        String nome,
        String email,
        String crmv,
        String telefone,
        Especialidade especialidade,
        Endereco endereco
) {
    public DadosDetalhamentoVeterinario(Veterinario veterinario) {
        this(veterinario.getId(), veterinario.getNome(), veterinario.getEmail(), veterinario.getCrmv(), veterinario.getTelefone(),
                veterinario.getEspecialidade(), veterinario.getEndereco());
    }

}
