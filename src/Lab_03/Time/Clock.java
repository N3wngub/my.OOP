package Time;

public class Clock {
    int hour;
    int minute;

    public Clock(int hour,int minute){
        setTime(hour,minute);
        if(minute >= 59){
            if(hour >= 23 || hour <= 0){
                increaseHour();
                this.hour = 0;
                this.minute = 0;
            }else{
                increaseHour();
                this.minute = 0;
            }
        }else if(hour > 23 || hour <= 0){
            increaseHour();
            this.hour = 0;
        }else{
            this.hour = hour;
        }
        toString();
    }

    public void setTime(int hour,int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public void increaseMinute(){
        if(minute >= 59){
            if(hour >= 23 || hour <= 0){
                increaseHour();
                this.hour = 0;
                this.minute = 0;
            }else{
                increaseHour();
                minute = 0;
            }
        }else{
            minute += 1;
        }
    }

    public void increaseHour(){
        hour += 1;
    }

    public String toString() {
        if(minute<10) {
            if(hour < 1){
                return "0" + hour + ":" + "0" + minute;
            }else{
                return  hour + ":" + "0" + minute;
            }
        }else if(hour <1 ){
            return  "0" + hour + ":" + minute;
        }else {
            return  hour + ":" + minute;
        }
    }
}