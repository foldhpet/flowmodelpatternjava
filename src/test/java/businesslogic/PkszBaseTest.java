package businesslogic;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public class PkszBaseTest extends BaseTest {

    @Override
    @BeforeEach
    protected void setup() {
        super.setup();
        driver.get("https://www.profiboksz.hu/");
    }
}
