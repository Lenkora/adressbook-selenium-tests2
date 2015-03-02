package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name=" group name 1";
    		group.header=" group header 1";
    				group.footer=" group footer 1";
	fillGroupForm(group);
    siubmitGroupCreation();
    returnToGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
    openGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    siubmitGroupCreation();
    returnToGroupPage();
  }
  
}
