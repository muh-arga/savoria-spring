package test.savoria.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_employee")

public class Employee {
    @Id
    private Integer id;

    private String nama_karyawan;

    private LocalDate tanggal_lahir;

    private String alamat;

    private String email;

    private LocalDate valid_from;

    private LocalDate valid_to;

    private Integer create_by;

    private LocalDateTime create_date;

    private Integer update_by;

    private LocalDateTime update_date;

    @OneToMany(mappedBy = "employee")
    private List<Family> keluarga;


}
