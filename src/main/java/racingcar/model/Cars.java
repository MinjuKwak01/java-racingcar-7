package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        long uniqueNameCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueNameCount != cars.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}