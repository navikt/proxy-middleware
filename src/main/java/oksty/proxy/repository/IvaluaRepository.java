package oksty.proxy.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

/**
 * 🔴 RED ZONE — Core integration logic. Write this yourself to understand
 * the Ivalua API contract, error modes, and data mapping.
 */
@Repository
public class IvaluaRepository {

    @SuppressWarnings("java:S1068") // Field will be used when methods are implemented
    private final RestClient restClient;

    public IvaluaRepository(RestClient ivaluaRestClient) {
        this.restClient = ivaluaRestClient;
    }

    // Stub: implement when Ivalua API contract is finalized (OSK-143)
    public String getContracts() {
        throw new UnsupportedOperationException("Not yet implemented — write this yourself");
    }

    // Stub: implement when Ivalua API contract is finalized (OSK-143)
    public String getContractById(String id) {
        throw new UnsupportedOperationException("Not yet implemented — write this yourself");
    }
}
