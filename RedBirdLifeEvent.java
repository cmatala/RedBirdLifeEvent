


import jdk.jfr.EventType;
import java.util.Random;

public class RedBirdLifeEvent {
    // variables initialisation
    static int EventsTrack = 0;
    private String EventName;
    private String EventType;
    private int EventCapacity;
    private int Quantity;
    private String EventLocation;
    private String Barcode;
    private int SeatTaken;
    private int remainSeat;


    // Default constructor
    RedBirdLifeEvent() {
        EventsTrack++; // to keep track of how many events have been created
    }

    // Constructor Overload
    RedBirdLifeEvent(String EventName, String EvenType) {
        this.EventName = EventName;
        this.EventType = EvenType;
        SeatTaken = 0;
        CalcMaximumSeats(EventType);
        generateBarCode();


    }

    RedBirdLifeEvent(String EventName, String EventType, int EventCapacity) {
        this(EventName, EventType);
        this.EventCapacity = EventCapacity;
    }

    private void CalcMaximumSeats(String EventType) {
        this.EventType = EventType;

        if (EventType.equals("Workshop")) {
            EventLocation = "Jullian Hall 28";
            EventCapacity = 30;
        }

        if (EventType.equals("Seminar")) {
            EventLocation = "Visual Arts 151";
            EventCapacity = 100;
        }

        if (EventType.equals("Career fair")) {
            EventLocation = "Performing Arts Lobby";
            EventCapacity = 100000000;
        }

    }


    private void generateBarCode() {
        // Get the Event Name first character
        char firstEventName = EventName.charAt(0);

        // Get the Event Location first character
        String[] words = EventLocation.split("\\s+");
        char firstChar1 = words[0].charAt(0);
        char firstChar2 = words[1].charAt(0);
        String firstEventLocation = Character.toString(firstChar1) + Character.toString(firstChar2);

        // Generate 5 random digit
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomNum = rand.nextInt(10);
            sb.append(randomNum);
        }

        String randomNumber = sb.toString();

        // Barcode generate

        Barcode = firstEventName + firstEventLocation + randomNumber;

    }

    //Getters Methods
    public int getEventCapacity(){
        return EventCapacity;
    }

    public int getQuantity(){
        return Quantity;
    }

    public int getSeatTaken(){
        return SeatTaken;
    }

    public int getRemainSeat() {
        return remainSeat;
    }

    public String getEventName(){
        return EventName;
    }

    public String getEventType(){
        return EventType;
    }

    public String getEventLocation(){
        return EventLocation;
    }

    public String getBarcode(){
        return Barcode;
    }

    // Setters Methods

    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }

    public void setSeatTaken(int SeatTaken) {
        this.SeatTaken = SeatTaken;
    }

    public void setEventCapacity(int EventCapacity) {
        this.EventCapacity = EventCapacity;
    }

    public void setRemainSeat(int remainSeat) {
        this.remainSeat = remainSeat;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public void setEventLocation(String EventLocation) {
        this.EventLocation = EventLocation;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public void setEventType(String EventType) {
        this.EventType = EventType;
    }

    // return the number of Event Created
    public static int getEventsTrack(){
        return EventsTrack;
    }


    //  the difference between the capacity and the number of seats taken

    public int getAvailableSeats(){
        int difference = EventCapacity - SeatTaken;
        return difference;
    }

    @Override
    public String toString() {

        remainSeat = getAvailableSeats();
        String SeatRemain = "seat";

        if (remainSeat == 0){
            SeatRemain = "  FULL";
        }

        if (remainSeat > 1){
            SeatRemain = Integer.toString(remainSeat)+"  "+"seats";
        }

        if (EventType.equals("Career fair")){
            SeatRemain = "Unlimited";
        }

        String message = String.format("%-10s%-10s%-10s%-10s%-10s%-10s", Barcode, EventName," ", EventLocation,"  ",SeatRemain );
        return message;
    }
    // Handle group Registration
    public boolean register(int Quantity){
        this.Quantity = Quantity;

        if (!EventType.equals("Career fair")){
            if (remainSeat > 0){
                SeatTaken += Quantity;
                return true;
            } else {
                return false;

            }
        }
        else if(EventType.equals("Career fair")){
            SeatTaken += Quantity;
            return true;
        }else{
            return false;
        }


    }
    // Handles individual registration
    public boolean register(){
        if (!EventType.equals("Career fair")){
            if (remainSeat > 0){
                SeatTaken += 1;
                return true;
            } else {
                return false;

            }
        }
        else if(EventType.equals("Career fair")){
            SeatTaken += 1;
            return true;
        }else{
            return false;
        }
    }


}