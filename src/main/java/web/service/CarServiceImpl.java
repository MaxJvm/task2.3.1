package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("model1", "black", 100));
        cars.add(new Car("model2", "red", 101));
        cars.add(new Car("model3", "white", 102));
        cars.add(new Car("model4", "blue", 103));
        cars.add(new Car("model5", "metal", 104));


    }

    @Override
    public List<Car> getCars(int count) {
        return (count > cars.size()) ? cars : cars.subList(0, count);
    }


}
