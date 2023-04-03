package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.FoodDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuService {
    boolean insertFood(MultipartFile file, String name, String description, double price, String instruction, int cate_res_id);
    List<FoodDTO> getAllFood();
}
