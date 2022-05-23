import Model.Cat;
import Model.CatCity;
import Model.CatHome;

import java.util.List;

public class Main {
    private static final DAOPostgres daoPostgres = new DAOPostgres();

    public static void main(String... args) {

        Cat cat = new Cat(4, "Vasilek");
        daoPostgres.saveCat(cat);


        List<Cat> catList = daoPostgres.getCatList();
        catList.forEach(c -> System.out.println(c.getId() + " " + c.getName()));

        CatHome catHome = new CatHome(99L, cat);
        daoPostgres.saveCatHome(catHome);

        List<CatHome> catHomes = daoPostgres.getCatHomes();
        catHomes.forEach(cH -> System.out.printf("Home no. %d Cat name %s\n", cH.getApartamentNo(),
                cH.getCat().getName()));

        CatCity catCity = new CatCity("TigerCity", catHomes);
        daoPostgres.saveCatCity(catCity);

        daoPostgres.close();
        System.gc();
    }
}
