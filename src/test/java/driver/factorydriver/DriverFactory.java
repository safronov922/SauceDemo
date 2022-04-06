package driver.factorydriver;

public class DriverFactory {
    public DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case MOZILLA:
                driverManager = new MozillaDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type: " + type);
        }
        return driverManager;
    }
}
