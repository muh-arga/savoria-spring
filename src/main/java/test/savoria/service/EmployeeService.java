package test.savoria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import test.savoria.entity.Employee;
import test.savoria.entity.Family;
import test.savoria.model.EmployeeResponse;
import test.savoria.model.FamilyResponse;
import test.savoria.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeResponse toEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .keluarga(toFamilyResponseList(employee.getKeluarga() != null ? employee.getKeluarga() : List.of()))
                .nama(employee.getNama_karyawan())
                .tanggal_lahir(employee.getTanggal_lahir())
                .alamat(employee.getAlamat())
                .email(employee.getEmail())
                .build();
    }

    private FamilyResponse toFamilyResponse(Family family) {
        return FamilyResponse.builder()
                .hubungan(family.getHubungan_keluarga())
                .nama(family.getNama_anggota_keluarga())
                .tanggal_lahir(family.getTanggal_lahir_anggota_keluarga())
                .build();
    }

    private List<FamilyResponse> toFamilyResponseList(List<Family> family) {
        return family.stream().map(this::toFamilyResponse).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeResponse get(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return toEmployeeResponse(employee);
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> list() {
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map(this::toEmployeeResponse).toList();
    }

}
