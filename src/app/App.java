

package app;


import service.EmailDelivery;
import service.EmailProvider;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        Thread.currentThread().setName("Main");

        EmailDelivery emailDelivery = new EmailDelivery(new EmailProvider());
        Thread baco = new Thread(emailDelivery, "God Baco");

        baco.start();

        loop:
        while (true) {

            String email = JOptionPane.showInputDialog("Enter as email: ");
            if (email == null || email.isEmpty()) {
                emailDelivery.getProvider().close();
                break;
            } else {
                System.out.println("----- START PROGRAM ------");
                System.out.println(Thread.currentThread().getName() + " will enter the add method..");

                emailDelivery.getProvider().addEmail(email);
            }


            int confirm = JOptionPane.showConfirmDialog(null, "Keep running?");
            switch (confirm) {
                case 1, 2 -> {
                    break loop;
                }
            }

        }


    }

}

