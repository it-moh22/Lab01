/* ===========================
   InventoryController.java
   =========================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Inventory.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryResponseModel>> getInventories() {
        return ResponseEntity.ok().body(inventoryService.getInventories());
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponseModel> getInventoryById(@PathVariable String inventoryId) {
        return ResponseEntity.ok().body(inventoryService.getInventoryById(inventoryId));
    }

    @PostMapping
    public ResponseEntity<InventoryResponseModel> addInventory(@RequestBody InventoryRequestModel inventoryRequestModel) {
        return ResponseEntity.ok().body(inventoryService.addInventory(inventoryRequestModel));
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponseModel> updateInventory(@PathVariable String inventoryId,
                                                                  @RequestBody InventoryRequestModel inventoryRequestModel) {
        return ResponseEntity.ok().body(inventoryService.updateInventoryDetails(inventoryRequestModel, inventoryId));
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable String inventoryId) {
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.noContent().build();
    }
}
