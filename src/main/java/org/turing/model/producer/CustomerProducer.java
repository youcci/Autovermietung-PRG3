package org.turing.model.producer;

import org.turing.model.Customer;
import org.turing.service.CustomerService;
import org.turing.util.EntityManagerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Produces some test data for the {@link Customer} model.
 *
 * @author Youcef Wippert
 */
public class CustomerProducer {
    private static CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        produce();
        EntityManagerUtil.closeEntityManagerFactory();
    }

    private static void produce() {
        List<Customer> list = new ArrayList<>();

        list.add(new Customer("Saarbrücken", "01.01.1975", "L52C006JE97", "a.anwar@htwsaar.de", "Ahmad", "141",
                "40323722104D58020924109082", "Anwar", "+49271823428", "Eisenbahnstraße", 66121));
        list.add(new Customer("Saarbrücken", "24.02.1945", "E12G064UE45", "greendude@gmx.de", "Green", "42",
                "5082135064D730803739021052", "Dude", "+4918686302002", "Bahnhofstraße", 66111));
        list.add(new Customer("Saarbrücken", "23.11.1940", "J34R344PO63", "blo@gmail.com", "Brice", "20",
                "3965673348D721226240040178", "Low", "+491590767803", "Fenner Straße", 66115));
        list.add(new Customer("Dortmund", "03.08.2000", "L43Q643MM47", "kolle@empire.de", "Felix", "73",
                "7329048896D880623138011838", "Blume", "+491726894235", "Wieselweg", 44142));
        list.add(new Customer("Düsseldorf", "31.06.1995", "K47U371PP73", "banger@bangermusic.de", "Farid", "1",
                "6237763868D680121040102494", "Bang", "+491601283606", "Bangerstraße", 10115));
        list.add(new Customer("Stuttgart", "26.06.1977", "I15Y458AJ18", "jason@transporter.de", "Jason", "4",
                "6171758595D660330040061254", "Statham", "+491780969260", "Kaiserstraße", 66113));
        list.add(new Customer("München", "02.05.1982", "V72H674GX63", "djohnson@rock.de", "Dwayne The Rock", "13",
                "7146115786D741202839122652", "Johnson", "+491790764271", "Dorfstraße", 92345));
        list.add(new Customer("Kiel", "04.06.1975", "G46K471FR49", "amerkel@gmx.com", "Angela", "27",
                "1693557288D751014239033080", "Merkel", "+491525360169", "Parkstraße", 24105));
        list.add(new Customer("Berlin", "15.04.1990", "L73S162SA15", "oscholz@web.de", "Olaf", "51",
                "8471690711D900624539112024", "Scholz", "+491637275929", "Ilburger Ufer", 10587));

        for (Customer customer : list) {
            customerService.persist(customer);
        }
    }
}
