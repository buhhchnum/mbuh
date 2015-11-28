package org.munchub.core.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.munchub.core.beans.Item;
import org.munchub.core.beans.ItemInfo;
import org.munchub.core.service.ItemService;
import org.springframework.stereotype.Component;

@Component
@Path("/items")
public class ItemResource {
	
	private ItemService itemService;

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Item item){
		item = itemService.addItem(item);		
		System.out.println(item.getId());
	}
	
	@GET
	@Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item get(@PathParam("itemId") Long id)
    {
		return itemService.getItemById(id);
    }
		
	@GET
	@Path("/{vendorId}/items")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemInfo> getAllItems(@PathParam("vendorId") Long vendorId){
		return itemService.getItemsByVendor(vendorId);
	}
}
