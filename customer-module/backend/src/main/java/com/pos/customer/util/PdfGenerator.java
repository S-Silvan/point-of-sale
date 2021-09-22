package com.pos.customer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pos.customer.entity.Order;
import com.pos.customer.entity.OrderItem;

public class PdfGenerator {
	public static ByteArrayInputStream customerPDFReport(Order order) {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	PdfWriter.getInstance(document, out);
            document.open();
        	
			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph para = new Paragraph( "Order Invoice", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			Paragraph p1=new Paragraph("Order Date: "+order.getDate());
			document.add(p1);
			document.add(Chunk.NEWLINE);
			Paragraph p2=new Paragraph("Order Id: "+order.getOrderId());
			document.add(p2);
			document.add(Chunk.NEWLINE);
			Paragraph p3=new Paragraph("Total amount: "+order.getTotalPrice());
			document.add(p3);
			document.add(Chunk.NEWLINE);
			
        	PdfPTable table = new PdfPTable(6);
        	// Add PDF Table Header ->
			Stream.of("Product","Brand","Cateory","Price", "Quantity","Tax")
			    .forEach(headerTitle -> {
			          PdfPCell header = new PdfPCell();
			          Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			          header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			          header.setHorizontalAlignment(Element.ALIGN_CENTER);
			          header.setPhrase(new Phrase(headerTitle, headFont));
			          table.addCell(header);
			    });
            
			List<OrderItem> orderItems = order.getOrders();
            for (OrderItem orderItem : orderItems) {
            	PdfPCell idCell = new PdfPCell(new Phrase(orderItem.getProduct().getName()));
            	idCell.setPaddingLeft(4);
            	idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);
                
                PdfPCell productNameCell = new PdfPCell(new Phrase(String.valueOf(orderItem.getProduct().getBrand())));
                productNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                productNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                productNameCell.setPaddingRight(4);
                table.addCell(productNameCell);
                

                PdfPCell vendorNameCell = new PdfPCell(new Phrase(orderItem.getProduct().getCategory().getName()));
                vendorNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                vendorNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                vendorNameCell.setPaddingRight(4);
                table.addCell(vendorNameCell);

                PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(orderItem.getQuantity())));
                quantityCell.setPaddingLeft(4);
                quantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                quantityCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(quantityCell);
          
                
                PdfPCell purchasedPriceCell = new PdfPCell(new Phrase(String.valueOf(orderItem.getPrice())));
                purchasedPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                purchasedPriceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                purchasedPriceCell.setPaddingRight(4);
                table.addCell(purchasedPriceCell);    
            }
            document.add(table);
            
            document.close();
        }catch(DocumentException e) {
        	System.out.println(e.getMessage());
        }
        
		return new ByteArrayInputStream(out.toByteArray());
	}
}
