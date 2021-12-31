package com.alarm.annotation;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

class Alarm {

    @Task(time=10)
    public  void task0() {
        System.out.println("10시 입니다.");
    }

    @Log @Task(time=14)
    public void task1() {
        System.out.println("14시 입니다.");
    }

    public  void fun1() {
        System.out.println("no~~~~~~~~~~~~~");
    }
}
public class AlarmTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InterruptedException {
            new AlarmService(new Alarm()).run();
    }


    public static void main2(String[] args) throws InvocationTargetException, IllegalAccessException {

        Alarm alarm = new Alarm();
        Method methods[] = alarm.getClass().getDeclaredMethods();

        for(Method method : methods) {
            System.out.println(method.getName());
            Task annTask = method.getAnnotation(Task.class);
            if ( annTask == null) System.out.println("X");
            else System.out.println("@Task");

            Log annLog = method.getAnnotation(Log.class);
            if ( annLog == null) System.out.println("X");
            else System.out.println("@Log");

            if ( annTask != null) {
                System.out.println("time value =" + annTask.time());
                if ( annTask.time() == 10 )
                    method.invoke(alarm);
            }
        }
    }
}

class AlarmService {

    private  Object alarm;

    public  AlarmService(Object alarm) {
        this.alarm = alarm;

    }
    public  void run() throws InvocationTargetException, IllegalAccessException, InterruptedException {
        Method methods[] = alarm.getClass().getDeclaredMethods();
        HashMap<Integer, Method> mapTask = new HashMap<Integer,Method>();

        for (Method method : methods) {
            Task antTask = method.getAnnotation(Task.class);
            if (antTask != null) {
                mapTask.put(antTask.time(), method);
            }
        }
        while (true) {
            for (int i = 0; i < 24; i++) {
                Thread.sleep(100);
                for (Integer time: mapTask.keySet() ) {
                    if ( i == time )  {
                        Method method = mapTask.get(time);
                        method.invoke(alarm);
                    }
                }
            }
        }
    }
}
