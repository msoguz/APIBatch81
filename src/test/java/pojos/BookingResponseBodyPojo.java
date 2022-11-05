package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)  // Bu anotation ayni levelde bilinmeyen verileri gormezden
public class BookingResponseBodyPojo {
    private Integer bookingId;
    private BookingPojo booking;


    public BookingResponseBodyPojo(Integer bookingId, BookingPojo booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
