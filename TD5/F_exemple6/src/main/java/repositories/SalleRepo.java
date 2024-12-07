package repositories;

import entities.Salle;
import org.springframework.data.repository.CrudRepository;

public interface SalleRepo extends CrudRepository<Salle,Integer> {
}
