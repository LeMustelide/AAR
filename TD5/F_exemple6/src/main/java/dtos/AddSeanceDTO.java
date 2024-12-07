package dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class AddSeanceDTO {
    private int idGroupe;
    private int idSalle;
    private String idMatiere;
    private LocalDateTime debut;
    private LocalDateTime fin;
}
