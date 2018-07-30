package maverick.ogs.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({UserAccountTest.class, SubscriptionsTest.class, CreditCardTest.class})
public class AllTests {
}
