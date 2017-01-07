import java.util.*;


public class Main
{
    //Main method
    public static void main(String[] args)
    {

        TreeMap<String,List<String>> students = new TreeMap<>();
        //TreeMap declaration
        //TreeMap<String, String> students = new TreeMap<>();

        //Displays menu and operates on TreeMap
        Operate(students);
    }

    //Method that prints menu to user and calls the appropriate function based on user option
    public static void Operate(TreeMap<String,List<String>> students)
    {
        int option;
        Scanner keyboard = new Scanner(System.in);

        //Loop till user wants to quit
        do
        {
            //Printing menu
            System.out.println("\n What Would You Like To Do? \n");
            System.out.println(" 1 - Add Student \n 2 - Remove Student \n 3 - Modify Student \n 4 - Print Students \n 5 - Exit \n");
            System.out.print("\n Enter Your Choice: ");
            option = Integer.parseInt(keyboard.nextLine());

            //Calling appropriate function
            switch (option)
            {
                case 1:
                    addStudent(students);
                    break;
                case 2:
                    removeStudent(students);
                    break;
                case 3:
                    modifyStudent(students);
                    break;
                case 4:
                    printStudent(students);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\n Invalid Choice.... \n");
                    break;
            }

        }
        while (option != 5);
    }

    //Method that adds student to TreeMap
    public static void addStudent(TreeMap<String,List<String>> students)
    {
        String name;
        //List grade;
        List<String> grade = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter name:");

            name = keyboard.next();
            if (name.equals("0"))
            {
                System.out.println("Grades Entered Successfully");
                break;
            }
            System.out.println("Enter grade:");
            String gradeInput = keyboard.next();
            grade.add(gradeInput);
            students.put(name, grade);
        }
    }

    //Method that removes student from TreeMap
    public static void removeStudent(TreeMap<String,List<String>> students)
    {
        String name;
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter name:");

            name = keyboard.next();
            if (name.equals("0"))
            {
                System.out.println("Students removed Successfully");
                break;
            }
            else if (students.containsKey(name))
            {
                students.remove(name);
            }
            else
            {
                System.out.println("\n Student named " + name + " does not exist.");
            }
        }
    }

    //Method that modifies student of TreeMap
    public static void modifyStudent(TreeMap<String,List<String>> students)
    {
        String name;
        List<String> grade = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter name:");

            name = keyboard.next();
            if (name.equals("0"))
            {
                System.out.println("Students modified Successfully");
                break;
            }
            else if (students.containsKey(name))
            {
                System.out.println("Enter grade:");
                String gradeInput = keyboard.next();
                grade.add(gradeInput);
            }
            else
            {
                System.out.println("\n Student named " + name + " does not exist.");
            }
        }
    }

    //Method that prints the TreeMap
    public static void printStudent(TreeMap<String,List<String>> students)
    {
        //Reading set of entries
        Set set = students.entrySet();

        //Initializing an iterator
        Iterator it = set.iterator();

        System.out.println();

        //Displaying elements
        while (it.hasNext())
        {
            //Read each node
            Map.Entry node = (Map.Entry) it.next();

            //Print each key and value
            System.out.print(" " + node.getKey() + " : ");
            System.out.println(node.getValue());
        }
        System.out.println();
    }
}


