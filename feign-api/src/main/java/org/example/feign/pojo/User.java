package org.example.feign.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 start");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 start");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}