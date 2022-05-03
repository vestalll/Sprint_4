import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Проверка валидности строки с фамилией и именем для печати")
    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }
        return name.length() >= 3 && name.length() <= 19 && StringUtils.countMatches(name, " ") == 1 && !name.startsWith(" ") && !name.endsWith(" ");
    }
}





