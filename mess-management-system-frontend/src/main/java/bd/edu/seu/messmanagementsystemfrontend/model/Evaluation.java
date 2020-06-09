package bd.edu.seu.messmanagementsystemfrontend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    private long evaluationNo;
    private double ablity;
    private double foodQuality;
    private double relationWithMember;
    private String username;
    private String managerUserName;
    private LocalDate date;
}

