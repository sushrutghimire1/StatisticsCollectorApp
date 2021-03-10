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
            if (statistics.containsKey("BIRTH_PLACE_" + employee.getBirthPlace()))
                statistics.put("BIRTH_PLACE_" + employee.getBirthPlace(), statistics.get("BIRTH_PLACE_" + employee.getBirthPlace()) + 1);
            else
                statistics.put("BIRTH_PLACE_" + employee.getBirthPlace(), 1);

            if (statistics.containsKey("BIRTH_YEAR_" + employee.getBirthDate().getYear()))
                statistics.put("BIRTH_YEAR_" + employee.getBirthDate().getYear(), statistics.get("BIRTH_YEAR_" + employee.getBirthDate().getYear()) + 1);
            else
                statistics.put("BIRTH_YEAR_" + employee.getBirthDate().getYear(), 1);

            if (statistics.containsKey("RESIGNATION_YEAR_" + employee.getResignationDate().getYear()))
                statistics.put("RESIGNATION_YEAR_" + employee.getResignationDate().getYear(), statistics.get("RESIGNATION_YEAR_" + employee.getResignationDate().getYear()) + 1);
            else
                statistics.put("RESIGNATION_YEAR_" + employee.getResignationDate().getYear(), 1);

            if (statistics.containsKey("POSITION_" + employee.getPosition()))
                statistics.put("POSITION_" + employee.getPosition(), statistics.get("POSITION_" + employee.getResignationDate().getYear()) + 1);
            else
                statistics.put("POSITION_" + employee.getPosition(), 1);

            if (employee.getSalary() < 350) {
                if (statistics.containsKey("SALARY<350"))
                    statistics.put("SALARY<350", statistics.get("SALARY<350") + 1);
                else
                    statistics.put("SALARY<350", 1);
            } else if (employee.getSalary() < 600) {
                if (statistics.containsKey("SALARY 350-600"))
                    statistics.put("SALARY 350-600", statistics.get("SALARY 350-600") + 1);
                else
                    statistics.put("SALARY 350-600", 1);
            } else if (employee.getSalary() < 1200) {
                if (statistics.containsKey("SALARY 600-1200"))
                    statistics.put("SALARY 600-1200", statistics.get("SALARY 600-1200") + 1);
                else
                    statistics.put("SALARY 600-1200", 1);
            } else {
                if (statistics.containsKey("SALARY >1200"))
                    statistics.put("SALARY >1200", statistics.get("SALARY >1200") + 1);
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
