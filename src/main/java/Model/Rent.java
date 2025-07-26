
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Rent {
    private int ID;
    private User user;
    private Car car;
    private LocalDateTime datetime;
    private int hour;
    private double total;
    private int status;
     private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
    
     
     //status 0==>running
     //        1==>returned
public Rent(){
datetime=LocalDateTime.now();

}
 public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    

    public String getDatetime() {
        return formatter.format(datetime);
    }
    public LocalDateTime getLocalDateTime(){
        return datetime;
    }
    public void setDatetime(String datetimeString) {
    this.datetime = LocalDateTime.parse(datetimeString, formatter);
}

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }
public String getStatusToString() {
    long passedHours = ChronoUnit.HOURS.between(datetime, LocalDateTime.now());
    String status = "";

if (getStatus() == 0) {
    if (passedHours < getHour()) {
        status = "Estimated";
    } else {
        status = "Delayed";
    }
} else if (getStatus() == 1) {
    status = "Returned";
}


    return status;
}
public long getDelayedHours(){
        long passedHours = ChronoUnit.HOURS.between(datetime, LocalDateTime.now());
        return passedHours-hour;
}

    public void setStatus(int status) {
        this.status = status;
    }

}

