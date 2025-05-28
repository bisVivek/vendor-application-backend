package com.application.vendorApp.controller;

import com.application.vendorApp.model.CloudVendor;
import com.application.vendorApp.response.ResponseHandler;
import com.application.vendorApp.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @PostMapping("/add")
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        System.out.println("testtest1234: " + cloudVendor);
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Vendor Created Successfully";
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<?> getCloudvendor(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/getAll")
    public List<CloudVendor> getAllVendorInfo(){
        return cloudVendorService.getAllCloudVendor();
    }

    @PutMapping("/update")
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId){
        return cloudVendorService.deleteCloudVendor(vendorId);
    }
}
