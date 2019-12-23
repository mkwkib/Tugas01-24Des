package com.btpns.training.latihan3.controller;

import com.btpns.training.latihan3.dao.ResponseDao;
import com.btpns.training.latihan3.entity.RoleEntity;
import com.btpns.training.latihan3.entity.UserEntity;
import com.btpns.training.latihan3.service.PasswordConverterService;
import com.btpns.training.latihan3.service.RoleService;
import com.btpns.training.latihan3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
public class ApiController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordConverterService passwordConverterService;

    @PostMapping(value = "/registrasi", headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(UserEntity userEntity, UriComponentsBuilder uriComponentsBuilder){
        userEntity.setPassword(passwordConverterService.convertPassword(userEntity.getPassword()));
        userService.insertUser(userEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}")
                .buildAndExpand(userEntity.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findBy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity>
    findByUserId(@RequestParam(value = "userId", defaultValue = "")int id){
        UserEntity userEntity = userService.findById(id);

        if(userEntity.equals(null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userEntity);
        }else return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userEntity);
    }

    @PostMapping(value = "/role", headers = "Accept=application/json")
    public ResponseEntity<Void> createRole(RoleEntity roleEntity, UriComponentsBuilder uriComponentsBuilder){
        roleService.insertRole(roleEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/role/{id}")
                .buildAndExpand(roleEntity.getRoleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/listByRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDao>
    findByRoleId(@RequestParam(value = "roleId", defaultValue = "")int id){
        List<UserEntity> userEntities= userService.findByRoleId(id);
         ResponseDao responseDao = new ResponseDao();

        responseDao.setData(userEntities);

         if(userEntities.isEmpty()){
             responseDao.setCode(404);
             responseDao.setStatus("Error!!");
             responseDao.setMessage("Error! Data Tidak Ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseDao);

        }else {
             responseDao.setCode(200);
             responseDao.setStatus("OK");
             responseDao.setMessage("List User "+roleService.findById(id).getRoleName()+": ");
             return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseDao);
         }
    }
}
