package com.boot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.project.model.Inventory;
import com.boot.project.model.StringResponse;
import com.boot.project.service.InventoryService;
import com.boot.project.service.ProductService;

@RestController
public class ChefController {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ProductService productService;

	@PostMapping("/api/chef/inventory-create")
	public ResponseEntity<?> createInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.saveInventory(inventory), HttpStatus.CREATED);
	}

	/*
	 * // @GetMapping("api/admin/delete/{email}") // public Iterable<Reserve>
	 * deleteReserve(@PathVariable String email){ // return
	 * reserveService.deleteUserByEmail(email); // }
	 */

	@PutMapping("/api/chef/inventory-update")
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.updateInventory(inventory), HttpStatus.CREATED);
	}

	// This can be also @DeleteMapping.

	@PostMapping("/api/chef/inventory-delete")
	public ResponseEntity<?> deleteInventory(@RequestBody Inventory inventory) {
		inventoryService.deleteInventory(inventory.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/chef/inventory-all")
	public ResponseEntity<?> findAllInventories() {
		return new ResponseEntity<>(inventoryService.findAllInventories(), HttpStatus.OK);
	}

	@GetMapping("/api/chef/inventory-number")
	public ResponseEntity<?> numberOfInventorys() {
		Long number = inventoryService.numberOfInventories();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
