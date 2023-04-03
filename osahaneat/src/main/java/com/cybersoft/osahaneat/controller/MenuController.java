package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.payload.ResponsePayload;
import com.cybersoft.osahaneat.service.FileStorageService;
import com.cybersoft.osahaneat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/menu")
@RestController
public class MenuController {
    ////up file
    // form-data: Stream
    //request-body: chuyen file ve base64 -> se bi x1.5 dung luong file

    //// save file
    // database : file chuyen ve base64, file phai o dang byte -> ko khuyen khich ( vi du lieu cang nang truy van cang lau,, khi select ko nen select * )
    // ổ đĩa : file duoc luu o o cung -> luon dc su dung ( bat loi o dia hu mat trang nhung van co the sao luu)

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    MenuService menuService;

    @PostMapping("")
    public ResponseEntity<?> addMenu (
            @RequestParam MultipartFile file,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam String instruction,
            @RequestParam int cate_res_id
    ) {
        ResponsePayload responsePayload = new ResponsePayload();
        boolean isSuccess = menuService.insertFood(file, name, description, price, instruction, cate_res_id);
        responsePayload.setData(isSuccess);

        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMenu() {
        ResponsePayload responsePayload = new ResponsePayload();

        responsePayload.setData(menuService.getAllFood());

        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/files/{filesname:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filesname) {
        Resource resource = fileStorageService.load(filesname);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filesname + "\"")
                .body(resource);
    }
}
