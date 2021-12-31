package com.alarm.event;

public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {
        AlarmService service = new AlarmService(new Alarm());
        service.run();
    }
}


class Alarm {
    public  void setup() {
        System.out.println("알람을 시작합니다.");   //초기화
    }

    public  void reset() {
        System.out.println("알람을 재시작합니다.");   // reset
    }

    public void loop(int time) {
        if ( time == 10)
            System.out.println("10시가 되었습니다.");
        if ( time == 17)
            System.out.println("17시가 되었습니다.");
    }
}

class AlarmService {

    private  Alarm alarm;
    

    public  AlarmService(Alarm alarm) {
        this.alarm = alarm;
    }

    public void run() throws InterruptedException {
        alarm.setup();
        while ( true) {
            alarm.reset();
            for(int i = 0 ; i < 24; i++) {
                Thread.sleep(100);
                alarm.loop(i);
            }
        }
    }
}
