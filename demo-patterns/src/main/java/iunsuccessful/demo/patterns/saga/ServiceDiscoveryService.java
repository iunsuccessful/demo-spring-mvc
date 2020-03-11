package iunsuccessful.demo.patterns.saga;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 依韵 2020/1/18
 */
public class ServiceDiscoveryService {

    private Map<String, OrchestrationChapter<?>> services;

    public Optional<OrchestrationChapter> find(String service) {
        return Optional.ofNullable(services.getOrDefault(service, null));
    }

    public ServiceDiscoveryService discover(OrchestrationChapter<?> orchestrationChapterService) {
        services.put(orchestrationChapterService.getName(), orchestrationChapterService);
        return this;
    }

    public ServiceDiscoveryService() {
        this.services = new HashMap<>();
    }

}
