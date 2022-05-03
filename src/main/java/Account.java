import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

public class Account {
    private final String name;
    public Account(String name) {
        this.name = name;
    }

    @Step("Проверка валидности строки с фамилией и именем для печати")
    public boolean checkNameToEmboss() {
        int minLength = 3;
        int maxLength = 19;
        String spaceSign = " ";
        return name != null
                && name.length() >= minLength
                && name.length() <= maxLength
                && StringUtils.countMatches(name, spaceSign) == 1
                && !name.startsWith(spaceSign)
                && !name.endsWith(spaceSign);
    }
}





