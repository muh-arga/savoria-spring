package test.savoria.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeResponse {
    private List<FamilyResponse> keluarga;
    private String nama;
    private String tanggal_lahir;
    private String alamat;
    private String email;
}
