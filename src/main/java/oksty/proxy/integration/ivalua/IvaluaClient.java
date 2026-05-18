package oksty.proxy.integration.ivalua;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * 🔴 RED ZONE — Core integration logic. Write this yourself to understand
 * the Ivalua API contract, error modes, and data mapping.
 */
@Component
public class IvaluaClient {

    private final RestClient restClient;

    public IvaluaClient(RestClient ivaluaRestClient) {
        this.restClient = ivaluaRestClient;
    }

    // TODO: Implement fetching contracts from Ivalua
    // Consider: What fields do consumers need? What does Ivalua return?
    // Consider: How do you handle pagination from Ivalua?
    // Consider: What happens on 401/403/500 from Ivalua?
    public String getContracts() {
        throw new UnsupportedOperationException("Not yet implemented — write this yourself");
    }

    // TODO: Implement fetching a single contract by ID
    // Consider: What is the Ivalua contract identifier format?
    // Consider: What do you return when the contract doesn't exist?
    public String getContractById(String id) {
        throw new UnsupportedOperationException("Not yet implemented — write this yourself");
    }
}
