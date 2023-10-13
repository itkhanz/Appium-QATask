package com.itkhanz.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itkhanz.utils.FakerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UserFactory {
    private static Map<String, Map<String, String>> userCredentials;

    private static void readUsersDataJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//users.json";
            userCredentials = objectMapper.readValue(
                    new File(userDataFilePath),
                    new TypeReference<Map<String, Map<String, String>>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("failed to read the user data");
        }
    }

    public static User createUser(String userType) {
        if (userCredentials == null) {
            UserFactory.readUsersDataJson();
        }

        if (!userCredentials.containsKey(userType)) {
            throw new RuntimeException(String.format("%s is not present in the users.json test data", userType));
        }

        return User.builder()
                .username(userCredentials.get(userType).get("email"))
                .password(userCredentials.get(userType).get("password"))
                .build();
    }

    public static User createFakeUser() {
        return User.builder()
                .username(FakerFactory.getEmail())
                .password(FakerFactory.getPassword())
                .build();
    }
}
