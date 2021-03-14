package com.example.targetcasestudy.model.request;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class IssueTicketWebRequest {

  private String carRegistrationNumber;
  private String carColour;

  public IssueTicketWebRequest(String carRegistrationNumber, String carColour) {
    this.carRegistrationNumber = carRegistrationNumber;
    this.carColour = carColour;
  }

  public String getCarRegistrationNumber() {
    return carRegistrationNumber;
  }

  public void setCarRegistrationNumber(String carRegistrationNumber) {
    this.carRegistrationNumber = carRegistrationNumber;
  }

  public String getCarColour() {
    return carColour;
  }

  public void setCarColour(String carColour) {
    this.carColour = carColour;
  }
}
