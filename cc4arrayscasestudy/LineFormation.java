package schoolprograms.cc4arrayscasestudy;

import java.util.Scanner;

// Marc Rodnie G. Manalo
// BSCS - 2D

public class LineFormation {
    public static void main(String[] args) {
        String[] line = new String[8];
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while(!exit) {

            int current = 0;
            // Moving elements if there are nulls in the middle of the array
            if (count(line) != 0) {
                for (int position = 0; position < line.length; position++) {
                    if (line[position] == null) {
                        current = position;
                        break;
                    }
                }
                // Elements will not move if:
                // current null position is the last position
                // if there are no nulls in the middle of the array
                while (line[current] == null && current != line.length - 1 && count(line) > current) {
                    moveElements(line, "LEFT", current);
                }
            }

            // Show Current line
            System.out.println("\nCurrent line:");
            for (int element = 0; element < line.length; element++) {
                System.out.println("Line position " + element + " = " + line[element]);
            }

            // Show Options
            System.out.print("\nLine Formation options:\n1 Count\n2 Retrieve\n3 Assign\n4 Remove\n5 Insert\n6 Exit" +
                    "\nOption: ");
            int option = Integer.parseInt(scanner.nextLine());

            System.out.println();

            // Options
            switch(option) {
                // Count Option
                case 1 -> System.out.println("Counting the people on the line: " + count(line));

                // Retrieve Option
                case 2 -> {
                    System.out.print("Insert the name of the person you want to know the position of: ");
                    String name = scanner.nextLine();
                    int position = retrieve(line, name);
                    if (position == -1) {
                        System.out.println(name + " is not on the line.");
                        break;
                    }
                    System.out.println(name + " is found at the line position " + position);
                }

                // Assign Option
                case 3 -> {
                    System.out.println("What is the name of the person that will be assigned on the line: ");
                    String name = scanner.nextLine();
                    int position = -1;
                    while(position < 0 || position > line.length - 1) {
                        System.out.print("Input its position: ");
                        position = Integer.parseInt(scanner.nextLine());
                    }
                    assign(line, name, position);
                }

                // Remove Option
                case 4 -> {
                    System.out.print("Insert the position you would like to remove: ");
                    int position = Integer.parseInt(scanner.nextLine());
                    if (line[position] == null) {
                        System.out.println("Position " + position + " is already empty");
                        break;
                    }
                    remove(line, position);
                }

                // Insert Option
                case 5 -> {
                    if (count(line) == line.length) {
                        System.out.println("Line is full, cannot insert anymore!");
                        break;
                    }
                    System.out.println("Insert the name of the person you will be adding: ");
                    String name = scanner.nextLine();
                    int position = -1;
                    while(position < 0 || position > line.length - 1) {
                        System.out.print("Input its position: ");
                        position = Integer.parseInt(scanner.nextLine());
                    }
                    insert(line, name, position);
                }

                // Exit
                case 6 -> exit = true;

                default -> System.out.println("Not an option!");
            }
        }
    }

    // traverse each element to count
    static int count(String[] queue) {
        int total = 0;
        for (String position : queue) {
            if (position != null) {
                total++;
            }
        }
        return total;
    }

    // Get a value requested from the user
    static int retrieve(String[] queue, String name) {
        int position;
        for (position = 0; position < queue.length; position++) {
            System.out.println("Line position " + position + " = " + queue[position]);
            if (queue[position] != null && queue[position].equalsIgnoreCase(name)) return position;
        }
        return -1;
    }

    // Replace an element with a new one
    static void assign(String[] line, String newName, int position) {
        if (line[position] == null) {
            System.out.println("Assigning " + newName + " to line position " + position);
        } else {
            System.out.println("Replacing " + line[position] + " with " + newName);
        }
        line[position] = newName;
    }

    // Remove an element
    static void remove(String[] line, int deletePosition) {
        System.out.println("Removing " + line[deletePosition] + " from the line");
        line[deletePosition] = null;
    }

    // Insert a value without replacing an element
    static void insert(String[] line, String addName, int newPosition) {
        // Move elements
        if (newPosition != line.length - 1 && line[newPosition] != null) {
            moveElements(line, "RIGHT", newPosition);
        }
        System.out.println("Adding " + addName + " on position " + newPosition);
        line[newPosition] = addName;
    }

    // Moving elements
    static void moveElements(String[] line, String direction, int desiredPosition) {
        if (direction.equals("LEFT")) {
            for (int index = desiredPosition; index < line.length - 1; index++) {
                line[index] = line[index+1];
                line[index+1] = null;
            }
        } else {
            for (int index = line.length - 1; index > desiredPosition; index--) {
                line[index] = line[index - 1];
                line[index - 1] = null;
            }
        }
    }

}
