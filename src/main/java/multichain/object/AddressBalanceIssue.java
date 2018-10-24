/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

import java.util.HashMap;
import java.util.Map;
import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;
import multichain.object.queryobjects.ParamIssue;
import multichain.object.queryobjects.ParamIssueMore;

/**
 * @author Ub - H. MARTEAU
 * @version 4.16
 */
public class AddressBalanceIssue implements AddressBalance {
	String address = null;
	ParamIssue issue = null;
	ParamIssueMore issuemore = null;

	public void isFilled() throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		if (issue == null && issuemore == null) {  
		  throw new MultichainException("issue/issuemore", "issue / issuremore badly filled (none).");
		} else if (issue != null && issuemore != null
            && issue.isFilled() && issuemore.isFilled()) {
          throw new MultichainException("issue/issuemore", "issue / issuremore badly filled (both).");
		}
		  
	}
	
	public Map<String, Object> getValue() throws MultichainException {
		Map<String, Object> mapAssets = new HashMap<String, Object>();
		
		if (issue != null && issue.isFilled()) {
		  mapAssets.put("issue", issue);
		} else if (issuemore != null && issuemore.isFilled()) {
          mapAssets.put("issuemore", issuemore);
        }
		
		return mapAssets;
	}

  /**
   * 
   */
  public AddressBalanceIssue() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param address
   * @param issue
   * @param issuemore
   */
  public AddressBalanceIssue(String address, ParamIssue issue, ParamIssueMore issuemore) {
    this.address = address;
    this.issue = issue;
    this.issuemore = issuemore;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the issue
   */
  public ParamIssue getIssue() {
    return issue;
  }

  /**
   * @param issue the issue to set
   */
  public void setIssue(ParamIssue issue) {
    this.issue = issue;
  }

  /**
   * @return the issuemore
   */
  public ParamIssueMore getIssuemore() {
    return issuemore;
  }

  /**
   * @param issuemore the issuemore to set
   */
  public void setIssuemore(ParamIssueMore issuemore) {
    this.issuemore = issuemore;
  }

  
}
