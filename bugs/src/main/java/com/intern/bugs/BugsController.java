package com.intern.bugs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
final class BugsController {
    private final BugsService bugsService;

    @Autowired
    BugsController(BugsService bugsService) {
        this.bugsService = bugsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    BugsDTO create(@RequestBody @Valid BugsDTO bug) {
        return bugsService.create(bug);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    BugsDTO delete(@PathVariable("id") String id) {
        return bugsService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<BugsDTO> findAll() {
        return bugsService.findAll();
    }

    @RequestMapping(value = "id", method = RequestMethod.GET)
    BugsDTO findById(@PathVariable("id") String id) {
        return bugsService.findById(id);
    }

    @RequestMapping(value = "id", method = RequestMethod.PUT)
    BugsDTO update (@RequestBody @Valid BugsDTO bug) {
        return bugsService.update(bug);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleBugNotFound (BugNotFoundException e) {}
}