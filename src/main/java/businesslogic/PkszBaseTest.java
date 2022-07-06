package businesslogic;

import org.junit.jupiter.api.BeforeEach;

public class PkszBaseTest extends core.BaseTest {

    @Override
    @BeforeEach
    protected void setup() {
        super.setup();
        driver.get("https://www.profiboksz.hu/");
    }
}
