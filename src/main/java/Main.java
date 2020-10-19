import io.javalin.Javalin;
import repository.Repository;

import java.io.File;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));

        Repository repo = new Repository(new File("parkingSpots.json"));

    }

}
