package com.globan.automation.tests;

import com.globan.automation.config.TestsRunner;
import com.globan.automation.models.OrderDTO;
import com.globan.automation.models.UserDTO;
import com.globan.automation.models.pet.PetDTO;
import com.globan.automation.request.RequestBuild;
import com.globan.automation.util.ObjectFactory;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.globan.automation.request.RequestBuild.response;

/**
 * Main test class containing automated tests for the PerfDog API.
 * Each method tests an independent functionality of the pet store.
 */

public class AllTests extends TestsRunner {

    /**
     * Test that creates a user and performs login.
     * Verifies that the login is successful.
     */
    @Test(priority = 1, testName ="1-2 User creation and login")
    public void userCreatedAndLogin() {
        Response response = createAndLoginUser();
        Assert.assertEquals(response.getStatusCode(),200, "The login was not successful");
    }

    /**
     * Test that retrieves all pets with status "available".
     * Verifies that all listed pets are available.
     */
    @Test(priority = 2, testName ="3 All pets that are available")
    public void availablePets(){
        List<PetDTO> petDTOList = response(getBaseURL(),"/pet/findByStatus?status=available").as(new TypeRef<List<PetDTO>>() {});
        boolean allAvailable = petDTOList.stream()
                .allMatch(pet -> "available".equalsIgnoreCase(pet.status()));

        Assert.assertTrue(allAvailable, "Not all pets are available");
    }


    /**
     * Test that creates a pet and then retrieves its data by ID.
     * Verifies that the retrieved data matches the created pet.
     */
    @Test(priority = 3, testName ="4 Consult Pet")
    public void petCreatedGet() {
        PetDTO newPet = (PetDTO)ObjectFactory.randomObjectDTO("Pet");
        RequestBuild.createResponse(getBaseURL(),"/pet",newPet);
        PetDTO requestPet = RequestBuild.waitFor(getBaseURL(), "/pet/" + newPet.id(), 5, 200, PetDTO.class);

        Assert.assertEquals(newPet.toString(), requestPet.toString(), "The pet was not requested correctly");
    }


    /**
     * Test that creates a purchase order for a pet.
     * Verifies that the order is created successfully.
     */
    @Test(priority = 4, testName ="5 Create purchase order")
    public void createOrder(){
        OrderDTO newOrder = (OrderDTO)ObjectFactory.randomObjectDTO("Order");
        RequestBuild.createResponse(getBaseURL(),"/store/order",newOrder);
        OrderDTO requestOrder = RequestBuild.waitFor(getBaseURL(), "/store/order/" + newOrder.id(), 5, 200, OrderDTO.class);

        Assert.assertEquals(newOrder.toString(),requestOrder.toString(), "The order could not be created");

    }

    /**
     * Test that logs out a user.
     * Verifies that the logout is successful.
     */
    @Test(priority = 6, testName ="6 User logout")
    public void userLogout() {
        createAndLoginUser();
        Response response = response(getBaseURL(), "/user/logout");

        Assert.assertEquals(response.getStatusCode(),200, "The logout was not successful");
    }

    /**
     * Creates a random user, registers it, and performs login.
     *
     * @return Response from the login request.
     */
    private Response createAndLoginUser() {
        UserDTO newUser = (UserDTO) ObjectFactory.randomObjectDTO("User");
        RequestBuild.createResponse(getBaseURL(), "/user", newUser);
        RequestBuild.waitFor(getBaseURL(), "/user/" + newUser.username(), 5, 200, UserDTO.class);

        return response(getBaseURL(), "/user/login?username=" + newUser.username() + "&password=" + newUser.password());
    }
}
