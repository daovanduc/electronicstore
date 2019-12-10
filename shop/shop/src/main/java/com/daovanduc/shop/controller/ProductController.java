package com.daovanduc.shop.controller;

import com.daovanduc.shop.dto.ProductData;
import com.daovanduc.shop.facade.ProductFacade;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@Transactional
public class ProductController {

    @Resource
    private ProductFacade productFacade;

    @RequestMapping(value = {"/addproduct"}, method = RequestMethod.GET)
    public String addProduct(Model model) {
        ProductData productData = new ProductData();
        model.addAttribute("productData", productData);
        return "addproduct.html";
    }

    // POST: Save product
    @RequestMapping(value = {"/addproduct"}, method = RequestMethod.POST)
    public String productSave(Model model,
                              @RequestParam("picture") MultipartFile picture,
                              @ModelAttribute("productData") @Validated ProductData productData,
                              BindingResult result,
                              final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "addproduct.html";
        }
        try {
            productData.setImage(picture.getBytes());
            productFacade.saveProduct(productData);
        } catch (Exception e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            String message = rootCause.getMessage();
            model.addAttribute("errorMessage", message);
            // Show product form.
            return "addproduct.html";
        }

        return "redirect:/productList";
    }

    @RequestMapping({"/productList"})
    public String listProductHandler(Model model, //
                                     @RequestParam(value = "name", defaultValue = "") String likeName,
                                     @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;

        List<ProductData> result = productFacade.getAllProducts();

        model.addAttribute("productList", result);
        return "shop.html";
    }

    @RequestMapping(value = {"/productimage"}, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("id") Integer id) throws IOException {
        ProductData product = null;
        if (Objects.nonNull(id)) {
            product = this.productFacade.getProduct(id);
        }

        if (Objects.nonNull(product) && Objects.nonNull(product.getImage())) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }

}
