package test.savoria.model;

import java.time.LocalDate;

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
    private LocalDate tanggal_lahir;
}
