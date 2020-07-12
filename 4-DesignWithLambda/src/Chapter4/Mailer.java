package Chapter4;

public class Mailer {
    public void from(final String address){/*... */}
    public void to(final String address){/*... */}
    public void subject(final String line){/*... */}
    public void body(final String message){/*... */}
    public void send(){
        System.out.println("sending ...");
    }

    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("abc@gmail.com");
        mailer.to("xyz@gmail.com");
        mailer.subject("build notification");
        mailer.body("...your code sucks...");
        mailer.send();
    }
}
