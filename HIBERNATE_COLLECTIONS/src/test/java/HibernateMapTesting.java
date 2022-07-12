import Collections.Country;
import Operations.HibernateConnectionProvider;
import Other.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class HibernateMapTesting {
    @Test
    @SneakyThrows
    public void testHibernateMap() {
        List<Country> countryList = Util.readJsonData();

        Session session = HibernateConnectionProvider.INSTANCE.getHibernateSession();
        //SimpleOperations.dropAllTables(session);

        session.beginTransaction();
        countryList.forEach(session::saveOrUpdate);
        session.getTransaction().commit();

        List<Country> countryListFromDB = session.createQuery("from Country").list();
        Assert.assertEquals(countryList, countryListFromDB);
        //System.out.println(countryList == countryListFromDB);
        countryListFromDB.forEach(System.out::println);

        session.close();
        HibernateConnectionProvider.INSTANCE.closeSessionFactory();
    }
}

