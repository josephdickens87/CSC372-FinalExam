import java.util.*;


public class Main
{
    //Main method
    public static void main(String[] args)
    {

        TreeMap<String, List<String>> students = new TreeMap<>();
        //TreeMap declaration
        //TreeMap<String, String> students = new TreeMap<>();

        //Displays menu and operates on TreeMap
        Operate(students);
    }

    //Method that prints menu to user and calls the appropriate function based on user option
    public static void Operate(TreeMap<String, List<String>> students)
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
    public static void addStudent(TreeMap<String, List<String>> students)
    {
        String name;
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nEnter student's name:"+"\nEnter 0 when done.\n");
            name = keyboard.next();

            if (name.equals("0"))
            {
                System.out.println("\nGrades Entered Successfully");
                break;
            }
            else if (!students.containsKey(name))
            {
                System.out.println("\nEnter Grade");
                String gradeInput = keyboard.next();
                List<String> gradeList = new ArrayList<>();
                gradeList.add(gradeInput);
                students.put(name, gradeList);
            }
            else if (students.containsKey(name))
            {
                System.out.println("\nEnter Grade:");
                String gradeInput = keyboard.next();
                students.get(name).add(gradeInput);
            }
        }
    }

    //Method that removes student from TreeMap
    public static void removeStudent(TreeMap<String, List<String>> students)
    {
        String name;
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nEnter name of student to be removed:"+"\nEnter 0 when done.\n");

            name = keyboard.next();
            if (name.equals("0"))
            {
                System.out.println("\nStudents removed Successfully");
                break;
            }
            else if (students.containsKey(name))
            {
                System.out.println("\nType score of grade to be removed:"+"\n"+students.get(name));
                String removeInput = keyboard.next();
                students.get(name).remove(removeInput);
                System.out.println("\nGrade Removed Successfully");
            }
            else
            {
                System.out.println("\n Student named " + name + " does not exist.");
            }
        }
    }

    //Method that modifies student of TreeMap
    public static void modifyStudent(TreeMap<String, List<String>> students)
    {
        String name;
        Scanner keyboard = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nEnter name of student to modify:"+"\nEnter 0 when done.\n");

            name = keyboard.next();
            if (name.equals("0"))
            {
                System.out.println("\nStudents modified Successfully");
                break;
            }
            else if (students.containsKey(name))
            {
                System.out.println("\nType grade score to be modified:"+"\n"+students.get(name));
                String modifyInput = keyboard.next();
                students.get(name).remove(modifyInput);
                System.out.println("\nEnter new grade:");
                String newGrade = keyboard.next();
                students.get(name).add(newGrade);
            }
            else
            {
                System.out.println("\nStudent named " + name + " does not exist.");
            }
        }
    }

    //Method that prints the TreeMap
    public static void printStudent(TreeMap<String, List<String>> students)
    {
        //Reading set of entries
        Set set = students.entrySet();

        //Initializing an iterator
        //Iterator it = set.iterator();

        Iterator it = students.keySet().iterator();
        while (it.hasNext())
        {
            String key = it.next().toString();
            String value = students.get(key).toString();
            System.out.println(key + ":" + value);
        }

        //Displaying elements


      /*  for(List value : students.values())
        {
            value.forEach(System.out::println);
        }*/


        /*while (it.hasNext())
        {
            //Read each node
            Map.Entry node = (Map.Entry) it.next();

            //Print each key and value
            System.out.print(" " + node.getKey() + " : ");
            System.out.println(node.getValue());
        }
        System.out.println();*/

        for(Map.Entry<String,List<String>> entry: students.entrySet())
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //students.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        }

    }