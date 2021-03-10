import objects.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeStatisticsCollector implements StatisticsCollector<Employee, EmployeeStatistic> {

    @Override
    public String getName() {
        return "EMPLOYEE STATISTICS";
    }

    @Override
    public Iterable<EmployeeStatistic> collectStatistics(Iterable<Employee> objects) {
        HashMap<String, Integer> statistics = new HashMap<>();
        objects.forEach((employee -> {
            if (statistics.containsKey("BIRTH PLACE " + employee.getBirthPlace()))
                statistics.put("BIRTH PLACE " + employee.getBirthPlace(), statistics.get("BIRTH PLACE " + employee.getBirthPlace()) + 1);
            else
                statistics.put("BIRTH PLACE " + employee.getBirthPlace(), 1);

            if (statistics.containsKey("BIRTH YEAR " + employee.getBirthDate().getYear()))
                statistics.put("BIRTH YEAR " + employee.getBirthDate().getYear(), statistics.get("BIRTH YEAR " + employee.getBirthDate().getYear()) + 1);
            else
                statistics.put("BIRTH YEAR " + employee.getBirthDate().getYear(), 1);

            if (statistics.containsKey("RESIGNATION YEAR " + employee.getResignationDate().getYear()))
                statistics.put("RESIGNATION YEAR " + employee.getResignationDate().getYear(), statistics.get("RESIGNATION YEAR " + employee.getResignationDate().getYear()) + 1);
            else
                statistics.put("RESIGNATION YEAR " + employee.getResignationDate().getYear(), 1);

            if (statistics.containsKey("POSITION " + employee.getPosition()))
                statistics.put("POSITION " + employee.getPosition(), statistics.get("POSITION " + employee.getResignationDate().getYear()) + 1);
            else
                statistics.put("POSITION " + employee.getPosition(), 1);

            if (employee.getSalary() < 350) {
                if (statistics.containsKey("SALARY<350"))
                    statistics.put("SALARY<350", statistics.get("SALARY<350" + 1));
                else
                    statistics.put("SALARY<350", 1);
            } else if (employee.getSalary() < 600) {
                if (statistics.containsKey("SALARY 350-600"))
                    statistics.put("SALARY 350-600", statistics.get("SALARY 350-600" + 1));
                else
                    statistics.put("SALARY 350-600", 1);
            } else if (employee.getSalary() < 1200) {
                if (statistics.containsKey("SALARY 600-1200"))
                    statistics.put("SALARY 600-1200", statistics.get("SALARY 600-1200" + 1));
                else
                    statistics.put("SALARY 600-1200", 1);
            } else {
                if (statistics.containsKey("SALARY >1200"))
                    statistics.put("SALARY >1200", statistics.get("SALARY >1200" + 1));
                else
                    statistics.put("SALARY >1200", 1);
            }
        }));

        ArrayList<EmployeeStatistic> statisticArrayList = new ArrayList<>();
        EmployeeStatistic employeeStatistic;

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            employeeStatistic = new EmployeeStatistic();
            employeeStatistic.setKey(entry.getKey());
            employeeStatistic.setValue(entry.getValue());
            statisticArrayList.add(employeeStatistic);
        }
        return statisticArrayList;
    }
}
