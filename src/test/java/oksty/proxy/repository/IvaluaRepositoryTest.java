package oksty.proxy.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * 🔴 RED ZONE — Write these tests BEFORE implementing IvaluaRepository.
 * They define the contract your implementation must satisfy.
 */
class IvaluaRepositoryTest {

    @Test
    @Disabled("Pending IvaluaRepository implementation")
    void getContracts_shouldReturnContractList() {
        fail("Not yet implemented — call GET /contracts and assert response body");
    }

    @Test
    @Disabled("Pending IvaluaRepository implementation")
    void getContractById_shouldReturnSingleContract() {
        fail("Not yet implemented — call GET /contracts/{id} and assert 404 when missing");
    }

    @Test
    @Disabled("Pending IvaluaRepository implementation")
    void getContracts_shouldHandleIvaluaServerError() {
        fail("Not yet implemented — mock Ivalua 500 and assert 502 Bad Gateway");
    }

    @Test
    @Disabled("Pending IvaluaRepository implementation")
    void getContracts_shouldHandleIvaluaTimeout() {
        fail("Not yet implemented — mock timeout and assert 504 Gateway Timeout");
    }
}
