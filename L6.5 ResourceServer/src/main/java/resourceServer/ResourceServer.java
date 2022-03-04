package resourceServer;

import resources.TestResource;

public interface ResourceServer {
    TestResource getResource();

    void setResource(TestResource testResource);
}
