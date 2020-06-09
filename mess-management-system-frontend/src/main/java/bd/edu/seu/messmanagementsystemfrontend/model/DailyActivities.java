package bd.edu.seu.messmanagementsystemfrontend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyActivities{
    private long serialNo;
    private String username;
    private LocalDate date;
    private Double totalCost;
    private List<Bazar> bazar;

    @Override
    public String toString() {
        AtomicReference<String> bazarAsName= new AtomicReference<>("");
        bazar.forEach(b -> {
            bazarAsName.set(bazarAsName.get()+"\n"+(b.getName()+"-unit: "+b.getUnit()+"-unitPrice:"+b.getCostPerUnit()));
        });
        return "DailyActivities{" +
                "serialNo=" + serialNo +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", totalCost=" + totalCost +
                ", bazar=" + bazarAsName.get() +
                '}';
    }
}

