package pl.training.bank.disposition;

import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaExecutedDispositionRepository implements ExecutedDispositionRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ExecutedDisposition executedDisposition) {
        entityManager.persist(executedDisposition);
    }

}
