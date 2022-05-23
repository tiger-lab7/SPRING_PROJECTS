import Model.Cat;
import Model.CatCity;
import Model.CatHome;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class DAOPostgres {
    private static SessionFactory sessionFactory;

    @SneakyThrows
    public DAOPostgres() {
        Configuration configuration = new Configuration(); // resources/hibernate.properties read here

        configuration.addAnnotatedClass(Model.Cat.class);
        configuration.addAnnotatedClass(Model.CatHome.class);
        configuration.addAnnotatedClass(Model.CatCity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    private void saveEntity(Object entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Optional<List<?>> getEntityList(String hqlQuery, Class<?> entityClass) {
        Optional<List<?>> resultList = Optional.empty();
        try (Session session = sessionFactory.openSession()) {
            Query<?> query = session.createQuery(hqlQuery, entityClass);
            resultList = Optional.of(query.list());
        } catch (Exception ex) { ex.printStackTrace(); }
        return resultList;
    }

    public void saveCat(Cat cat) {
        saveEntity(cat);
    }

    public List<Cat> getCatList() {
        return (List<Cat>) getEntityList("from Model.Cat", Cat.class)
                .orElseThrow(() -> new RuntimeException("No result"));
    }

    public void saveCatHome(CatHome catHome) {
        saveEntity(catHome);
    }

    public List<CatHome> getCatHomes() {
        return (List<CatHome>) getEntityList("from Model.CatHome", CatHome.class)
                .orElseThrow(() -> new RuntimeException("No result"));
    }

    public void saveCatCity(CatCity catCity) {
        saveEntity(catCity);
    }

    public void close() {
        sessionFactory.close();
    }
}
