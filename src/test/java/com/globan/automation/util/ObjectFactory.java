
package com.globan.automation.util;

import com.globan.automation.models.OrderDTO;
import com.globan.automation.models.UserDTO;
import com.globan.automation.models.pet.PetCategoryDTO;
import com.globan.automation.models.pet.PetDTO;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for generating sample data objects for testing purposes.
 * This class provides methods to create lists of UserDTO, PetDTO, and OrderDTO objects
 * with predefined sample data.
 */

public class ObjectFactory {


    /**
     * Generates a list of UserDTO objects with sample data.
     *
     * @return List of UserDTO objects
     */
    public static List<UserDTO> userDTOList(){
        return Arrays.asList(
            new UserDTO(
                    111,
                    "RickDeckard11",
                    "Rick",
                    "Deckard",
                    "rickg.d@bladerunner.com",
                    "VoightKampff_2019!",
                    "+1 213-555-8472",
                    0),

            new UserDTO(
                    112,
                    "Case00",
                    "Henry",
                    "Case",
                    "case.n@neuromancer.net",
                    "ICEbreaker_AI.2021",
                    "+81 3-5555-0137",
                    0),

            new UserDTO(
                    113,
                    "Neo",
                    "Thomas",
                    "Anderson",
                    "neo.matrix@zion.org",
                    "WakeUp_Neo1999!",
                    "+1 312-555-1010",
                    0),

            new UserDTO(
                    114,
                    "MnemonicJack7",
                    "Johnny",
                    "Mnemonic",
                    "johnny.mem@datavault.biz",
                    "YakuzaSync_320GB$",
                    "+81 45-5555-9898",
                    0),

            new UserDTO(
                    115,
                    "SnowHero9",
                    "Hiro",
                    "Protagonist",
                    "hiro.katana@snowcrash.io",
                    "SwordRider_20XX!",
                    "+1 310-555-7744",
                    0),

            new UserDTO(
                    116,
                    "MollyBlades",
                    "Molly",
                    "Millions",
                    "razorgirl@freelance.zone",
                    "MirrorShades_808!",
                    "+44 20-5555-2211",
                    0)
        );
    }

    /**
     * Generates a list of PetDTO objects with sample data.
     *
     * @return List of PetDTO objects
     */
    public static List<PetDTO> petDTOList(){
        return Arrays.asList(

            new PetDTO(
                    new BigInteger("201"),
                    new PetCategoryDTO(new BigInteger("1"), "Artificial Animal"),
                    "ElectricSheep",
                    List.of("https://images.bladerunner.com/sheep1.png"),
                    List.of(
                            new PetCategoryDTO(new BigInteger("10"), "Dream"),
                            new PetCategoryDTO(new BigInteger("11"), "Android")
                    ),
                    "available"),

            new PetDTO(
                    new BigInteger("202"),
                    new PetCategoryDTO(new BigInteger("2"), "Cyber Companion"),
                    "TogusaHound",
                    List.of("https://images.section9.org/togusa_dog.jpg"),
                    List.of(
                            new PetCategoryDTO(new BigInteger("12"), "Tactical"),
                            new PetCategoryDTO(new BigInteger("13"), "Trained")
                    ),
                    "pending"),

            new PetDTO(
                    new BigInteger("203"),
                    new PetCategoryDTO(new BigInteger("3"), "Virtual Entity"),
                    "GlitchCat",
                    List.of("https://matrixassets.net/glitchcat.gif"),
                    List.of(
                            new PetCategoryDTO(new BigInteger("14"), "Code"),
                            new PetCategoryDTO(new BigInteger("15"), "Companion")
                    ),
                    "sold"),

            new PetDTO(
                    new BigInteger("204"),
                    new PetCategoryDTO(new BigInteger("4"), "Bioengineered"),
                    "Nibbles_77",
                    List.of("https://cyberpetlabs.com/nibbles77.jpg"),
                    List.of(
                            new PetCategoryDTO(new BigInteger("16"), "Augmented"),
                            new PetCategoryDTO(new BigInteger("17"), "Rodent")
                    ),
                    "available"),

            new PetDTO(
                    new BigInteger("205"),
                    new PetCategoryDTO(new BigInteger("5"), "Drone"),
                    "WatcherBot",
                    List.of("https://cybercitycams.net/watcherbot.png"),
                    List.of(
                            new PetCategoryDTO(new BigInteger("18"), "Surveillance"),
                            new PetCategoryDTO(new BigInteger("19"), "Flying")
                    ),
                    "available")
            );

    }

    /**
     * Generates a list of OrderDTO objects with sample data.
     *
     * @return List of OrderDTO objects
     */
    public static List<OrderDTO> orderDTOS(){
        return Arrays.asList(
            new OrderDTO(
                    301,
                    new BigInteger("201"),
                    1,
                    "2025-06-15T00:00:00.000+0000",
                    "placed",
                    true),

            new OrderDTO(
                    302,
                    new BigInteger("202"),
                    2,
                    "2025-06-15T00:00:00.000+0000",
                    "placed",
                    true),

            new OrderDTO(
                    303,
                    new BigInteger("203"),
                    1,
                    "2025-06-15T00:00:00.000+0000",
                    "placed",
                    true),

            new OrderDTO(
                    304,
                    new BigInteger("204"),
                    3,
                    "2025-06-15T00:00:00.000+0000",
                    "placed",
                    true),

            new OrderDTO(
                    305,
                    new BigInteger("205"),
                    1,
                    "2025-06-15T00:00:00.000+0000",
                    "placed",
                    true)

            );
    }


    /**
     * Returns a random object from a specified type (User, Pet, or Order).
     * The method shuffles the list of objects and returns the first one.
     *
     * @param object The type of object to return ("User", "Pet", or "Order").
     * @return A random object of the specified type.
     */
    public static Object randomObjectDTO(String object) {
        List<?> objectDTOList;

        switch (object) {
            case "User" -> objectDTOList = userDTOList();
            case "Pet" -> objectDTOList = petDTOList();
            case "Order" -> objectDTOList = orderDTOS();
            default -> throw new IllegalArgumentException("Unsupported type: " + object);
        }

        Collections.shuffle(objectDTOList);
        return objectDTOList.getFirst();
    }

}
