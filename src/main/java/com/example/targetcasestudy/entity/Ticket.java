package com.example.targetcasestudy.entity;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class Ticket {

  private static int ticketNumber;
  private Slot allotedSlot;

  public Ticket(Slot allotedSlot) {
    ticketNumber = ticketNumber + 1;
    this.allotedSlot = allotedSlot;
  }

  public int getTicketNumber() {
    return ticketNumber;
  }

  public Slot getAllotedSlot() {
    return allotedSlot;
  }
}
