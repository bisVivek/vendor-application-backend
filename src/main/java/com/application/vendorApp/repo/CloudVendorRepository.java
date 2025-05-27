package com.application.vendorApp.repo;

import com.application.vendorApp.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository <CloudVendor, String> {
}
