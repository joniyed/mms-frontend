package bd.edu.seu.messmanagementsystemfrontend.model;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;@Data@AllArgsConstructor@NoArgsConstructorpublic class Name {    private String firstName;    private String lastName;    @Override    public String toString() {        return firstName+" "+lastName;    }}