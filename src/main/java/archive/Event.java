package archive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zguo on 3/13/17.
 * *
 */
public class Event {
    //Event ID,Event Type,Event Clearance Date,Hundred Block Location,District/Sector,Zone/Beat
    //1658027,DISTURBANCES,1/24/16 11:54,142XX BLOCK OF LINDEN AV N,N,N2
    String Event_ID;
    String Event_Type;
    String Event_Clearance_Date;
    String Hundred_Block_Location;
    String District_Sector;
    String Zone_Beat;

    public Event(String strInput) {
        String[] input = strInput.split(",");
        Event_ID = input[0];
        Event_Type = input[1];
        Event_Clearance_Date = input[2];
        Hundred_Block_Location = input[3];
        District_Sector = input[4];
        Zone_Beat = input[5];
    }


    public void f1() throws FileNotFoundException {
        File f = new File("Seattle_911_Incidents.csv");
        Scanner sc = new Scanner(f);
        List<Event> le15 = new ArrayList<Event>();
        List<Event> le16 = new ArrayList<Event>();
        List<Event> le17 = new ArrayList<Event>();
        sc.nextLine();

        while (sc.hasNextLine()) {
            Event e = new Event(sc.nextLine());
            if (e.Event_Clearance_Date.contains("/15 "))
                le15.add(e);
            else if (e.Event_Clearance_Date.contains("/16 "))
                le16.add(e);
            else
                le17.add(e);
        }
        System.out.println("yea 15 + " + le15.size());
        System.out.println("yea 16 + " + le16.size());
        System.out.println("yea 17 + " + le17.size());
        System.out.println("Sample form 15");
        System.out.println("==============================");
        System.out.println(le15.get(0).Event_ID);
        System.out.println(le15.get(0).Event_Type);
        System.out.println(le15.get(0).Event_Clearance_Date);
        System.out.println(le15.get(0).Hundred_Block_Location);
        System.out.println(le15.get(0).District_Sector);
        System.out.println(le15.get(0).Zone_Beat);

    }

}
