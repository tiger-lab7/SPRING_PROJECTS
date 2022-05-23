import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

enum Color {
    RED, BLUE, BLACK, WHITE, YELLOW
}

public class HibernateTests {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Computer.class);
        configuration.addAnnotatedClass(Processor.class);
        configuration.addAnnotatedClass(ComputerOrder.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction4 = session.beginTransaction();
        for (ComputerOrder computerOrder : ComputerShop.sellComputers()) {
            //for(Computer computer : computerOrder.getSellComputers()) {
            //    session.saveOrUpdate(computer);
            //}
            session.saveOrUpdate(computerOrder);
        }
        transaction4.commit();


        Query<ComputerOrder> computerOrderQuery =
                session.createQuery("from ComputerOrder", ComputerOrder.class);
        computerOrderQuery.list().forEach(System.out::println);


        session.close();
        sessionFactory.close();
    }
}

@Entity(name = "computers_list")
@Data
@NoArgsConstructor
class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String vendor;
    @Column
    private long memory;
    @Column
    private Color color;
    @Embedded
    private Processor processor;

    public Computer(String vendor, long memory, Color color, Processor processor) {
        this.vendor = vendor;
        this.memory = memory;
        this.color = color;
        this.processor = processor;
    }
}

@Embeddable
@Data
@NoArgsConstructor
class Processor {

    @Column(name = "processor_vendor")
    private String vendor;
    @Column(name = "processor_frequency")
    private long frequency;
    @Column(name = "core_number")
    private int cores;

    public Processor(String vendor, long frequency, int cores) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.cores = cores;
    }
}

@Entity(name = "computer_orders")
@Data
@NoArgsConstructor
class ComputerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sell_date")
    private Date sellDate;

    @OneToMany
    @Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
    private List<Computer> sellComputers;

    public ComputerOrder(Date sellDate, List<Computer> sellComputers) {
        this.sellDate = sellDate;
        this.sellComputers = sellComputers;
    }
}



class ComputerFactory {
    private static final String[] VENDORS = {"ASUS", "ACER", "LENOVO", "HP", "DELL"};
    private static final Random random = new Random();

    public static Computer getComputer() {
        return new Computer(VENDORS[random.nextInt(VENDORS.length)],
                (long) Math.pow(2, random.nextInt(20, 24)),
                Color.values()[random.nextInt(Color.values().length)],
                ProcessorFactory.getProcessor()
        );
    }
}

class ProcessorFactory {
    private static final String[] VENDORS = {"INTEL", "PENTIUM", "CELERON", "AMD", "THREADREAPER"};
    private static final Random random = new Random();

    public static Processor getProcessor() {
        return new Processor(VENDORS[random.nextInt(VENDORS.length)],
                random.nextLong(1500, 4500),
                random.nextInt(1, 16) * 2
        );
    }
}

class ComputerShop {
    private static final Random random = new Random();

    public static List<ComputerOrder> sellComputers() {

        List<ComputerOrder> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Computer> sellComputers = new ArrayList<>();
            int bound = random.nextInt(1,5);
            for (int k = 0; k < bound; k++) {
                sellComputers.add(ComputerFactory.getComputer());
            }
            result.add(new ComputerOrder(new Date(), sellComputers));
        }
        return result;
    }
}