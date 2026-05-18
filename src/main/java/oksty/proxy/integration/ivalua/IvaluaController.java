package oksty.proxy.integration.ivalua;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ivalua")
@Tag(name = "Ivalua", description = "Proxy endpoints for Ivalua contract data")
public class IvaluaController {

    private final IvaluaClient ivaluaClient;

    public IvaluaController(IvaluaClient ivaluaClient) {
        this.ivaluaClient = ivaluaClient;
    }

    @GetMapping("/contracts")
    @Operation(summary = "List contracts", description = "Fetches contracts from Ivalua")
    @ApiResponse(responseCode = "200", description = "Contracts returned successfully")
    @ApiResponse(responseCode = "502", description = "Ivalua is unavailable")
    public ResponseEntity<String> getContracts() {
        return ResponseEntity.ok(ivaluaClient.getContracts());
    }

    @GetMapping("/contracts/{id}")
    @Operation(summary = "Get contract by ID", description = "Fetches a single contract from Ivalua")
    @ApiResponse(responseCode = "200", description = "Contract returned successfully")
    @ApiResponse(responseCode = "404", description = "Contract not found")
    @ApiResponse(responseCode = "502", description = "Ivalua is unavailable")
    public ResponseEntity<String> getContractById(@PathVariable String id) {
        return ResponseEntity.ok(ivaluaClient.getContractById(id));
    }
}
