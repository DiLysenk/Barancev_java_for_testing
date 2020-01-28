package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDate;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreationTest() throws Exception {           // создание группы
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupDate("babasnyt098", "234r5", "fqwerf"));
        app.submintGroupCreation();
        app.returnGroupCreation();
    }
}
