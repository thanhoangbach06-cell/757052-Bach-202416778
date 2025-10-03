import java.util.Scanner;
public class Ex64 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int year = -1;
            int month = -1;
            while (true) {
                System.out.println("Enter Year: ");
                String yearInput = sc.nextLine();
                if (yearInput.matches("\\d+")) {
                    year = Integer.parseInt(yearInput);
                    if (year >= 1000) {
                        break;
                    } else { 
                        System.out.println("The value of year must be greater than or equal to 1000, please enter again: ");
                    }
                }
                else {
                    System.out.println("Invalid value of year, please enter again: ");
                    } 
                }
            while (true) {
                System.out.println("Enter Month:");
                String monthInput = sc.nextLine();
                month = parseMonth(monthInput);
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.println("Invalid value of month, please enter again: ");
                }
            }
            int days = getDaysInMonth(month,year);
            System.out.println(days);
            sc.close();
        }

        private static int parseMonth(String input) {
            input = input.toLowerCase();
            switch(input) {
                case "1": case "january": case "jan.": case "jan": return 1;
                case "2": case "february": case "feb.": case "feb": return 2;
                case "3": case "march": case "mar.": case "mar": return 3;
                case "4": case "april": case "apr.": case "apr": return 4;
                case "5": case "may": return 5;
                case "6": case "june": case "jun": return 6;
                case "7": case "july": case "jul": return 7;
                case "8": case "august": case "aug.": case "aug": return 8;
                case "9": case "september": case "sept.": case "sep": return 9;
                case "10": case "october": case "oct.": case "oct": return 10;
                case "11": case "november": case "nov.": case "nov": return 11;
                case "12": case "december": case "dec.": case "dec": return 12;
                default: return -1;
            }
        }
        private static int getDaysInMonth(int month, int year) {
            switch(month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
                case 4: case 6: case 9: case 11: return 30;
                case 2: if (isLeapYear(year)) return 29;
                else return 28;
                default: return -1;
            }
        }
        private static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }
