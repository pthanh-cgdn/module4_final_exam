package com.codegyme.module4_final.controllers;

import com.codegyme.module4_final.dtos.OrderDto;
import com.codegyme.module4_final.models.Category;
import com.codegyme.module4_final.models.Order;
import com.codegyme.module4_final.models.Product;
import com.codegyme.module4_final.services.ICategoryService;
import com.codegyme.module4_final.services.IOrderService;
import com.codegyme.module4_final.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @GetMapping("/order")
    public String display(@PageableDefault(value = 5) Pageable pageable, Model model){
        Page<Order> orders = orderService.findAll(pageable);
        model.addAttribute("orders", orders);
        return "/display";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable,
                         @RequestParam(name="startDate") LocalDate startDate,
                         @RequestParam(name="endDate") LocalDate endDate,
                         Model model){
        if(startDate.isAfter(endDate)){
            Page<Order> orders = orderService.findAll(pageable);
            model.addAttribute("orders", orders);
            model.addAttribute("startDate", startDate);
            model.addAttribute("endDate", endDate);
            model.addAttribute("message", "Vui long chon lai ngay");
            return "/display";
        }
        Page<Order> orders = orderService.findAllByDate(startDate, endDate, pageable);
        model.addAttribute("orders", orders);
        return "/search";
    }
    @GetMapping("viewTop")
    public String displayTop(
            @RequestParam(name="top") Integer top,
                             Model model){
        List<Order> orders = orderService.findTopOrderByAmount(top);
        if(orders.size() < top){
            model.addAttribute("orders", orders);
        } else {
            List<Order> newOrders = orders.subList(0, top);
            model.addAttribute("orders", newOrders);
        }
        return "/viewTop";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Order order = orderService.findById(id);
        List<Category> categories = categoryService.findAll();
        List<Product> products = productService.findAll();
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        model.addAttribute("orderDto",orderDto);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("orderDto") OrderDto orderDto
            , BindingResult bindingResult
            , RedirectAttributes redirect
            , Model model){
        new OrderDto().validate(orderDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<Category> categories = categoryService.findAll();
            List<Product> products = productService.findAll();
            model.addAttribute("orderDto",orderDto);
            model.addAttribute("products", products);
            model.addAttribute("categories", categories);
            return "/edit";
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        orderService.save(order);
        redirect.addFlashAttribute("message", "Sua san pham thành công");
        return "redirect:/order";
    }
}
