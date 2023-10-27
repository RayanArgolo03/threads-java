package service;

import java.util.Optional;

public class EmailDelivery implements Runnable {

    private final EmailProvider provider;

    public EmailDelivery(EmailProvider emailProvider) {
        this.provider = emailProvider;
    }

    public EmailProvider getProvider() {
        return provider;
    }

    @Override
    public void run() {
        System.out.println("----- " + Thread.currentThread().getName() + " START RUN ------");

        while (provider.isOpen() || provider.pendingEmails() > 0) {
            try {
                Optional<String> email = provider.retrieveEmail();

                if (email.isPresent()) {
                    System.out.println("Removed by " + provider.getThreadName() + ": " + email.get());
                    System.out.println("Now, " + provider.getThreadName() + " sleeps..");

                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
