package com.alarm.function;

public class AlramTest {
    public static void main(String[] args) throws InterruptedException {
        AlarmService service = new AlarmService();
        service.run();
    }
}

class AlarmService {

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

    public void run() throws InterruptedException {
        setup();
        while ( true) {
            reset();
            for(int i = 0 ; i < 24; i++) {
                Thread.sleep(100);
                loop(i);
            }
        }
    }

}
