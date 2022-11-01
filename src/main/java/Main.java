import jakarta.persistence.EntityManager;
import menu.Home;
import util.Hibernate;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();
        Home home = new Home();
        home.showMenu();
    }

}
