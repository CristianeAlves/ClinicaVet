package br.com.crisdev.clinicavet.domain.veterinario;

public record DadosListagemVeterinarios(
        Long id,
        String nome,
        String email,
        String crmv,
        Especialidade especialidade
) {
    public DadosListagemVeterinarios(Veterinario veterinario) {
        this(veterinario.getId(), veterinario.getNome(), veterinario.getEmail(), veterinario.getCrmv(), veterinario.getEspecialidade());
    }
}
