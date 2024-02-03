package br.com.nssouto.gestao_vagas.modules.candidates;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Daniel de Souza")
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo username não deve ter espaços")
    @Schema(example = "Daniel")
    private String username;

    @Email(message = "O campo e-mail deve conter informações validas")
    @Schema(example = "daniel@gmail.com")
    private String email;

    @Length(min = 6, max = 200, message = "A senha deve conter entre 6 e 30 caracteres")
    @Schema(example = "admin@1234", minLength = 10, maxLength = 200, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
    private String password;

    @Schema(example = "Desenvolvedor Java")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
