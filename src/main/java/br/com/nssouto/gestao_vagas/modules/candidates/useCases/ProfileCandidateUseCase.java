package br.com.nssouto.gestao_vagas.modules.candidates.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.nssouto.gestao_vagas.modules.candidates.CandidateRepository;
import br.com.nssouto.gestao_vagas.modules.candidates.controllers.dto.ProfileCandidateResponseDTO;
import br.com.nssouto.gestao_vagas.modules.candidates.controllers.dto.ProfileCandidateResponseDTO.ProfileCandidateResponseDTOBuilder;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTOBuilder execute(UUID idCandidate) {

        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder().description(candidate.getDescription())
                .username(candidate.getUsername()).email(candidate.getEmail()).name(candidate.getName())
                .id(candidate.getId());

        return candidateDTO;

    }
}