package oksty.proxy.integration.ivalua;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * 🔴 RED ZONE — Core integration logic. Write this yourself to understand
 * the Ivalua API contract, error modes, and data mapping.
 */
@Component
public class IvaluaClient {

    @SuppressWarnings("java:S1068") // Field will be used when methods are implemented
    private final RestClient restClient;

    public IvaluaClient(RestClient ivaluaRestClient) {
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
