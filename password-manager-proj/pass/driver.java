package pass;
import java.util.*;

public class driver {
    private static HashMap<String, String[]> data= new HashMap<String, String[]>();
    public static void main(String[] args) {
        
        StdIn.setFile("database.out");                                  //database.out file used to store encrypted entries. 
        while(!StdIn.isEmpty())                                                  //reads database.out file and adds entries to 'data' Hashmap. 
        {
            String name = StdIn.readString().toUpperCase();
            String[] creds  = {StdIn.readString(), StdIn.readString()};

            data.put(name,creds);
        }
                                                                                 //Scanner and System.out are used to interact with the user 
                                                                                 //while the StdIn and StdOut libraries are used to read from and write to database.out

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose function:");
        System.out.println("1. Add entry");
        System.out.println("2. Remove entry");
        System.out.println("3. Display all");
        System.out.println("4. Search");
        System.out.println("5. Quit");
        int in = sc.nextInt();
        while(in>0&&in<5)
        {
            switch(in)
            {
                case 1:
                addEntry();
                break;
                
                case 2:
                removeEntry();
                break;

                case 3:
                displayAll();
                break;

                case 4:
                break;
            }
            System.out.println("Choose function:");
            System.out.println("1. Add entry");
            System.out.println("2. Remove entry");
            System.out.println("3. Display all");
            System.out.println("4. Search");
            System.out.println("5. Quit");
            in = sc.nextInt();
        }
        StdOut.setFile("database.out");
        for(String b:data.keySet())
        {
            StdOut.println(b+" "+data.get(b)[0]+" "+data.get(b)[1]);
        }
    }

    public static void addEntry()
    {
        System.out.println("Entries with the same name will be replaced by new additions. Please number new entries to avoid this.");
        crypt pass = new crypt();
        Scanner sc = new Scanner(System.in);
        System.out.print("Website name: ");
        String accName = sc.next();
        System.out.println();
        System.out.print("Username: ");
        String username = sc.next();
        System.out.println();
        System.out.print("Password(no spaces): ");
        String password = sc.next();
        String encrypted = pass.keyGen(password);                               //encrypts given password.

        String[] creds = {username, encrypted};
        data.put(accName.toUpperCase(), creds);                                 //adds entry to 'data' hashmap
    }

    public static void removeEntry()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the website name for the account you'd like to delete - ");
        String delete = sc.next();

        if(data.containsKey(delete.toUpperCase()))
            data.remove(delete.toUpperCase());
      
        else   
            System.out.println("Entry does not exist.");
    }

    public static void displayAll()
    {
        crypt pass = new crypt();
        for(String a:data.keySet())                                               //iterates over and prints contents of 'data' Hashmap.
        {
            System.out.println("--------------------------");
            System.out.println("Account: "+a);
            System.out.println("Username: "+data.get(a)[0]);
            System.out.println("Password: "+pass.decrypt(data.get(a)[1]));
        }
        System.out.println("--------------------------");
    }

    public static void search()
    {
        crypt pass = new crypt();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter website name for the account you'd like to find - ");
        String target = sc.next();

        if(data.containsKey(target.toUpperCase()))
        {
            System.out.println(target+"- Username: "+data.get(target)[0]+" Password: "+data.get(target)[1]);
        }

        else
            System.out.println("Entry does not exist.");
    }
}
