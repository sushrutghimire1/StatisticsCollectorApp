import objects.Employee;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UseCase {
    public static void main(String[] args) {

        statsByString();
        statsByEmployee();


    }

    private static void statsByEmployee() {
        StatisticsCollector<Employee, ? extends Statistic> collector = new EmployeeStatisticsCollector();

        ArrayList<Employee> objects = new ArrayList<>();

        Employee sushrut = new Employee();
        sushrut.setBirthDate(new Date(1998, Calendar.OCTOBER, 23));
        sushrut.setFirstName("Sushrut");
        sushrut.setBirthPlace("NEPAL");
        sushrut.setPosition("INTERN");
        sushrut.setHiringDate(new Date(2011, Calendar.MAY, 23));
        sushrut.setSalary(Double.parseDouble("350"));
        sushrut.setResignationDate(new Date(2012, Calendar.MAY, 23));
        objects.add(sushrut);

        Employee ram = new Employee();
        ram.setBirthDate(new Date(1998, Calendar.OCTOBER, 23));
        ram.setFirstName("RAM");
        ram.setBirthPlace("NEPAL");
        ram.setPosition("SENIOR DEVELOPER");
        ram.setHiringDate(new Date(2015, Calendar.MAY, 23));
        ram.setSalary(Double.parseDouble("350"));
        ram.setResignationDate(new Date(2019, Calendar.MAY, 23));
        objects.add(ram);

        Iterable<? extends Statistic> statistics = collector.collectStatistics(objects);

        System.out.printf("%-10s|%-30s%n", "Key", "Value");

        for (Statistic statistic : statistics) {

            System.out.printf("%-10s|%-30s%n", statistic.getKey(), statistic.getValue());

        }
    }

    private static void statsByString() {
        StatisticsCollector<String, ? extends Statistic> collector = new StringStatisticsCollector();

        ArrayList<String> objects = new ArrayList<>();

        objects.add("abcD");

        objects.add("123 one two three");

        Iterable<? extends Statistic> statistics = collector.collectStatistics(objects);

        System.out.printf("%-10s|%-30s%n", "Key", "Value");

        for (Statistic statistic : statistics) {

            System.out.printf("%-10s|%-30s%n", statistic.getKey(), statistic.getValue());

        }
    }
}
