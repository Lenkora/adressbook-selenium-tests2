package com.example.tests;


import org.testng.annotations.Test;

public class ZANew extends TestBase{
	

  @Test
  public void testNonEmptyAddNewCreation() throws Exception {
    openMainPage();
    addNew();
    ZANewData addNew = new ZANewData();
    addNew.nameFirst1="nameFirs_1";
    addNew.nameLaste1="nameLaste_1";
    addNew.address1="address_1";
    addNew.homa1="homa_1";
    addNew.mobile1="mobile_1";
    addNew.work1="work_1";
    addNew.email1="email_1";
    addNew.email2="email_2";
    addNew.day="2";
    addNew.month="April";
    addNew.year="2015";
    addNew.groupname1="group name 1";
    addNew.address2="address_2";
    addNew.home2="home_2";
    

	fillAddNewForm(addNew);
    submitAddNewCreation();
    returnToAddNext();
  }
  @Test
  public void testEmptyAddNewCreation() throws Exception {
    openMainPage();
    addNew();
    fillAddNewForm(new ZANewData("", "", "", "", "", "", "", "", "-", "-", "-", "[none]", "", ""));
    submitAddNewCreation();
    returnToAddNext();
  }


}
