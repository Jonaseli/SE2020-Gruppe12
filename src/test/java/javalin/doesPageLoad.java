package javalin;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.tools.javac.Main;
import controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.UUID;

public class doesPageLoad {

    Repository repo = new Repository();
    Controller controller = new Controller(repo);
    static Javalin app;
    HttpResponse response;

    @BeforeAll
    public static void setup(){
        app = Javalin.create().start(7000);
    }

    @Test
    public void frontPageLoads() throws UnirestException {
        app.get("/", new VueComponent("login-page"));
        response = Unirest.get("http://localhost:7000/").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void parkingSpotOverviewPageLoads() throws UnirestException {
        app.get("/parking-spot", new VueComponent("parking-spots-overview"));
        response = Unirest.get("http://localhost:7000/parking-spot").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void parkingSpotDetailPageLoads() throws UnirestException {
        String parkingSpotId = repo.getParkingSpots().get(0).getParkingSpotId().toString();
        app.get("/parking-spot/:parking-spot-id", new VueComponent("parking-spot-detail"));
        response = Unirest.get("http://localhost:7000/parking-spot/" + parkingSpotId).asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void parkingSpotPaymentPageLoads() throws UnirestException {
        String parkingSpotId = repo.getParkingSpots().get(0).getParkingSpotId().toString();
        app.get("/parking-spot/:parking-spot-id/payment", new VueComponent("payment-page"));
        response = Unirest.get("http://localhost:7000/parking-spot/" + parkingSpotId + "/payment").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void myParkingSpotsPageLoads() throws UnirestException {
        String accountId = repo.getAccounts().get(0).getAccountId().toString();
        app.get("/account/:account-id/my-parking-spots", new VueComponent("my-parking-spots"));
        response = Unirest.get("http://localhost:7000/account/" + accountId + "/my-parking-spots").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void createParkingSpotPageLoads() throws UnirestException {
        String accountId = repo.getAccounts().get(0).getAccountId().toString();
        app.get("/account/:account-id/my-parking-spots/create-parking", new VueComponent("parking-create"));
        response = Unirest.get("http://localhost:7000/account/" + accountId + "/my-parking-spots/create-parking").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void adminPageLoads() throws UnirestException {

        app.get("/admin-page", new VueComponent("admin-page"));
        response = Unirest.get("http://localhost:7000/admin-page").asString();

        Assertions.assertEquals(response.getStatus(), 200);
    }

    @AfterAll
    public static void shutdown(){
        app.stop();
    }

}
