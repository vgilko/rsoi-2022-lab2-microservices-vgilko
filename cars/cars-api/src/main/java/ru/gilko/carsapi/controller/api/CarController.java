package ru.gilko.carsapi.controller.api;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gilko.carsapi.constants.ControllerUrl;
import ru.gilko.carsapi.dto.CarOutDto;

import java.util.UUID;

public interface CarController {
    @GetMapping(path = ControllerUrl.CARS_URL)
    ResponseEntity<Page<CarOutDto>> getCars(@RequestParam @DefaultValue("false") boolean showAll,
                                            @RequestParam @DefaultValue("0") int page,
                                            @RequestParam @DefaultValue("100") int size);

    @PutMapping(path = ControllerUrl.CONCRETE_CAR_URL)
    ResponseEntity<?> changeAvailability(@PathVariable UUID carId);
}
