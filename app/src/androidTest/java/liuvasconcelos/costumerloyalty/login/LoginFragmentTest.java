package liuvasconcelos.costumerloyalty.login;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Ui tests for the implementation of {@link LoginFragment}
 */
@RunWith(Enclosed.class)
@LargeTest
public class LoginFragmentTest {

    public abstract static class Describe_Login_action {

        @Rule
        public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

        String getResourceString(int resourceId) {
            return activityTestRule.getActivity().getResources().getString(resourceId);
        }

    }

    public static class Context_when_something extends Describe_Login_action {
        @Before
        public void before() {

        }

        @Test
        public void It_should_call_sync(){

        }

    }
}

