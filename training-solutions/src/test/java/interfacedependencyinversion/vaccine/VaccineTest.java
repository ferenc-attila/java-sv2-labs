package interfacedependencyinversion.vaccine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VaccineTest {

    List<Person> registrated;

    @BeforeEach
    void setUp() {
        registrated = new ArrayList<>();
        registrated.add(new Person("Tóth Béla", 19, ChronicDisease.NO, Pregnancy.NO));
        registrated.add(new Person("Kovács Tivadar", 68, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Hegyi Máté", 84, ChronicDisease.NO, Pregnancy.NO));
        registrated.add(new Person("Búzás Emília", 27, ChronicDisease.NO, Pregnancy.YES));
        registrated.add(new Person("Szabó Jánosné", 45, ChronicDisease.NO, Pregnancy.NO));
        registrated.add(new Person("Mezei Virág", 84, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Erdei Ibolya", 32, ChronicDisease.NO, Pregnancy.YES));
        registrated.add(new Person("Réti Jácint", 55, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Szabó Ödön", 25, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Farkas Cecília", 28, ChronicDisease.NO, Pregnancy.YES));
        registrated.add(new Person("Peresztegi Ilona", 37, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Ablakos Aurél", 47, ChronicDisease.YES, Pregnancy.NO));
        registrated.add(new Person("Fónagy Márta", 21, ChronicDisease.NO, Pregnancy.YES));
        registrated.add(new Person("Fekete Lázárné", 36, ChronicDisease.YES, Pregnancy.YES));
    }

    @Test
    void testFirstVaccine() {
        Vaccine vaccine = new FirstVaccine();
        vaccine.generateVaccinationList(registrated);

        Assertions.assertEquals(14, vaccine.getVaccinationList().size());
        Assertions.assertEquals("Búzás Emília", vaccine.getVaccinationList().get(0).getName());
        Assertions.assertEquals("Fekete Lázárné", vaccine.getVaccinationList().get(4).getName());
        Assertions.assertEquals("Hegyi Máté", vaccine.getVaccinationList().get(5).getName());
        Assertions.assertEquals("Mezei Virág", vaccine.getVaccinationList().get(6).getName());
        Assertions.assertEquals("Kovács Tivadar", vaccine.getVaccinationList().get(7).getName());
        Assertions.assertEquals("Tóth Béla", vaccine.getVaccinationList().get(13).getName());
    }

    @Test
    void testSecondVaccine() {
        Vaccine vaccine = new SecondVaccine();
        vaccine.generateVaccinationList(registrated);

        Assertions.assertEquals(3, vaccine.getVaccinationList().size());
        Assertions.assertEquals("Tóth Béla", vaccine.getVaccinationList().get(0).getName());
        Assertions.assertEquals("Szabó Jánosné", vaccine.getVaccinationList().get(1).getName());
        Assertions.assertEquals("Hegyi Máté", vaccine.getVaccinationList().get(2).getName());
    }
}