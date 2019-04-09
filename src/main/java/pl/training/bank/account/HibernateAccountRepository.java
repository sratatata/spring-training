package pl.training.bank.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.training.bank.common.ResultPage;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateAccountRepository implements AccountRepository {

    @NonNull
    private SessionFactory sessionFactory;

    @Override
    public Account save(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(account);
        account.setId(id);
        return account;
    }

    @Override
    public ResultPage<Account> get(int pageNumber, int pageSize) {
        List<Account> accounts = sessionFactory.getCurrentSession()
                .createNamedQuery(Account.SELECT_ACCOUNTS, Account.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return new ResultPage<>(accounts, pageNumber, -1);
    }

    @Override
    public Optional<Account> getByNumber(String accountNumber) {
        return sessionFactory.getCurrentSession()
                .createNamedQuery(Account.SELECT_ACCOUNT_BY_NUMBER, Account.class)
                .setParameter("number", accountNumber)
                .uniqueResultOptional();
    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.getCurrentSession();
        if (session.load(Account.class, account.getId()) == null) {
            throw new AccountNotFoundException();
        }
        session.update(account);
    }

}
