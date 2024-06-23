package tests.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String fullName = faker.name().fullName();
    public String userEmail = faker.internet().emailAddress();
    public String userCurrentAddress = faker.address().fullAddress();
    public String userPermanentAddress = faker.address().fullAddress();
    public String userNumber = getRandomPhone();
    public String userGender = getRandomGender();
    public String userHobby = getRandomHobby();
    public String userSubject = getRandomSubject();
    public String dayOfBirth = getRandomDay();
    public String monthOfBirth = getRandomMonth();
    public String yearOfBirth = getRandomYear();
    public String state = getRandomState();
    public String city = getRandomCity();
    public String userFile = getRandomFile();

    private String selectedState;

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public long getRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public String getRandomPhone() {
        return String.format("%s", getRandomLong(1111111111, 9999999999L));
    }

    public String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public String getRandomSubject() {
        String[] subjects = {
                "Arts", "History", "English", "Chemistry",
                "Computer Science", "Commerce", "Economics", "Maths",
                "Social Studies", "Accounting", "Physics", "Biology",
                "Hindi", "Civics"
        };
        return getRandomItemFromArray(subjects);
    }

    public String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        selectedState = getRandomItemFromArray(states);
        return selectedState;
    }

    public String getRandomCity() {
        if (selectedState == null) {
            getRandomState();
        }
        Map<String, String[]> stateCityMap = new HashMap<>();
        stateCityMap.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateCityMap.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateCityMap.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateCityMap.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
        return getRandomItemFromArray(stateCityMap.get(selectedState));
    }

    public String getRandomFile() {
        String[] files = {"Test-1.jpg", "Test-2.jpg", "Test-3.jpg"};
        return getRandomItemFromArray(files);
    }

    public String[] generateRandomDate() {
        Random randomDate = new Random();
        int year = randomDate.nextInt(Year.now().getValue() - 1900) + 1900;
        int month = randomDate.nextInt(12) + 1;
        int day = randomDate.nextInt(Month.of(month).length(LocalDate.of(year, month, 1).isLeapYear())) + 1;
        return new String[]{
                String.valueOf(day),
                Month.of(month).name().substring(0, 1).toUpperCase() + Month.of(month).name().substring(1).toLowerCase(),
                String.valueOf(year)
        };
    }

    public String getRandomDay() {
        return generateRandomDate()[0];
    }

    public String getRandomMonth() {
        return generateRandomDate()[1];
    }

    public String getRandomYear() {
        return generateRandomDate()[2];
    }
}