package repositories;

import entities.Seance;
import org.springframework.data.repository.CrudRepository;

public interface SeanceRepo extends CrudRepository<Seance,Integer> {
}
