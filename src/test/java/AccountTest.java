import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    @DisplayName("Можно напечатать строку с фамилией и именем с допустимым значением")
    public void checkNameToEmbossWithValidData() {
        String name = "Vasya Ivanov";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Можно напечатать строку с фамилией и именем с минимальным кол-вом символов")
    public void checkNameToEmbossWithMinLength() {
        String name = "A C";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Нельзя напечатать строку с фамилией и именем с кол-вом символов меньше минимального")
    public void checkNameToEmbossWithLessThanMinLength() {
        String name = "Ab";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Можно напечатать строку с фамилией и именем с максимальным кол-вом символов")
    public void checkNameToEmbossWithMaxLength() {
        String name = "Qwertyui Asdfghjkl";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Нельзя напечатать строку с фамилией и именем с кол-вом символов больше максимального")
    public void checkNameToEmbossWithMoreThanMaxLength() {
        String name = "Qwertyuio Asdfghjklz";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Нельзя напечатать строку с фамилией и именем с более чем одним пробелом внутри")
    public void checkNameToEmbossWithMoreThanOneSpace() {
        String name = "Vasya  Ivanov";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Нельзя напечатать строку с фамилией и именем с пробелом в начале строки")
    public void checkNameToEmbossStartsFromSpace() {
        String name = " VasyaIvanov";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    @DisplayName("Нельзя напечатать строку с фамилией и именем с пробелом в конце строки")
    public void checkNameToEmbossEndsWithSpace() {
        String name = "VasyaIvanov ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

}