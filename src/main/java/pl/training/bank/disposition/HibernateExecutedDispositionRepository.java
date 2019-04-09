package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

@RequiredArgsConstructor
public class HibernateExecutedDispositionRepository implements ExecutedDispositionRepository {

    @NonNull
    private SessionFactory sessionFactory;

    @Override
    public void save(ExecutedDisposition executedDisposition) {
        sessionFactory.getCurrentSession().save(executedDisposition);
    }

}
