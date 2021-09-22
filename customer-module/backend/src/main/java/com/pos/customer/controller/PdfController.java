package com.pos.customer.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Order;
import com.pos.customer.service.OrderService;
import com.pos.customer.util.PdfGenerator;

@RestController
@RequestMapping("/customer")
public class PdfController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/pdf/order/{order-id}",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> orderPdf(@PathVariable("order-id")Long orderId) throws Exception{
		Order order=orderService.getOrder(orderId).getBody();
		ByteArrayInputStream bis = PdfGenerator.customerPDFReport(order);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=order.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
