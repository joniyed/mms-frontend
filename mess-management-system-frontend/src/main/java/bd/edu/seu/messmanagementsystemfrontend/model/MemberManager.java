package bd.edu.seu.messmanagementsystemfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberManager {
  private String username;
  private Name name;
  private Address address;
  private Phone phone;
  private String email;
  private LocalDate localDate;
}

