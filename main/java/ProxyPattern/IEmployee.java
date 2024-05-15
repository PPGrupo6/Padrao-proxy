package ProxyPattern;

import java.util.List;

public interface IEmployee {
    List<String> getPersonalData();

    List<Float> getSalary(Boss boss);
}
