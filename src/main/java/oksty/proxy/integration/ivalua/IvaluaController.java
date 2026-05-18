package oksty.proxy.integration.ivalua;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ivalua")
public class IvaluaController {

    private final IvaluaClient ivaluaClient;

    public IvaluaController(IvaluaClient ivaluaClient) {
        this.ivaluaClient = ivaluaClient;
    }

    @GetMapping("/contracts")
    public ResponseEntity<String> getContracts() {
        return ResponseEntity.ok(ivaluaClient.getContracts());
    }

    @GetMapping("/contracts/{id}")
    public ResponseEntity<String> getContractById(@PathVariable String id) {
        return ResponseEntity.ok(ivaluaClient.getContractById(id));
    }
}
