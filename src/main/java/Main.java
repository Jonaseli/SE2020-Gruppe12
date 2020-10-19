import io.javalin.Javalin;
import repository.Repository;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));

        String[] filesPaths = new String[4];

        filesPaths[0] = "parkingSpots.json";
        filesPaths[1] = "accounts.json";
        filesPaths[2] = "posts.json";
        filesPaths[3] = "reservations.json";

        Repository repo = new Repository(filesPaths);

    }

}
