import com.dpavlenko.abstractfactory.CardType;
import com.dpavlenko.abstractfactory.CreditCard;
import com.dpavlenko.abstractfactory.CreditCardFactory;
import com.dpavlenko.builder.LunchOrder;
import com.dpavlenko.factory.Website;
import com.dpavlenko.factory.WebsiteFactory;
import com.dpavlenko.factory.WebsiteType;
import com.dpavlenko.prototype.Movie;
import com.dpavlenko.prototype.Registry;
import com.dpavlenko.singleton.DbSingleton;
import com.dpavlenko.singleton.TestSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //for Performance testing
        long timeBefore = 0;
        long timeAfter = 0;

        DbSingleton instance = DbSingleton.getInstance();

        timeBefore = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter - timeBefore);

        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
            System.out.println("Table created!");
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter - timeBefore);

        builderDemo();

        getCalendar();

        System.out.println("Factory pattern goes below:");
        factoryDemo();

        System.out.println("Abstract Factory pattern goes below:");
        abstractFactoryDemo();

        System.out.println("Prototype pattern goes below:");
        prototypeDemo();

        System.out.println("System available ADAPTER list example");
        adapterArrayList();

        sendMessage();
    }

    private static void sendMessage() {

    }

    private static void prototypeDemo() {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Creational Patterns in Java");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
    }

    private static void abstractFactoryDemo() {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);

        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);

        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());
    }

    private static void getCalendar() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }

    private static void builderDemo() {

        LunchOrder.Builder builder = new LunchOrder.Builder();

        builder.bread("Wheat").dressing("Mayo").meat("Turkey");

        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }

    private static void factoryDemo() {
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

        System.out.println(site.getPages());
    }

    private static void adapterArrayList() {
        Integer[] arraysOfInts = new Integer[] {42, 43, 44};
        //adapting integers to a List
        List<Integer> listOfInts = Arrays.asList(arraysOfInts);

        System.out.println(arraysOfInts);
        System.out.println(listOfInts);
    }
}
