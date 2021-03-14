package com.example.targetcasestudy.entity;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class Car {

  private String registrationNumber;
  private String colour;

  public Car(String registrationNumber, String colour) {
    this.registrationNumber = registrationNumber;
    this.colour = colour;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

}
