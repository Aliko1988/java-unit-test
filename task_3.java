import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckIsAdultTest {

    private final int age;
    private final boolean result;

    public CheckIsAdultTest(int age, boolean result) {
        this.age = age;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {19, true},  // Пользователь совершеннолетний
                {17, false}, // Пользователь несовершеннолетний
                {18, true},   // Пользователь 18 лет
              {21, true}   // Пользователь 21 лет
        });
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age);
        String message = String.format("Ожидается, что для возраста %d результат будет %b", age, result);
        assertEquals(message, result, isAdult);

    }
}

