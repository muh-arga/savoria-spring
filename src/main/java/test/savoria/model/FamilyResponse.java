package test.savoria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FamilyResponse {
    private String hubungan;
    private String nama;
    private String tanggal_lahir;
}
