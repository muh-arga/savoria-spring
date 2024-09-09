package test.savoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import test.savoria.model.EmployeeResponse;
import test.savoria.model.WebResponse;
import test.savoria.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/api/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<EmployeeResponse> get(@PathVariable Integer employeeId) {
        try {
            EmployeeResponse employeeResponse = employeeService.get(employeeId);

            return WebResponse.<EmployeeResponse>builder()
                    .data(employeeResponse)
                    .build();
        } catch (ResponseStatusException ex) {
            return WebResponse.<EmployeeResponse>builder()
                    .message(ex.getMessage())
                    .build();
        } catch (Exception ex) {
            return WebResponse.<EmployeeResponse>builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    @GetMapping(path = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<EmployeeResponse>> get() {
        try {
            List<EmployeeResponse> employeeResponse = employeeService.list();

            return WebResponse.<List<EmployeeResponse>>builder()
                    .data(employeeResponse)
                    .build();

        } catch (Exception ex) {
            return WebResponse.<List<EmployeeResponse>>builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

}
