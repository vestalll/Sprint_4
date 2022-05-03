import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"Vasya Ivanov", true},
                {"A C", true},
                {"Qwertyui Asdfghjkl", true},
                {"Ab", false},
                {"Qwertyuio Asdfghjklz", false},
                {"Vasya  Ivanov", false},
                {" Vasya Ivanov", false},
                {"Vasya Ivanov ", false},
                {"", false},
                {null, false},

        };
    }

    @Test
    @DisplayName("Проверка возможности печати строки с именем и фамилией")
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }
}