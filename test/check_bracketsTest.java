import ass.check_brackets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class check_bracketsTest {

    @Test
    public void checkBalancePositiveScenario(){

        String str = "(())";
        assertEquals(check_brackets.checkBalance(str),"Success");

        str = "(){}";
        assertEquals(check_brackets.checkBalance(str),"Success");

        str = "[{ac}]";
        assertEquals(check_brackets.checkBalance(str),"Success");

        str ="(({}))";
        assertEquals(check_brackets.checkBalance(str),"Success");

        str = "}";
        assertEquals(check_brackets.checkBalance(str),"1");

        str = "{}()}";
        assertEquals(check_brackets.checkBalance(str),"5");

        str ="{[}";
        assertEquals(check_brackets.checkBalance(str),"3");

        str ="{}(){";
        assertEquals(check_brackets.checkBalance(str),"5");

        str = "{}{{{{";
        assertEquals(check_brackets.checkBalance(str),"3");

        str = "{{{{{";
        assertEquals(check_brackets.checkBalance(str),"1");

        str ="[]";
        assertEquals(check_brackets.checkBalance(str),"Success");

        str ="[";
        assertEquals(check_brackets.checkBalance(str),"1");

        str ="[{}]{";
        assertEquals(check_brackets.checkBalance(str),"5");

        str ="((())";
        assertEquals(check_brackets.checkBalance(str),"3");






    }
}
