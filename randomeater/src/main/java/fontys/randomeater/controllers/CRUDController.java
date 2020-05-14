package fontys.randomeater.controllers;

import fontys.randomeater.builder.response.Response;
import fontys.randomeater.models.BaseEntity;
import fontys.randomeater.services.CRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRUDController<T extends BaseEntity> extends ControllerBase<T> {
    private CRUDService<T, Long> service;

    CRUDController(CRUDService<T, Long> service) {
        this.service = service;
    }

    @GetMapping("/")
    public Response getAll() {
        List result = this.getAllInternal();
        return responseDirector.getSuccessResponse(result.size(), result);
    }

    private List getAllInternal() {
        return getListFromIterator(this.service.findAll().iterator());
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable Long id) {
        T result = this.getByIdInternal(id);

        if (result == null) {
            return responseDirector.getFailResponse(String.format("No object found with ID : %d", id));
        } else {
            return responseDirector.getSuccessResponse(1, result);
        }
    }

    protected T getByIdInternal(Long id) {
        return this.service.findById(id);
    }

    @PostMapping("/")
    public Response create(@RequestBody T object) {
        T result = this.createInternal(object);
        return responseDirector.getSuccessResponse(1, result);
    }

    protected T createInternal(T object) {
        return this.service.update(object);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody T object) {
        if (object.getId() == id) {
            T result = this.updateInternal(object);
            return responseDirector.getSuccessResponse(1, result);
        } else {
            return responseDirector.getFailResponse("Path id and object id do not match!");
        }
    }

    protected T updateInternal(T object) {
        return this.service.update(object);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Long id) {
        this.deleteByIdInternal(id);
        return responseDirector.getSuccessResponse(1, null);
    }

    protected void deleteByIdInternal(Long id) {
        this.service.deleteById(id);
    }

    //Converts the iterator to a list.
    private static <T> List<T> getListFromIterator(Iterator<T> iterator) {
        // Create an empty list
        List<T> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);

        // Return the List
        return list;
    }
}
