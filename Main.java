public class Main {
    
    public static boolean isLeapYear(int year) 
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
        public static int getMaxDayOfMonth(int year, int month) 
    {
        switch (month) 
        {
            case 2:
                if (isLeapYear(year)) 
                {
                    return 29;
                } 
                else 
                {
                    return 28;
                }
            case 4:
                return 30;
            case 6:
                return 30;
            case 9:
                return 30;
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    
    public static void printBonusDatesBetween(int fromYear, int toYear) 
    {
        boolean BonusYearFound = false;
        if (fromYear > toYear) 
        {
            System.out.printf("Error.\nInvalid input.");
            return;
        }

        for (int year = fromYear; year <= toYear; year++) 
        {
            for (int month = 1; month <= 12; month++) 
            {
                int maxDay = getMaxDayOfMonth(year, month);
                for (int day = 1; day <= maxDay; day++) 
                {
                    if (isPalindromeDate(year, month, day)) 
                    {
                        System.out.printf("%04d-%02d-%02d\n", year, month, day);
                        BonusYearFound = true;
                    }
                }
            }
        }
        if(BonusYearFound == false)
        {
            System.out.printf("No Bonus year found.\n");
        }
    }

    public static boolean isPalindromeDate(int year, int month, int day) 
    {
        String dateString = String.format("%04d%02d%02d", year, month, day);
        int left = 0;
        int right = dateString.length() - 1;

        while (left < right) 
        {
            if (dateString.charAt(left) != dateString.charAt(right)) 
            {
                return false;
            }
            left++;
            right--;
        }
    return true;
    }


    public static void main(String[] args) 
    {
        printBonusDatesBetween(2010, 2015);
    }
}
