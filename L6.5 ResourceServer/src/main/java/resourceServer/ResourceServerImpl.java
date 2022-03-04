package resourceServer;

import resources.TestResource;

public class ResourceServerImpl implements ResourceServer{
    private TestResource testResource;

    @Override
    public TestResource getResource() {
        return testResource;
    }

    @Override
    public void setResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
