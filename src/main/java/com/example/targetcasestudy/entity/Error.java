package com.example.targetcasestudy.entity;

/**
 * @author vishnupriyaamara
 * @since 13/03/21.
 */
public enum Error {

  INVALID_INPUT_FOR_STOREYS_AND_SLOTS("Invalid input for totalStoreys and totalSlots"),
  NO_FREE_SLOTS_AVAILABLE("No free slots available for parking"),
  SLOT_IS_ALREADY_FREE("Slot is free, No car at the slot"),
  NO_CAR_WITH_REG_NUMBER("No car with given registration number"),
  CAR_REGISTRATION_NUMBER_BLANK("Car registration number should not be blank"),
  CAR_COLOUR_BLANK("Car colour should not be blank"),
  REGISTRATION_NUMBER_ALREADY_EXIST("Invalid registration number, car is already parked"),

  SYSTEM_ERROR("Internal system error");

  private String message;

  Error(String message) {
    this.message = message;
  }

  public String getCode() {
    return this.name();
  }

  public String getMessage() {
    return this.message;
  }
}
