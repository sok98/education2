package com.alarm.basic;

public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("알람을 시작합니다.");   //초기화
        while ( true) {
            System.out.println("재시작합니다..");  //재시작 초기화
            for(int i = 0 ; i < 24; i++) {
                Thread.sleep(100);
                if ( i == 10)
                    System.out.println("10시가 되었습니다.");
                if ( i == 17)
                    System.out.println("17시가 되었습니다.");
            }
        }
    }
}
