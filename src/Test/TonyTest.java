package Test;

import model.User;
import model.UserDatabase;
import org.junit.Test;

import org.junit.Assert;

import java.util.ArrayList;

public class TonyTest {
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
        a.add(new User("c","d"));
        a.add(new User("f","g"));
        a.add(new User("h", "i"));
        UserDatabase db = new UserDatabase(a);

        Assert.assertEquals(db.getCredentials("j","p"), us);

    }

    @Test
    public void test_getWrongCredentials() {

        ArrayList<User> a = new ArrayList<>();
        User us = (new User("d","p"));

        a.add(new User("c","d"));
        a.add(new User("f","g"));
        a.add(new User("h", "i"));
        UserDatabase db = new UserDatabase(a);

        Assert.assertNotEquals(db.getCredentials("j","p"), us);

    }
}
