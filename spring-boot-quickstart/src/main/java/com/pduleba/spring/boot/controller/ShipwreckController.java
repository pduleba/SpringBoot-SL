package com.pduleba.spring.boot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pduleba.spring.boot.model.Shipwreck;
import com.pduleba.spring.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping(path = "/api/v1")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(path = "/shipwrecks", method = GET, produces = APPLICATION_JSON_VALUE)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}

	@RequestMapping(path = "/shipwrecks", method = POST, produces = APPLICATION_JSON_VALUE)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public Shipwreck read(@PathVariable(value = "id") Long id) {
		Shipwreck found = shipwreckRepository.findOne(id);
		if (found == null) {
			throw new RuntimeException();
		} else {
			return found;
		}
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = PUT, produces = APPLICATION_JSON_VALUE)
	public Shipwreck update(@PathVariable(value = "id") Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existing = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existing);
		return shipwreckRepository.saveAndFlush(existing);
	}

	@RequestMapping(path = "/shipwrecks/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
	public Shipwreck delete(@PathVariable(value = "id") Long id) {
		Shipwreck existing = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(id);
		return existing;
	}
}
