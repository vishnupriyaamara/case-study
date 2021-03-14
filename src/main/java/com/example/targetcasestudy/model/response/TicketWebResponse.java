package com.example.targetcasestudy.model.response;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class TicketWebResponse {

  private int ticketNumber;
  private SlotWebResponse slotWebResponse;

  public int getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(int ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public SlotWebResponse getSlotWebResponse() {
    return slotWebResponse;
  }

  public TicketWebResponse(SlotWebResponse slotWebResponse) {
    this.slotWebResponse = slotWebResponse;
  }

  public void setSlotWebResponse(SlotWebResponse slotWebResponse) {
    this.slotWebResponse = slotWebResponse;
  }

  public TicketWebResponse(int ticketNumber, SlotWebResponse slotWebResponse) {
    this.ticketNumber = ticketNumber;
    this.slotWebResponse = slotWebResponse;
  }
}
