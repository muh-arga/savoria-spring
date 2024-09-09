package test.savoria.entity;

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

    private String tanggal_lahir;

    private String alamat;

    private String email;

    private String valid_from;

    private String valid_to;

    private String create_by;

    private String create_date;

    private String update_by;

    private String update_date;

    @OneToMany(mappedBy = "employee")
    private List<Family> keluarga;


}
