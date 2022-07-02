package ru.netology.aqa0patterns.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class DataGenerator {

    private Faker faker = new Faker(new Locale("ru"));
    private final String[] CITIES = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул",
            "Белгород", "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ",
            "Владимир", "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново",
            "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома",
            "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала",
            "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург",
            "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань",
            "Салехард", "Самара", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск",
            "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа",
            "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск",
            "Якутск", "Ярославль"};

    public String generateDate() {
        return LocalDate.now().plusDays(3 + new Random().nextInt(3000))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @UtilityClass
    public class Registration{
        public RegistrationInfo generate() {
            Name name = faker.name();
            return new RegistrationInfo(CITIES[new Random().nextInt(CITIES.length)],
                    name.lastName() + " " + name.firstName(),
                    faker.phoneNumber().phoneNumber());
        }
    }

    @Data
    @AllArgsConstructor
    public class RegistrationInfo {
        public String cityName;
        public String fullName;
        public String phoneNumber;
    }
}
