package Test;

import model.User;
import model.UserDatabase;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

import java.util.ArrayList;

public class TonyTest {

    @Before
    public void setUp() throws Exception{
        User u = new User();
    }

    @Test
    public void test_userEquals() {
        User first = new User("me", "pass");
        User second = new User("me", "pass");
        Assert.assertEquals(first,second);
    }

    @Test
    public void test_userNotEquals() {
        User first = new User("me", "pass");
        User second = new User("you", "notpass");
        Assert.assertNotEquals(first, second);
    }

    @Test
    public void test_getCredentials() {

        ArrayList<User> a = new ArrayList<>();
        User us = (new User("j","p"));
        a.add(us);
        UserDatabase db = new UserDatabase(a);

        Assert.assertEquals(db.getCredentials("j","p"), us);

    }

    @Test
    public void test_getWrongCredentials() {

        ArrayList<User> a = new ArrayList<>();
        User us = (new User("d","p"));
        a.add(us);

        UserDatabase db = new UserDatabase(a);
        Assert.assertEquals(db.getCredentials("j","p"), null);
        Assert.assertEquals(db.getCredentials("d","ss"), null);
        Assert.assertEquals(db.getCredentials("asd","sdp"), null);

    }
    @Test
    public void test_wrongPass() {
        User a = new User("a", "b");
        User b = new User("a", "d");

        Assert.assertNotEquals(a,b);
    }
}
