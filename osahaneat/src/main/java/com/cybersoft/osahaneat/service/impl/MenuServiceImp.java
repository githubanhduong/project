package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.entity.CategoryRestaurant;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.repository.FoodRepository;
import com.cybersoft.osahaneat.service.FileStorageService;
import com.cybersoft.osahaneat.service.MenuService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public boolean insertFood(MultipartFile file, String name, String description, double price, String instruction, int cate_res_id) {
        boolean isInsertSuccess = false;
        boolean isSuccess = fileStorageService.saveFiles(file);
        if (isSuccess) {
            try {
                //Luu du lieu khi file da dc luu thanh cong
                Food food = new Food();
                food.setName(name);
                food.setDesc(description);
                food.setPrice(price);
                food.setIntruction(instruction);
                food.setImage(file.getOriginalFilename());

                CategoryRestaurant categoryRestaurant = new CategoryRestaurant();
                categoryRestaurant.setId(cate_res_id);

                food.setCategoryRestaurant(categoryRestaurant);

                foodRepository.save(food);
                isInsertSuccess = true;
            } catch (Exception e) {
                System.out.println("MenuServiceImp | Insert :\t" + e.getMessage());
            }
        }

        return isInsertSuccess;
    }

    @Override
//    @Cacheable("food")
    public List<FoodDTO> getAllFood() {
        Gson gson = new Gson();

        List<Food> foodList;
        List<FoodDTO> foodDTOList = new ArrayList<>();

        String data = (String) redisTemplate.opsForValue().get("foods");

        if (data == null) {
            foodList = foodRepository.findAll();
            for (Food food : foodList) {
                FoodDTO foodDTO = new FoodDTO();

                foodDTO.setImage(food.getImage());
                foodDTO.setName(food.getName());

                foodDTOList.add(foodDTO);
            }

            redisTemplate.opsForValue().set("foods", gson.toJson(foodDTOList));
        } else {
            foodDTOList = gson.fromJson(data, new TypeToken<List<FoodDTO>>(){}.getType());
        }


        return foodDTOList;
    }
}
