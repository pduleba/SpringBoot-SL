package com.pduleba.spring.boot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pduleba.spring.boot.model.Shipwreck;

@RestController
@RequestMapping(path = "/api/v1")
public class ShipwreckController {

	@RequestMapping(path = "/shipwrecks", method = GET, produces = APPLICATION_JSON_VALUE)
	public List<Shipwreck> list() {
		return ShipwreckStub.list();
	}

	@RequestMapping(path = "/shipwrecks", method = POST, produces = APPLICATION_JSON_VALUE)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.create(shipwreck);
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public Shipwreck read(@PathVariable(value = "id") Long id) {
		return ShipwreckStub.read(id);
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = PUT, produces = APPLICATION_JSON_VALUE)
	public Shipwreck update(@PathVariable(value = "id") Long id, @RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.update(id, shipwreck);
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
	public Shipwreck delete(@PathVariable(value = "id") Long id) {
		return ShipwreckStub.delete(id);
	}
}
