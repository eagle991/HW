import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern L0GIN_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");

    static void validate(String login, String password, String confirmPassword){
        try {
            validateLoqin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Валидация пройдена");
        }

    }



    private static void validateLoqin(String login) throws WrongLoginException {
        if (!L0GIN_PATTERN.matcher(login).matches()){
            throw new WrongLoginException("Login не верный, проверьте корректность введенных данных");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()){
            throw new WrongPasswordException("Password не верный, проверьте корректность введенных данных");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password не совпадают, проверьте корректность введенных данных");
        }
    }
}