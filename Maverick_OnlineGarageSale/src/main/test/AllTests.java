import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({UserAccountTest.class, TiersAndSubscriptionsTest.class, CreditCardTest.class})
public class AllTests {
}
