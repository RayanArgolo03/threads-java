package service;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class EmailProvider {
    private final Queue<String> emails;
    private boolean open;

    public EmailProvider() {
        this.emails = new ArrayBlockingQueue<>(1);
        open = true;
    }

    public boolean isOpen() {
        System.out.println(getThreadName() + " in open method...");
        return open;
    }

    public void close() {
        System.out.println("----- " + getThreadName() + " CLOSE PROVIDER ------");
        open = false;
        synchronized (emails) {
            System.out.println(getThreadName() + " closing the program..");
        }
    }

    public int pendingEmails() {
        System.out.println("----- " + getThreadName() + " PENDING METHOD ------");
        System.out.println(getThreadName() + " in pending method...");
        synchronized (emails) {
            return emails.size();
        }
    }

    public void addEmail(String email) {

        System.out.println("----- " + getThreadName() + " ADD METHOD ------");
        System.out.println(getThreadName() + "in adding method...");

        synchronized (emails) {
            emails.offer(email);
            System.out.println(getThreadName() + " add " + email + " on emails!");
            //Released concorrent threads
            emails.notifyAll();

            System.out.println();
            System.out.println(getThreadName() + " released of concurrent threads!");
            System.out.println();
        }

        System.out.println(getThreadName() + " out the add method..");

    }

    public Optional<String> retrieveEmail() throws InterruptedException {
        System.out.println("----- " + getThreadName() + " RETRIEVE METHOD ------");
        System.out.println(getThreadName() + "in retrieve method...");

        synchronized (emails) {
            while (pendingEmails() == 0) {
                if (!open) {
                    System.out.println("Provider is closed :(");
                    break;
                }
                System.out.println(getThreadName() + " waiting for new emails...");
                emails.wait();
            }
            return Optional.ofNullable(emails.poll());
        }

    }

    public String getThreadName() {
        return Thread.currentThread().getName();
    }
}
